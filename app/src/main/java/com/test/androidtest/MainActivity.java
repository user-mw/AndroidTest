package com.test.androidtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.test.androidtest.screens.MainScreenFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            changeFragment(MainScreenFragment.newInstance());
        }
    }

    private void changeFragment(Fragment newFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        boolean isInBackStack = fragmentManager.findFragmentById(R.id.fragment_container) != null;

        FragmentTransaction transaction = fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment);

        if(isInBackStack) {
            transaction.addToBackStack(newFragment.getClass().getSimpleName());
        }

        transaction.commit();
    }
}
