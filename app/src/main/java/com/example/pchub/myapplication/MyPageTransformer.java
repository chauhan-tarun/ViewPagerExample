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
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth() - 10;
        int pageHeight = page.getHeight() - 10;

        // Values less than -1 means the page is out of the screen to the left
        if(position < -0.5){
            // This alpha will be set to page visible on the left side
            page.setAlpha(0.5f);

            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        }else if(position <= 1){
            // Focused page
            page.setAlpha(1);
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }else{
            // values greater than 1 means page is out of the screen to the right
            // This alpha will be set to page visible on the right side
            page.setAlpha(0.5f);


            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
//            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        }

    }
}
