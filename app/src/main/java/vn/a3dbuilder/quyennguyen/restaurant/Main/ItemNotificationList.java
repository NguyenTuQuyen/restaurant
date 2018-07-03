package vn.a3dbuilder.quyennguyen.restaurant.Main;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemNotificationList {

    String notification;
    int time;
    boolean following;
    int linkImg;

    public ItemNotificationList(String notification, int time, boolean following, int linkImg) {
        this.notification = notification;
        this.time = time;
        this.following = following;
        this.linkImg = linkImg;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getTime() {
        return time + "";
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean getFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public int getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(int linkImg) {
        this.linkImg = linkImg;
    }
}


