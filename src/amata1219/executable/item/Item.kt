package amata1219.executable.item

import amata1219.executable.item.command.Command
import org.bukkit.Material

class Item(
        private val type: Material,
        val displayName: String,
        private val lore: List<String>,
        val conditions: List<List<Condition>>,
        val commands: List<Command>,
        var cooldownTicks: Tick,
        var consumable: Boolean
) {

    val isNonCooldown: Boolean
        get() = cooldownTicks.isEmpty

    val hashCode: Int = calculateHashCode(type, displayName, lore)

    private fun calculateHashCode(type: Material, displayName: String, lore: List<String>): Int {
        var hash = 1
        hash = hash * 31 + type.hashCode()
        hash = hash * 31 + displayName.hashCode()
        hash = hash * 31 + lore.hashCode()
        return hash
    }

}