package com.example.learningfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FolderFragment extends Fragment {

    public FolderFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_folder, container, false);

        ListView listView = view.findViewById(R.id.listViewFolders);

        // Hardcoded folder data
        String[] folders = {
                "Work",
                "Personal",
                "Ideas",
                "Projects",
                "Study",
                "Travel Plans"
        };

        // Simple adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                folders
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {

            String selectedFolder = folders[position];

            Bundle bundle = new Bundle();
            bundle.putString("folder", selectedFolder);

            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_folder_to_detail, bundle);
        });
        return view;
    }
}