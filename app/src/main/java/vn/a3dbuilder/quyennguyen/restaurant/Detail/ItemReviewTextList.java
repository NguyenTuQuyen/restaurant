package vn.a3dbuilder.quyennguyen.restaurant.Detail;

public class ItemReviewTextList {


    public ItemReviewTextList() {
    }

    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public  int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public  int getLinkAvatar() {
        return linkAvatar;
    }

    public void setLinkAvatar(int linkAvatar) {
        this.linkAvatar = linkAvatar;
    }

    public  String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ItemReviewTextList(String username, int time, int mark, int linkAvatar, String review) {

        this.username = username;
        this.time = time;
        this.mark = mark;
        this.linkAvatar = linkAvatar;
        this.review = review;
    }

     String username;
     int time;
     int mark;
     int linkAvatar;
     String review;
}
