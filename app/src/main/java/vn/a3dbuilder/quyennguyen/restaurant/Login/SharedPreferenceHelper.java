package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.content.Context;
import android.content.SharedPreferences;

import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.StaticConfig1;
import vn.a3dbuilder.quyennguyen.restaurant.LoginSocial.User1;


public class SharedPreferenceHelper {
    private static SharedPreferenceHelper instance = null;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static String SHARE_USER_INFO = "userinfo";
    private static String SHARE_KEY_NAME = "username";
    private static String SHARE_KEY_EMAIL = "email";
    private static String SHARE_KEY_LOCATION = "location";

    private static String SHARE_KEY_UID = "uid";


    private SharedPreferenceHelper() {
    }

    public static SharedPreferenceHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferenceHelper();
            preferences = context.getSharedPreferences(SHARE_USER_INFO, Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return instance;
    }

    public void saveUserInfo(User user) {
        editor.putString(SHARE_KEY_NAME, user.name);
        editor.putString(SHARE_KEY_EMAIL, user.email);


        editor.putString(SHARE_KEY_UID, StaticConfig1.UID);
        editor.apply();
    }

    public User getUserInfo() {
        String userName = preferences.getString(SHARE_KEY_NAME, "");
        String email = preferences.getString(SHARE_KEY_EMAIL, "");
        String location = preferences.getString(SHARE_KEY_LOCATION, "");


        User user = new User();
        user.name = userName;
        user.email = email;
        user.location = location;


        return user;
    }

    public String getUID() {
        return preferences.getString(SHARE_KEY_UID, "");
    }

}
