package amata1219.executable.item.placeholder

import org.bukkit.entity.Entity

enum class EntityPlaceholder(
        override val field: String,
        override val value: (Entity) -> Any,
        override val prefix: String = "entity"
) : Placeholder<Entity> {

    LOCATION_X("loc-x", { it.location.x }),
    LOCATION_Y("loc-y", { it.location.y }),
    LOCATION_Z("loc-z", { it.location.z });

    companion object {

        val PLACEHOLDERS: List<Placeholder<Entity>> = values().toList()

        fun of(target: Entity): PlaceholderReplacer<Entity> = PlaceholderReplacer(target, PLACEHOLDERS)

    }

}
