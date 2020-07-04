package amata1219.executable.item.command

class Tick(val value: Long) {

    init {
        if(value < 0) throw IllegalArgumentException("value must be non-negative Long.")
    }

    val isEmpty: Boolean
        get() = this.value == 0L

}