package functional

import org.scalatest.{GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.Assert

class FunSpecTest extends FunSpec with WebBrowser with GivenWhenThen {

  implicit val driver: WebDriver = new FirefoxDriver()

  describe("when user types in the url") {
    it("Should open the application") {

      Given("Browser is open")
      When("User navigates to url : " + "http://localhost:9000")
      go to ("http://localhost:9000")

      Then("the message should appear")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

      driver.close()
    }
  }

}
