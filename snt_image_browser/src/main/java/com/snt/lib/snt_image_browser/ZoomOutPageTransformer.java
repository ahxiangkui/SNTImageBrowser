package com.snt.lib.snt_image_browser;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 向奎 on 2017/9/20.
 * <p>
 * 描述：
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            view.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }



//    private static final float MIN_SCALE = 0.75f;
//    public void transformPage(View view, float position) {
//        int pageWidth = view.getWidth();
//        if (position < -1) { // [-Infinity,-1)
//            // This page is way off-screen to the left.
//            view.setAlpha(0);
//        } else if (position <= 0) { // [-1,0]
//            // Use the default slide transition when moving to the left page
//            view.setAlpha(1);
//            view.setTranslationX(0);
//            view.setScaleX(1);
//            view.setScaleY(1);
//        } else if (position <= 1) { // (0,1]
//            // Fade the page out.
//            view.setAlpha(1 - position);
//            // Counteract the default slide transition
//            view.setTranslationX(pageWidth * -position);
//            // Scale the page down (between MIN_SCALE and 1)
//            float scaleFactor = MIN_SCALE
//                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
//            view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
//        } else { // (1,+Infinity]
//            // This page is way off-screen to the right.
//            view.setAlpha(0);
//        }
//    }


    //旋转
//    private static final float ROT_MAX = 20.0f;
//    private float mRot;
//
//
//    public void transformPage(View view, float position)
//    {
//        if (position < -1)
//        { // [-Infinity,-1)
//            // This page is way off-screen to the left.
//            ViewHelper.setRotation(view, 0);
//        } else if (position <= 1) // a页滑动至b页 ； a页从 0.0 ~ -1 ；b页从1 ~ 0.0
//        { // [-1,1]
//            // Modify the default slide transition to shrink the page as well
//            if (position < 0)
//            {
//                mRot = (ROT_MAX * position);
//                ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
//                ViewHelper.setPivotY(view, view.getMeasuredHeight());
//                ViewHelper.setRotation(view, mRot);
//            } else
//            {
//                mRot = (ROT_MAX * position);
//                ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
//                ViewHelper.setPivotY(view, view.getMeasuredHeight());
//                ViewHelper.setRotation(view, mRot);
//            }
//            // Scale the page down (between MIN_SCALE and 1)
//            // Fade the page relative to its size.
//        } else
//        { // (1,+Infinity]
//            // This page is way off-screen to the right.
//            ViewHelper.setRotation(view, 0);
//        }
//    }
}

