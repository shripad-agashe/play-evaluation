package functional

import org.scalatest.{Tag, GivenWhenThen, FeatureSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.Assert
import java.util.concurrent.TimeUnit


class FeatureSpecTest extends FeatureSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  feature("Open Home page"){

    scenario("Verify application is up slow", Tag("Slow")){

      go to ("http://127.0.0.1:9000")

      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

    }

    scenario("Verify application is up fast", Tag("Fast")){
      go to ("http://127.0.0.1:9000")

      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

    }
  }

  feature("Check user search") {

    scenario("Verify search page") {

      go to ("http://localhost:9000/search")
      val expected = driver.findElement(By.xpath("//h2")).getText
      Assert.assertEquals(expected, "searchPage")
    }

    scenario("Verify search results page") {

      Given("User on search page")
      go to ("http://localhost:9000/search")

      When("User search for any term")
      driver.findElement(By.name("term")).sendKeys("scala")
      driver.findElement(By.xpath("//*[@type='submit']")).click()

      Then("User should able to see search results page")
      val text = driver.findElement(By.xpath("//h2")).getText
      Assert.assertEquals(text, "Definition is :")

      driver.close()

    }
  }

}
