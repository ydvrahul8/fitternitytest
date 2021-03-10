package com.example.fitternitytest.view.fragment.fitternity_page

import android.webkit.WebSettings
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseFragment
import com.example.fitternitytest.databinding.FragmentFitternityBinding
import com.example.fitternitytest.utils.URL


class FitternityFragment : BaseFragment<FragmentFitternityBinding>() {

    override val layout: Int
        get() = R.layout.fragment_fitternity

    override fun init(bind: FragmentFitternityBinding) {
        bind.listener = this
        bind.toolbar.title=URL
        val webSettings: WebSettings = bind.webView.settings
        webSettings.javaScriptEnabled = true
        bind.webView.loadUrl(URL)
    }
    fun backButtonPressed() {
        requireActivity().onBackPressed()
    }
}