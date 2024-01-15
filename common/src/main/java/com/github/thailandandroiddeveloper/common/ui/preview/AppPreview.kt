package com.github.thailandandroiddeveloper.common.ui.preview

// use static const because it need to be used in annotation

object Pixel7 {
    const val name = "Pixel7"
    const val spec = "spec:id=reference_phone,shape=Normal,width=411,height=914,unit=dp,dpi=420"
}

object PixelTablet {
    const val name = "PixelTablet"
    const val spec = "spec:id=reference_tablet,shape=Normal,width=1280,height=800,unit=dp,dpi=320"
}

// Not working with Showkase
//@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
//annotation class Pixel7Preview
//
//@Preview(group = PixelTablet.name, device = PixelTablet.spec, showBackground = true)
//annotation class PixelTabletPreview
