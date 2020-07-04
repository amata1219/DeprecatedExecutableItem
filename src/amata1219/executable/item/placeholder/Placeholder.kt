package amata1219.executable.item.placeholder

interface Placeholder<T> {

    val prefix: String
    val field: String
    val text get() = "[$prefix@$field]"
    val value: (T) -> Any

}
