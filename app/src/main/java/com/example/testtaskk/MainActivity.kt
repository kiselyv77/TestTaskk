package com.example.testtaskk

import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.testtaskk.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.ui_view.ViewProvider


class MainActivity : AppCompatActivity() {
    lateinit var mapView:MapView
    lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    lateinit var binding: ActivityMainBinding
    val listPoint = arrayListOf(
        Point(55.864954, 37.836450),// лоссинный остров
        Point(55.750577, 37.619813),// тверской район
        Point(55.730439, 37.585348),// район хамовники
        Point(55.789434, 37.616121),// район марьина роща
        Point(55.727661, 37.699821),// некрасовский район
        Point(55.906462, 37.724439),// мытищи
        Point(55.808848, 37.605043),// бутырский район
        Point(55.591275, 37.623506),// район Бирюлёво Западное
        Point(55.660919, 37.464721),// район Тропарёво-Никулино
        Point(55.855263, 37.438873),// район Северное Тушино
        Point(55.898856, 37.438873),// химки



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey("b66017cb-e131-4832-9e94-21d8d2f8af2b")
        MapKitFactory.initialize(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.mapview
        mapView.map.move(
            CameraPosition(Point(55.751574, 37.573856), 9.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0f),
            null
        )

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet).apply {
            peekHeight = 200
            state = BottomSheetBehavior.STATE_COLLAPSED

        }

        listPoint.forEach{
            drawMyLocationMark(it, mapView)
        }

        val tabs = findViewById<TabLayout>(R.id.tabs)
        val viewpager = findViewById<ViewPager2>(R.id.viewpager)
        viewpager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabs, viewpager) { tab, position ->
            tab.text = "title"
        }.attach()

    }


    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    private fun drawMyLocationMark(point: Point, mapview: MapView) {
        val view = View(this).apply {
            background = getDrawable(R.drawable.ic_location)
        }

        mapview.map.mapObjects.addPlacemark(point, ViewProvider(view))
    }

}

