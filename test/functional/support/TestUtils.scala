package functional.support

import org.scalatest.{FunSpec, BeforeAndAfterAll}
import functional.support.WebDriverSupport

class TestUtils extends FunSpec with WebDriverSupport with BeforeAndAfterAll{

  override def afterAll() = driver.close()

}
