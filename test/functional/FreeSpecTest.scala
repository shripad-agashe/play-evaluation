package functional

import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.FreeSpec

class FreeSpecTest extends FreeSpec with WebBrowser {

  implicit val driver: WebDriver = new FirefoxDriver()

  "User navigates to homepage" - {
    "Then Browser must open the application" - {
      go to ("http://localhost:9000")
      driver.close()
    }
  }
}
