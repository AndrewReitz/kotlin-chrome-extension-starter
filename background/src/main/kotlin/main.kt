import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const val color = "#3aa757"

fun main() {
    Chrome.runtime.onInstalled.addListener {
      GlobalScope.launch {
        Chrome.storage.sync.set("color", color)
        println("Default background color set to $color")
      }
    }
}
