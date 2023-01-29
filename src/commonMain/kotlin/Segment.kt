import com.soywiz.korge.view.*
import com.soywiz.korim.color.*

inline fun Container.segment(display: SolidRect, direction: Direction, allowMove: Boolean, updatePos: Boolean)
    = Segment(display, direction, allowMove, updatePos)

class Segment(val display: SolidRect, var direction: Direction, var allowMove: Boolean, var updatePos: Boolean) : Container() {

    fun updatePosition() {

        if (allowMove && updatePos) {

            if (direction == Direction.LEFT) {
                display.x -= (18);
            }

            if (direction == Direction.RIGHT) {
                display.x += (18);
            }

            if (direction == Direction.DOWN) {
                display.y += (18);
            }

            if (direction == Direction.UP) {
                display.y -= (18);
            }

        }

        updatePos = false;

    }

}
