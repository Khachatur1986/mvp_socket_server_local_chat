package example.am.mvp_socket_server_local_chat.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public final class SharedPreferencesUtil {

    public static void saveData(Context context, final String MY_PREFS_NAME, Pair<String, String> pair) {
        if (pair != null) {
            SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString(pair.first, pair.second);
            editor.apply();
        }
    }

    /**
     * apply() is asynchronous call to perform disk I/O where as commit() is synchronous.
     * So avoid calling commit() from the UI thread
     *
     * @param context
     * @param MY_PREFS_NAME
     */
    public static void saveDatas(Context context, final String MY_PREFS_NAME, List<Pair<String, String>> pairs) {
        if (pairs.size() > 0) {
            SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

            for (Pair<String, String> pair : pairs) {
                editor.putString(pair.first, pair.second);
            }
            editor.apply();
        }
    }

    public static Pair<String, String> retrieveData(Context context, final String MY_PREFS_NAME, String key) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        String restoredText = prefs.getString(key, null);
        Pair<String, String> pair = new Pair<>(key, restoredText);
        return pair;
    }

    public static List<Pair<String, String>> retriveDatas(Context context, final String MY_PREFS_NAME, String[] keys) {
        List<Pair<String, String>> pairs = new ArrayList<>();
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        for (String key : keys) {
            String restoredText = prefs.getString(key, null);
            Pair<String, String> pair = new Pair<>(key, restoredText);
            pairs.add(pair);
        }
        return pairs;
    }

    public static List<Pair<String, String>> retriveAll(Context context, final String MY_PREFS_NAME) {
        List<Pair<String, String>> pairs = new ArrayList<>();
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Map<String, ?> all = prefs.getAll();
        for (String key : all.keySet()) {
            String restoredText = all.get(key).toString();
            Pair<String, String> pair = new Pair<>(key, restoredText);
            pairs.add(pair);
        }
        return pairs;
    }

    public static void clearAll(Context context, final String MY_PREFS_NAME) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    public static void removeDatas(Context context, final String MY_PREFS_NAME, String[] key) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        for (int i = 0; i < key.length; i++) {
            editor.remove(key[i]);
        }
        editor.apply();
    }

    //-------------------------------
    public static void setStringPreference(Context context, final String MY_PREFS_NAME, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringPreference(Context context, final String MY_PREFS_NAME, String key, String defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(key, defaultValue);
    }

    public static void setBooleanPreference(Context context, final String MY_PREFS_NAME, String key, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBooleanPreference(Context context, final String MY_PREFS_NAME, String key, boolean defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getBoolean(key, defaultValue);
    }

    public static void setFloatPreference(Context context, final String MY_PREFS_NAME, String key, float value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public static float getFloatPreference(Context context, final String MY_PREFS_NAME, String key, float defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getFloat(key, defaultValue);
    }

    public static void setIntegerPreference(Context context, final String MY_PREFS_NAME, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getIntegerPreference(Context context, final String MY_PREFS_NAME, String key, int defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getInt(key, defaultValue);
    }

    public static void setLongPreference(Context context, final String MY_PREFS_NAME, String key, long value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLongPreference(Context context, final String MY_PREFS_NAME, String key, long defaultValue) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getLong(key, defaultValue);
    }

}
