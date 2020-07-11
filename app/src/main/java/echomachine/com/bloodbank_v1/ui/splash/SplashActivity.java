package echomachine.com.bloodbank_v1.ui.splash;
import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.BaseActivity;
import echomachine.com.bloodbank_v1.utils.NavigationUtils;

public class SplashActivity extends BaseActivity {
    @Override
    public Fragment createFragment() {
        return new SplashFragment();
    }

    @Override
    public void onBackPressed() {
        NavigationUtils.navigateToHomeFlag(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
