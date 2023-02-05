import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import java.util.*

buildscript {
  configurations.all {
    resolutionStrategy {
      force("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
    }
  }
}

plugins {
  alias(libs.plugins.kotlin.multiplatform)
  alias(libs.plugins.compose)
  alias(libs.plugins.buildKonfig)
}

compose {
  kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:${libs.versions.composeCompiler.get()}")
}

kotlin {
  js(IR) {
    browser {
      commonWebpackConfig {
        cssSupport {
          enabled.set(true)
        }
      }

      binaries.executable()
    }
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.web.core)
        implementation(compose.runtime)
        implementation(rootProject)
      }
    }
  }
}


buildkonfig {
  packageName = "com.sample"
  defaultConfigs {
    val file = rootProject.file("local.properties")
    val properties = Properties().apply {
      if (file.exists()) {
        load(file.reader())
      }
    }

    val accessToken: String? = System.getenv()["MAPBOX_ACCESS_TOKEN"] ?: properties["MAPBOX_ACCESS_TOKEN"]?.toString()
    checkNotNull(accessToken) { "'MAPBOX_ACCESS_TOKEN' not defined in local.properties" }
    buildConfigField(STRING, "MAPBOX_ACCESS_TOKEN", accessToken)
  }
}
