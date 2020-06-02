package de.telekom.sea.mystuff.frontend.einkaufsliste.ui;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import de.telekom.sea.mystuff.frontend.einkaufsliste.R;
import de.telekom.sea.mystuff.frontend.einkaufsliste.api.ApiFactory;
import de.telekom.sea.mystuff.frontend.einkaufsliste.api.ItemApi;
import de.telekom.sea.mystuff.frontend.einkaufsliste.databinding.FragmentShopDetailBinding;
import de.telekom.sea.mystuff.frontend.einkaufsliste.model.Item;
import de.telekom.sea.mystuff.frontend.einkaufsliste.repo.ItemRepo;


public class ShopDetailFragment extends Fragment {

    private FragmentShopDetailBinding binding;
    private EinkaufenListViewModel viewModel;
    //private EinkaufenDetailViewModel viewModel;

    public static ShopDetailFragment newInstance(){
        return new ShopDetailFragment();
    }
    /*
    public ShopDetailFragment() {
        // Required empty public constructor
    }      */



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop_detail, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long itemId = getArguments().getLong("itemId");
        Log.d("ShopDetailFragment", "ItemId: " + itemId);
        Toast.makeText(getContext(), "ItemId: " + itemId, Toast.LENGTH_LONG);

        // Wir müssen an dieser Stelle an den Context kommen:
        //MyStuffApplication application = (MyStuffApplication) requireActivity().getApplication();
        //MyStuffContext myStuffContext = application.getMyStuffContext();  // alt + enter

        //Application application = (Application) requireActivity().getApplication();
        //Context einkaufenContext = application.getBaseContext().getApplicationContext();


        ApiFactory apiFactory = new ApiFactory();
        ItemRepo itemRepo = new ItemRepo(apiFactory.createApi(ItemApi.class));

        itemRepo.getById(itemId).observe(this.getViewLifecycleOwner(), itemApiResponse -> {
            if (itemApiResponse.isSuccessful()){
                binding.setItem(itemApiResponse.body);
            } else {
                Toast.makeText(getContext(), "Could not load item", Toast.LENGTH_LONG).show();
            }
        }

        );

    }
}

