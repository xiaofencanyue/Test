package com.example.lenovo.webview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        webView= (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            /*@Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //页面加载开始时操作
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //页面加载结束时操作
                super.onPageFinished(view, url);
            }*/
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){
                    Toast.makeText(MainActivity.this,"网页加载完毕",Toast.LENGTH_LONG).show();
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        //适应手机屏幕
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        webView.loadUrl("http://www.baidu.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            webView.goBack();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }


}
