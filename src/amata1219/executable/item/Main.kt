package amata1219.executable.item

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {

        lateinit var INSTANCE: Main
            private set

    }

    override fun onEnable() {
        INSTANCE = this
    }

    override fun onDisable() {

    }

}