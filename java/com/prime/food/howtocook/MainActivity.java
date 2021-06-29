package com.prime.food.howtocook;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
//import androidx.core.app.Fragment;
//import androidx.core.app.FragmentTransaction;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd minter;
    private AdView madView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this,"ca-app-pub-3895242033285544~3468569587"); // add real app id

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        madView=findViewById(R.id.adView1);

     // AdRequest adRequest= new AdRequest.Builder().addTestDevice("FF06027ECD145E8C7BB7C7BB830710BB").build(); //emulator
       AdRequest adRequest= new AdRequest.Builder().build(); // real device
            madView.loadAd(adRequest);


     //   AdView adView = new AdView(this);

      //  adView.setAdSize(AdSize.BANNER);

       // adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
     //   adView.setAdUnitId("ca-app-pub-3895242033285544/6049337171");


        //Inter ca-app-pub-3940256099942544/1033173712





//        Fragment fragment= new FoodFragment();
        Fragment fragment= new FoodFragment();
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frag_content,fragment);
        ft.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
       /*     case R.id.about:
                Intent intent=new Intent(this,AboutActivity.class);
                startActivity(intent);
               // return true;
                break; */
            case R.id.rate:
                startActivity(
                        new Intent(Intent.ACTION_VIEW, Uri.parse(
                                String.format("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName())
                        ))
                );

                return true;

            case R.id.share:
                try{
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT,"+2347061946739");
                    i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    startActivity(Intent.createChooser(i,"Share With"));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"PlayStore Not Found",Toast.LENGTH_LONG).show();
                }

                return true;
            case R.id.update:
                try{
                    startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(
                                    String.format("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName())
                            ))
                    );
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"PlayStore not Found on Device",Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.more:
                try{
                    startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(
                                    String.format("https://play.google.com/store/apps/developer?id=Nprime_Technology")
                            ))
                    );
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Telegram Not install on the phone",Toast.LENGTH_LONG).show();
                }
                return true;
/*
            case R.id.telegram:
                try{
                    startActivity(
                            new Intent(Intent.ACTION_VIEW, Uri.parse(
                                    String.format("https://t.me/jamb_update")
                            ))
                    );
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Telegram Not install on the phone",Toast.LENGTH_LONG).show();
                }
                return true;   */

                default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Do you want to exit App?")
                .setIcon(R.drawable.ic_info_black_24dp)
                .setTitle("Quit App")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // MainActivity.super.onBackPressed();
                        finish();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }

}
