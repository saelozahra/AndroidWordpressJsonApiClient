package ir.technopedia.wordpressjsonclient.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ir.technopedia.wordpressjsonclient.R;

/**
 * Created by user1 on 10/7/2016.
 */

public class Util {
    public static void shareData(Context context, String title, String Body) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, title);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, Body);
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_with)));
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void saveData(Context context, String key, String text) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                "technopedia", context.MODE_PRIVATE).edit();
        editor.putString(key, text);
        editor.commit();
    }

    public static String loadData(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(
                "technopedia", context.MODE_PRIVATE);
        String text = prefs.getString(key, "");
        return text;
    }
}
