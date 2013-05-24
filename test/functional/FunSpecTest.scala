package functional

import org.scalatest.{Tag, GivenWhenThen, FunSpec}
import org.scalatest.selenium.WebBrowser
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.firefox.FirefoxDriver
import org.junit.{Ignore, Assert}
import steps.{SearchPageSteps, HomePageSteps}
import support.TestUtils

class FunSpecTest extends TestUtils
  with HomePageSteps
  with SearchPageSteps{

  describe("when user types in the url") {
    it("Should open the application slow", Tag("Fast")) {
      openHomePage
      verifyWelcomeText
    }
  }

  describe("When user search in search") {
    it("Should open the search result page",Tag("searchTest")) {
      openSearchPage
      verifySearchPageText("searchPage")
    }

    it("Should search for the search term scala",Tag("searchResultsTest")) {
      openSearchPage
      searchFor("scala")
      verifySearchPageText("Definition is :")
    }
  }

}

