package com.prime.food.howtocook;


import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private InterstitialAd mInterstitialAd;
    private Listener listener;

    interface Listener{
void onClick(int position);
    }


    private Context contextx;

    private String [] name,des;
    private int[] imageResourcek;

    public ImageAdapter(String[] name, String[] des, int[] imageResourcek,Context contextx) {
        this.contextx = contextx;
        this.name = name;
        this.des = des;
        this.imageResourcek = imageResourcek;


      //  MobileAds.initialize(contextx, "ca-app-pub-3940256099942544~3347511713");

        MobileAds.initialize(contextx, "ca-app-pub-3895242033285544~3468569587");
//ca-app-pub-3895242033285544/3919979812
        mInterstitialAd = new InterstitialAd(contextx);
        mInterstitialAd.setAdUnitId("ca-app-pub-3895242033285544/3919979812");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
/*
    public ImageAdapter(String[] name, String[] des, int[] imageResourcek) {
        this.name = name;
        this.des = des;
        this.imageResourcek = imageResourcek;
    }
*/

    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView cardView=(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image,parent,false);

        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {

        CardView cardView=holder.cardView;
        TextView textView=holder.cardView.findViewById(R.id.ctitle);
        textView.setText(name[position]);

        ImageView imageView=(ImageView)cardView.findViewById(R.id.food_image);

        Drawable drawable= ContextCompat.getDrawable(cardView.getContext(),imageResourcek[position]);
        imageView.setImageDrawable(drawable);
imageView.setContentDescription(name[position]);


cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
           // Toast.makeText(contextx,"The interstitial wasn't loaded yet.",Toast.LENGTH_LONG).show();

        }



        // remove content first

      //  Intent intent= new Intent(context,FoodDetailActivity.class);
        //context.startActivity(intent);

        if(listener !=null){
listener.onClick(position);
        }

    }
});

    }

public void setListener(Listener listener){
this.listener=listener;
}

    @Override
    public int getItemCount() {
        return name.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        public MyViewHolder(CardView itemView) {

            super(itemView);
            cardView=itemView;
        }
    }
}
