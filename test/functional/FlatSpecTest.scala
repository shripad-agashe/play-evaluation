package functional

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.internal.ProfilesIni
import org.junit.Ignore

@Ignore
class FlatSpecTest extends FlatSpec with ShouldMatchers with WebBrowser {
  implicit val driver: WebDriver = new FirefoxDriver()

  "When user enters a url, the application" should "have text" in {
    go to ("http://localhost:9000")
    driver.close()
  }

}
