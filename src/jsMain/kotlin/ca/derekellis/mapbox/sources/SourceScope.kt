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
import mapbox.BackgroundLayer

class SourceScope(private val sourceId: String, private val mapRef: mapbox.Map) {
  @Composable
  private fun <T : LayerScope> Layer(id: String, type: String, scope: T, style: @Composable T.() -> Unit) {
    ComposeNode<LayerNode, MapNodeApplier>(
      factory = {
        LayerNode(
          id,
          jsObject<BackgroundLayer> {
            this.type = type
            this.source = sourceId
            this.id = id
          },
        )
      },
      update = {
        set(id) { this.id = id }
      },
      content = { scope.style() },
    )
  }

  @Composable
  fun BackgroundLayer(id: String, style: @Composable BackgroundLayerScope.() -> Unit = {}) {
    val styleScope = BackgroundLayerScope(id, mapRef)
    Layer(id, "background", styleScope, style)
  }

  @Composable
  fun FillLayer(id: String, style: @Composable FillLayerScope.() -> Unit = {}) {
    val styleScope = FillLayerScope(id, mapRef)
    Layer(id, "fill", styleScope, style)
  }

  @Composable
  fun LineLayer(id: String, style: @Composable LineLayerScope.() -> Unit = {}) {
    val styleScope = LineLayerScope(id, mapRef)
    Layer(id, "line", styleScope, style)
  }

  @Composable
  fun SymbolLayer(id: String, style: @Composable SymbolLayerScope.() -> Unit = {}) {
    val styleScope = SymbolLayerScope(id, mapRef)
    Layer(id, "symbol", styleScope, style)
  }

  @Composable
  fun CircleLayer(id: String, style: @Composable CircleLayerScope.() -> Unit = {}) {
    val styleScope = CircleLayerScope(id, mapRef)
    Layer(id, "circle", styleScope, style)
  }
}
