package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.{Term, WordService}
import play.api.libs.ws.WS
import scala.concurrent.duration._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }


  val searchForm : Form[Term] = Form(
    mapping(
      "term" -> text
    )(Term.apply)(Term.unapply)
  )

  def search = Action {
    Ok(views.html.search("search",searchForm))

  }

  def result = Action {  implicit request =>
    searchForm.bindFromRequest.fold(
      errors => {
         println(errors.errors.take(1))
        BadRequest("ab")
      },
      term =>  { Redirect(routes.Application.showResults(term.term).url) }
    )
  }

  def showResults(displayText:String) = Action {
    Ok(views.html.result(displayText) )
  }
}