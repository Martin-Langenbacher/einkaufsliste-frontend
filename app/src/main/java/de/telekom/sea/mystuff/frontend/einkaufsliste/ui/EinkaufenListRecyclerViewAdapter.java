package de.telekom.sea.mystuff.frontend.einkaufsliste.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.telekom.sea.mystuff.frontend.einkaufsliste.R;
import de.telekom.sea.mystuff.frontend.einkaufsliste.databinding.EinkaufenItemBinding;
import de.telekom.sea.mystuff.frontend.einkaufsliste.model.Item;


import lombok.Getter;
import timber.log.Timber;

public class EinkaufenListRecyclerViewAdapter extends RecyclerView.Adapter<EinkaufenListRecyclerViewAdapter.ViewHolder>{

    private static int countOnBindViewHolder = 0;
    private static int countOnCreateViewHolder = 0;

    private NavController navController;

    @Getter
    private final List<Item>list;  // final List kann Referenz nicht ändern, da final! --> Inhalt kann geändert werden - trotz final!


    public EinkaufenListRecyclerViewAdapter(NavController navController){
        this.navController = navController;
        this.list = new ArrayList<>();
    }




    /* --> alt !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public EinkaufenListRecyclerViewAdapter(List<Item> list){
        this.list = list;
    }
    */


    public void updateList(List<Item> newList){
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();  // Benachrichtigung an Oberfläche: etwas wurde geändert!
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        countOnCreateViewHolder++;
        Timber.d("-----------------------------------------------------------------> countOnCreateViewHolder " + countOnCreateViewHolder);
        EinkaufenItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.einkaufen_item, parent, false);
        return new ViewHolder(listItemBinding);
    }


    @Override
    public void onBindViewHolder(@lombok.NonNull ViewHolder holder, int position){
        countOnBindViewHolder++;
        Timber.d("-----------------------------------------------------------------> OnBindViewHolder " + countOnBindViewHolder);
        Item item = getList().get(position);
        holder.getBinding().setItem(item);




        // Sprung ... --> actionToDetail
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("ItemListRecycler", "Click row : ", v);
                Bundle bundle = new Bundle();  // Bundle ist so etwas wie eine map
                bundle.putLong("itemId", item.getId());
                // bundle.putSerializable("item", (Serializable) item); // ???????????????????????????????????????????????????????????????????????????? cast ???
                //navController.navigate(R.id.actionToDetail, bundle);
                navController.navigate(R.id.actionToDetail, bundle);
            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private EinkaufenItemBinding binding;

        public ViewHolder(@lombok.NonNull EinkaufenItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}




// Info, RecyclerView (Link):
// https://androidwave.com/android-recyclerview-example-best-practices/


// Info, more general (Link):
// https://androidwave.com/android-data-binding-recyclerview/








/* Vorher











{

    private static int countOnBindViewHolder = 0;
    private static int countOnCreateViewHolder = 0;

    private final List<Item> items;  // final List kann Referenz nicht ändern, da final! --> Inhalt kann geändert werden - trotz final!
    private NavController navController;

    public EinkaufenListRecyclerViewAdapter(NavController navController){
        this.items = new ArrayList<>();
        this.navController = navController;
    }


    public void updateList(List<Item> list){
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();  // Benachrichtigung an Oberfläche: etwas wurde geändert!
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        countOnCreateViewHolder++;
        Timber.d("-----------------------------------------------------------------> countOnCreateViewHolder " + countOnCreateViewHolder);
        MyStuffItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.my_stuff_item, parent, false);
        return new ViewHolder(listItemBinding, false);
    }


    @Override
    public void onBindViewHolder(@lombok.NonNull ViewHolder holder, int position){
        countOnBindViewHolder++;
        Timber.d("-----------------------------------------------------------------> OnBindViewHolder " + countOnBindViewHolder);
        Item item = this.items.get(position);
        holder.binding.setItem(item);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("ItemListRecycler", "Click row : ", v);
                Bundle bundle = new Bundle();  // Bundle ist so etwas wie eine map
                bundle.putLong("itemId", item.getId());
                // bundle.putSerializable("item", (Serializable) item); // ???????????????????????????????????????????????????????????????????????????? cast ???
                //navController.navigate(R.id.actionToDetail, bundle);
                navController.navigate(R.id.actionToDetail, bundle);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }else {
            return 0;
        }
    }



    static class ViewHolder extends RecyclerView.ViewHolder {


        @Getter
        final MyStuffItemBinding binding;

        ViewHolder(MyStuffItemBinding binding, Boolean received) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
 */































/*


package de.telekom.sea.mystuff.frontend.android.ui;


// ViewAdapter ist zur Anzeige der View zustän

public class ItemListRecyclerViewAdapter extends RecyclerView.Adapter<ItemListRecyclerViewAdapter.ViewHolder> {


}




 */






















/*
package de.telekom.sea.mystuff.frontend.android.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.telekom.sea.mystuff.frontend.android.R;
import de.telekom.sea.mystuff.frontend.android.databinding.MyStuffItemBinding;
import de.telekom.sea.mystuff.frontend.android.model.Item;
import lombok.Getter;
import timber.log.Timber;

// ViewAdapter ist zur Anzeige der View zustän

public class ItemListRecyclerViewAdapter extends RecyclerView.Adapter<ItemListRecyclerViewAdapter.ViewHolder> {

    private static int countOnBindViewHolder = 0;
    private static int countOnCreateViewHolder = 0;

    @Getter
    private final List<Item>list;  // final List kann Referenz nicht ändern, da final! --> Inhalt kann geändert werden - trotz final!

    public ItemListRecyclerViewAdapter(List<Item> list){
        this.list = list;
    }


    public void updateList(List<Item> newList){
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();  // Benachrichtigung an Oberfläche: etwas wurde geändert!
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        countOnCreateViewHolder++;
        Timber.d("-----------------------------------------------------------------> countOnCreateViewHolder " + countOnCreateViewHolder);
        MyStuffItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.my_stuff_item, parent, false);
        return new ViewHolder(listItemBinding);
    }


    @Override
    public void onBindViewHolder(@lombok.NonNull ViewHolder holder, int position){
        countOnBindViewHolder++;
        Timber.d("-----------------------------------------------------------------> OnBindViewHolder " + countOnBindViewHolder);
        Item item = getList().get(position);
        holder.getBinding().setItem(item);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public class  ViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private MyStuffItemBinding binding;

        public ViewHolder(@lombok.NonNull MyStuffItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}


// Info, RecyclerView (Link):
// https://androidwave.com/android-recyclerview-example-best-practices/


// Info, more general (Link):
// https://androidwave.com/android-data-binding-recyclerview/


 */



















