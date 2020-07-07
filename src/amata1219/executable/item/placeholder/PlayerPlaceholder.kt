package amata1219.executable.item.placeholder

import org.bukkit.entity.Player

enum class PlayerPlaceholder(
        override val field: String,
        override val value: (Player) -> Any,
        override val prefix: String = "player"
) : Placeholder<Player> {

    NAME("name", Player::getName),
    DISPLAY_NAME("display-name", Player::getDisplayName);

    companion object {

        private val PLACEHOLDERS: List<Placeholder<Player>> = values().toList()

        fun of(target: Player): PlaceholderReplacer<Player> = PlaceholderReplacer(target, PLACEHOLDERS)

    }

}
