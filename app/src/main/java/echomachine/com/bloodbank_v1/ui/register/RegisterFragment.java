package echomachine.com.bloodbank_v1.ui.register;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import echomachine.com.bloodbank_v1.Constant;
import echomachine.com.bloodbank_v1.MyApp;
import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.api.RetrofitClient;
import echomachine.com.bloodbank_v1.pojo.ProfileData;
import echomachine.com.bloodbank_v1.pojo.general.Cities;
import echomachine.com.bloodbank_v1.pojo.general.Datum;
import echomachine.com.bloodbank_v1.pojo.general.Governorates;
import echomachine.com.bloodbank_v1.pojo.register.RegisterData;
import echomachine.com.bloodbank_v1.receiver.ConnectivityReceiver;
import echomachine.com.bloodbank_v1.utils.HelperMethod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterFragment extends Fragment implements ConnectivityReceiver.ConnectivityReceiverListener {
    private static final String TAG = "ZiadReg";
    
    // Widgets 
    private EditText mUsernameET, mEmailET, mBirthET, mLastDonationET, mPhoneET, mPasswordET, mPasswordConfET;
    private Button signUpBtn;
    private Spinner sBloodTypeSpinner, sGoverSpinner, sCitySpinner;
    
    // Vars
    private List<String> mListGovernate = new ArrayList<>();
    private List<String> mListCities = new ArrayList<>();
    private List<String> mListBloodType = new ArrayList<>();

    private ArrayAdapter<String> governateAdapter;
    private ArrayAdapter<String> cityAdapter;
    private ArrayAdapter<String> bloodTypeAdapter;

    private ConnectivityReceiver receiver;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperMethod.hideAllBars(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        mUsernameET = view.findViewById(R.id.reg_fragment_ll_et_username);
        mEmailET = view.findViewById(R.id.reg_fragment_ll_et_email);
        mBirthET = view.findViewById(R.id.reg_fragment_ll_et_birth);
        sBloodTypeSpinner = view.findViewById(R.id.reg_fragment_ll_et_blood_type);
        mLastDonationET = view.findViewById(R.id.reg_fragment_ll_et_last_don);
        sGoverSpinner = view.findViewById(R.id.reg_fragment_ll_et_country);
        sCitySpinner = view.findViewById(R.id.reg_fragment_ll_et_city);
        mPhoneET = view.findViewById(R.id.reg_fragment_ll_et_phone);
        mPasswordET = view.findViewById(R.id.reg_fragment_ll_et_pass);
        mPasswordConfET = view.findViewById(R.id.reg_fragment_ll_et_pass_con);
        signUpBtn = view.findViewById(R.id.reg_fragment_ll_btn);

        signUpBtn.setOnClickListener(v -> checkValidation());

        if (ConnectivityReceiver.isConnected(getActivity())) {
            getBloodTypeData();
        }
        return view;
    }

    private void checkValidation() {
        String username = mUsernameET.getText().toString();
        String email = mEmailET.getText().toString();
        String birth = mBirthET.getText().toString();
        String last_don = mLastDonationET.getText().toString();
        String phone = mPhoneET.getText().toString();
        String pass = mPasswordET.getText().toString();
        String pass_con = mPasswordConfET.getText().toString();

        String blood_type = sBloodTypeSpinner.getSelectedItem().toString();
        String country = sGoverSpinner.getSelectedItem().toString();
        String city = sCitySpinner.getSelectedItem().toString();

        int countryValue = sGoverSpinner.getSelectedItemPosition() + 1;
        int cityValue = sCitySpinner.getSelectedItemPosition() + 1;
        int bloodValue = sBloodTypeSpinner.getSelectedItemPosition() + 1;

        String[] allName = {username, email, birth, blood_type, last_don, phone, pass, pass_con};
        EditText[] allEdit = {mUsernameET, mEmailET, mBirthET, mLastDonationET, mPhoneET, mPasswordET, mPasswordConfET};

        for (int i = 0; i < allName.length - 1; i++) {
            if (TextUtils.isEmpty(allName[i])) {
                allEdit[i].setError("Please fill the field");
                return;
            }
        }

        if (!pass.equals(pass_con)) {
            mPasswordConfET.setError("Not the same password");
            return;
        }
        // TODO(1) You need to make a call to end the Register Validation (Intent)
        ProfileData data = new ProfileData(username, email,
                birth, cityValue,
                phone, last_don,
                pass, pass_con, bloodValue);

        RetrofitClient.getINSTANCE().registerNewUserClient(data)
                .enqueue(new Callback<RegisterData>() {
                    @Override
                    public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                        if (response.isSuccessful()) {
                            SharedPreferences.Editor prefs = getContext()
                                    .getSharedPreferences(Constant.KEY_SHARED_PREF, Context.MODE_PRIVATE).edit();

                            prefs.putString(Constant.PREF_USERNAME_VALUE, username);
                            prefs.putString(Constant.PREF_EMAIL_VALUE, email);
                            prefs.putString(Constant.PREF_BIRTH_VALUE, birth);
                            prefs.putString(Constant.PREF_BLOOD_TYPE_VALUE, blood_type);
                            prefs.putString(Constant.PREF_LAST_DON_VALUE, last_don);
                            prefs.putString(Constant.PREF_COUNTRY_VALUE, country);
                            prefs.putString(Constant.PREF_CITY_VALUE, city);
                            prefs.putString(Constant.PREF_PHONE_VALUE, phone);
                            prefs.putInt(Constant.PREF_COUNTRY_CONFIRM_VALUE, countryValue);
                            prefs.putInt(Constant.PREF_CITY_CONFIRM_VALUE, cityValue);
                            prefs.putInt(Constant.PREF_BLOOD_CONFIRM_VALUE, bloodValue);
                            prefs.apply();

                            Toast.makeText(getContext(), "USER IS ON BABY", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterData> call, Throwable t) {
                        signUpBtn.setError("Please check your information again");
                    }
                });
    }

    private void getBloodTypeData() {
        RetrofitClient.getINSTANCE().getAllBloodType()
                .enqueue(new Callback<Governorates>() {
                    @Override
                    public void onResponse(Call<Governorates> call, Response<Governorates> response) {
                        if (response.body() != null && response.body().getStatus() == 1) {
                            List<Datum> data = response.body().getData();
                            mListBloodType = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                mListBloodType.add(data.get(i).getName());
                            }
                            Log.d(TAG, "Blood Type call: " + mListBloodType.size());
                            bloodTypeAdapter = new ArrayAdapter<>(getContext(),
                                    android.R.layout.simple_spinner_item, mListBloodType);
                            bloodTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sBloodTypeSpinner.setAdapter(bloodTypeAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Governorates> call, Throwable t) {

                    }
                });

        sBloodTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sBloodTypeSpinner.setSelection(position);
                Log.d(TAG, "Blood Type onItemSelected: " + sBloodTypeSpinner.getSelectedItem().toString());
                getAllGovernate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                signUpBtn.setError("Check spinners");
            }
        });
    }

    private void getCitiesData(int position) {
        Log.d(TAG, "getCitiesData: " + position);
        RetrofitClient.getINSTANCE().getAllCities(position)
                .enqueue(new Callback<Cities>() {
                    @Override
                    public void onResponse(Call<Cities> call, Response<Cities> response) {
                        if (response.body() != null && response.body().getStatus() == 1) {
                            List<Datum> data = response.body().getData();
                            mListCities = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                mListCities.add(data.get(i).getName());
                            }
                            cityAdapter = new ArrayAdapter<>(getContext(),
                                    android.R.layout.simple_spinner_item, mListCities);
                            cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sCitySpinner.setAdapter(cityAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Cities> call, Throwable t) {

                    }
                });
        sCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sCitySpinner.setSelection(position);
                Log.d(TAG, "City onItemSelected: " + sCitySpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                signUpBtn.setError("Please choose one spinner and fill it right");
            }
        });
    }

    private void getAllGovernate() {
        RetrofitClient.getINSTANCE().getAllGovernors()
                .enqueue(new Callback<Governorates>() {
                    @Override
                    public void onResponse(Call<Governorates> call, Response<Governorates> response) {
                        if (response.body() != null && response.body().getStatus() == 1) {
                            List<Datum> data = response.body().getData();
                            mListGovernate = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                mListGovernate.add(data.get(i).getName());
                            }
                            Log.d(TAG, "Governate: " + mListGovernate.size());
                            governateAdapter = new ArrayAdapter<>(getContext(),
                                    android.R.layout.simple_spinner_item, mListGovernate);
                            governateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            sGoverSpinner.setAdapter(governateAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<Governorates> call, Throwable t) {

                    }
                });
        sGoverSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sGoverSpinner.setSelection(position);
                Log.d(TAG, "Governate onItemSelected: " + sGoverSpinner.getSelectedItem().toString());
                getCitiesData(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                signUpBtn.setError("Please choose one spinner and fill it right");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        receiver = new ConnectivityReceiver();
        getActivity().registerReceiver(receiver, intentFilter);

        receiver.setConnectivityReceiverListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(receiver);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (!isConnected) {
            HelperMethod.showProgressDialog(getActivity(), "Check your internet connection");
        } else{
            getBloodTypeData();
        }
    }
}