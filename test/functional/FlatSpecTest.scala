package functional

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class FlatSpecTest extends FlatSpec with ShouldMatchers with WebBrowser {
  implicit val driver: WebDriver = new FirefoxDriver()

  "When user enters a url, the application" should "have text" in {
    go to ("http://127.0.0.1:9000")
    driver.close()
  }

}
