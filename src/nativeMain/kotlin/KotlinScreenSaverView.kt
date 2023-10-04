@file:OptIn(ExperimentalForeignApi::class)

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSBundle
import platform.Foundation.NSRect
import platform.ScreenSaver.ScreenSaverView

fun create(): KotlinScreenSaverView = LogoScreenSaverView()

abstract class KotlinScreenSaverView {
    protected lateinit var view: ScreenSaverView
    private set

    protected lateinit var bundle: NSBundle
    private set

    protected var isPreview = false
        private set

    open fun init(screenSaverView: ScreenSaverView, isPreview: Boolean, bundle: NSBundle) {
        this.view = screenSaverView
        this.bundle = bundle
        this.isPreview = isPreview
    }

    abstract fun draw(rect: CPointer<NSRect>)
    abstract fun animateOneFrame()
}