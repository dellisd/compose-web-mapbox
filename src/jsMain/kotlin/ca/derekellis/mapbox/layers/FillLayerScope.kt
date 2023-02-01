package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import ca.derekellis.mapbox.style.Anchor
import ca.derekellis.mapbox.style.Expression
import org.jetbrains.compose.web.css.CSSColorValue

class FillLayerScope(layerId: String, mapRef: mapbox.Map) : LayerScope(layerId, mapRef) {
  @Composable
  fun fillAntialias(value: Boolean) {
    paint("fill-antialias", value)
  }

  @Composable
  fun fillAntialias(expression: Expression) {
    paint("fill-antialias", expression)
  }

  @Composable
  fun fillColor(color: String) {
    paint("fill-color", color)
  }

  @Composable
  fun fillColor(color: CSSColorValue) {
    paint("fill-color", color.toString())
  }

  @Composable
  fun fillColor(expression: Expression) {
    paint("fill-color", expression)
  }

  @Composable
  fun fillOpacity(opacity: Double) {
    paint("fill-opacity", opacity)
  }

  @Composable
  fun fillOpacity(expression: Expression) {
    paint("fill-opacity", expression)
  }

  @Composable
  fun fillOutlineColor(color: String) {
    paint("fill-outline-color", color)
  }

  @Composable
  fun fillOutlineColor(color: CSSColorValue) {
    paint("fill-outline-color", color.toString())
  }

  @Composable
  fun fillOutlineColor(expression: Expression) {
    paint("fill-outline-color", expression)
  }

  @Composable
  fun fillPattern(image: String) {
    paint("fill-pattern", image)
  }

  @Composable
  fun fillPattern(expression: Expression) {
    paint("fill-pattern", expression)
  }

  @Composable
  fun fillSortKey(key: Double) {
    layout("fill-sort-key", key)
  }

  @Composable
  fun fillSortKey(expression: Expression) {
    layout("fill-sort-key", expression)
  }

  @Composable
  fun fillTranslate(x: Double, y: Double) {
    paint("fill-translate", arrayOf(x, y))
  }

  @Composable
  fun fillTranslate(expression: Expression) {
    paint("fill-translate", expression)
  }

  @Composable
  fun fillTranslateAnchor(anchor: Anchor) {
    paint("fill-translate-anchor", anchor)
  }

  @Composable
  fun fillTranslateAnchor(expression: Expression) {
    paint("fill-translate-anchor", expression)
  }
}
