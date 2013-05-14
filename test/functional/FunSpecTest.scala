package functional

import org.scalatest.{Tag, GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.{Ignore, Assert}

class FunSpecTest extends FunSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  describe("when user types in the url") {

    it("Should open the application slow", Tag("Fast")) {
      go to ("http://localhost:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
      driver.close()
    }

    it("Should open the application fast", Tag("Slow")) {
      go to ("http://localhost:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
      driver.close()
    }
  }
}
