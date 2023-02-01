package ca.derekellis.mapbox

import kotlinx.coroutines.suspendCancellableCoroutine
import mapbox.AnimationOptions
import mapbox.CameraOptions
import mapbox.FitBoundsOptions
import mapbox.PaddingOptions
import kotlin.coroutines.resume

class MapboxState(
  internal val initialCenter: LngLat = LngLat(0.0, 0.0),
  internal val initialZoom: Double = 0.0,
  internal val initialBearing: Double = 0.0,
  internal val initialPitch: Double = 0.0,
) {
  internal var map: mapbox.Map? = null
    set(value) {
      if (value != null) initMap()
      field = value
    }

  /**
   * Performs deferred initialization of the map with the initial state
   */
  private fun initMap() {
    center = initialCenter
    zoom = initialZoom
    bearing = initialBearing
    pitch = initialPitch
  }

  var center: LngLat
    get() = map!!.getCenter().let { LngLat(it.lng.toDouble(), it.lat.toDouble()) }
    set(value) {
      map?.setCenter(value.array)
    }

  var zoom: Double
    get() = map!!.getZoom().toDouble()
    set(value) {
      map?.setZoom(value)
    }

  var bearing: Double
    get() = map!!.getBearing().toDouble()
    set(value) {
      map?.setBearing(bearing)
    }

  var padding: PaddingOptions
    get() = map!!.getPadding()
    set(value) {
      map?.setPadding(value)
    }

  var pitch: Double
    get() = map!!.getPitch().toDouble()
    set(value) {
      map?.setPitch(value)
    }

  suspend fun panBy(x: Double, y: Double, options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.panBy(arrayOf(x, y), options?.let(::jsObject))
  }

  suspend fun panTo(location: LngLat, options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.panTo(location.array, options?.let(::jsObject))
  }

  suspend fun zoomTo(zoom: Double, options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.zoomTo(zoom, options?.let(::jsObject))
  }

  suspend fun zoomIn(options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.zoomIn(options?.let(::jsObject))
  }

  suspend fun zoomOut(options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.zoomOut(options?.let(::jsObject))
  }

  suspend fun rotateTo(bearing: Double, options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.rotateTo(bearing, options?.let(::jsObject))
  }

  suspend fun resetNorth(options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.resetNorth(options?.let(::jsObject))
  }

  suspend fun resetNorthPitch(options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.resetNorthPitch(options?.let(::jsObject))
  }

  suspend fun snapToNorth(options: (AnimationOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.snapToNorth(options?.let(::jsObject))
  }

  fun cameraForBounds(bounds: LngLatBounds, options: (CameraOptions.() -> Unit)? = null): CameraOptions? {
    return map?.cameraForBounds(bounds.array, options?.let(::jsObject)).unsafeCast<CameraOptions?>()
  }

  suspend fun fitBounds(bounds: LngLatBounds, options: (FitBoundsOptions.() -> Unit)? = null) = doMoveAnimation {
    map?.fitBounds(bounds, options?.let(::jsObject))
  }

  suspend fun easeTo(
    center: LngLat = this.center,
    zoom: Double = this.zoom,
    bearing: Double = this.bearing,
    pitch: Double = this.pitch,
    padding: PaddingOptions = this.padding,
    options: (AnimationOptions.() -> Unit)? = null,
  ) = doMoveAnimation {
    map?.easeTo(
      jsObject {
        this.center = center.array
        this.zoom = zoom
        this.bearing = bearing
        this.pitch = pitch
        this.padding = padding

        options?.invoke(this)
      },
    )
  }

  suspend fun flyTo(
    center: LngLat = this.center,
    zoom: Double = this.zoom,
    bearing: Double = this.bearing,
    pitch: Double = this.pitch,
    padding: PaddingOptions = this.padding,
    options: (AnimationOptions.() -> Unit)? = null,
  ) = doMoveAnimation {
    map?.flyTo(
      jsObject {
        this.center = center.array
        this.zoom = zoom
        this.bearing = bearing
        this.pitch = pitch
        this.padding = padding

        options?.invoke(this)
      },
    )
  }

  // TODO: fitScreenCoordinates, jumpTo, easeTo, flyTo

  /**
   * Runs the given [block], assuming that the [block] triggers a move animation on the [map].
   * Suspends until the move animation has ended.
   */
  private suspend fun doMoveAnimation(block: () -> Unit) {
    var listener: (Any) -> Unit
    var resumed = false
    suspendCancellableCoroutine<Unit> { continuation ->
      block()
      listener = { _ ->
        // If the animation is interrupted, the "moveend" listener may fire a second time before the cancellation is complete
        if (!resumed) {
          continuation.resume(Unit)
        }
        resumed = true
      }
      map?.on("moveend", listener)

      continuation.invokeOnCancellation {
        map?.stop()
        map?.off("moveend", listener)
      }
    }
  }
}
