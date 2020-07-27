package echomachine.com.bloodbank_v1.ui.register;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.BaseActivity;
import echomachine.com.bloodbank_v1.MyApp;
import echomachine.com.bloodbank_v1.receiver.ConnectivityReceiver;
import echomachine.com.bloodbank_v1.utils.HelperMethod;

public class RegisterActivity extends BaseActivity {

    private ConnectivityReceiver receiver;
    @Override
    public Fragment createFragment() {
        return new RegisterFragment();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!ConnectivityReceiver.isConnected(this)) {
            HelperMethod.showProgressDialog(this, "Check internet connection!");
        }
    }
}
