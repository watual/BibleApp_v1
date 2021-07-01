package com.example.bibleapp_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
        return MyAdapter_fragment.newinstance(1);
    }

    @Override
    public int getItemCount() {
        return mCount;
    }
}
