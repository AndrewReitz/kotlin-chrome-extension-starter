include(
    ":popup",
    ":background",
    "chrome-platform"
)

rootProject.name = "chrome-extension"

for (project in rootProject.children) {
    project.apply {
        buildFileName = "$name.gradle.kts"
    }
}