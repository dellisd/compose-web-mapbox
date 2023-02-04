rootProject.name = "compose-web-mapbox"

dependencyResolutionManagement {
  repositories {
    maven("https://androidx.dev/storage/compose-compiler/repository/")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
  }
}

include(":sample")
