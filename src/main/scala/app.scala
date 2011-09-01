package com.robert42.jvmng

import net.liftweb.json._
import net.liftweb.json.Serialization.read
import com.foursquare.rogue.Rogue._
import org.bson.types.ObjectId

// Persistence layer interface.
object MainDocs extends Storable {
  implicit val formats = Serialization.formats(NoTypeHints)

  def create(json: String) = {
    val data   = read[MainDocData](json)
    val record = MainDoc.createRecord
      .name(data.name)
      .cnt(data.cnt)
      .isNew(data.isNew)
      .save
    compact(render(record.asJValue))
  }

  def get(id: String) = {
    val query  = MainDoc where (_.id eqs new ObjectId(id)) get
    val record = query.get
    compact(render(record.asJValue))
  }

  def all = {
    val all = MainDoc.findAll.map(_.asJValue)
    compact(render(JArray(all)))
  }

  def update(json: String) = {
    val data  = read[MainDocAllData](json)
    val query = MainDoc where (_.id eqs new ObjectId(data._id))
    val modification = query modify
      (_.name setTo data.name) and (_.cnt setTo data.cnt) and
      (_.isNew setTo data.isNew)
    modification.updateOne
    val record = query.get.get
    compact(render(record.asJValue))
  }

  def remove(id: String) = {
    val query  = MainDoc where (_.id eqs new ObjectId(id)) get
    val record = query.get
    record.delete_!
  }
}
