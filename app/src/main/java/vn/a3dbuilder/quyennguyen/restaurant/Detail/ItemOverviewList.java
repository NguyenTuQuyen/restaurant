package vn.a3dbuilder.quyennguyen.restaurant.Detail;

/**
 * Created by HV on 5/30/2018.
 */

public class ItemOverviewList {


    int mark;

    int linkImg;

    public ItemOverviewList(int mark, int linkImg) {
        this.mark = mark;
        this.linkImg = linkImg;
    }


    public String getMark() {
        return mark + "";
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    public int getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(int linkImg) {
        this.linkImg = linkImg;
    }
}


