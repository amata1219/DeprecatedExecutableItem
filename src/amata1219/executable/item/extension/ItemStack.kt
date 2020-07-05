package amata1219.executable.item.extension

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

val ItemStack.displayName: String
    get() = itemMeta?.displayName ?: ""

val ItemStack.lore: List<String>
    get() = itemMeta?.lore ?: emptyList()

fun ItemStack.consume(){
    if(amount <= 1) type = Material.AIR
    else amount--
}

fun calculateHashCode(type: Material, displayName: String, lore: List<String>): Int {
    var hash = 1
    hash = hash * 31 + type.hashCode()
    hash = hash * 31 + displayName.hashCode()
    hash = hash * 31 + lore.hashCode()
    return hash
}
