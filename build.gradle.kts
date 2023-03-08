import org.gradle.kotlin.dsl.compose

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose)
  alias(libs.plugins.spotless)
  alias(libs.plugins.publish)
}

group = "ca.derekellis.mapbox"
version = "0.1.0-SNAPSHOT"

kotlin {
  js(IR) {
    browser {
      commonWebpackConfig {
        cssSupport {
          enabled.set(true)
        }
      }
    }
  }
  sourceSets {
    val commonMain by getting
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(compose.web.core)
        implementation(compose.runtime)
        implementation(npm("mapbox-gl", libs.versions.mapbox.get()))
      }
    }
    val jsTest by getting
  }
}

spotless {
  kotlin {
    target("**/*.kt")
    targetExclude("**/generated/**/*.*")

    ktlint(libs.versions.ktlint.get()).editorConfigOverride(
      mapOf(
        "indent_size" to "2",
        "disabled_rules" to "package-name",
        "ij_kotlin_allow_trailing_comma" to "true",
        "ij_kotlin_allow_trailing_comma_on_call_site" to "true",
      )
    )

    trimTrailingWhitespace()
    endWithNewline()
  }
}
