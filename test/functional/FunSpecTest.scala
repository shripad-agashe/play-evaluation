package functional

import org.scalatest.{Tag, GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.{Ignore, Assert}

class FunSpecTest extends FunSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  describe("when user types in the url") {

    it("Should open the application slow", Tag("Fast")) {
      go to ("http://127.0.0.1:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
    }

    it("Should open the application fast", Tag("Slow")) {
      go to ("http://127.0.0.1:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
    }
  }

  describe("When user search in search") {

    it("Should open the search result page",Tag("searchTest")) {
      go to ("http://localhost:9000/search")
      val expected = driver.findElement(By.xpath("//h2")).getText
      Assert.assertEquals(expected, "searchPage")
    }

    it("Should search for the search term scala",Tag("searchResultsTest")) {

      Given("User on search page")
      go to("http://localhost:9000/search")

      When("User search for any term")
      val searchTerm: String = "scala"
      driver.findElement(By.name("term")).sendKeys(searchTerm)
      driver.findElement(By.xpath("//input[@type='submit']")).click()

      Then("User should able to see search results page")
      val text = driver.findElement(By.xpath("//h2")).getText
      Assert.assertEquals(text, "Definition is :")

      driver.close()
    }
  }
}

