package com.example.shaileshbored.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shaileshbored.model.Bored;
import com.example.shaileshbored.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoredViewModel extends ViewModel {


    private static final BoredViewModel instance = new BoredViewModel();
    public MutableLiveData<Bored> boredMutableLiveData = new MutableLiveData<>();


    public static BoredViewModel getInstance() {
        return instance;
    }

    public BoredViewModel() {
    }

    public void fetchAllData() {
        Call<Bored> call = RetrofitClient.getInstance().getApi().retrieveResponse();

        try {

            call.enqueue(new Callback<Bored>() {
                @Override
                public void onResponse(Call<Bored> call, Response<Bored> response) {
                    Bored bored = response.body();
                    boredMutableLiveData.postValue(bored);
                }

                @Override
                public void onFailure(Call<Bored> call, Throwable t) {

                }
            });

        } catch (Exception e) {

        }


    }

}
