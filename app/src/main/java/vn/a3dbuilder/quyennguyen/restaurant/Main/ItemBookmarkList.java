package vn.a3dbuilder.quyennguyen.restaurant.Main;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemBookmarkList {

    String listName;
    String description;
    int price;
    int distance;
    int linkImg;

    public ItemBookmarkList(String listName, String description, int price, int distance, int linkImg ) {
        this.listName = listName;
        this.description = description;
        this.price = price;
        this.distance = distance;
        this.linkImg = linkImg;
    }



    public String getListName() {
        return listName;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public String getDistance() {
        return distance + "";
    }

    public int getLinkImg() {
        return linkImg;
    }
}


