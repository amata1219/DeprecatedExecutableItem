package amata1219.executable.item.placeholder.replacer

import amata1219.executable.item.placeholder.Placeholder

class PlaceholderReplacer<T>(private val target: T, private val placeholders: List<Placeholder<T>>) {

    fun replace(text: String): String {
        val builder = StringBuilder(text)
        for(placeholder in placeholders){
            var index: Int
            while(true){
                index = builder.indexOf(placeholder.text)
                if(index == -1) break
                builder.replace(index, index + placeholder.text.length, placeholder.value(target).toString())
            }
        }
        return builder.toString()
    }

}