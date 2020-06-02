package de.telekom.sea.mystuff.frontend.einkaufsliste.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import de.telekom.sea.mystuff.frontend.einkaufsliste.MainActivity;
import de.telekom.sea.mystuff.frontend.einkaufsliste.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopListFragment extends Fragment {

    private RecyclerView itemsList;
    private EinkaufenListViewModel viewModel;
    private EinkaufenListRecyclerViewAdapter itemListAdapter = null;


    public ShopListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_list, container, false);
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Code aus MainA.

        itemsList = view.findViewById(R.id.rv_items);
        //  --> check the dogsExample:  --> Mayo ==> refreshLayout = findViewById(R.id.refreshRideListLayout);
        viewModel = new ViewModelProvider(this).get(EinkaufenListViewModel.class);                // warum macht man dies so kompliziert? --> ViewModelProvider: der Erzeuger der ViewModel, da die ViewModel kann länger leben als die MainActivity...
        //viewModel.initWithApplication(getApplication());  // springt in MyStuffViewModel, damit bekomme ich den Context --> Api-Factory sind definiert (Zentraler Bereich, wie ich an meine Dienste komme)Zeile macht:                                           // darum legt man die Daten ab und man holt sie die alte Instanz aus dem Speicher...

        // array-list ausgebaut: --> itemListAdapter = new EinkaufenListRecyclerViewAdapter(new ArrayList<>()); // Android kann sehr willkührlich sein.

        // item besorgen bedeutet construktor aufrufen! <==
        itemListAdapter = new EinkaufenListRecyclerViewAdapter(Navigation.findNavController(view));



        itemsList.setLayoutManager(new LinearLayoutManager(getActivity())); // -------------------------------------------------------------------------------------------> getActivity von DAVID !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        itemsList.setAdapter(itemListAdapter);  // verbindet Adapter mit RecyclerView; RecyclerView benutzt Adapter um die Zeilen aufzubauen.

        observeItemsListViewModel();            // ruft die Methode unten auf...



    }



    // LiveData (leere Hülle) ist, was ich im Hintergrund ändern kann. Der Ladevorgang ist ein Hintergrundtask. Benachrichtige uns, wenn Du fertig bist mit laden...!
    // ObserveForEver / Observe --> xxx / Observe, nur solange die Activity läuft
    private void observeItemsListViewModel() {
        viewModel.getMyItems().observe(getActivity(), listApiResponse -> {
            if (listApiResponse.isSuccessful()){
                itemListAdapter.updateList(listApiResponse.body);
            } else {
                Toast.makeText(getActivity(), listApiResponse.errorMessage, Toast.LENGTH_LONG).show();
                // ohne myStuff... keine Fehlermeldung, also über Toast...
                // ((MyStuffApplication) getApplication()).getMyStuffContext().sendInfoMessage(listApiResponse.errorMessage);
            }
        });








    }




}



// Hier muss der Code des RecylerView!!!




/*

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.telekom.sea.mystuff.frontend.android.R;


public class ListFragment extends Fragment {

    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}

 */