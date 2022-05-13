package cl.ravenhill.lekter

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database

/*
 * "lekter" (c) by R8V.
 * "lekter" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */

object DbSettings {
  val db by lazy {
    Database.connect("jdbc:sqlite:/data/lekter.db", "org.sqlite.JDBC")
  }
}

object LibraryElementTable : IntIdTable() {
  val name = varchar("name", 255)
}

object FileTable : IntIdTable() {
  val parent = reference("parent_id", LibraryElementTable)
  val path = varchar("path", 255)
}

object CategoryTable : IntIdTable() {
  val parent = reference("parent_id", LibraryElementTable)
}

object ContainsRelationTable : IntIdTable() {
  val category = reference("category", CategoryTable)
  val element = reference("element", LibraryElementTable)
}