package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detailwebView = findViewById<WebView>(R.id.detailwebView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val url = intent.getStringExtra("URL")
        if(url != null){
            detailwebView.settings.javaScriptEnabled = true;
            detailwebView.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            detailwebView.webViewClient = object: WebViewClient(){
                override fun onPageCommitVisible(view: WebView?, url: String?) {
                    super.onPageCommitVisible(view, url)
                    progressBar.visibility = View.GONE
                    detailwebView.visibility = View.VISIBLE

                }
            }
            detailwebView.loadUrl(url)
        }
    }
}