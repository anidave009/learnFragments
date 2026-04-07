package com.example.learningfragments;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNavigationView);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);

        NavController navController = navHostFragment.getNavController();

        // Bottom nav clicks
        bottomNav.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.menu_notes) {
                navController.navigate(R.id.notesFragment);
                return true;
            } else if (item.getItemId() == R.id.menu_folders) {
                navController.navigate(R.id.folderFragment);
                return true;
            }

            return false;
        });

        // Show / Hide bottom nav
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            if (destination.getId() == R.id.notesFragment ||
                    destination.getId() == R.id.folderFragment) {

                bottomNav.setVisibility(View.VISIBLE);
            } else {
                bottomNav.setVisibility(View.GONE);
            }
        });
    }
}