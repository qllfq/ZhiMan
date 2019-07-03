package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundFragment extends Fragment{
    private MarketAdapter adapter;
    private int[] sucaiInt = {R.drawable.background1,R.drawable.background2,R.drawable.background3};

   // private ArrayList<Sucai> arrayList = new ArrayList<>(Arrays.asList(sucais));
   private ArrayList<Sucai> arrayList = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.background_fragment,null);
        initData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MarketAdapter(arrayList);
        adapter.setOnItemClickListener(new MarketAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),Purches.class);
                intent.putExtra("sucai",sucaiInt);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }
    private void initData() {
        for(int i=0;i< sucaiInt.length;i++){
            Sucai sucai = new Sucai(sucaiInt[i]);
            arrayList.add(sucai);

        }
    }
}

