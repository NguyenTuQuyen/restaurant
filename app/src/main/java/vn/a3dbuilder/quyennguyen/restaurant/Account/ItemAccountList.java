package vn.a3dbuilder.quyennguyen.restaurant.Account;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemAccountList {

    String listName;
    int distance;
    int linkImg;
    int mark;

    public ItemAccountList(String listName,  int distance, int linkImg , int mark) {
        this.listName = listName;
        this.distance = distance;
        this.linkImg = linkImg;
        this.mark = mark;
    }



    public String getListName() {
        return listName;
    }


    public String getDistance() {
        return distance + "";
    }

    public int getLinkImg() {
        return linkImg;
    }
    public String getMark() {
        return mark + "";
    }
}


