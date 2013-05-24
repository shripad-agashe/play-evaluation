package functional.support

import org.scalatest.{BeforeAndAfterAll, GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

trait WebDriverSupport extends WebBrowser{

  implicit val driver: WebDriver = new FirefoxDriver()
}
