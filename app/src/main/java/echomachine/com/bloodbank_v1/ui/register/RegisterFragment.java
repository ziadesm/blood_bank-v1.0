package echomachine.com.bloodbank_v1.ui.register;
import android.os.Bundle;

import androidx.constraintlayout.solver.widgets.Helper;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.utils.HelperMethods;

public class RegisterFragment extends Fragment {
    private EditText ed0, ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9;
    private Button signUpBtn;

    public RegisterFragment() {
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
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ed0 = view.findViewById(R.id.reg_fragment_ll_et_0);
        ed1 = view.findViewById(R.id.reg_fragment_ll_et_1);
        ed2 = view.findViewById(R.id.reg_fragment_ll_et_2);
        ed3 = view.findViewById(R.id.reg_fragment_ll_et_3);
        ed4 = view.findViewById(R.id.reg_fragment_ll_et_4);
        ed5 = view.findViewById(R.id.reg_fragment_ll_et_5);
        ed6 = view.findViewById(R.id.reg_fragment_ll_et_6);
        ed7 = view.findViewById(R.id.reg_fragment_ll_et_7);
        ed8 = view.findViewById(R.id.reg_fragment_ll_et_8);
        ed9 = view.findViewById(R.id.reg_fragment_ll_et_9);

        signUpBtn = view.findViewById(R.id.reg_fragment_ll_btn);

        signUpBtn.setOnClickListener(v -> { checkValidation(); });

        return view;
    }

    private void checkValidation() {
        String name0 = ed0.getText().toString();
        String name1 = ed1.getText().toString();
        String name2 = ed2.getText().toString();
        String name3 = ed3.getText().toString();
        String name4 = ed4.getText().toString();
        String name5 = ed5.getText().toString();
        String name6 = ed6.getText().toString();
        String name7 = ed7.getText().toString();
        String name8 = ed8.getText().toString();
        String name9 = ed9.getText().toString();

        String[] allName = {name0, name1, name2, name3, name4, name5, name6, name7, name8, name9};
        EditText[] allEdit = {ed0, ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9};

        for (int i = 0; i < allName.length - 1; i++) {
            if (TextUtils.isEmpty(allName[i])) {
                allEdit[i].setError("Please fill the field");
                return;
            }
        }

        // TODO(1) You need to make a call to end the Register Validation (Intent)
    }
}