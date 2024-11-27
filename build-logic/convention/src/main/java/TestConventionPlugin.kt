import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class TestConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("de.mannodermaus.android-junit5")
            }

            dependencies {
                "testRuntimeOnly"(project.libs.findLibrary("junit-jupiter-engine").get())
                "testImplementation"(project.libs.findLibrary("junit-jupiter-api").get())
                "testImplementation"(project.libs.findLibrary("junit-jupiter-params").get())
                "testImplementation"(project.libs.findLibrary("assert-k").get())
                "testImplementation"(project.libs.findLibrary("mockk").get())

            }
        }

    }
}