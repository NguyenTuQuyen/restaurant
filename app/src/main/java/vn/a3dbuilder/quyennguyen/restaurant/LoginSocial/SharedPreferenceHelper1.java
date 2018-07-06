package vn.a3dbuilder.quyennguyen.restaurant.LoginSocial;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceHelper1 {
    private static SharedPreferenceHelper1 instance = null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static String SHARE_USER_INFO = "userinfo";
    private static String SHARE_KEY_NAME = "username";
    private static String SHARE_KEY_EMAIL = "email";

    private static String SHARE_KEY_BACKGROUND = "background";
    private static String SHARE_KEY_UID = "uid";


    private SharedPreferenceHelper1() {
    }

    public static SharedPreferenceHelper1 getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferenceHelper1();
            preferences = context.getSharedPreferences(SHARE_USER_INFO, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return instance;
    }

    public void saveUserInfo(User1 user1) {
        editor.putString(SHARE_KEY_NAME, user1.username);
        editor.putString(SHARE_KEY_EMAIL, user1.email);


        editor.putString(SHARE_KEY_UID, StaticConfig1.UID);
        editor.apply();
    }

    public User1 getUserInfo() {
        String userName = preferences.getString(SHARE_KEY_NAME, "");
        String email = preferences.getString(SHARE_KEY_EMAIL, "");

        String background = preferences.getString(SHARE_KEY_BACKGROUND, "default");

        User1 user1 = new User1();
        user1.username = userName;
        user1.email = email;


        return user1;
    }

    public String getUID() {
        return preferences.getString(SHARE_KEY_UID, "");
    }

}
