package functional

import org.scalatest.{Tag, GivenWhenThen, FeatureSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.Assert
import java.util.concurrent.TimeUnit


class FeatureSpecTest extends FeatureSpec with WebBrowser with GivenWhenThen{

  implicit val driver: WebDriver = new FirefoxDriver()

  feature("Open Home page"){

    scenario("Verify application is up slow", Tag("Slow")){

      go to ("http://127.0.0.1:9000")

      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

      driver.close()
    }

    scenario("Verify application is up fast", Tag("Fast")){
      go to ("http://127.0.0.1:9000")

      val text = driver.findElement(By.xpath("//h1")).getText
      Assert.assertEquals(text, "Your new application is ready.")

      driver.close()
    }
  }

  feature("Check user search") {

    ignore("When user search in search") {

      go to ("http://localhost:9000/search")

      driver.findElement(By.xpath("//*[@id='term']")).sendKeys("scala")
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)

      driver.findElement(By.xpath("//*[@type='submit']")).click()
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)

      val text = driver.findElement(By.xpath("//h2")).getText
      Assert.assertTrue(text.contains("scala"))

      driver.close()
    }

  }

}
