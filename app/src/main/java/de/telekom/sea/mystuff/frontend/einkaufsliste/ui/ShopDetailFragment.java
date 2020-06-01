package de.telekom.sea.mystuff.frontend.einkaufsliste.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.telekom.sea.mystuff.frontend.einkaufsliste.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment {

    public ShopDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_detail, container, false);
    }
}


/*

package de.telekom.sea.mystuff.frontend.android.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.telekom.sea.mystuff.frontend.android.R;

/**
 * A simple {@link Fragment} subclass.

public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}

 */