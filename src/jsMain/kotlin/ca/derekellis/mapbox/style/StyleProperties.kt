package ca.derekellis.mapbox.style

sealed interface Anchor {
  companion object {
    inline val map: Anchor get() = "map".unsafeCast<Anchor>()
    inline val viewport: Anchor get() = "viewport".unsafeCast<Anchor>()
  }
}

sealed interface PositionAnchor {
  companion object {
    inline val center: PositionAnchor get() = "center".unsafeCast<PositionAnchor>()
    inline val left: PositionAnchor get() = "left".unsafeCast<PositionAnchor>()
    inline val right: PositionAnchor get() = "right".unsafeCast<PositionAnchor>()
    inline val bottom: PositionAnchor get() = "bottom".unsafeCast<PositionAnchor>()
    inline val topLeft: PositionAnchor get() = "top-left".unsafeCast<PositionAnchor>()
    inline val topRight: PositionAnchor get() = "top-right".unsafeCast<PositionAnchor>()
    inline val bottomLeft: PositionAnchor get() = "bottom-left".unsafeCast<PositionAnchor>()
    inline val bottomRight: PositionAnchor get() = "bottom-right".unsafeCast<PositionAnchor>()
  }
}

sealed interface Justify {
  companion object {
    inline val auto: Justify get() = "auto".unsafeCast<Justify>()
    inline val left: Justify get() = "left".unsafeCast<Justify>()
    inline val center: Justify get() = "center".unsafeCast<Justify>()
    inline val right: Justify get() = "right".unsafeCast<Justify>()
  }
}

sealed interface Visibility {
  companion object {
    inline val visible: Visibility get() = "visible".unsafeCast<Visibility>()
    inline val none: Visibility get() = "none".unsafeCast<Visibility>()
  }
}

sealed interface LineCap {
  companion object {
    inline val butt: LineCap get() = "butt".unsafeCast<LineCap>()
    inline val round: LineCap get() = "round".unsafeCast<LineCap>()
    inline val square: LineCap get() = "square".unsafeCast<LineCap>()
  }
}

sealed interface LineJoin {
  companion object {
    inline val bevel: LineJoin get() = "bevel".unsafeCast<LineJoin>()
    inline val round: LineJoin get() = "round".unsafeCast<LineJoin>()
    inline val miter: LineJoin get() = "miter".unsafeCast<LineJoin>()
  }
}

sealed interface Alignment {
  companion object {
    inline val map: Alignment get() = "map".unsafeCast<Alignment>()
    inline val viewport: Alignment get() = "viewport".unsafeCast<Alignment>()
    inline val auto: Alignment get() = "auto".unsafeCast<Alignment>()
  }
}

sealed interface TextFit {
  companion object {
    inline val none: TextFit get() = "none".unsafeCast<TextFit>()
    inline val width: TextFit get() = "width".unsafeCast<TextFit>()
    inline val height: TextFit get() = "height".unsafeCast<TextFit>()
    inline val both: TextFit get() = "both".unsafeCast<TextFit>()
  }
}

sealed interface SymbolPlacement {
  companion object {
    inline val point: SymbolPlacement get() = "point".unsafeCast<SymbolPlacement>()
    inline val line: SymbolPlacement get() = "line".unsafeCast<SymbolPlacement>()
    inline val lineCenter: SymbolPlacement get() = "line-center".unsafeCast<SymbolPlacement>()
  }
}

sealed interface SymbolZOrder {
  companion object {
    inline val auto: SymbolZOrder get() = "auto".unsafeCast<SymbolZOrder>()
    inline val viewportY: SymbolZOrder get() = "viewport-y".unsafeCast<SymbolZOrder>()
    inline val source: SymbolZOrder get() = "source".unsafeCast<SymbolZOrder>()
  }
}

sealed interface TextTransform {
  companion object {
    inline val none: TextTransform get() = "none".unsafeCast<TextTransform>()
    inline val uppercase: TextTransform get() = "uppercase".unsafeCast<TextTransform>()
    inline val lowercase: TextTransform get() = "lowercase".unsafeCast<TextTransform>()
  }
}

sealed interface WritingMode {
  companion object {
    inline val horizontal: WritingMode get() = "horizontal".unsafeCast<WritingMode>()
    inline val vertical: WritingMode get() = "vertical".unsafeCast<WritingMode>()
  }
}
