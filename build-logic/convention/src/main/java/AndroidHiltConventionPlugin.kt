import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }

            dependencies {
                "implementation"(libs.findLibrary("hilt.android").get())
                "implementation"(libs.findLibrary("hilt.navigation").get())
                "ksp"(libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}