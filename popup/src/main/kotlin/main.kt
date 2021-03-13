import kotlinx.browser.document
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement

fun main() {
    GlobalScope.launch {
        val changeColor: HTMLElement = requireNotNull(document.getElementById("changeColor")) as HTMLButtonElement
        val color: String = Chrome.storage.sync.get("color")
        changeColor.style.background = color
    }
}
