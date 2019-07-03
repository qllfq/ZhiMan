package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zuixin extends Fragment {

    Intent intent;
    private int[] workarray = {R.drawable.timg4,R.drawable.timg1,R.drawable.timg2,R.drawable.timg3,
            R.drawable.timg5,R.drawable.timg9,R.drawable.timg7,R.drawable.timg8,R.drawable.timg6};
    private List<Work> workList = new ArrayList<>();
    private WorkAdapter adapter;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.zuixin,null);
        initWorks();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL));
        adapter = new WorkAdapter(workList);
        adapter.setOnItemClickListener(new WorkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                intent = new Intent(getActivity(),ContentActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("workarray",workarray);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }



    private void initWorks() {
        workList.clear();
        for(int i=0;i< workarray.length;i++){
            Work work = new Work(workarray[i]);
            workList.add(work);

        }
    }


}

