import sbt._
import Keys._
import play.Project._
import com.gu.SbtJasminePlugin._

object ApplicationBuild extends Build {

  val appName = "play-evaluation"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
    "org.seleniumhq.selenium" % "selenium-java" % "2.32.0" % "test"
  )







  val main = play.Project(appName, appVersion, appDependencies)
    .settings(jasmineSettings : _*)
    .settings(




      appJsDir <+= resourceManaged / "main/public/javascripts",

      appJsLibDir <+= baseDirectory / "public/javascripts",


      jasmineTestDir <+=  resourceManaged / "test/public",
      jasmineConfFile <+= baseDirectory / "test/assets/test.dependencies.js",

      // link jasmine to the standard 'sbt test' action. Now when running 'test' jasmine tests will be run, and if they pass
      // then other Play tests will be executed.
      (test in Test) <<= (test in Test) dependsOn (jasmine)
      )
}
