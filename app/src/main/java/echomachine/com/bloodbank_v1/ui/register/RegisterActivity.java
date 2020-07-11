package echomachine.com.bloodbank_v1.ui.register;

import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.BaseActivity;

class RegisterActivity extends BaseActivity {
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
}
