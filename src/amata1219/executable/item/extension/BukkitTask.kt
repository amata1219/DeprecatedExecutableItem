package amata1219.executable.item.extension

import amata1219.executable.item.Main
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

fun runTaskLater(delay: Long, action: () -> Unit): BukkitTask {
    return object : BukkitRunnable(){
        override fun run() {
            action()
        }
    }.runTaskLater(Main.INSTANCE, delay)
}