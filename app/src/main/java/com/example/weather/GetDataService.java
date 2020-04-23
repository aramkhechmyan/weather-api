package com.example.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("/data/2.5/weather?appid=25716db72827ed662a5aaa3ea3b1eafc")
    Call<Response> getAllResponses(@Query("q") String location);

}
