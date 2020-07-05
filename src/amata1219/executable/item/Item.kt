package amata1219.executable.item

import amata1219.executable.item.command.Command
import amata1219.executable.item.extension.calculateHashCode
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

    val needsCooldown: Boolean
        get() = !cooldownTicks.isEmpty

    val hashCode: Int = calculateHashCode(type, displayName, lore)

}
