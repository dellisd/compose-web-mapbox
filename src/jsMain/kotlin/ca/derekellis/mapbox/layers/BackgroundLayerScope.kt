package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import ca.derekellis.mapbox.style.Expression
import org.jetbrains.compose.web.css.CSSColorValue

class BackgroundLayerScope(layerId: String, mapRef: mapbox.Map) : LayerScope(layerId, mapRef) {
  @Composable
  fun backgroundColor(color: String) {
    paint("background-color", color)
  }

  @Composable
  fun backgroundColor(color: CSSColorValue) {
    paint("background-color", color.toString())
  }

  @Composable
  fun backgroundColor(expression: Expression) {
    paint("background-color", expression)
  }

  @Composable
  fun backgroundOpacity(opacity: Double) {
    paint("background-opacity", opacity)
  }

  @Composable
  fun backgroundOpacity(expression: Expression) {
    paint("background-color", expression)
  }

  @Composable
  fun backgroundPattern(image: String) {
    paint("background-color", image)
  }

  @Composable
  fun backgroundPattern(expression: Expression) {
    paint("background-color", expression)
  }
}
