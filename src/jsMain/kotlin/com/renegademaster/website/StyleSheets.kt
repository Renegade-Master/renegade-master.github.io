package com.renegademaster.website

import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionDuration
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.pc
import org.jetbrains.compose.web.css.px
import kotlin.time.Duration.Companion.seconds


object RenegadeMasterLogo: StyleSheet() {
    val navbar = Modifier
        .id("navbar")
        .display(DisplayStyle.Flex)
        .flexDirection(FlexDirection.Row)
        .width(100.pc)
        .background(rgb(0x6E28D9))
        .padding(1.cssRem)

    val logo = Modifier
        .id("logo")
        .cursor(Cursor.Crosshair)


    val logoLeft = Modifier
        .id("logo_left")
        .backgroundColor(Color.black)
        .width(24.px)
        .height(24.px)
        .padding(1.cssRem)
        .borderRadius(100.pc)
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .alignItems(AlignItems.Center)
        .fontSize(1.5.cssRem)
        .transition(Transition.all())

    val logoRight = Modifier
        .id("logo_right")
}
