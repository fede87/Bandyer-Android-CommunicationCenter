package com.bandyer.demo_communication_center.utils.networking;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * WARNING!!!
 * The networking package is used only to fetch the users, to make the demo app run out of the box.
 * With the least efforts.
 * <p>
 * RetroFit ApiClient used to make the rest calls
 */
public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(final String apikey) {
        if (retrofit != null)
            return retrofit;

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(authenticationHeaders(apikey))
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox.bandyer.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    private static Interceptor authenticationHeaders(final String apikey) {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {

                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("apikey", apikey)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        };
    }

}