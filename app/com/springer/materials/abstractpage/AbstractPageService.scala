package com.springer.materials.abstractpage

import play.api.libs.json.{Json, JsValue}

class AbstractPageService {

  def getAbstractPageData(id: String): (JsValue, JsValue, JsValue) = {
    val header = Json.parse( """{
         "heading" : "Adsorption",
         "dataSetTitle" : "Adsorption Isotherm for <Adsorbate> on <Adsorbant>",
         "temperature" : "296 K"
      }""")

    val adsorbate = Json.parse( """ {
        "header" : "Adsorbate",
        "columnHeader1" : "Property",
        "columnHeader2" : "Value",
        "rows" : [
          { "property" : "Sum Formula", "value" : "H2S"},
          { "property" : "Molecular Weight", "value" : "34.081"}
        ]
    }""")


    val adsorbant = Json.parse( """ {

             "header" : "Adsorbant",
             "columnHeader1" : "Property",
             "columnHeader2" : "Value",
             "rows" : [
                    {"property" : "Solid Class", "value" : "AC"},
                    {"property" : "Solid Subclass", "value" : "--"},
                    {"property" : "Description", "value" : "Activated Carbon"}
                  ]

                   }  """.stripMargin)


    (header, adsorbate, adsorbant)
  }


}
