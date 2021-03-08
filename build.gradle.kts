plugins {
    distribution
    kotlin("js") version "1.4.30"
}

group = "cash.andrew"
version = "0.1"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
}

dependencies {
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
}

distributions {
    main {
        distributionBaseName.set("chrome-extension")
        contents {
            from("manifest.json") {
                expand(
                    "name" to "Test", // project.name.split("-").joinToString(" ") { it.capitolize() },
                    "version" to "${project.version}",
                    "description" to "description of extension goes here"
                )
            }

            from("$buildDir/distributions/${project.name}.js") {
                rename { "background.js" }
            }

            into("/")
        }
    }
}

tasks.named("installDist").configure {
    dependsOn(tasks.named("assemble"))
}
