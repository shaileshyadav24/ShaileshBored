// Created by Shailesh Yadav - 101332535


package com.example.shaileshbored;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaileshbored.ViewModel.BoredViewModel;
import com.example.shaileshbored.model.Bored;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BoredViewModel boredViewModel;
    private TextView tvActivity;
    private Button btnAddToFav;
    private Button btnShowAnother;
    private Bored bored = new Bored();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boredViewModel = BoredViewModel.getInstance();

        boredViewModel.fetchAllData();

        this.tvActivity = findViewById(R.id.tvActivity);
        this.btnAddToFav = findViewById(R.id.addToFav);
        this.btnAddToFav.setOnClickListener(this);
        this.btnShowAnother = findViewById(R.id.btnShowAnother);
        this.btnShowAnother.setOnClickListener(this);

        this.boredViewModel.boredMutableLiveData.observe(this, new Observer<Bored>() {
            @Override
            public void onChanged(Bored b) {
                if (b != null) {
                    tvActivity.setText(b.getActivity());
                    bored = b;
                }
            }
        });

        this.boredViewModel.getBoredRepositoryInstance().boredMutableData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                if(message != null) {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.addToFav:
                    // firestore
                    boredViewModel.addBoredToFavList(bored);
                    break;
                case R.id.btnShowAnother:
                    boredViewModel.fetchAllData();
                    break;
            }
        }
    }
}