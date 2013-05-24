package functional.steps

import org.openqa.selenium.By
import org.junit.Assert
import org.scalatest.selenium.WebBrowser
import functional.support.WebDriverSupport
import functional.pages.HomePage
import org.scalatest.selenium.WebBrowser.go

trait HomePageSteps extends WebDriverSupport{

  val homePage = new HomePage(driver)
  val localDevBox: String = "http://localhost:9000"

  def openHomePage = {
    go to(localDevBox)
  }

  def verifyWelcomeText{
    Assert.assertEquals(homePage.getWelcomeText(), "Welcome To Play-Webapp")
  }

}
