package echomachine.com.bloodbank_v1.utils;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import echomachine.com.bloodbank_v1.R;

public class NavigationUtils {

    public static void navigateToDestinationActivity(Context context, Class tClass) {
        Intent intent = new Intent(context, tClass);
        context.startActivity(intent);
    }

    public static void navigateToHomeFlag(Activity activity) {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(a);
    }
}
