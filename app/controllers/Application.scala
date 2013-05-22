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
import scala.xml.{NodeSeq, XML}
import controllers.tools.Scalate


object Application extends Controller {

  def index = Action {
    //Ok(views.html.index("Your new application is ready."))
    Ok(Scalate("index.jade").render('message -> "Welcome To Play-Webapp"))
  }


  val searchForm: Form[Term] = Form(
    mapping(
      "term" -> text
    )(Term.apply)(Term.unapply)
  )

  def searchPage = Action {
    Ok(views.html.search("searchPage", searchForm))
  }

  def search = Action {
    implicit request =>
      searchForm.bindFromRequest.fold(
        errors => {
          println(errors.errors.take(1))
          BadRequest("ab")
        },
        term => {
          Redirect(routes.Application.showResults(term.term).url)
        }
      )
  }

  def showResults(displayText: String) = Action {

    val homePage = WS.url("http://services.aonaware.com/DictService/DictService.asmx/Define?word=" + displayText).get()


    val resultFuture: Future[Result] = homePage.map {
      resp =>
        val xml = scala.xml.XML.loadString(resp.body).toList
        val description = (xml \ "Definitions" \ "Definition" \ "WordDefinition").toList


      //  Ok(description.head.text)
        Ok(views.html.result(description.head.text))

    }

    Async(resultFuture)
    //Ok(views.html.result(displayText))

  }

}