package jp.techinstitute.osaka.security.enshu;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
    // 秘密のページのURL
    private static final String URL_STRING = "http://www.google.co.jp/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        WebView view = (WebView) findViewById(R.id.web_view);
        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        // JavaScript 有効化、GPS有効化
        WebSettings settings = view.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);

        // 秘密のページを開く
        view.loadUrl(URL_STRING);
    }
}
