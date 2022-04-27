package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface API {

    //register
    @FormUrlEncoded
    @POST("api/store_user")
    @Headers("Accept: application/json")
    fun register(
        @Field("city_id")city_id:Int,
        @Field("first_name")first_name:String,
        @Field("last_name")last_name:String,
        @Field("email")email:String,
        @Field("gender")gender:String,
        @Field("password")password:String,
        @Field("address")address:String,
        @Field("phone")phone:Long
    ): Call<UserRegister>

    //git category
    @FormUrlEncoded
    @POST("api/auth/places_types/show_all_places_types")
    @Headers("Accept: application/json")
    fun gitCategory(
        @Field("token") token:String


    ): Call<CategoriesRespon>

    ///gitPlaceByPlaceType
    @FormUrlEncoded
    @POST("api/auth/places/show_places_by_place_type")
    @Headers("Accept: application/json")
    fun gitPlaceByPlaceType(
        @Field("token") token:String,
        @Field("place_type_id") place_type_id:Int

    ): Call<ListOfPlaceType>
    //////placeDetails
    @FormUrlEncoded
    @POST("api/auth/places/show_details_of_place")
    @Headers("Accept: application/json")
    fun getPlaceDetails(
        @Field("token") token:String,
        @Field("place_type_id") place_id:Int

    ): Call<PlaceDetailsResponse>
}