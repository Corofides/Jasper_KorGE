import com.soywiz.klock.*
import com.soywiz.korge.*
import com.soywiz.korge.scene.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.*
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.*
import com.soywiz.korma.interpolation.*
import com.soywiz.korev.Key

suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
	val sceneContainer = sceneContainer()

	sceneContainer.changeTo({ MyScene() })
}

class MyScene : Scene() {
	override suspend fun SContainer.sceneMain() {
		val minDegrees = (-16).degrees
		val maxDegrees = (+16).degrees

        val drawSize = 16;
        val guideSize = 2;
        val tickTime = 500.0; //Time of a tick in milliseconds

        val segments = listOf(solidRect(drawSize, drawSize, Colors.GREEN) {
            x = 512.0 / 2 - (drawSize / 2);
            y = 512.0 / 2 - (drawSize / 2);
        });

        /*for (i in 0..1) {
            snake.plus(solidRect(drawSize, drawSize, Colors.GREEN) {
                x = 512.0 / 2 - (drawSize / 2);
                y = 512.0 / 2 - (drawSize / 2);
            })
        }*/

        var nextTime = 0.0;
        var started = false;
        var direction = Direction.UP;

        addUpdater {

            println("Time Interval $it");

            if (input.keys[Key.LEFT]) {
                started = true;
                direction = Direction.LEFT;
            }

            if (input.keys[Key.RIGHT]) {
                started = true;
                direction = Direction.RIGHT;
            }

            if (input.keys[Key.UP]) {
                started = true;
                direction = Direction.UP;
            }

            if (input.keys[Key.DOWN]) {
                started = true;
                direction = Direction.DOWN;
            }

            if (started && nextTime <= 0) {

                nextTime += tickTime;

                for (segment in segments) {

                    if (direction == Direction.LEFT) {
                        segment.x -= (18);
                    }

                    if (direction == Direction.RIGHT) {
                        segment.x += (18);
                    }

                    if (direction == Direction.DOWN) {
                        segment.y += (18);
                    }

                    if (direction == Direction.UP) {
                        segment.y -= (18);
                    }

                }

            }

            if (started) {
                nextTime -= it.milliseconds;
            }


        }



		/*val image = image(resourcesVfs["korge.png"].readBitmap()) {
			rotation = maxDegrees
			anchor(.5, .5)
			scale(0.8)
			position(256, 256)
		}

		while (true) {
			image.tween(image::rotation[minDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
			image.tween(image::rotation[maxDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
		}*/
	}
}
