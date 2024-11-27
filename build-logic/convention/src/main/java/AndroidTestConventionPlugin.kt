import com.android.build.api.dsl.LibraryExtension
import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude

class AndroidTestConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {

            configurations.getByName("androidTestImplementation") {
                exclude(group = "io.mockk", module = "mockk-agent-jvm")
            }


            extensions.configure<LibraryExtension> {
                defaultConfig {
                    testInstrumentationRunner = "com.uuthman.common.androidtest.HiltTestRunner"
                }
            }

            dependencies {
                "androidTestImplementation"(project.libs.findLibrary("androidx-junit").get())
                "androidTestImplementation"(project.libs.findLibrary("androidx-junit-ext").get())
                "androidTestImplementation"(project.libs.findLibrary("androidx-junit-runner").get())
                "androidTestImplementation"(project.libs.findLibrary("androidx-test-core").get())
                "androidTestImplementation"(project.libs.findLibrary("assert-k").get())
                "androidTestImplementation"(project.libs.findLibrary("mockk").get())

            }
        }

    }
}