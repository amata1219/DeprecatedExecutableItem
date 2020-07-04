package amata1219.executable.item.command

import amata1219.executable.item.extension.runTaskLater
import amata1219.executable.item.placeholder.replacer.PlaceholderReplacer
import org.bukkit.entity.Player

abstract class Command (private val baseText: String, private val delayTicks: Tick) {

    fun execute(executor: Player, vararg replacers: PlaceholderReplacer<*>) {
        var text: String = baseText
        for(replacer in replacers) text = replacer.replace(text)
        if(delayTicks.isEmpty) execute(executor, text)
        else runTaskLater(delayTicks.value){
            execute(executor, text)
        }
    }

    abstract fun execute(executor: Player, commandText: String)

}
