package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import ca.derekellis.mapbox.style.Alignment
import ca.derekellis.mapbox.style.Anchor
import ca.derekellis.mapbox.style.Expression
import ca.derekellis.mapbox.style.Justify
import ca.derekellis.mapbox.style.PositionAnchor
import ca.derekellis.mapbox.style.SymbolPlacement
import ca.derekellis.mapbox.style.SymbolZOrder
import ca.derekellis.mapbox.style.TextFit
import ca.derekellis.mapbox.style.TextTransform
import ca.derekellis.mapbox.style.WritingMode
import org.jetbrains.compose.web.css.CSSColorValue

class SymbolLayerScope(layerId: String, mapRef: mapbox.Map) : LayerScope(layerId, mapRef) {
  @Composable
  fun iconAllowOverlap(allow: Boolean) {
    layout("icon-allow-overlap", allow)
  }

  @Composable
  fun iconAllowOverlap(expression: Expression) {
    layout("icon-allow-overlap", expression)
  }

  @Composable
  fun iconAnchor(anchor: PositionAnchor) {
    layout("icon-anchor", anchor)
  }

  @Composable
  fun iconAnchor(expression: Expression) {
    layout("icon-anchor", expression)
  }

  @Composable
  fun iconColor(color: String) {
    paint("icon-color", color)
  }

  @Composable
  fun iconColor(color: CSSColorValue) {
    paint("icon-color", color.toString())
  }

  @Composable
  fun iconColor(expression: Expression) {
    paint("icon-color", expression)
  }

  @Composable
  fun iconHaloBlur(blur: Double) {
    paint("icon-halo-blur", blur)
  }

  @Composable
  fun iconHaloBlur(expression: Expression) {
    paint("icon-halo-blur", expression)
  }

  @Composable
  fun iconHaloColor(color: String) {
    paint("icon-halo-color", color)
  }

  @Composable
  fun iconHaloColor(color: CSSColorValue) {
    paint("icon-halo-color", color.toString())
  }

  @Composable
  fun iconHaloColor(expression: Expression) {
    paint("icon-halo-color", expression)
  }

  @Composable
  fun iconHaloWidth(width: Double) {
    paint("icon-halo-width", width)
  }

  @Composable
  fun iconHaloWidth(expression: Expression) {
    paint("icon-halo-width", expression)
  }

  @Composable
  fun iconIgnorePlacement(ignore: Boolean) {
    layout("icon-ignore-placement", ignore)
  }

  @Composable
  fun iconIgnorePlacement(expression: Expression) {
    layout("icon-ignore-placement", expression)
  }

  @Composable
  fun iconImage(image: String) {
    layout("icon-image", image)
  }

  @Composable
  fun iconImage(expression: Expression) {
    layout("icon-image", expression)
  }

  @Composable
  fun iconKeepUpright(keep: Boolean) {
    layout("icon-keep-upright", keep)
  }

  @Composable
  fun iconKeepUpright(expression: Expression) {
    layout("icon-keep-upright", expression)
  }

  @Composable
  fun iconOffset(x: Double, y: Double) {
    layout("icon-offset", arrayOf(x, y))
  }

  @Composable
  fun iconOffset(expression: Expression) {
    layout("icon-offset", expression)
  }

  @Composable
  fun iconOpacity(opacity: Double) {
    paint("icon-opacity", opacity)
  }

  @Composable
  fun iconOpacity(expression: Expression) {
    paint("icon-opacity", expression)
  }

  @Composable
  fun iconOptional(optional: Boolean) {
    layout("icon-optional", optional)
  }

  @Composable
  fun iconOptional(expression: Expression) {
    layout("icon-optional", expression)
  }

  @Composable
  fun iconPadding(padding: Double) {
    layout("icon-padding", padding)
  }

  @Composable
  fun iconPadding(expression: Expression) {
    layout("icon-padding", expression)
  }

  @Composable
  fun iconPitchAlignment(alignment: Alignment) {
    layout("icon-pitch-alignment", alignment)
  }

  @Composable
  fun iconPitchAlignment(expression: Expression) {
    layout("icon-pitch-alignment", expression)
  }

  @Composable
  fun iconRotate(rotation: Double) {
    layout("icon-rotation", rotation)
  }

  @Composable
  fun iconRotate(expression: Expression) {
    layout("icon-rotation", expression)
  }

  @Composable
  fun iconRotationAlignment(alignment: Alignment) {
    layout("icon-rotation-alignment", alignment)
  }

