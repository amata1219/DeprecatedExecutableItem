package amata1219.executable.item

import amata1219.executable.item.command.Command
import amata1219.executable.item.extension.*
import org.apache.commons.lang.mutable.Mutable
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import java.text.SimpleDateFormat
import java.util.*

class ExecutingItemListener : Listener {

    private val playerUniqueIdsToItemCooldownInformationMaps: MutableMap<UUID, MutableMap<Int, Long>> = mutableMapOf()

    private fun routine(event: PlayerEvent, target: ItemStack, condition: Lazy<List<Condition>>): List<Command> {
        val hash: Int = calculateHashCode(target.type, target.displayName, target.lore)
        val item: Item = Main.INSTANCE.itemMap[hash] ?: return emptyList()

        val player: Player = event.player
        val playerUniqueId: UUID = player.uniqueId
        val itemCooldownInformationMap: MutableMap<Int, Long>
                = playerUniqueIdsToItemCooldownInformationMaps[playerUniqueId]!!
        if (itemCooldownInformationMap.containsKey(hash)) {
            if (event is Cancellable) event.isCancelled = true
            val diff: Long = System.currentTimeMillis() - itemCooldownInformationMap[hash]!!
            val format = SimpleDateFormat("HH:mm:ss.SSS")
            format.timeZone = TimeZone.getTimeZone("GMT")
            player.sendMessage("${ChatColor.RED}クールダウン中です！ ${ChatColor.GRAY}(残り時間：${format.format(diff)})")
            return emptyList()
        }

        item.conditions.find(condition.value::containsAll) ?: return emptyList()

        if (item.consumable) target.consume()

        if (item.needsCooldown) {
            val cooldownTicks: Long = item.cooldownTicks.value
            val cooldownEndTime: Long = System.currentTimeMillis() + cooldownTicks * 50
            itemCooldownInformationMap[hash] = cooldownEndTime
            runTaskLater(cooldownTicks) {
                itemCooldownInformationMap.remove(hash)
            }
        }

        return item.commands
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        playerUniqueIdsToItemCooldownInformationMaps[event.player.uniqueId] = mutableMapOf()
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        playerUniqueIdsToItemCooldownInformationMaps.remove(event.player.uniqueId)
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action == Action.PHYSICAL || !event.hasItem()) return

    }

    @EventHandler
    fun onPlayerConsume(event: PlayerItemConsumeEvent) {
    }
    /*
    list[condition] = (hand-type, click, click-type, clicked-type)
    water clicking - from clicking with a bucket processing
    create replacers(player, block, entity)
     */

}