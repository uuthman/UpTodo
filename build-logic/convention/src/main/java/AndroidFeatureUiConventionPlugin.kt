import com.android.build.api.dsl.LibraryExtension
import com.uuthman.convention.ExtensionType
import com.uuthman.convention.addUiLayerDependencies
import com.uuthman.convention.configureAndroidCompose
import com.uuthman.convention.configureBuildTypes
import com.uuthman.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureUiConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("uptodo.android.library.compose")
                apply("uptodo.android.hilt")
            }

            dependencies {
               addUiLayerDependencies(target)
            }

        }

    }
}