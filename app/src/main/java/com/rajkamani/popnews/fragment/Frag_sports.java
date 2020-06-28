package com.rajkamani.popnews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.rajkamani.popnews.apicall.ApiCall;
import com.rajkamani.popnews.constant.Constants;
import com.rajkamani.popnews.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Frag_sports extends Fragment {
    RecyclerView recyclerView;
    SpinKitView spinKitView;

    public Frag_sports() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_home, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        spinKitView = view.findViewById(R.id.spin_kit);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ApiCall apiCall = new ApiCall(Constants.sports_url, getContext(), recyclerView, spinKitView);
        apiCall.apiFetch();
        return view;
    }

}