plugins {
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.boot.dependency.management)
	alias(libs.plugins.spring.boot.jpa)
}

group = "br.com.ktlj"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	gradlePluginPortal()
}

dependencies {
	implementation(libs.spring.boot.starter.data.jpa)
	implementation(libs.spring.boot.starter.web)
	implementation(libs.kotlin.jackson.module)
	implementation(libs.kotlin.reflect)
	runtimeOnly(libs.postgresql)
	testImplementation(libs.test.spring.boot.starter)
	testImplementation(libs.test.junit5)
	testImplementation(libs.test.junit.platform)
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
