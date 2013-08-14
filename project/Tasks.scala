import com.gu.SbtJasminePlugin._
import java.io.File
import play.core.coffeescript.CoffeescriptCompiler
import sbt._
import sbt.Keys._
import IO._
import sbt.{Task, Project, TaskKey}


object Tasks {
  val hello = TaskKey[Unit]("Hello","prints hello")
  val coffeTestDir = SettingKey[File]("testfile")

  val helloTask  = hello := {

    val file: File = new File("./test/assets/specs/validation.spec.coffee")
    val compiledFile = CoffeescriptCompiler.compile(file, Seq("bare"))
    println(compiledFile)
    val jsTest = new File("./test/specs/validation.spec.js")
    write(jsTest, compiledFile)
  }
}