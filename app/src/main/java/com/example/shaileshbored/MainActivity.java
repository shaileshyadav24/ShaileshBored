package com.example.shaileshbored;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.shaileshbored.ViewModel.BoredViewModel;
import com.example.shaileshbored.model.Bored;

public class MainActivity extends AppCompatActivity {

    private BoredViewModel boredViewModel;
    private TextView tvActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boredViewModel = BoredViewModel.getInstance();

        boredViewModel.fetchAllData();

        this.tvActivity = findViewById(R.id.tvActivity);


        this.boredViewModel.boredMutableLiveData.observe(this, new Observer<Bored>() {
            @Override
            public void onChanged(Bored bored) {
                if(bored != null) {
                    tvActivity.setText(bored.getActivity().toString());
                }
            }
        });


    }
}