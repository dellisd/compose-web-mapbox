import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontFamily
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.value
import org.jetbrains.compose.web.css.variable
import org.jetbrains.compose.web.css.width

object MainStyle {
  val textPrimary by variable<CSSColorValue>()
  val backgroundPrimary by variable<CSSColorValue>()
}

object Light : StyleSheet() {
  init {
    ":root" style {
      MainStyle.textPrimary(Color("#000000"))
      MainStyle.backgroundPrimary(Color("#FFFFFF"))
    }
  }
}

object Dark : StyleSheet() {
  init {
    ":root" style {
      MainStyle.textPrimary(Color("#FFFFFF"))
      MainStyle.backgroundPrimary(Color("#000000"))
    }
  }
}

object MainStyleSheet : StyleSheet() {
  init {
    "html, body, #root" style {
      width(100.percent)
      height(100.percent)
      margin(0.px)
      fontFamily("sans-serif")
    }

    "body" {
      backgroundColor(MainStyle.backgroundPrimary.value())
    }
  }

  val overlay by style {
    position(Position.Fixed)
    top(0.px)
    left(0.px)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    gap(8.px)
    padding(8.px)
    color(MainStyle.textPrimary.value())
  }
}
