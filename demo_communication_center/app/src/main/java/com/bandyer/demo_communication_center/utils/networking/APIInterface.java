package com.bandyer.demo_communication_center.utils.networking;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * WARNING!!!
 * The networking package is used only to fetch the users, to make the demo app run out of the box.
 * With the least efforts.
 * <p>
 * Defines Rest calls available to be used
 */
public interface APIInterface {

    /**
     * Method returns the mocked users that have been created by us or you via server side rest calls.
     *
     * @return BandyerUsers
     */
    @GET("rest/user/list")
    Call<BandyerUsers> getUsers();
}