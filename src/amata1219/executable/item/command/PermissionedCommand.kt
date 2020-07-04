package amata1219.executable.item.command

import amata1219.executable.item.Tick
import org.bukkit.entity.Player

class PermissionedCommand(baseText: String, delay: Tick) : Command(baseText, delay) {

    override fun execute(executor: Player, commandText: String) {
        executor.performCommand(commandText)
    }

}