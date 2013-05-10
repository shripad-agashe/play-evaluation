package functional

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class FlatSpecTest extends FlatSpec with ShouldMatchers with WebBrowser {
  implicit val driver: WebDriver = new FirefoxDriver()

  "Page at Google" should "open" in {
    go to("http://google.co.in")
  }

}
