package entities

import components.*
import com.github.quillraven.fleks.World

fun World.createPlayerArtefact(position: Position) {

    entity {
        var xx = position.x;
        var yy = position.y;

        it += Position(
            x = xx,
            y = yy,
        )

        it += Segment()
    }

}
