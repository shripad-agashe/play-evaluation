import java.io.File
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
    "org.seleniumhq.selenium" % "selenium-java" % "2.32.0" % "test",
    "org.fusesource.scalate" % "scalate-core_2.10" % "1.6.1"
  )





  val customDist = TaskKey[Unit]("dist-custom", "Packs additional files in the distribution zip")

  val someTask = customDist <<= (dist, distDirectory) map {(originalZip, originalDir) =>
    val viewsDir = new File("./app/views")

    IO.unzip(originalZip, originalDir)

    val unzippedDir = new File(originalDir, appName + "-" + appVersion)
    IO.copyDirectory(viewsDir, unzippedDir)

    def filesToZip(files : Array[File]) : List[(File, String)] = {
      files.foldLeft(List[(File, String)]()) {
        (accumulator, file) => {
          val relativePath = file.getAbsolutePath.substring(file.getAbsolutePath.indexOf("play-evaluation-1.0-SNAPSHOT"))
          if (file.isDirectory)
            (file, relativePath) :: filesToZip(file.listFiles()) ::: accumulator
          else
            (file, relativePath) :: accumulator
        }
      }
    }

    IO.zip(filesToZip(Array(unzippedDir)), originalZip)
    IO.delete(unzippedDir)
  }



  val main = play.Project(appName, appVersion, appDependencies, settings = Seq(someTask) ++ Defaults.defaultSettings)
    .settings(jasmineSettings: _*)
    .settings(
    appJsDir <+= resourceManaged / "main/public/javascripts",
    appJsLibDir <+= baseDirectory / "public/javascripts",
    jasmineTestDir <+= baseDirectory / "test/assets/specs",
    jasmineConfFile <+= baseDirectory / "test/assets/test.dependencies.js",

    //resourceGenerators in test <+= CoffeescriptCompiler  ,
    // link jasmine to the standard 'sbt test' action. Now when running 'test' jasmine tests will be run, and if they pass
    // then other Play tests will be executed.
    (test in Test) <<= (test in Test) dependsOn (jasmine),
    (jasmine) <<= (jasmine) dependsOn(Tasks.hello)

  ).settings( Tasks.helloTask)
  .settings(
    coffeescriptEntryPoints <<= baseDirectory(_ / "app" / "assets" / "javascripts" ** "*.coffee")
  )
}
