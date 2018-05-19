package cn.hachchina.nuaa.smartmedical.Activity;

import android.app.Activity;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import cn.hachchina.nuaa.smartmedical.R;

public class GuaHaoActivity extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guahao);

        webView=findViewById(R.id.guahaoid);
        webView.loadUrl("http://www.zy91.com/zyyy/hlwyy.html");

    }
}
