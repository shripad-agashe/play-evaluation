package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Term, WordService}
import play.api.libs.ws.WS
import scala.concurrent.duration._
import play.libs.F._
import play.api.libs.ws
import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global



object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }


  val searchForm : Form[Term] = Form(
    mapping(
      "term" -> text
    )(Term.apply)(Term.unapply)
  )

  def searchPage = Action {
    Ok(views.html.search("searchPage",searchForm))

  }

  def search = Action {  implicit request =>
    searchForm.bindFromRequest.fold(
      errors => {
         println(errors.errors.take(1))
        BadRequest("ab")
      },
      term =>  { Redirect(routes.Application.showResults(term.term).url) }
    )
  }

  def showResults(displayText:String) = Action {

    val homePage =  WS.url("http://services.aonaware.com/DictService/DictService.asmx/Define?word=" + displayText).get()


    val resultFuture: Future[Result] = homePage.map { resp =>
    // Create a Result that uses the http status, body, and content-type
    // from the example.com Response
      Status(resp.status)(resp.body).as(resp.ahcResponse.getContentType)
    }


    Async(resultFuture)

//    Ok(views.html.result(displayText))

      /*(response.json \ "title").as[String]*/
  }

}