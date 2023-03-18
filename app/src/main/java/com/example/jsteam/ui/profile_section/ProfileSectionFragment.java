package com.example.jsteam.ui.profile_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jsteam.databinding.FragmentProfileSectionBinding;

/**
 * @author kareltan
 */
public class ProfileSectionFragment extends Fragment {

    private FragmentProfileSectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileSectionModel profileSectionModel = new ViewModelProvider(this).get(ProfileSectionModel.class);

        binding = FragmentProfileSectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textProfileSection;
        profileSectionModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}