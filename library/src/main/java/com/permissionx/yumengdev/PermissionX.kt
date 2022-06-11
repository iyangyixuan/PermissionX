package com.permissionx.yumengdev

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisiableFragment"

    fun request(activity: FragmentActivity, vararg permissions: String, callback:
            PermissionCallback) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisiableFragment
        } else {
            val invisiableFragment = InvisiableFragment()
            fragmentManager.beginTransaction().add(invisiableFragment, TAG).commitNow()
            invisiableFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}