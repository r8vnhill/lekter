/*
 * "Lekter" (c) by R8V.
 * "Lekter" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */
package cl.ravenhill.lekter.model

import java.nio.file.Path

/**
 * A Library Element is a Node in the Lekter Media Manager Graph (LMMG).
 *
 * @property id
 *    a string that uniquely identifies the element on the database.
 * @property name
 *    a user readable name for the element; this value may be not-unique.
 * @author R8V
 */
sealed interface LibraryElement {
  val id: String
  val name: String
}

class FileNode(override val id: String, override val name: String, val path: Path) : LibraryElement

class Category(
  override val id: String,
  override val name: String,
  val children: List<LibraryElement> = mutableListOf()
) : LibraryElement

