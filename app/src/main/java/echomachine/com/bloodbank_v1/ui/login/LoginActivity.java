package echomachine.com.bloodbank_v1.ui.login;
import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.BaseActivity;

public class LoginActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return new LoginFragment();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