  @Composable
  fun iconRotationAlignment(expression: Expression) {
    layout("icon-rotation-alignment", expression)
  }

  @Composable
  fun iconSize(size: Double) {
    layout("icon-size", size)
  }

  @Composable
  fun iconSize(expression: Expression) {
    layout("icon-size", expression)
  }

  @Composable
  fun iconTextFit(fit: TextFit) {
    layout("icon-text-fit", fit)
  }

  @Composable
  fun iconTextFit(expression: Expression) {
    layout("icon-text-fit", expression)
  }

  @Composable
  fun iconTextFitPadding(top: Double = 0.0, right: Double = 0.0, bottom: Double = 0.0, left: Double = 0.0) {
    layout("icon-text-fit-padding", arrayOf(top, right, bottom, left))
  }

  @Composable
  fun iconTextFitPadding(expression: Expression) {
    layout("icon-text-fit-padding", expression)
  }

  @Composable
  fun iconTranslate(x: Double, y: Double) {
    paint("icon-translate", arrayOf(x, y))
  }

  @Composable
  fun iconTranslate(expression: Expression) {
    paint("icon-translate", expression)
  }

  @Composable
  fun iconTranslateAnchor(anchor: Anchor) {
    paint("icon-translate-anchor", anchor)
  }

  @Composable
  fun iconTranslateAnchor(expression: Expression) {
    paint("icon-translate-anchor", expression)
  }

  @Composable
  fun symbolAvoidEdges(avoid: Boolean) {
    layout("symbol-avoid-edges", avoid)
  }

  @Composable
  fun symbolAvoidEdges(expression: Expression) {
    layout("symbol-avoid-edges", expression)
  }

  @Composable
  fun symbolPlacement(placement: SymbolPlacement) {
    layout("symbol-placement", placement)
  }

  @Composable
  fun symbolPlacement(expression: Expression) {
    layout("symbol-placement", expression)
  }

  @Composable
  fun symbolSortKey(key: Double) {
    layout("symbol-sort-key", key)
  }

  @Composable
  fun symbolSortKey(expression: Expression) {
    layout("symbol-sort-key", expression)
  }

  @Composable
  fun symbolSpacing(spacing: Double) {
    layout("symbol-spacing", spacing)
  }

  @Composable
  fun symbolSpacing(expression: Expression) {
    layout("symbol-spacing", expression)
  }

  @Composable
  fun symbolZOrder(order: SymbolZOrder) {
    layout("symbol-z-order", order)
  }

  @Composable
  fun symbolZOrder(expression: Expression) {
    layout("symbol-z-order", expression)
  }

  @Composable
  fun textAllowOverlap(overlap: Boolean) {
    layout("text-allow-overlap", overlap)
  }

  @Composable
  fun textAllowOverlap(expression: Expression) {
    layout("text-allow-overlap", expression)
  }

  @Composable
  fun textAnchor(anchor: PositionAnchor) {
    layout("text-anchor", anchor)
  }

  @Composable
  fun textAnchor(expression: Expression) {
    layout("text-anchor", expression)
  }

  @Composable
  fun textColor(color: String) {
    paint("text-color", color)
  }

  @Composable
  fun textColor(color: CSSColorValue) {
    paint("text-color", color.toString())
  }

  @Composable
  fun textColor(expression: Expression) {
    paint("text-color", expression)
  }

  @Composable
  fun textField(field: String) {
    layout("text-field", field)
  }

  @Composable
  fun textField(expression: Expression) {
    layout("text-field", expression)
  }

  @Composable
  fun textFont(vararg stack: String) {
    layout("text-font", stack)
  }

  @Composable
  fun textFont(expression: Expression) {
    layout("text-font", expression)
  }

  @Composable
  fun textHaloBlur(blur: Double) {
    paint("text-halo-blur", blur)
  }

  @Composable
  fun textHaloBlur(expression: Expression) {
    paint("text-halo-blur", expression)
  }

  @Composable
  fun textHaloColor(color: String) {
    paint("text-halo-color", color)
  }

  @Composable
  fun textHaloColor(color: CSSColorValue) {
    paint("text-halo-color", color.toString())
  }

  @Composable
  fun textHaloColor(expression: Expression) {
    paint("text-halo-color", expression)
  }

  @Composable
  fun textHaloWidth(width: Double) {
    paint("text-halo-width", width)
  }

  @Composable
  fun textHaloWidth(expression: Expression) {
    paint("text-halo-width", expression)
  }

  @Composable
  fun textIgnorePlacement(ignore: Boolean) {
    layout("text-ignore-placement", ignore)
  }

