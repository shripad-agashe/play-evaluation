package functional

import org.scalatest.WordSpec
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

class WordSpecTest extends WordSpec with WebBrowser{

  implicit val driver: WebDriver = new FirefoxDriver()

  "User enters a url" when {
    "Open application" should {
      "Text Your application is ready" in{
        go to("http://localhost:9000")
        driver.close()
      }
    }
  }
}
