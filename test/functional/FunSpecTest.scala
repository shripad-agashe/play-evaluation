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
      go to ("http://127.0.0.1:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
      driver.close()
    }

    it("Should open the application fast", Tag("Slow")) {
      go to ("http://127.0.0.1:9000")
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")
      driver.close()
    }
  }

  describe("When user search in search") {

    ignore("Should open the search result page") {
      go to ("http://localhost:9000")
      driver.findElement(By.id("term")).sendKeys("scala")
      driver.findElement(By.xpath("//*[@type='submit']")).click();
      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertTrue(text.contains("scala"))
      driver.close()
    }

  }

}
