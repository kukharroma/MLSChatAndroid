package com.mlsdev.mlschatandroid.data.remote.api.contract;

import com.mlsdev.mlschatandroid.domain.model.Profile;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

/**
 * Created by oleksandr on 03.05.17.
 */

public interface ProfileAPIContract {

    @GET(APIUrls.Profile.PROFILE)
    Observable<Profile> getProfile();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST(APIUrls.Profile.PROFILE)
    Observable<Profile> createProfile(@Field("user[first_name]") String firstName,
                                      @Field("user[last_name]") String lastName,
                                      @Field("user[email]") String email,
                                      @Field("user[password]") String password,
                                      @Field("password_confirmation") String passwordConfirmation);

    @Multipart
    @PUT(APIUrls.Profile.PROFILE)
    Observable<Profile> updateProfile(@Part(value = "profile[first_name]") RequestBody firstName,
                                      @Part(value = "profile[last_name]") RequestBody lastName,
                                      @Part(value = "profile[email]") RequestBody email,
                                      @Part MultipartBody.Part photo);

}
