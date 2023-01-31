package components

import com.github.quillraven.fleks.Component
import com.github.quillraven.fleks.*

data class Position(
    var x: Double = 100.0,
    var y: Double = 100.0,
) : Component<Position> {
    override fun type(): ComponentType<Position> = Position

    companion object : ComponentType<Position>()
}
