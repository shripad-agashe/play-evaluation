package functional.pages

import org.openqa.selenium.{By, WebDriver}

class SearchPage(val driver: WebDriver) {

  def searchPageText = driver.findElement(By.xpath("//h2")).getText

}
