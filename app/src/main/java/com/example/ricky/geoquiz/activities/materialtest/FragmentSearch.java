package com.example.ricky.geoquiz.activities.materialtest;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricky.geoquiz.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentSearch extends Fragment {

    private AdapterUpcoming mAdapter;
    private RecyclerView listSearch;

    public FragmentSearch() {
        // Required empty public constructor
    }

    public List<Information> getData() {
        //load only static data inside a drawer
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.ic_action_home, R.drawable.ic_action_home, R.drawable.ic_action_home, R.drawable.ic_action_home};
        String[] titles = {"Name", "Place", "Brief", "Description"};
        for (int i = 0; i < 8; i++) {
            Information current = new Information();
            current.iconId = icons[i % icons.length];
            current.title = titles[i % titles.length];

            data.add(current);
        }
        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        listSearch = (RecyclerView) view.findViewById(R.id.listsearch);
        listSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AdapterUpcoming(getActivity(), getData());
        listSearch.setAdapter(mAdapter);

        return view;
    }

}
