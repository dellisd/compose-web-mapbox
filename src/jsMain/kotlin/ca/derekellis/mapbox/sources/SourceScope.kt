package ca.derekellis.mapbox.sources

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import ca.derekellis.mapbox.compose.LayerNode
import ca.derekellis.mapbox.compose.MapNodeApplier
import ca.derekellis.mapbox.jsObject
import ca.derekellis.mapbox.layers.BackgroundLayerScope
import ca.derekellis.mapbox.layers.CircleLayerScope
import ca.derekellis.mapbox.layers.FillLayerScope
import ca.derekellis.mapbox.layers.LayerScope
import ca.derekellis.mapbox.layers.LineLayerScope
import ca.derekellis.mapbox.layers.SymbolLayerScope
import ca.derekellis.mapbox.style.Expression
import mapbox.FillLayer

private typealias GenericLayer = FillLayer

class SourceScope(private val sourceId: String, private val mapRef: mapbox.Map) {
  @Composable
  private fun <T : LayerScope> Layer(id: String, type: String, filter: Expression?, scope: T, style: @Composable T.() -> Unit) {
    ComposeNode<LayerNode, MapNodeApplier>(
      factory = {
        LayerNode(
          id,
          jsObject<GenericLayer> {
            this.type = type
            this.source = sourceId
            this.id = id
            if (filter != null) {
              this.filter = filter.parts.unsafeCast<Array<Any>>()
            }
          },
        )
      },
      update = {
        set(id) { this.id = id }
        set(filter) {
          if (mapRef.getLayer(id) != null) {
            mapRef.setFilter(id, filter?.parts.unsafeCast<Array<Any>?>())
          }
        }
      },
      content = { scope.style() },
    )
  }

  @Composable
  fun BackgroundLayer(id: String, filter: Expression? = null, style: @Composable BackgroundLayerScope.() -> Unit = {}) {
    val styleScope = BackgroundLayerScope(id, mapRef)
    Layer(id, "background", filter, styleScope, style)
  }

  @Composable
  fun FillLayer(id: String, filter: Expression? = null, style: @Composable FillLayerScope.() -> Unit = {}) {
    val styleScope = FillLayerScope(id, mapRef)
    Layer(id, "fill", filter, styleScope, style)
  }

  @Composable
  fun LineLayer(id: String, filter: Expression? = null, style: @Composable LineLayerScope.() -> Unit = {}) {
    val styleScope = LineLayerScope(id, mapRef)
    Layer(id, "line", filter, styleScope, style)
  }

  @Composable
  fun SymbolLayer(id: String, filter: Expression? = null, style: @Composable SymbolLayerScope.() -> Unit = {}) {
    val styleScope = SymbolLayerScope(id, mapRef)
    Layer(id, "symbol", filter, styleScope, style)
  }

  @Composable
  fun CircleLayer(id: String, filter: Expression? = null, style: @Composable CircleLayerScope.() -> Unit = {}) {
    val styleScope = CircleLayerScope(id, mapRef)
    Layer(id, "circle", filter, styleScope, style)
  }
}
