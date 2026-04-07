package com.example.learningfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteDetailFragment extends Fragment {

    public NoteDetailFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note_detail, container, false);

        TextView tvContent = view.findViewById(R.id.tvNoteContent);

        // Get data from bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String note = bundle.getString("note_key");
            tvContent.setText(note);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Hide bottom nav
        requireActivity()
                .findViewById(R.id.bottomNavigationView)
                .setVisibility(View.GONE);
    }
}