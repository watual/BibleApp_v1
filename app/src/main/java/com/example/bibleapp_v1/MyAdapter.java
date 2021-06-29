package com.example.bibleapp_v1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public int mCount;
    public MyAdapter(AppCompatActivity aca, int count) {
        super(aca);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragment1.newinstance(1);
    }

    @Override
    public int getItemCount() {

        return 10;
    }
}
