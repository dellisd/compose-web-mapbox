import ca.derekellis.mapbox.MapboxMap
import ca.derekellis.mapbox.rememberMapboxState
import com.sample.BuildKonfig
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.renderComposable

external fun require(module: String): dynamic

object MainStyleSheet : StyleSheet() {
  init {
    "html, body, #root" style {
      width(100.percent)
      height(100.percent)
      margin(0.px)
    }
  }
}

fun main() {
  require("mapbox-gl/dist/mapbox-gl.css")

  renderComposable(rootElementId = "root") {
    val mapState = rememberMapboxState()

    Style(MainStyleSheet)
    MapboxMap(
      accessToken = BuildKonfig.MAPBOX_ACCESS_TOKEN,
      style = "mapbox://styles/mapbox/light-v10",
      state = mapState,
      containerAttrs = {
        style {
          height(100.vh)
          width(100.vw)
        }
      },
    ) {
      // TODO: Add sources
    }
  }
}
