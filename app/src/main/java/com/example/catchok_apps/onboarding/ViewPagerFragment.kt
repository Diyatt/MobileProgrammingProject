package com.example.catchok_apps.onboarding

import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentViewPagerBinding

class ViewPagerFragment:BaseFragment<FragmentViewPagerBinding>(FragmentViewPagerBinding::inflate) {

    override var showBottomNavigation: Boolean = false
    override fun onBindView() {
        super.onBindView()
        val fragmentList = arrayListOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )
        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

    }

}