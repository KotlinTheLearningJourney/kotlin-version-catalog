package br.com.ktlj.kotlin_fixtures.domain

data class Library(
  val books: List<Book>,
  val type: LibraryType
) {
  enum class LibraryType {
    ONLINE, PHYSICAL
  }
}