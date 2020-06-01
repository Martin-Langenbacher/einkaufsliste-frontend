package de.telekom.sea.mystuff.frontend.einkaufsliste.ui;

import androidx.lifecycle.ViewModel;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.telekom.sea.mystuff.frontend.einkaufsliste.api.ApiFactory;
import de.telekom.sea.mystuff.frontend.einkaufsliste.api.ApiResponse;
import de.telekom.sea.mystuff.frontend.einkaufsliste.api.ItemApi;
import de.telekom.sea.mystuff.frontend.einkaufsliste.model.Item;

public class EinkaufenListViewModel extends ViewModel {

    // Ohne ...Context, ....
    public LiveData<ApiResponse<List<Item>>> getMyItems(){
        ApiFactory apiFactory = new ApiFactory();
        ItemApi itemApi = apiFactory.createApi(ItemApi.class); // Hier erzeuge ich das itemApi
        //ItemRepo itemRepo = new ItemRepo(itemApi);
        //return itemRepo.getAll();
        return itemApi.getAll(); // Grund für Repo: Google-Empfehlung (wegen offline-Nutzung!)
    }

}



// NICHT mit MYStuff ViewMOdel...

/*



public class ItemListViewModel extends MyStuffViewModel {

    public LiveData<ApiResponse<List<Item>>> getMyItems(){
        return getMyStuffContext().getItemRepo().getAll();
    }

}


 */