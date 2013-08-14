package scala.com.springer.materials.abstractpage

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import com.springer.materials.abstractpage.AbstractPageService
import play.api.libs.json.Json


class AbstractPageServiceTest extends FunSpec with ShouldMatchers {

  val abstractPageService = new AbstractPageService

  it("should return a dummy json"){

   val actualJson = abstractPageService.getAbstractPageData("1")

   //header
   (actualJson._1\"heading").as[String] should be ("Adsorption")
   (actualJson._1\"dataSetTitle").as[String] should be ("Adsorption Isotherm for <Adsorbate> on <Adsorbant>")
   (actualJson._1\"temperature").as[String] should be ("296 K")

    //adsorbate
   (actualJson._2\"header").as[String] should be ("Adsorbate")
   (actualJson._2\"columnHeader1").as[String] should be ("Property")
   (actualJson._2\"columnHeader2").as[String] should be ("Value")

   ((actualJson._2\"rows")(0)\"property").as[String] should be ("Sum Formula")
   ((actualJson._2\"rows")(0)\"value").as[String] should be ("H2S")

   ((actualJson._2\"rows")(1)\"property").as[String] should be ("Molecular Weight")
   ((actualJson._2\"rows")(1)\"value").as[String] should be ("34.081")

    //adsorbant
    (actualJson._3\"header").as[String] should be ("Adsorbant")
    (actualJson._3\"columnHeader1").as[String] should be ("Property")
    (actualJson._3\"columnHeader2").as[String] should be ("Value")

    ((actualJson._3\"rows")(0)\"property").as[String] should be ("Solid Class")
    ((actualJson._3\"rows")(0)\"value").as[String] should be ("AC")

    ((actualJson._3\"rows")(1)\"property").as[String] should be ("Solid Subclass")
    ((actualJson._3\"rows")(1)\"value").as[String] should be ("--")

    ((actualJson._3\"rows")(2)\"property").as[String] should be ("Description")
    ((actualJson._3\"rows")(2)\"value").as[String] should be ("Activated Carbon")
  }



}
