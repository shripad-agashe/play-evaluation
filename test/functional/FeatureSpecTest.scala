package functional

import org.scalatest.{GivenWhenThen, FeatureSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.Assert

class FeatureSpecTest extends FeatureSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  info("As a student")
  info("I want to open Home Page")
  info("so that I can browse through the application")

  feature("Open Home page"){
    scenario("Verify application is up"){

      Given("Browser is open")
      When("User navigates to url : "+ "http://localhost:9000")
      go to ("http://localhost:9000")

      Then("the message should appear")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

      driver.close()

    }
  }
}
