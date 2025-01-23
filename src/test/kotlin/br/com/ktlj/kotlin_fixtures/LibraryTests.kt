package br.com.ktlj.kotlin_fixtures

import br.com.ktlj.kotlin_fixtures.domain.Author
import br.com.ktlj.kotlin_fixtures.domain.Book
import br.com.ktlj.kotlin_fixtures.domain.Library
import br.com.ktlj.kotlin_fixtures.domain.Library.LibraryType
import com.appmattus.kotlinfixture.kotlinFixture
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeOneOf
import io.kotest.matchers.nulls.beNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe

class LibraryTests : StringSpec({
  val fixture = kotlinFixture()

  beforeEach {
   println("Test: ${it.name.testName}")
  }

  fun Library.print() {
    println(this.type)
    println(this.books)
  }

  "Should be able to create a random library" {
    val library = fixture<Library>()

    library.print()

    library.books shouldNotBe emptyList<Book>()
    library.type shouldBeOneOf LibraryType.entries
  }

  "Should be able to create a random library without books" {
    val library = fixture<Library> {
      property(Library::books) { emptyList() }
    }

    library.print()

    library.books shouldBe emptyList()
  }

  "Should be able to create a library with books from a single author" {
    val booksFromJohnDoe = fixture.asSequence<Book> {
      property(Book::authors) {
        listOf(fixture<Author> {
          property(Author::id) { 1 }
          property(Author::name) { "John Doe" }
        })
      }
    }

    val library = fixture<Library> {
      property(Library::books) { booksFromJohnDoe.take(5).toList() }
    }

    library.print()

    library.books.size shouldBe 5
  }
})