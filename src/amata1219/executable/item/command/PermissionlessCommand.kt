package amata1219.executable.item.command

import amata1219.executable.item.Main
import org.bukkit.craftbukkit.v1_16_R1.CraftServer
import org.bukkit.entity.Player

class PermissionlessCommand(baseText: String, delay: Tick) : Command(baseText, delay) {

    override fun execute(executor: Player, commandText: String) {
        val parts: List<String> = commandText.split(" ")
        val label: String = parts[0]
        val args: Array<String> = parts.slice(1 until parts.size).toTypedArray()
        (Main.INSTANCE.server as CraftServer).commandMap.getCommand(label)?.execute(executor, label, args)
    }

}