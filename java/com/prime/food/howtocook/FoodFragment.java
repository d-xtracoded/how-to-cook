package com.prime.food.howtocook;


import android.content.Intent;
import android.os.Bundle;
//import androidx.core.app.Fragment;
import androidx.fragment.app.Fragment;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("From Food FRag"," +++++++");
        RecyclerView foodrecycler = (RecyclerView) inflater.inflate(R.layout.fragment_food,container,false);
        Log.d("From Food FRag"," +++++++");

        String[] foodnames = new String[Foods.foods.length];
        for(int i=0; i<foodnames.length; i++){
            foodnames[i]=Foods.foods[i].getName();
        }

        final String[] foodDes= new String[Foods.foods.length];
        for (int i=0;i<foodDes.length;i++){
            foodDes[i]=Foods.foods[i].getFood_des();
        }


        int[] imageResource= new int[Foods.foods.length];
        for(int i=0; i<foodnames.length;i++){
            imageResource[i]=Foods.foods[i].getImageResourceId();
        }

        //com.example.samsung1.howtocook


        ImageAdapter adapter= new ImageAdapter(foodnames,foodDes,imageResource,getContext());

        foodrecycler.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        foodrecycler.setLayoutManager(layoutManager);



adapter.setListener(new ImageAdapter.Listener() {
    @Override
    public void onClick(int position) {
Intent intent= new Intent(getActivity(),FoodDetailActivity.class);
//intent.putExtra(FoodDetailActivity.EXTRA_FOOD_ID,position);
        intent.putExtra(FoodDetailActivity.EXTRA_FOOD_LINK,foodDes[position]);
getActivity().startActivity(intent);
    }
});

        return foodrecycler;
    }

}
