package com.example.learningfragments;

import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class NotesFragment extends Fragment {

    public NotesFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        ListView listView = view.findViewById(R.id.listViewNotes);

        // Hardcoded data
        String[] notes = {
                "Buy groceries",
                "Complete Android project",
                "Call John",
                "Prepare for interview",
                "Read system design notes",
                "Workout at 7 PM",
                "Plan weekend trip"
        };

        // Simple adapter (built-in)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                notes
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {

            String selectedNote = notes[position];

            Bundle bundle = new Bundle();
            bundle.putString("note", selectedNote);

            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_notes_to_detail, bundle);
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        requireActivity()
                .findViewById(R.id.bottomNavigationView)
                .setVisibility(View.VISIBLE);
    }
}