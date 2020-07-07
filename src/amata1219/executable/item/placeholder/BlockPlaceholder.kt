package amata1219.executable.item.placeholder

import org.bukkit.block.Block

enum class BlockPlaceholder(
        override val field: String,
        override val value: (Block) -> Any,
        override val prefix: String = "block"
) : Placeholder<Block> {

    LOCATION_X("loc-x", { it.location.x });

    companion object {

        val PLACEHOLDERS: List<Placeholder<Block>> = values().toList()

        fun of(target: Block): PlaceholderReplacer<Block> = PlaceholderReplacer(target, PLACEHOLDERS)

    }

}
