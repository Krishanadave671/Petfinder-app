package com.krishana.petfinderapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.krishana.petfinderapp.fragment.Chemistry_fragment;
import com.krishana.petfinderapp.fragment.MathsFragment;
import com.krishana.petfinderapp.fragment.PhysicsFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 1:
               return new MathsFragment();
           case 2:
               return new Chemistry_fragment();
           case 3:
               return new PhysicsFragment();
           default:
               return new MathsFragment();

       }


    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
