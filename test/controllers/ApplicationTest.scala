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
        contentAsString(resp) contains("This is a search form")
      }
    }
  }

}
