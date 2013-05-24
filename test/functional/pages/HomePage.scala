package functional.pages

import org.openqa.selenium.{By, WebDriver}


class HomePage(val driver: WebDriver) {

  def getWelcomeText() = driver.findElement(By.xpath("//h1")).getText

}
