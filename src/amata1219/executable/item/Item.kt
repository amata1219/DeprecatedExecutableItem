package amata1219.executable.item

import amata1219.executable.item.command.Command
import org.bukkit.Material

class Item(
        private val type: Material,
        val displayName: String,
        private val lore: List<String>,
        val conditions: MutableList<List<Condition>>,
        val commands: MutableList<Command>,
        var cooldownTicks: Tick,
        var consumable: Boolean
) {

    val isCooldownless: Boolean
        get() = cooldownTicks.isEmpty

    val hashCode: Int = calculateHashCode(type, displayName, lore)

}

fun calculateHashCode(type: Material, displayName: String, lore: List<String>): Int {
    var hash = 1
    hash = hash * 31 + type.hashCode()
    hash = hash * 31 + displayName.hashCode()
    hash = hash * 31 + lore.hashCode()
    return hash
}
