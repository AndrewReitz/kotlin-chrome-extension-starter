plugins {
    kotlin("js")
}

description = "Common external references to chrome platform, as well as common kotlin js functionality"

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}
