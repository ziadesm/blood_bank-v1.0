package echomachine.com.bloodbank_v1.receiver;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import echomachine.com.bloodbank_v1.MyApp;

public class ConnectivityReceiver extends BroadcastReceiver {
    private static final String TAG = "ZiadRec";
    public static ConnectivityReceiverListener mConnectivityReceiverListener;

    public ConnectivityReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean connected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
        Log.d(TAG, "onReceive: " + connected);
        if(mConnectivityReceiverListener != null) {
            mConnectivityReceiverListener.onNetworkConnectionChanged(connected);
        }
    }

    public void setConnectivityReceiverListener(ConnectivityReceiverListener listener) {
        mConnectivityReceiverListener = listener;
    }

    public static boolean isConnected(Activity activity) {
        ConnectivityManager manager = (ConnectivityManager)
                        activity.getApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null
                && info.isConnectedOrConnecting();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}