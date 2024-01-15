@file:Suppress("TestFunctionName")

package com.github.thailandandroiddeveloper.screenshottest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.android.resources.Density
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.preview.PixelTablet
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.util.*

// https://github.com/airbnb/Showkase/blob/master/showkase-screenshot-testing-paparazzi-sample/src/test/java/com/airbnb/android/showkase/screenshot/testing/paparazzi/sample/PaparazziSampleScreenshotTest.kt
@RunWith(TestParameterInjector::class)
class PreviewScreenshotTests {
    object PreviewProvider : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentTestPreview> {
            val metadata = Showkase.getMetadata()
            val components = metadata.componentList.filter { component ->
                listOf(Pixel7.name, PixelTablet.name).contains(component.group) &&
                        sequenceOf("Easy", "Medium", "Hard", "Qualify").any { component.componentName.startsWith(it) }
            }.map(::ComponentTestPreview)
            return components //+ colors + typography
        }
    }

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = 0.0,
        deviceConfig = DeviceConfig.PIXEL_2.copy(softButtons = false),
    )

    @Before
    fun setup() {
        val diffPath = File("diff")
        if (!diffPath.exists()) diffPath.mkdir()
    }

    @Test
    fun test(
        @TestParameter(valuesProvider = PreviewProvider::class) componentPreview: ComponentTestPreview,
    ) {
        paparazzi.unsafeUpdateConfig(componentPreview.device.copy(softButtons = false))

        try {
            paparazzi.snapshot {
                CompositionLocalProvider(
                    LocalInspectionMode provides true,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        componentPreview.Content()
                    }

                }
            }

            val filePath = "diff/${componentPreview}.txt"
            val fileContent = "0"
            val file = File(filePath)
            file.writeText(fileContent)
        } catch (e: Throwable) {
            e.printStackTrace()
            runCatching {
                val filePath = "diff/${componentPreview}.txt"
                val fileContent = e.toString().split("(by ")[1].split("%) - ")[0]
                val file = File(filePath)
                file.writeText(fileContent)
            }
        }
    }
}

private val deviceConfigMap = mapOf(
    Pixel7.name to DeviceConfig(
        screenHeight = 2400,
        screenWidth = 1080,
        xdpi = 420,
        ydpi = 420,
        density = Density.DPI_420,
    ),
    PixelTablet.name to DeviceConfig(
        screenWidth = 2560,
        screenHeight = 1600,
        xdpi = 320,
        ydpi = 320,
        density = Density.XHIGH,
    ),
)

fun String.toDevice(): DeviceConfig {
    return deviceConfigMap[this] ?: deviceConfigMap[Pixel7.name]!!
}

interface TestPreview {

    val device: DeviceConfig

    @Composable
    fun Content()
}

class ComponentTestPreview(
    private val showkaseBrowserComponent: ShowkaseBrowserComponent,
) : TestPreview {

    private fun String.mapComponentNameToLevel() = split("Screen")[0]

    override val device: DeviceConfig = showkaseBrowserComponent.group.toDevice()

    @Composable
    override fun Content() = showkaseBrowserComponent.component()
    override fun toString(): String = showkaseBrowserComponent.run {
        componentName.mapComponentNameToLevel() + "_" + group
    }
}
