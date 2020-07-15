package com.stu_app.data1.polytechcardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.stu_app.data1.polytechcardapp.R;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView)findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSaveFormData(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setSupportZoom(false);

        webView.loadUrl("https://kopo8315.cf");
    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

    //key down
    BackPressCloseHandler backPressCloseHandler = new BackPressCloseHandler(this);

    @Override
    public void onBackPressed() {
        if (webView.getOriginalUrl().equalsIgnoreCase("https://kopo8315.cf")) {
            backPressCloseHandler.onBackPressed();
        }else if(webView.canGoBack()){
            webView.goBack();
        }else{
            backPressCloseHandler.onBackPressed();
        }
    }

}
