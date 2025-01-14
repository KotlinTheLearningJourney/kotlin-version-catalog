package br.com.ktlj.kotlin_version_catalog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinVersionCatalogApplication

fun main(args: Array<String>) {
	runApplication<KotlinVersionCatalogApplication>(*args)
}
