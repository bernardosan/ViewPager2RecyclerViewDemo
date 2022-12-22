package com.example.viewpagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var viewPager2: ViewPager2? = null

    private val pager2Callback = object:ViewPager2.OnPageChangeCallback(){

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if (position == PageList.itemSlides.size - 1) {
                binding?.controllerBtn?.text = getString(R.string.finish)
            } else {
                binding?.controllerBtn?.text = getString(R.string.next)
                binding?.controllerBtn?.setOnClickListener {
                    viewPager2?.currentItem = position + 1
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        setupViewPager(binding!!)
    }


    private fun setupViewPager(binding: ActivityMainBinding){

        val adapter = ItemAdapter(PageList.itemSlides)
        viewPager2 = binding.viewPager
        viewPager2?.adapter = adapter
        viewPager2?.registerOnPageChangeCallback(pager2Callback)
        binding.dotsIndicator.setViewPager2(viewPager2!!)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2?.unregisterOnPageChangeCallback(pager2Callback)
    }
}
