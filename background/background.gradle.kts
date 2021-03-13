plugins {
    kotlin("js")
}

description = "The background.js file for chrome extension."

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}

dependencies {
    implementation(project(":chrome-platform"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.4.3")
}

configurations {
    create("content")
}

artifacts {
    add("content", file("$buildDir/distributions/${name}.js")) {
        builtBy("browserProductionWebpack")
    }
}
