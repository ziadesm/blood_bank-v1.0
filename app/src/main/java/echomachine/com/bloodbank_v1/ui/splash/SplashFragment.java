package echomachine.com.bloodbank_v1.ui.splash;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.ui.demo.DemoActivity;
import echomachine.com.bloodbank_v1.utils.HelperMethod;

public class SplashFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperMethod.hideAllBars(getActivity());
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getActivity(), DemoActivity.class);
            startActivity(intent);
        }, 2000);
    }
}