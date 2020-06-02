package de.telekom.sea.mystuff.frontend.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import de.telekom.sea.mystuff.frontend.einkaufsliste.ui.EinkaufenListRecyclerViewAdapter;
import de.telekom.sea.mystuff.frontend.einkaufsliste.ui.EinkaufenListViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}


