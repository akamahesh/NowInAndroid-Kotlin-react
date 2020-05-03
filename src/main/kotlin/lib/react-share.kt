@file:JsModule("react-share")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("EmailIcon")
external val EmailIcon: RClass<IconProps>

@JsName("EmailShareButton")
external val EmailShareButton: RClass<ShareButtonProps>

@JsName("TelegramIcon")
external val TelegramIcon: RClass<IconProps>

@JsName("TelegramShareButton")
external val TelegramShareButton: RClass<ShareButtonProps>

@JsName("WhatsappIcon")
external val WhatsappIcon: RClass<IconProps>

@JsName("WhatsappShareButton")
external val WhatsappShareButton: RClass<ShareButtonProps>

external interface ShareButtonProps : RProps {
    var url: String
}

external interface IconProps : RProps {
    var size: Int
    var round: Boolean
}