package com.example.qiaolulu.fangqi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Caogao extends Fragment {
    private int[] workarray = {R.drawable.timg4,R.drawable.timg1,R.drawable.timg2,R.drawable.timg3,
            R.drawable.timg5,R.drawable.timg9,R.drawable.timg7};
    private List<Work> workList = new ArrayList<>();
    private WorkAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.caogao,null);
        initWorks();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager,VERTICAL);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL));
        adapter = new WorkAdapter(workList);
        adapter.setOnItemClickListener(new WorkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),ContentActivity.class);
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
        for(int i=0;i<workarray.length;i++){
            Work work = new Work(workarray[i]);
            workList.add(work);
           /* Random random = new Random();
            int index = random.nextInt(works.length);
            workList.add(works[index]);*/
        }
    }
}
