package echomachine.com.bloodbank_v1.ui.login;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.ui.forget_password.ResetPasswordActivity;
import echomachine.com.bloodbank_v1.utils.HelperMethods;
import echomachine.com.bloodbank_v1.utils.NavigationUtils;

public class LoginFragment extends Fragment {
    private EditText ed0, ed1;
    private TextView tv0;
    private Button signinBtn;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperMethods.hideAllBars(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        signinBtn = view.findViewById(R.id.login_fragment_ll_btn);
        tv0 = view.findViewById(R.id.login_fragment_ll_tv);
        ed0 = view.findViewById(R.id.login_fragment_ll_et_0);
        ed1 = view.findViewById(R.id.login_fragment_ll_et_1);

        signinBtn.setOnClickListener(v -> { checkValidation(); });

        tv0.setOnClickListener(v -> NavigationUtils
                .navigateToDestinationActivity(getActivity(), ResetPasswordActivity.class));
        return view;
    }

    private void checkValidation() {
        String name0 = ed0.getText().toString();
        String name1 = ed1.getText().toString();

        if (TextUtils.isEmpty(name0)) {
            ed0.setError("Please fill right email");
            return;
        }
        if (TextUtils.isEmpty(name1)) {
            ed1.setError("Please fill right password");
            return;
        }

        // TODO(2) After check E-mail & Password go to Home Screen With All profile data
    }
}