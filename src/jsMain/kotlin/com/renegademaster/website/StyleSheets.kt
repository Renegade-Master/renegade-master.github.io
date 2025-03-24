package com.renegademaster.website

import com.renegademaster.website.RenegadeMasterLogo.body
import com.renegademaster.website.RenegadeMasterLogo.logoLeft
import com.renegademaster.website.RenegadeMasterLogo.logoRight
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.CSSColor
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.fontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.media
import org.jetbrains.compose.web.css.pc
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.css.vh


object RenegadeMasterLogo: StyleSheet() {
    val body = Modifier
        .id("body")
        .color(Color.white)
        .margin(0.px)
        .height(100.vh)
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .alignItems(AlignItems.Center)
        .fontFamily("", "Courier New")

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

    val rm = Modifier
        .id("rm")

    val largeScreen2 = media("screen and (min-width: 1200px)") {
        body.fontSize(1.5.cssRem)
        logoLeft.then(hover as Modifier) {
            
        }
    }

//    val largeScreen = media("screen and (min-width: 1200px)") {
//        style(body as CSSSelector) {
//            fontSize(1.5.cssRem)
//        }
//        style(logoLeft.hover()) {
//            backgroundColor(Color.white)
//            color(Color.black)
//        }
//    }

    val smallScreen = media("screen and (max-width: 750px)") {
        style(logoRight as CSSSelector) {
            display(DisplayStyle.None)
        }
    }
}
