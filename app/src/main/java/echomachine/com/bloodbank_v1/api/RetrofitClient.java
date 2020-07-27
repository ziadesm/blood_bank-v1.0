package echomachine.com.bloodbank_v1.api;
import android.util.Log;

import echomachine.com.bloodbank_v1.pojo.ProfileData;
import echomachine.com.bloodbank_v1.pojo.general.Cities;
import echomachine.com.bloodbank_v1.pojo.general.Governorates;
import echomachine.com.bloodbank_v1.pojo.register.RegisterData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String TAG = "ZiadReg";
    private static RetrofitClient INSTANCE;
    private ApiService apiService;
    private static final String BASE_URL = "http://ipda3-tech.com/blood-bank/api/v1/";

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }

    public Call<ResponseBody> resetPasswordClient(String phone) {
        return apiService.resetPasswordRequest(phone);
    }

    public Call<ResponseBody> newPasswordClient(String password, String password_confirmation, int pin_code, String phone) {
        return apiService.newPasswordRequest(password, password_confirmation, pin_code, phone);
    }

    public Call<RegisterData> registerNewUserClient(ProfileData data){
        Log.d(TAG, "registerNewUserClient: " + data.getName());
        Log.d(TAG, "registerNewUserClient: " + data.getEmail());
        Log.d(TAG, "registerNewUserClient: " + data.getBirth_date());
        Log.d(TAG, "registerNewUserClient: " + data.getCity_id());
        Log.d(TAG, "registerNewUserClient: " + data.getPhone());
        Log.d(TAG, "registerNewUserClient: " + data.getDonation_last_date());
        Log.d(TAG, "registerNewUserClient: " + data.getPassword());
        Log.d(TAG, "registerNewUserClient: " + data.getPassword_confirmation());
        Log.d(TAG, "registerNewUserClient: " + data.getBlood_type_id());
        return apiService.registerNewUser(data.getName(), data.getEmail(),
                data.getBirth_date(), data.getCity_id(), data.getPhone(),
                data.getDonation_last_date(), data.getPassword(), data.getPassword_confirmation(),
                data.getBlood_type_id());
    }

    public Call<Governorates> getAllGovernors() {
        return apiService.getAllGovernorates();
    }

    public Call<Governorates> getAllBloodType() {
        return apiService.getAllBloodTypes();
    }

    public Call<Cities> getAllCities(int governorId) {
        return apiService.getAllCities(governorId);
    }
}
