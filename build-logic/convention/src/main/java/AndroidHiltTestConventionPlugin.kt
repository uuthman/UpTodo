import com.android.build.api.dsl.LibraryExtension
import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude

class AndroidHiltTestConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {

        target.run {
            pluginManager.run {
                apply("com.google.devtools.ksp")


                dependencies {
                    "androidTestImplementation"(project.libs.findLibrary("hilt-android-test").get())
                    "kspAndroidTest"(project.libs.findLibrary("hilt-android-compiler").get())

                }
            }

        }
    }
}