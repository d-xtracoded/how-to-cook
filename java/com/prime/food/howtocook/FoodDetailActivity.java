package com.prime.food.howtocook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class FoodDetailActivity extends AppCompatActivity {

    public static final String EXTRA_FOOD_ID="fid";
    public static final String EXTRA_FOOD_LINK="flink";
    private WebView webView;
    private AdView madView;
    private InterstitialAd interstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

     //   Toolbar toolbar=findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

//   int imgId =(Integer)getIntent().getExtras().get(EXTRA_FOOD_ID);
   String FLINK=(String)getIntent().getExtras().get(EXTRA_FOOD_LINK);

Log.i("Fdetail Activity","FOOD LINK"+getIntent().getExtras().get(EXTRA_FOOD_LINK));
        webView=findViewById(R.id.webview);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
 //       webView.loadUrl("file:///android_asset/"+imgId+".html");
        webView.loadUrl("file:///android_asset/"+FLINK);

        MobileAds.initialize(this,"ca-app-pub-3895242033285544~3468569587"); //add real app id

        madView=findViewById(R.id.adView);
         //AdRequest adRequest= new AdRequest.Builder().addTestDevice("FF06027ECD145E8C7BB7C7BB830710BB").build(); //
        AdRequest adRequest= new AdRequest.Builder().build(); //
        madView.loadAd(adRequest);

        if(savedInstanceState!=null){
            webView.restoreState(savedInstanceState);
        }else {

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setBuiltInZoomControls(true);
        }

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(my maenu file,menu);
        return super.onCreateOptionsMenu(menu);
    } */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }
}