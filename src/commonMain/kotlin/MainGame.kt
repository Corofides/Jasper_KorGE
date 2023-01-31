import com.soywiz.korge.scene.*
import com.soywiz.korge.view.*
import com.github.quillraven.fleks.*
import com.soywiz.korim.color.*
import components.*
import systems.*

class MainGame: Scene() {

    companion object {
        const val scaleFactor = 3
    }

    override suspend fun SContainer.sceneMain() {

        container {
            scale = scaleFactor.toDouble()

            val layer0 = container();

            val world = world(entityCapacity = 512) {

                injectables {
                    add("layer0", layer0)
                }

                components {
                    onAdd(Segment, Segment.onComponentAdded)
                    onRemove(Segment, Segment.onComponentRemoved)
                }

                systems {
                    add(PlayerSpawnSystem())
                }

            }

            world.entity {
                it += Segment();
            }

            addUpdater { dt ->
                world.update(dt.seconds.toFloat())
            }
        }

        solidRect(16.0, 16.0, Colors.GREEN) {
            x = 0.0;
            y = 0.0;

            addUpdater {
                x += 1.0;
            }

        }

        /*val layer0 = container();

        val world = world(entityCapacity = 512) {

        }*/

    }

}
