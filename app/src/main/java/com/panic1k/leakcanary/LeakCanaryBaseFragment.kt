package com.panic1k.leakcanary

import android.support.v4.app.Fragment

class LeakCanaryBaseFragment : Fragment() {

    override fun onDestroyView() {
        super.onDestroyView()
        (activity!!.application as LeakyApplication).refwatcher!!.watch(this)
    }
}