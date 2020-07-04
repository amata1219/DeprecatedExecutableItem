package amata1219.executable.item.extension

import org.bukkit.inventory.ItemStack

val ItemStack.displayName: String
    get() = itemMeta?.displayName ?: ""

val ItemStack.lore: List<String>
    get() = itemMeta?.lore ?: emptyList()