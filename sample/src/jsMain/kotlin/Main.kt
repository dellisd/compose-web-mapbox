import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ca.derekellis.mapbox.MapboxMap
import ca.derekellis.mapbox.rememberMapboxState
import com.sample.BuildKonfig
import geojson.GeoJsonObject
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.RangeInput
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

external fun require(module: String): dynamic

fun main() {
  require("mapbox-gl/dist/mapbox-gl.css")
  val data = require("./data.json")

  renderComposable(rootElementId = "root") {
    val mapState = rememberMapboxState()

    var color by remember { mutableStateOf("#000000") }
    var showLayer by remember { mutableStateOf(true) }
    var circleSize by remember { mutableStateOf(5) }
    var isDarkTheme by remember { mutableStateOf(false) }

    if (isDarkTheme) Style(Dark) else Style(Light)
    Style(MainStyleSheet)

    MapboxMap(
      accessToken = BuildKonfig.MAPBOX_ACCESS_TOKEN,
      style = if (isDarkTheme) "mapbox://styles/mapbox/dark-v10" else "mapbox://styles/mapbox/light-v10",
      state = mapState,
      containerAttrs = {
        style {
          height(100.vh)
          width(100.vw)
        }
      },
    ) {
      GeoJsonSource("test", data = data.unsafeCast<GeoJsonObject>()) {
        if (showLayer) {
          CircleLayer("circles") {
            circleColor(color)
            circleRadius(circleSize)
          }
        }
      }
    }

    // Map Controls
    Div(attrs = { classes(MainStyleSheet.overlay) }) {
      Div {
        Label(forId = "color") { Text("Layer Color:") }
        Input(InputType.Color, attrs = {
          id("color")
          onInput { color = it.value }
        })
      }
      Div {
        Label(forId = "layer-toggle") { Text("Toggle Layer:") }
        Button(attrs = {
          id("layer-toggle")
          onClick { showLayer = !showLayer }
        }) { Text(if (showLayer) "ON" else "OFF") }
      }
      Div {
        Label(forId = "circle-size") { Text("Circle Size:") }
        RangeInput(value = circleSize, min = 5, max = 30) {
          id("circle-size")
          onInput { circleSize = it.value?.toInt() ?: circleSize }
        }
      }
      Div {
        Label(forId = "theme-toggle") { Text("Toggle Theme:") }
        Button(attrs = {
          id("theme-toggle")
          onClick { isDarkTheme = !isDarkTheme }
        }) { Text(if (isDarkTheme) "Dark" else "Light") }
      }
    }
  }
}
