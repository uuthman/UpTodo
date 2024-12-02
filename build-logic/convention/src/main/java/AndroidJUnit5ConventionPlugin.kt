import com.android.build.api.dsl.LibraryExtension
import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude

class AndroidJUnit5ConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {

            pluginManager.apply("uptodo.jvm.junit5")
            pluginManager.apply("de.mannodermaus.android-junit5")

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "com.uuthman.core.android_test.HiltTestRunner"
                }
            }

            dependencies {
                "androidTestImplementation"(libs.findLibrary("junit5.android.test.compose").get())

                "androidTestImplementation"(project.libs.findLibrary("androidx-junit-runner").get())
                "androidTestImplementation"(project.libs.findLibrary("androidx-test-core").get())
                "androidTestImplementation"(project.libs.findLibrary("assert-k").get())
                "androidTestImplementation"(project.libs.findLibrary("mockk").get())
                "androidTestImplementation"(libs.findLibrary("coroutines.test").get())
                "androidTestImplementation"(libs.findLibrary("turbine").get())
                "androidTestImplementation"(project(":core:android-test"))

            }
        }

    }
}