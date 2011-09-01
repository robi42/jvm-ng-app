import com.robert42.jvmng.{MongoConfig, MainDoc, MainDocs}
import org.junit.Test
import com.codahale.simplespec.Spec
import com.foursquare.rogue.Rogue._

class AppSpec extends Spec {
  MongoConfig.init

  class `A MongoDB document` {
    @Test def `can be CRUDed.` = {
      // Creation.
      val json = """{"name": "md1", "cnt": 123, "isNew": true}"""
      MainDocs create json

      // Querying.
      val query = MainDoc where (_.name eqs "md1") get
      val md    = query.get
      md.name.is must equalTo("md1")
      md.cnt.is must equalTo(123)

      // Updating.
      val jsonForUpdate =
        """{"name":"md2","_id":"%s","cnt":12,"isNew":false}"""
          .format(md.id)
      val updatedJson = MainDocs.update(jsonForUpdate)
      updatedJson must equalTo(jsonForUpdate)

      // Deletion.
      MainDocs remove md.id.toString
    }
  }
}
