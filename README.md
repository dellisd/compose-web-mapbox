# compose-web-mapbox

A Compose for Web wrapper of Mapbox.

## Setup

This library currently targets Kotlin `1.8.10`, with a minimum Compose for Web version of `1.3.1-rc02`.  
(Kotlin 1.8.0 is unsupported due to a compiler bug).

To add this to your compose project, make sure to specify the version of the compose compiler, and add this library as a dependency.

```kotlin
// build.gradle.kts
plugins {
  id("org.jetbrains.kotlin.multiplatform") version "1.8.10"
  id("org.jetbrains.compose") version "1.3.1-rc02"
}

repositories {
  maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
}

kotlin {
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation("ca.derekellis.mapbox:compose-web-mapbox:0.1.0-SNAPSHOT")
      }
    }
  }
}
```

## Usage

To create a map, call `rememberMapboxState()` to obtain a map state object that you can use to programmatically interact with the map. Then call the `MapboxMap()` composable and pass it your Mapbox access token and a map style URL at a minimum.

```kotlin
val mapState = rememberMapboxState()

MapboxMap(
  accessToken = MAPBOX_ACCESS_TOKEN,
  style = "mapbox://styles/mapbox/dark-v10",
  state = mapState,
) {
  // Place your sources and layers here
}
```

### Adding Sources

Data sources are added using Composable methods in the `sources` block of the `MapboxMap` function.
Currently, only GeoJSON sources are implemented.

```kotlin
import geojson.GeoJsonObject

MapboxMap(/* ... */) {
  GeoJsonSource(id = "test", data = data.unsafeCast<GeoJsonObject>()) {
    // Layers for this data source go here
  }
}
```

### Adding Layers

Layers are added within the scope of a data source. The layer is automatically set up to pull data from that source.
Paint and layout properties can be applied to the layer.

```kotlin
MapboxMap(/* ... */) {
  GeoJsonSource(/* ... */) {
    CircleLayer(id = "circles") {
      circleColor("#FF0000")
      circleRadius(10)
    }
  }
}
```

All the source, layer, and paint/layout property functions are composable functions meaning that their properties
can be updated like any other composable function.

```kotlin
var size by remember { mutableStateOf(1) }

MapboxMap(/* ... */) {
  GeoJsonSource(/* ... */) {
    CircleLayer(id = "circles") {
      circleColor("#FF0000")
      // The circle radius will automatically update on the map
      circleRadius(size)
    }
  }
}
Button(attrs = {
  onClick = { size++ }
}) {
  Text("Increase Size")
}
```

## Building the Sample

This repo includes a [sample](sample) project using the map. You can try out the sample here: https://dellisd.github.io/compose-web-mapbox.

To build the sample locally, first create a `local.properties` file at the repository root and add your Mapbox access token to it.
```properties
MAPBOX_ACCESS_TOKEN={ your access token here }
```

Next, build and run the project:

```shell
./gradlew :sample:jsBrowserRun
```

The sample will open at http://localhost:8080.