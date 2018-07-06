package vn.a3dbuilder.quyennguyen.restaurant.Detail;

import android.widget.Adapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HV on 6/6/2018.
 */

public class ItemReviewImgList extends ItemReviewTextList {


    public int getImageLink1() {
        return imageLink1;
    }

    public void setImageLink1(int imageLink1) {
        this.imageLink1 = imageLink1;
    }

    public int getImageLink2() {
        return imageLink2;
    }

    public void setImageLink2(int imageLink2) {
        this.imageLink2 = imageLink2;
    }

    public int getImageLink3() {
        return imageLink3;
    }

    public void setImageLink3(int imageLink3) {
        this.imageLink3 = imageLink3;
    }

    public ItemReviewImgList( int imageLink1, int imageLink2, int imageLink3) {

super();

        this.imageLink1 = imageLink1;
        this.imageLink2 = imageLink2;
        this.imageLink3 = imageLink3;
    }


    int imageLink1;
    int imageLink2;
    int imageLink3;


}