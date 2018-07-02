package vn.a3dbuilder.quyennguyen.restaurant.Login;

/**
 * Created by HV on 6/17/2018.
 */

public class User {
    public String email, username, password;
    public User (){

    }
    public User( String email , String username, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

}

