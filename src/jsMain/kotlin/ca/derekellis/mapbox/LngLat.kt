package ca.derekellis.mapbox

value class LngLat private constructor(val array: Array<Double>) {
  constructor(longitude: Double, latitude: Double) : this(arrayOf(longitude, latitude))

  inline val longitude: Double get() = array[0]
  inline val latitude: Double get() = array[1]
}
