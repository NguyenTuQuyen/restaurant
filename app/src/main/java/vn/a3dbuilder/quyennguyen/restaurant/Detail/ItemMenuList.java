package vn.a3dbuilder.quyennguyen.restaurant.Detail;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemMenuList {

    String listName;
    String description;
    int price;

    int linkImg;

    public ItemMenuList(String listName, String description, int price, int linkImg ) {
        this.listName = listName;
        this.description = description;
        this.price = price;

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



    public int getLinkImg() {
        return linkImg;
    }
}


