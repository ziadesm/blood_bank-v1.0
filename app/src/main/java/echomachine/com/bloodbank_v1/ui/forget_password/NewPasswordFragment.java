package echomachine.com.bloodbank_v1.ui.forget_password;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.utils.HelperMethod;

public class NewPasswordFragment extends Fragment {

    public NewPasswordFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NewPasswordFragment newInstance(String param1, String param2) {
        NewPasswordFragment fragment = new NewPasswordFragment();
        return fragment;
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
        return inflater.inflate(R.layout.fragment_new_password, container, false);
    }
}