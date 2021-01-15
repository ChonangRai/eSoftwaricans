package com.example.esoftwaricans.ui.aboutUs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.esoftwaricans.R

class AboutUsFragment : Fragment() {
    private lateinit var wb_webView : WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        wb_webView = view.findViewById(R.id.wb_webView)
        wb_webView.webViewClient = WebViewClient()
        wb_webView.apply{
            loadUrl("https://softwarica.edu.np/about-softwarica/")
            settings.javaScriptEnabled = true
        }
        return view
    }
}