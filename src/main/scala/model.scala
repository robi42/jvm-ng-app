package com.robert42.jvmng

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._

// Model definitions.
trait Storable {
  def create(json: String): String
  def get(id: String): String
  def all: String
  def update(json: String): String
  def remove(id: String): Unit
}

case class MainDocData(name: String, cnt: Int, isNew: Boolean)
case class MainDocAllData(_id: String, name: String, cnt: Int, isNew: Boolean)

class MainDoc private() extends MongoRecord[MainDoc] with ObjectIdPk[MainDoc] {
  def meta = MainDoc

  object name  extends StringField(this, 12)
  object cnt   extends IntField(this)
  object isNew extends BooleanField(this)
}

object MainDoc extends MainDoc with MongoMetaRecord[MainDoc]
