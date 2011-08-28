import com.robert42.Greeter
import org.junit.Test
import com.codahale.simplespec.Spec

class AppSpec extends Spec {
  class `The greeter` {
    @Test def `greets friendly.` = {
      Greeter.greet must be("Hello, Scala world!")
    }
  }
}
