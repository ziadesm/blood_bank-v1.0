package echomachine.com.bloodbank_v1.api;

import java.util.ArrayList;

import echomachine.com.bloodbank_v1.pojo.ProfileData;
import echomachine.com.bloodbank_v1.pojo.general.Cities;
import echomachine.com.bloodbank_v1.pojo.general.Governorates;
import echomachine.com.bloodbank_v1.pojo.register.RegisterData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    // User (Profile- Login- Register- Reset)
    // --------------------------------------- User -----------------------------------------//

    @POST("reset-password")
    @FormUrlEncoded
    Call<ResponseBody> resetPasswordRequest(@Body String phone);

    @POST("new-password")
    @FormUrlEncoded
    Call<ResponseBody> newPasswordRequest(@Field("password") String password
            , @Field("password_confirmation") String password_confirmation
            , @Field("pin_code") int pin_code
            , @Field("phone") String phone);

    @POST("profile")
    @FormUrlEncoded
    Call<ResponseBody> getProfileData(@Field("api_token") String api_token);

    @POST("profile")
    @FormUrlEncoded
    Call<ResponseBody> editProfileData(@Field("") ProfileData profileData);

    @POST("signup")
    @FormUrlEncoded
    Call<RegisterData> registerNewUser(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("birth_date") String birthDate,
                                       @Field("city_id") int cityId,
                                       @Field("phone") String phone,
                                       @Field("donation_last_date") String donation_last_date,
                                       @Field("password") String password,
                                       @Field("password_confirmation") String password_confirmation,
                                       @Field("blood_type_id") int blood_type_id);

    @POST("login")
    @FormUrlEncoded
    Call<ResponseBody> loginUser(@Field("phone") String phone
            , @Field("password") String password);


    // --------------------------------------- Notification -----------------------------------------//

    @POST("signup-token")
    @FormUrlEncoded
    Call<ResponseBody> registerNotificationToken(@Field("token") String token
            , @Field("api_token") String api_token
            , @Field("type") String type);

    @POST("remove-token")
    @FormUrlEncoded
    Call<ResponseBody> removeNotificationToken(@Field("token") String token, @Field("api_token") String api_token);

    @POST("notifications-settings")
    @FormUrlEncoded
    Call<ResponseBody> changeNotificationSettings(
            @Field("api_token") String api_token,
            @Field("governorates[]") ArrayList<String> governorates,
            @Field("blood_types[]") ArrayList<String> blood_types);

    // --------------------------------------- General -----------------------------------------//

    @GET("governorates")
    Call<Governorates> getAllGovernorates();

    @GET("cities")
    Call<Cities> getAllCities(@Query("governorate_id") int governorate_id);

    @GET("blood-types")
    Call<Governorates> getAllBloodTypes();
}
