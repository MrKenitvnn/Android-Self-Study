package com.ken.retrofit.rest;

import com.ken.retrofit.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HN on 26/09/16.
 */
public interface ApiInterface {
    /**
     * URL will be:
     * http://api.themoviedb.org/3/movie/top_rated?api_key=blablable
     */
    @GET("move/top_rate")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);


    /**
     * URL will be:
     * http://api.themoviedb.org/3/movie/id={id}&api_key=blablable
     */
    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id,
                                         @Query("api_key") String apiKey);


    /**
     * Take a look to other annotations:
     *
     * @Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.
     *
     * @Query – specifies the query key name with the value of the annotated parameter.
     *
     * @Body – payload for the POST call
     *
     * @Header – specifies the header with the value of the annotated parameter
     *
     */

}
