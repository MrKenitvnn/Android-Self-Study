package com.ken.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ken.retrofit.model.Movie;
import com.ken.retrofit.model.MoviesResponse;
import com.ken.retrofit.rest.ApiClient;
import com.ken.retrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String API_KEY = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_SHORT).show();
            return;
        }

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.body() == null) {
                    Log.e(TAG, "BODY NULL");
                    return;
                }

                List<Movie> movies = response.body().getResults();
                Log.e(TAG, "list movies size: " + movies.size());

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }


}
