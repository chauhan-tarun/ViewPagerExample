package com.example.pchub.myapplication;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import java.io.PipedOutputStream;

/**
 * Created by pchub on 26-06-2017.
 */

public class MyPageTransformer implements ViewPager.PageTransformer {
    private String TAG = getClass().getSimpleName();


    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth() - 10;
        int pageHeight = page.getHeight() - 10;

        // Values less than -1 means the page is out of the screen to the left  and values greater than 1 means page is out of the screen to the right
        if(position < -1){
            page.setAlpha(0);
        }

    }
}
