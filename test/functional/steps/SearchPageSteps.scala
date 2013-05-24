package functional.steps

import functional.support.WebDriverSupport
import org.openqa.selenium.By
import functional.pages.SearchPage
import org.junit.Assert

trait SearchPageSteps extends WebDriverSupport {

  val searchPage = new SearchPage(driver)

  val searchPageUrl: String = "http://localhost:9000/search"

  def openSearchPage = go to(searchPageUrl)

  def searchFor(searchTerm: String){
    driver.findElement(By.name("term")).sendKeys(searchTerm)
    driver.findElement(By.xpath("//input[@type='submit']")).click()
  }

  def verifySearchPageText(actualText: String) = Assert.assertEquals(searchPage.searchPageText, actualText)

}
