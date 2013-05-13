import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "play-evaluation"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
    "org.seleniumhq.selenium" % "selenium-java" % "2.32.0" % "test"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
