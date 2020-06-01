package de.telekom.sea.mystuff.frontend.einkaufsliste.api;

import androidx.lifecycle.LiveData;

import java.util.List;

import de.telekom.sea.mystuff.frontend.einkaufsliste.model.Item;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItemApi {

    @GET("/api/v2/items")
    public LiveData<ApiResponse<List<Item>>> getAll();

    @GET("/api/v2/items/{id}")
    public LiveData<ApiResponse<Item>>getById(@Path("id") Long id);

}
