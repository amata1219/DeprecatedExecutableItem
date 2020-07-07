package amata1219.executable.item.command

import amata1219.executable.item.Main
import amata1219.executable.item.Tick
import org.bukkit.command.CommandExecutor
import org.bukkit.command.PluginCommand
import org.bukkit.command.SimpleCommandMap
import org.bukkit.entity.Player
import java.lang.reflect.Field
import java.lang.reflect.Method

class PermissionlessCommand(baseText: String, delay: Tick) : Command(baseText, delay) {

    companion object {

        private val simpleCommandMap: Method
        private val commandExecutor: Field

        init {
            val version: String = Main.INSTANCE.server.javaClass.`package`.name.replaceFirst(".*(\\d+_\\d+_R\\d+).*", "$1")
            val craftServer: Class<*> = Class.forName("org.bukkit.craftbukkit.$version.CraftServer")
            simpleCommandMap = craftServer.getDeclaredMethod("getCommandMap")

            val pluginCommand: Class<PluginCommand> = PluginCommand::class.java
            commandExecutor = pluginCommand.getDeclaredField("executor")
            commandExecutor.isAccessible = true
        }

    }

    override fun execute(executor: Player, commandText: String) {
        val parts: List<String> = commandText.split(" ")
        val label: String = parts[0]
        val commandMap: SimpleCommandMap = simpleCommandMap.invoke(Main.INSTANCE.server) as SimpleCommandMap
        val command: org.bukkit.command.Command = commandMap.getCommand(label) ?: return
        val execution: CommandExecutor = commandExecutor.get(command) as CommandExecutor
        val args: Array<String> = parts.drop(1).toTypedArray()
        execution.onCommand(executor, command, label, args)
    }

}
