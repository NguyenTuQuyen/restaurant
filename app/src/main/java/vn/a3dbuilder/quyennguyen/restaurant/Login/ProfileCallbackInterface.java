package vn.a3dbuilder.quyennguyen.restaurant.Login;

import android.graphics.Bitmap;

import vn.a3dbuilder.quyennguyen.restaurant.Login.User;

public interface ProfileCallbackInterface {
    void changeImage(String path, String imageName);



    void setAvatar(Bitmap bitmap);
    void responseProfile(User prf);

}
