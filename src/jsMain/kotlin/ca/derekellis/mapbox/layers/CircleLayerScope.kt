package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import ca.derekellis.mapbox.style.Anchor
import ca.derekellis.mapbox.style.Expression
import org.jetbrains.compose.web.css.CSSColorValue

class CircleLayerScope(layerId: String, mapRef: mapbox.Map) : LayerScope(layerId, mapRef) {
  @Composable
  fun circleBlur(blur: Number) {
    paint("circle-blur", blur)
  }

  @Composable
  fun circleBlur(expression: Expression) {
    paint("circle-blur", expression)
  }

  @Composable
  fun circleColor(color: String) {
    paint("circle-color", color)
  }

  @Composable
  fun circleColor(color: CSSColorValue) {
    paint("circle-color", color.toString())
  }

  @Composable
  fun circleColor(expression: Expression) {
    paint("circle-color", expression)
  }

  @Composable
  fun circleOpacity(opacity: Number) {
    paint("circle-opacity", opacity)
  }

  @Composable
  fun circleOpacity(expression: Expression) {
    paint("circle-opacity", expression)
  }

  @Composable
  fun circlePitchAlignment(alignment: Anchor) {
    paint("circle-pitch-alignment", alignment)
  }

  @Composable
  fun circlePitchAlignment(expression: Expression) {
    paint("circle-pitch-alignment", expression)
  }

  @Composable
  fun circlePitchScale(scale: Anchor) {
    paint("circle-pitch-scale", scale)
  }

  @Composable
  fun circlePitchScale(expression: Expression) {
    paint("circle-pitch-scale", expression)
  }

  @Composable
  fun circleRadius(radius: Number) {
    paint("circle-radius", radius)
  }

  @Composable
  fun circleRadius(expression: Expression) {
    paint("circle-radius", expression)
  }

  @Composable
  fun circleSortKey(key: Number) {
    layout("circle-sort-key", key)
  }

  @Composable
  fun circleSortKey(expression: Expression) {
    layout("circle-sort-key", expression)
  }

  @Composable
  fun circleStrokeColor(color: String) {
    paint("circle-stroke-color", color)
  }

  @Composable
  fun circleStrokeColor(color: CSSColorValue) {
    paint("circle-stroke-color", color.toString())
  }

  @Composable
  fun circleStrokeColor(expression: Expression) {
    paint("circle-stroke-color", expression)
  }

  @Composable
  fun circleStrokeOpacity(opacity: Number) {
    paint("circle-stroke-opacity", opacity)
  }

  @Composable
  fun circleStrokeOpacity(expression: Expression) {
    paint("circle-stroke-opacity", expression)
  }

  @Composable
  fun circleStrokeWidth(width: Number) {
    paint("circle-stroke-width", width)
  }

  @Composable
  fun circleStrokeWidth(expression: Expression) {
    paint("circle-stroke-width", expression)
  }

  @Composable
  fun circleTranslate(x: Number, y: Number) {
    paint("circle-translate", arrayOf(x, y))
  }

  @Composable
  fun circleTranslate(expression: Expression) {
    paint("circle-translate", expression)
  }

  @Composable
  fun circleTranslateAnchor(anchor: Anchor) {
    paint("circle-translate-anchor", anchor)
  }

  @Composable
  fun circleTranslateAnchor(expression: Expression) {
    paint("circle-translate-anchor", expression)
  }
}
