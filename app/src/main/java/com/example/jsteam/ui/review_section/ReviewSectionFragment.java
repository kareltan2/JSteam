package com.example.jsteam.ui.review_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jsteam.databinding.FragmentReviewSectionBinding;

/**
 * @author kareltan
 */
public class ReviewSectionFragment extends Fragment {

    private FragmentReviewSectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReviewSectionModel reviewSectionModel = new ViewModelProvider(this).get(ReviewSectionModel.class);

        binding = FragmentReviewSectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReviewSection;
        reviewSectionModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}