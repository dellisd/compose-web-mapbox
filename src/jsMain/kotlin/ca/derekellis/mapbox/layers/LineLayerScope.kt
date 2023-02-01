package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import ca.derekellis.mapbox.style.Anchor
import ca.derekellis.mapbox.style.Expression
import ca.derekellis.mapbox.style.LineCap
import ca.derekellis.mapbox.style.LineJoin
import org.jetbrains.compose.web.css.CSSColorValue

class LineLayerScope(layerId: String, mapRef: mapbox.Map) : LayerScope(layerId, mapRef) {
  @Composable
  fun lineBlur(blur: Double) {
    paint("line-blur", blur)
  }

  @Composable
  fun lineBlur(expression: Expression) {
    paint("line-blur", expression)
  }

  @Composable
  fun lineCap(cap: LineCap) {
    layout("line-cap", cap)
  }

  @Composable
  fun lineCap(expression: Expression) {
    layout("line-cap", expression)
  }

  @Composable
  fun lineColor(color: String) {
    paint("line-color", color)
  }

  @Composable
  fun lineColor(color: CSSColorValue) {
    paint("line-color", color.toString())
  }

  @Composable
  fun lineColor(expression: Expression) {
    paint("line-color", expression)
  }

  @Composable
  fun lineDasharray(vararg values: Double) {
    paint("line-dasharray", values)
  }

  @Composable
  fun lineDasharray(expression: Expression) {
    paint("line-dasharray", expression)
  }

  @Composable
  fun lineGapWidth(width: Double) {
    paint("line-gap-width", width)
  }

  @Composable
  fun lineGapWidth(expression: Expression) {
    paint("line-gap-width", expression)
  }

  @Composable
  fun lineGradient(expression: Expression) {
    paint("line-gradient", expression)
  }

  @Composable
  fun lineJoin(join: LineJoin) {
    layout("line-join", join)
  }

  @Composable
  fun lineJoin(expression: Expression) {
    layout("line-join", expression)
  }

  @Composable
  fun lineMiterLimit(limit: Double) {
    layout("line-miter-limit", limit)
  }

  @Composable
  fun lineMiterLimit(expression: Expression) {
    layout("line-miter-limit", expression)
  }

  @Composable
  fun lineOffset(offset: Double) {
    paint("line-offset", offset)
  }

  @Composable
  fun lineOffset(expression: Expression) {
    paint("line-offset", expression)
  }

  @Composable
  fun linePattern(pattern: String) {
    paint("line-pattern", pattern)
  }

  @Composable
  fun linePattern(expression: Expression) {
    paint("line-pattern", expression)
  }

  @Composable
  fun lineRoundLimit(limit: Double) {
    layout("line-round-limit", limit)
  }

  @Composable
  fun lineRoundLimit(expression: Expression) {
    layout("line-round-limit", expression)
  }

  @Composable
  fun lineSortKey(key: Double) {
    layout("line-sort-key", key)
  }

  @Composable
  fun lineSortKey(expression: Expression) {
    layout("line-sort-key", expression)
  }

  @Composable
  fun lineTranslate(expression: Expression) {
    paint("line-translate", expression)
  }

  @Composable
  fun lineTranslateAnchor(anchor: Anchor) {
    paint("line-translate-anchor", anchor)
  }

  @Composable
  fun lineTranslateAnchor(expression: Expression) {
    paint("line-translate-anchor", expression)
  }

  @Composable
  fun lineWidth(width: Double) {
    paint("line-width", width)
  }

  @Composable
  fun lineWidth(expression: Expression) {
    paint("line-width", expression)
  }
}
