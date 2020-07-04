package amata1219.executable.item.command

import amata1219.executable.item.Main
import org.bukkit.craftbukkit.v1_16_R1.CraftServer
import org.bukkit.entity.Player

class PermissionlessCommand(baseText: String, delay: Tick) : Command(baseText, delay) {

    override fun execute(executor: Player, commandText: String) {
        val label: String = commandText.split(" ")[0]
        val args: Array<String> = arrayOf("arguments...")
        (Main.INSTANCE.server as CraftServer).commandMap.getCommand(label)?.execute(executor, label, args)
    }

}