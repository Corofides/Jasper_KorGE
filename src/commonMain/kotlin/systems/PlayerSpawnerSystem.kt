package systems

import com.github.quillraven.fleks.*
import components.*
import entities.*

class PlayerSpawnSystem : IteratingSystem(
    World.family { all(Segment) },
    interval = EachFrame
) {
    override fun onTickEntity(entity: Entity) {
        val segment = entity[Segment]
    }

    private fun spawn(entity: Entity) {
        val playerPosition = entity[Position]
        world.createPlayerArtefact(playerPosition);
    }

}

