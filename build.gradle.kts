plugins {
    distribution
    kotlin("js") version "1.4.31" apply false
}

description = "Combines all the submodules together to build the chrome extension."

allprojects {
    group = "cash.andrew"
    version = "0.1"

    repositories {
        mavenCentral()
        jcenter()
    }
}

configurations {
    create("content")
}

dependencies {
    "content"(project(path = ":background", configuration = "content"))
    "content"(project(path = ":popup", configuration = "content"))
}

distributions {
    main {
        distributionBaseName.set("chrome-extension")
        contents {
            from("manifest.json") {
                expand(
                    "name" to "Extension Name Goes Here",
                    "version" to "${project.version}",
                    "description" to "description of extension goes here"
                )
            }

            val content by configurations
            from(content)

            from(file("resources"))

            into("/")
        }
    }
}

tasks.named("installDist").configure {
    dependsOn(tasks.named("assemble"))
}

tasks.named("distTar").configure {
  enabled = false
}
