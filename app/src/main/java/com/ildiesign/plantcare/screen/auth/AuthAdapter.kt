package com.ildiesign.plantcare.screen.auth

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.ildiesign.plantcare.R


class AuthAdapter(
        private val context: Context,
        manager: FragmentManager )

    : FragmentStatePagerAdapter( manager ) {


    override fun getPageTitle( position: Int ): CharSequence? =
        when ( position ) {
            0    -> context.getString( R.string.log_in )
            else -> context.getString( R.string.sign_up )
        }


    override fun getItem( position: Int ): Fragment =
        when ( position ) {
            0    -> LoginFragment()
            else -> SignupFragment()
        }



    override fun getCount() = 2

}