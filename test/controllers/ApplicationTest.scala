package controllers

import org.specs2.mutable.Specification
import play.api.test.{FakeRequest, FakeApplication}
import play.api.test.Helpers._


class ApplicationTest extends Specification{

  "ApplicationTest" should {
    "Get form for rendering ui" in {
      running(FakeApplication() ) {
        val resp = route(FakeRequest(GET, "/search")).get
        status(resp) must equalTo(OK)
        contentAsString(resp) contains("Search")
      }
    }
  }


  "ApplicationTest" should{

    "Get Text same as passed via textbox after rendering the result page" in{

      running(FakeApplication()){


        val word = route(FakeRequest(GET,routes.Application.showResults("value").url)).get

        contentAsString(word) contains("value")

      }


    }


  }





}
