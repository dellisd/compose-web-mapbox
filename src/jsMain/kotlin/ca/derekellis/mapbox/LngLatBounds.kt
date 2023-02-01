package ca.derekellis.mapbox

value class LngLatBounds private constructor(val array: Array<Double>) {
  constructor(southwest: LngLat, northeast: LngLat) : this(
    arrayOf(
      southwest.longitude,
      southwest.latitude,
      northeast.longitude,
      northeast.latitude,
    ),
  )

  constructor(west: Double, south: Double, east: Double, north: Double) : this(
    arrayOf(west, south, east, north),
  )

  inline val southwest: LngLat get() = LngLat(array[0], array[1])
  inline val northeast: LngLat get() = LngLat(array[2], array[3])
}
