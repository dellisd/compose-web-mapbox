@file:Suppress("NOTHING_TO_INLINE")

package ca.derekellis.mapbox.style

public sealed interface InterpolationType {
  public companion object {
    public inline val linear: InterpolationType get() = arrayOf("linear").unsafeCast<InterpolationType>()

    public inline fun exponential(base: Double) = arrayOf("exponential", base).unsafeCast<InterpolationType>()

    public inline fun cubicBezier(x1: Double, y1: Double, x2: Double, y2: Double) =
      arrayOf("cubic-bezier", x1, y1, x2, y2).unsafeCast<InterpolationType>()
  }
}

public inline fun interpolate(type: InterpolationType, input: Expression, vararg stops: Pair<Number, Any?>): Expression =
  expression(
    "interpolate",
    type,
    input.parts,
    Array(stops.size * 2) { i -> if (i % 2 == 0) stops[i / 2].first else stops[(i - 1) / 2].second })

public inline fun interpolateHcl(type: InterpolationType, input: Expression, vararg stops: Pair<Number, Any?>): Expression =
  expression(
    "interpolate-hcl",
    type,
    input.parts,
    Array(stops.size * 2) { i -> if (i % 2 == 0) stops[i / 2].first else stops[(i - 1) / 2].second })

public inline fun interpolateLab(type: InterpolationType, input: Expression, vararg stops: Pair<Number, Any?>): Expression =
  expression(
    "interpolate-lab",
    type,
    input.parts,
    Array(stops.size * 2) { i -> if (i % 2 == 0) stops[i / 2].first else stops[(i - 1) / 2].second })
