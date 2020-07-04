package amata1219.executable.item.command

import amata1219.executable.item.Main
import org.bukkit.Server
import org.bukkit.entity.Player

class ConsoleCommand(baseText: String, delay: Tick) : Command(baseText, delay) {

    override fun execute(executor: Player, commandText: String) {
        val server : Server = Main.INSTANCE.server
        server.dispatchCommand(server.consoleSender, commandText)
    }

}