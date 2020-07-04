package amata1219.executable.item.placeholder

import org.bukkit.entity.Player

enum class PlayerPlaceholder(
        override val field: String,
        override val value: (Player) -> Any,
        override val prefix: String = "player"
) : Placeholder<Player> {

    NAME("name", Player::getName),
    DISPLAY_NAME("display-name", Player::getDisplayName)

}
