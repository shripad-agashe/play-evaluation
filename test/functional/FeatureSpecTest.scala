package functional

import org.scalatest.{Tag, GivenWhenThen, FeatureSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.Assert


class FeatureSpecTest extends FeatureSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  feature("Open Home page"){

    scenario("Verify application is up"){
      go to ("http://localhost:9000")

      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

      driver.close()
    }
  }
}
