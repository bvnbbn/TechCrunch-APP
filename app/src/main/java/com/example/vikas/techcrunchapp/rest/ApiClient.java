package com.example.vikas.techcrunchapp.rest;

/**
 * Created by vikas on 29/9/17.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    public static final String URL="https://public-api.wordpress.com/rest/v1.1/sites/";
    private static Retrofit retrofit=null;

    public static Retrofit getClient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()//nested class of Retrofit used to create a new instance of retrofit class
                    .baseUrl(URL)//loaded the base URL which will be used later for all api calls
                    .addConverterFactory(GsonConverterFactory.create())//added converter factory for
                    // serialization and desserialization of objects

                    .build();//created the retrofit instance with configured values

        }
        return retrofit;
    }

}
