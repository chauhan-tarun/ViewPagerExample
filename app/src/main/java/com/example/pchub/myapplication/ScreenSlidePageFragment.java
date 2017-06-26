package com.example.pchub.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Fragment for View Pager
 */

public class ScreenSlidePageFragment extends Fragment {

    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_fragTitle = (TextView) view.findViewById(R.id.tv_fragTitle);

        tv_fragTitle.setBackgroundColor(Color.parseColor(getRandomColor()));

        Bundle b = getArguments();
        if (b != null) {
            tv_fragTitle.setText(b.getString("text"));
        }
    }

    /**
     * Gets the random color.
     *
     * @return the random color
     */
    public static String getRandomColor() {
        String[] letters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        StringBuilder color = new StringBuilder("#");
        for (int i = 0; i < 6; i++) {
            color.append(letters[(int) Math.round(Math.random() * 15)]);
        }
        return color.toString();
    }

    public void scaleImage(float scaleX) {
        rootView.setScaleY(scaleX);
        rootView.invalidate();
    }

    public void removeSpacing() {
        rootView.setPadding(0,0,0,0);
        rootView.invalidate();
    }
}
