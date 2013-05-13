package functional

import org.scalatest.{GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.{Ignore, Assert}

@Ignore
class FunSpecTest extends FunSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  describe("when user types in the url") {

    it("Should open the application") {

      go to ("http://localhost:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
      driver.close()
    }
  }

}
