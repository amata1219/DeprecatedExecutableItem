import amata1219.executable.item.Condition
import amata1219.executable.item.Item
import amata1219.executable.item.Main
import amata1219.executable.item.calculateHashCode
import amata1219.executable.item.command.Command
import amata1219.executable.item.extension.displayName
import amata1219.executable.item.extension.lore
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.util.*

class ExecutingItemListener : Listener {

    /*
    Is item.hash contained in item map?
    get executable item as exe
    Is player cooling the one?
    Is event satisfy at least one of exe.conditions
    commands.foreach execute: out
    if consumable amount--
    if !isCooldownless cooling down map .put(uuid, set(hash))
     */

    val coolingDownMap: Map<UUID, MutableSet<Int>> = mutableMapOf()

    private fun routine(player: Player, item: ItemStack, condition: () -> Set<Condition>): List<Command> {
        val hash: Int = calculateHashCode(item.type, item.displayName, item.lore)
        val exe: Item = Main.INSTANCE.itemMap[hash] ?: return emptyList()
        val playerIdentifier: UUID = player.uniqueId
        if (coolingDownMap[playerIdentifier]?.contains(hash) == true){
            //send msg "クールダウン中です 残り S.sss 秒"
            return emptyList()
        }
        for(conditions in exe.conditions){
            //if(condition().containsAll(conditions))
        }
    }

}