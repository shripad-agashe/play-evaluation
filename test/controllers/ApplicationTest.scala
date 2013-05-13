package controllers

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._


class ApplicationTest extends Specification{

  "ApplicationTest" should {
    "Get form for rendering ui" in {
      running(FakeApplication() ) {
//        val resp = route(FakeRequest(GET, "/searchPage")).get
//        status(resp) must equalTo(OK)
//        contentAsString(resp) contains("Search")
        val resp = controllers.Application.searchPage(FakeRequest())
                status(resp) must equalTo(OK)
                contentAsString(resp) contains("Search")
      }
    }




    "Get Text same as passed via textbox after rendering the search page" in{
      running(FakeApplication()){
        val word = controllers.Application.showResults("value")(FakeRequest())
        contentAsString(word) contains("value")
      }
    }



    "definition for a Content should display for a post value " in{

      running(FakeApplication()){
        val request =  FakeRequest("POST", routes.Application.searchPage().url).withFormUrlEncodedBody(("term","Computer"))

        val result = controllers.Application.search()(request)


        redirectLocation(result) must beSome.which(_ == routes.Application.showResults("Computer").url)
        status(result) mustEqual SEE_OTHER

        val response = route( FakeRequest("GET", redirectLocation(result).get) ).get

        contentAsString(response) contains ("A machine that can be programmed to manipulate\n        symbols")



      }

    }

  }





}
