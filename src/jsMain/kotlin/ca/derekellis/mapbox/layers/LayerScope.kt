package ca.derekellis.mapbox.layers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import ca.derekellis.mapbox.compose.ExpressionNode
import ca.derekellis.mapbox.compose.ExpressionType
import ca.derekellis.mapbox.compose.MapNodeApplier
import ca.derekellis.mapbox.style.Visibility

abstract class LayerScope(protected val layerId: String, private val mapRef: mapbox.Map) {
  @Composable
  protected fun paint(name: String, value: Any?) {
    ComposeNode<ExpressionNode, MapNodeApplier>(
      factory = {
        ExpressionNode(name, value, ExpressionType.PAINT)
      },
      update = {
        set(value) {
          this.expression = value
          if (mapRef.getLayer(layerId) != null) {
            mapRef.setPaintProperty(layerId, this.name, value)
          }
        }
      },
    )
  }

  @Composable
  protected fun layout(name: String, value: Any?) {
    ComposeNode<ExpressionNode, MapNodeApplier>(
      factory = {
        ExpressionNode(name, value, ExpressionType.LAYOUT)
      },
      update = {
        set(value) {
          this.expression = value
          if (mapRef.getLayer(layerId) != null) {
            mapRef.setLayoutProperty(layerId, this.name, value)
          }
        }
      },
    )
  }

  @Composable
  public fun visibility(visibility: Visibility) {
    layout("visibility", visibility)
  }
}
