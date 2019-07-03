package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class Me extends Fragment implements View.OnClickListener {

    private ImageView work;
    private ImageView add;
    private MarketAdapter adapter;
    private int[] sucaiInt = {R.drawable.timg1,R.drawable.timg2,R.drawable.timg3,R.drawable.addnew};
    private Sucai[] sucais = {new Sucai(R.drawable.timg1),new Sucai(R.drawable.timg2),
            new Sucai(R.drawable.timg3), new Sucai(R.drawable.addnew)};
    private ArrayList<Sucai> arrayList = new ArrayList<>(Arrays.asList(sucais));
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me,null);
       /* RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
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
        recyclerView.setAdapter(adapter);*/



       work = view.findViewById(R.id.work);
       add = view.findViewById(R.id.addpicture);
       work.setOnClickListener(this);
       add.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.work:
                Intent intent = new Intent(getActivity(),ContentActivity.class);
                intent.putExtra("position",R.drawable.timg1);
                startActivity(intent);
                break;
            case R.id.addpicture:
                Intent intent1 = new Intent(getActivity(),Finger.class);
                //intent.putExtra("id",R.id.work);
                startActivity(intent1);
                break;
        }

    }
}

