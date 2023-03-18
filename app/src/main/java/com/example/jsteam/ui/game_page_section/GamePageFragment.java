package com.example.jsteam.ui.game_page_section;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jsteam.databinding.FragmentGamePageBinding;
import com.example.jsteam.model.Game;

import java.util.Vector;

public class GamePageFragment extends Fragment {

    private FragmentGamePageBinding binding;
    private Vector<Game> gamesListVector = new Vector<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GamePageModel gamePageModel = new ViewModelProvider(this).get(GamePageModel.class);

        binding = FragmentGamePageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvTextGamePage;
        gamePageModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}