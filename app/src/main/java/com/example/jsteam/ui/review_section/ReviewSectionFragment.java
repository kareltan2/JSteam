package com.example.jsteam.ui.review_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsteam.Adapter.ReviewSectionAdapter;
import com.example.jsteam.databinding.FragmentReviewSectionBinding;
import com.example.jsteam.model.DatabaseConfiguration;

public class ReviewSectionFragment extends Fragment {

    private FragmentReviewSectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        new ViewModelProvider(this).get(ReviewSectionModel.class);

        binding = FragmentReviewSectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        init();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void init(){
        final RecyclerView recyclerViewReviewSectionList = binding.rvReviewSectionList;

        recyclerViewReviewSectionList.setAdapter(new ReviewSectionAdapter(binding.getRoot().getContext(), DatabaseConfiguration.reviews));
        recyclerViewReviewSectionList.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
    }
}