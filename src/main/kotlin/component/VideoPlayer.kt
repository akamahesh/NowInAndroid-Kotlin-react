package component

import EmailIcon
import EmailShareButton
import TelegramIcon
import TelegramShareButton
import WhatsappIcon
import WhatsappShareButton
import data.Video
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import lib.ReactPlayer
import react.*
import react.dom.h3
import styled.css
import styled.styledButton
import styled.styledDiv

external interface VideoPlayerProps : RProps {
    var video: Video
    var unwatchedVideo: Boolean
    var onWatchedButtonPressed: (Video) -> Unit
}

class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"John Doe: Building and breaking things"
            }
            styledButton {
                css {
                    display = Display.block
                    backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
                }
                attrs {
                    onClickFunction = {
                        props.onWatchedButtonPressed(props.video)
                    }
                }
                if (props.unwatchedVideo) {
                    +"Mark as watched"
                } else {
                    +"Mark as unwatched"
                }
            }

            styledDiv {
                css {
                    display = Display.flex
                    marginBottom = 10.px
                }
                EmailShareButton {
                    attrs.url = props.video.videoUrl
                    EmailIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }

                TelegramShareButton {
                    attrs.url = props.video.videoUrl
                    TelegramIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
                WhatsappShareButton {
                    attrs.url = props.video.videoUrl
                    WhatsappIcon {
                        attrs.size = 32
                        attrs.round = true
                    }
                }
            }

            ReactPlayer {
                attrs {
                    url = props.video.videoUrl
                }
            }
        }
    }

}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}