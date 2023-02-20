package com.example.apinavigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    MyAdapter myAdapter;
    List<ApiRecyModel> apiRecyModelList = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(apiRecyModelList);
        recyclerView.setAdapter(myAdapter);

        fetchContents();

        return view;
    }

    private void fetchContents() {
        RetrofitClient.getRetrofitClient().getApiREcyModels().enqueue(new Callback<List<ApiRecyModel>>() {
            @Override
            public void onResponse(Call<List<ApiRecyModel>> call, Response<List<ApiRecyModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    apiRecyModelList.addAll(response.body());
                    myAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ApiRecyModel>> call, Throwable t) {

            }
        });


    }
}