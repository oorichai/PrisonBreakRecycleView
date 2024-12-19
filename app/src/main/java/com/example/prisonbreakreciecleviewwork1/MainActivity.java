package com.example.prisonbreakreciecleviewwork1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Character> characterList = new ArrayList<>();
    private CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText search_bar = findViewById(R.id.search_bar);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        populateCharacterList();
        adapter = new CharacterAdapter(this, characterList);
        recyclerView.setAdapter(adapter);

        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    private void populateCharacterList() {
        characterList.add(new Character("Michael Scofield", "A genius engineer and mastermind of the escape plan.", R.drawable.michael_scofield));
        characterList.add(new Character("Lincoln Burrows", "Michael's brother, framed for a crime he didn't commit.", R.drawable.lincoln_burrows));
        characterList.add(new Character("Sara Tancredi", "The prison doctor and Michael's ally.", R.drawable.sara_tancredi));
        characterList.add(new Character("Theodore 'T-Bag' Bagwell", "A manipulative and dangerous inmate.", R.drawable.t_bag));
        characterList.add(new Character("Fernando Sucre", "Michael's loyal friend and cellmate.", R.drawable.fernando_sucre));
        characterList.add(new Character("John Abruzzi", "A mobster who becomes part of the escape plan.", R.drawable.john_abruzzi));
        characterList.add(new Character("Brad Bellick", "The cruel head guard of the prison.", R.drawable.brad_bellick));
        characterList.add(new Character("Alexander Mahone", "An FBI agent chasing the escapees.", R.drawable.alexander_mahone));
        characterList.add(new Character("Paul Kellerman", "A government agent carrying out shadowy missions.", R.drawable.paul_kellerman));
        characterList.add(new Character("Charles Westmoreland", "An older inmate who claims to be D.B. Cooper.", R.drawable.charles_westmoreland));
    }


    private void filter(String text) {
        List<Character> filteredList = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(character);
            }
        }
        adapter.filterList(filteredList);
    }
}
