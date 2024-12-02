import com.uuthman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class JvmJUnit5ConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {

            tasks.withType<Test> {
                useJUnitPlatform()
            }


            dependencies {
                "testRuntimeOnly"(project.libs.findLibrary("junit-jupiter-engine").get())
                "testImplementation"(project.libs.findLibrary("junit-jupiter-api").get())
                "testImplementation"(project.libs.findLibrary("junit-jupiter-params").get())

                "testImplementation"(project.libs.findLibrary("assert-k").get())
                "testImplementation"(project.libs.findLibrary("mockk").get())

                "testImplementation"(libs.findLibrary("turbine").get())
                "testImplementation"(libs.findLibrary("coroutines.test").get())

            }
        }

    }
}