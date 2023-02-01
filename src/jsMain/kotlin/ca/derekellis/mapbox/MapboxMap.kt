package ca.derekellis.mapbox

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mapbox.Map
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun MapboxMap(
  accessToken: String,
  style: String,
  state: MapboxState = rememberMapboxState(),
  hash: Boolean = false,
  projection: String = "mercator",
  containerAttrs: AttrsScope<HTMLDivElement>.() -> Unit = {},
  events: EventsScope.() -> Unit = {},
  sources: @Composable MapScope.() -> Unit,
) {
  var map: mapbox.Map? by remember { mutableStateOf(null) }
  val scope = rememberCoroutineScope()

  Div(attrs = {
    this.containerAttrs()

    ref {
      map = Map(
        jsObject {
          this.accessToken = accessToken
          container = it
          this.style = style
          this.projection = projection
          this.hash = hash

          this.center = state.initialCenter
          this.zoom = state.initialZoom
          this.bearing = state.initialBearing
          this.pitch = state.initialPitch
        },
      )
      console.dir(map!!)
      map?.resize()

      state.map = map

      var sourceScopeJob: Job? = null
      map?.on("style.load") {
        sourceScopeJob?.cancel()
        sourceScopeJob = scope.launch {
          // https://github.com/mapbox/mapbox-gl-js/issues/2268#issuecomment-401979967
          while (map?.isStyleLoaded() == false) {
            delay(100)
          }
          applySources(map!!, sources)
          EventsScope(map!!).events()
        }
      }

      onDispose { }
    }
  })

  DisposableEffect(style) {
    map?.setStyle(style)
    onDispose { }
  }

  DisposableEffect(projection) {
    map?.setProjection(projection)
    onDispose { }
  }
}

@Composable
fun rememberMapboxState(
  center: LngLat = LngLat(0.0, 0.0),
  zoom: Double = 0.0,
  bearing: Double = 0.0,
  pitch: Double = 0.0,
): MapboxState {
  return remember { MapboxState(center, zoom, bearing, pitch) }
}
