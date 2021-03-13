plugins {
    kotlin("js")
}

description = "Code for the popup when pressing the chrome extensions icon."

dependencies {
    implementation(project(":chrome-platform"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.4.3")
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
            binaries.executable()
        }
    }
}

configurations {
    create("content")
}

artifacts {
    add("content", file("$buildDir/distributions/${name}.js")) {
        builtBy("browserProductionWebpack")
    }
    add("content", file("$buildDir/distributions/popup.html"))
    add("content", file("$buildDir/distributions/button.css"))
}
