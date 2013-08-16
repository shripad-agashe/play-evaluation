import play.core.coffeescript.CoffeescriptCompiler
import sbt._
import IO._
import sbt.TaskKey


object Tasks {
  val hello = TaskKey[Unit]("Hello", "prints hello")
  val coffeTestDir = SettingKey[File]("testfile")

  val helloTask = hello := {

    val testDir = new File("./test/assets/specs")
    for (file <- testDir.listFiles.partition(_.getName.endsWith(".coffee"))._1) {
      val jsFile: File = new File("./test/assets/specs/"+file.getName)
      val compiledFile = CoffeescriptCompiler.compile(jsFile, Seq("bare"))
      val newFileName=   (file.getName).replaceAll(".coffee",".js")
      val jsTest = new File("./test/assets/specs/"+newFileName)
      write(jsTest, compiledFile)
    }
  }
}