  @Composable
  fun textIgnorePlacement(expression: Expression) {
    layout("text-ignore-placement", expression)
  }

  @Composable
  fun textJustify(justify: Justify) {
    layout("text-justify", justify)
  }

  @Composable
  fun textJustify(expression: Expression) {
    layout("text-justify", expression)
  }

  @Composable
  fun textKeepUpright(keep: Boolean) {
    layout("text-keep-upright", keep)
  }

  @Composable
  fun textKeepUpright(expression: Expression) {
    layout("text-keep-upright", expression)
  }

  @Composable
  fun textLetterSpacing(spacing: Double) {
    layout("text-letter-spacing", spacing)
  }

  @Composable
  fun textLetterSpacing(expression: Expression) {
    layout("text-letter-spacing", expression)
  }

  @Composable
  fun textLineHeight(height: Double) {
    layout("text-line-height", height)
  }

  @Composable
  fun textLineHeight(expression: Expression) {
    layout("text-line-height", expression)
  }

  @Composable
  fun textMaxAngle(max: Double) {
    layout("text-max-angle", max)
  }

  @Composable
  fun textMaxAngle(expression: Expression) {
    layout("text-max-angle", expression)
  }

  @Composable
  fun textMaxWidth(max: Double) {
    layout("text-max-width", max)
  }

  @Composable
  fun textMaxWidth(expression: Expression) {
    layout("text-max-width", expression)
  }

  @Composable
  fun textOffset(x: Double, y: Double) {
    layout("text-offset", arrayOf(x, y))
  }

  @Composable
  fun textOffset(expression: Expression) {
    layout("text-offset", expression)
  }

  @Composable
  fun textOpacity(opacity: Double) {
    paint("text-opacity", opacity)
  }

  @Composable
  fun textOpacity(expression: Expression) {
    paint("text-opacity", expression)
  }

  @Composable
  fun textOptional(optional: Boolean) {
    layout("text-optional", optional)
  }

  @Composable
  fun textOptional(expression: Expression) {
    layout("text-optional", expression)
  }

  @Composable
  fun textPadding(padding: Double) {
    layout("text-padding", padding)
  }

  @Composable
  fun textPadding(expression: Expression) {
    layout("text-padding", expression)
  }

  @Composable
  fun textPitchAlignment(alignment: Alignment) {
    layout("text-pitch-alignment", alignment)
  }

  @Composable
  fun textPitchAlignment(expression: Expression) {
    layout("text-pitch-alignment", expression)
  }

  @Composable
  fun textRadialOffset(offset: Double) {
    layout("text-radial-offset", offset)
  }

  @Composable
  fun textRadialOffset(expression: Expression) {
    layout("text-radial-offset", expression)
  }

  @Composable
  fun textRotate(degrees: Double) {
    layout("text-rotate", degrees)
  }

  @Composable
  fun textRotate(expression: Expression) {
    layout("text-rotate", expression)
  }

  @Composable
  fun textRotationAlignment(alignment: Alignment) {
    layout("text-rotation-alignment", alignment)
  }

  @Composable
  fun textRotationAlignment(expression: Expression) {
    layout("text-rotation-alignment", expression)
  }

  @Composable
  fun textSize(size: Double) {
    layout("text-size", size)
  }

  @Composable
  fun textSize(expression: Expression) {
    layout("text-size", expression)
  }

  @Composable
  fun textTransform(transform: TextTransform) {
    layout("text-transform", transform)
  }

  @Composable
  fun textTransform(expression: Expression) {
    layout("text-transform", expression)
  }

  @Composable
  fun textTranslate(x: Double, y: Double) {
    paint("text-translate", arrayOf(x, y))
  }

  @Composable
  fun textTranslate(expression: Expression) {
    paint("text-translate", expression)
  }

  @Composable
  fun textTranslateAnchor(anchor: Anchor) {
    paint("text-translate-anchor", anchor)
  }

  @Composable
  fun textTranslateAnchor(expression: Expression) {
    paint("text-translate-anchor", expression)
  }

  @Composable
  fun textVariableAnchor(anchor: PositionAnchor) {
    layout("text-variable-anchor", anchor)
  }

  @Composable
  fun textVariableAnchor(expression: Expression) {
    layout("text-variable-anchor", expression)
  }

  @Composable
  fun textWritingMode(mode: WritingMode) {
    layout("text-writing-mode", mode)
  }

  @Composable
  fun textWritingMode(expression: Expression) {
    layout("text-writing-mode", expression)
  }
}
