package echomachine.com.bloodbank_v1.ui.forget_password;

import androidx.fragment.app.Fragment;

import echomachine.com.bloodbank_v1.BaseActivity;

class NewPasswordActivity extends BaseActivity {

    @Override
    public Fragment createFragment() {
        return new NewPasswordFragment();
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
