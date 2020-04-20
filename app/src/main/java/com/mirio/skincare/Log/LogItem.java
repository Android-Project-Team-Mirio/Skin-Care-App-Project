package com.mirio.skincare.Log;

import android.widget.Button;
import android.widget.ScrollView;

public class LogItem {
    private String mText;
    private Button btn;
    private ScrollView scrollView;
    private int imageScr;

    public LogItem(int imageScr, String mText){

       this.imageScr = imageScr;
        this.mText = mText;
    }


    public int getImageScr(){
        return imageScr;
    }

    public String getmText(){
        return mText;
    }


}
