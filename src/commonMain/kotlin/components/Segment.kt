package components

import com.github.quillraven.fleks.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.addTo
import com.soywiz.korge.view.animation.ImageAnimationView
import com.soywiz.korim.bitmap.Bitmaps
import com.soywiz.korim.format.ImageAnimation

data class Segment (
    var solidRectView: SolidRect = SolidRect(16.0, 16.0)
) : Component<Segment> {
    override fun type(): ComponentType<Segment> = Segment

    companion object : ComponentType<Segment>() {

        val onComponentAdded: ComponentHook<Segment> = {entity, component ->
            val layerContainer = inject<Container>("layer0");
            component.solidRectView.addTo(layerContainer)
        }

        val onComponentRemoved: ComponentHook<Segment> = {entity, component ->
            component.solidRectView.removeFromParent();
        }

    }
}
