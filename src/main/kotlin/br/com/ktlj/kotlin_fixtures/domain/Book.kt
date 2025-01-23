package br.com.ktlj.kotlin_fixtures.domain

data class Book(
  val id: Int,
  val title: String,
  val authors: List<Author> = emptyList(),
  val isAvailable: Boolean = true,
) {
}