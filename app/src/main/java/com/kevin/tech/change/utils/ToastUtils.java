package com.kevin.tech.change.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kevin.tech.change.R;


/**
 * Created by Kevin on 2017/2/17.
 * Blog:http://blog.csdn.net/student9128
 * Description: the utils for toast.
 */

public class ToastUtils {

    private static Toast mShortToast;
    private static Toast mLongToast;
    private static Toast mKevinShortToast;

    public static void showToast(Context context, String message) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(message);
        mShortToast.show();

    }

    public static void showToast(String message, Context context) {
        if (mShortToast == null) {
            mShortToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        }
        mShortToast.setText(message);
        mShortToast.show();

    }

    public static void showLongToast(Context context, String message) {
        if (mLongToast == null) {
            mLongToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        mLongToast.setText(message);
        mLongToast.show();
    }

    public static void showLongToast(String message, Context context) {
        if (mLongToast == null) {
            mLongToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        }
        mLongToast.setText(message);
        mLongToast.show();
    }

    /**
     * customize short toast.
     *
     * @param message
     * @param resId   the resource id for imageView
     * @param context
     */
    public static void showMyLongToast(String message, int resId, Context context) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        ImageView iv = (ImageView) v.findViewById(R.id.toast_image);
        tv.setText(message);
        iv.setImageResource(resId);
        mKevinShortToast.setDuration(Toast.LENGTH_SHORT);
        mKevinShortToast.show();
    }

    /**
     * customize short toast.
     *
     * @param context
     * @param message
     * @param resId   the resource id for imageView
     */
    public static void showMyLongToast(Context context, String message, int resId) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        ImageView iv = (ImageView) v.findViewById(R.id.toast_image);
        tv.setText(message);
        iv.setImageResource(resId);
        mKevinShortToast.setDuration(Toast.LENGTH_SHORT);
        mKevinShortToast.show();
    }

    /**
     * customize short toast.
     *
     * @param context
     * @param message
     */
    public static void showMyToast(Context context, String message) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast_no_image, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        tv.setText(message);
        mKevinShortToast.setDuration(Toast.LENGTH_SHORT);
        mKevinShortToast.show();
    }

    /**
     * customize short toast.
     *
     * @param context
     * @param message
     */
    public static void showMyToast(String message, Context context) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast_no_image, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        tv.setText(message);
        mKevinShortToast.setDuration(Toast.LENGTH_SHORT);
        mKevinShortToast.show();
    }

    /**
     * customize short toast.
     *
     * @param context
     * @param message
     */
    public static void showMyLongToast(Context context, String message) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast_no_image, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        tv.setText(message);
        mKevinShortToast.setDuration(Toast.LENGTH_LONG);
        mKevinShortToast.show();
    }

    /**
     * customize short toast.
     *
     * @param context
     * @param message
     */
    public static void showMyLongToast(String message, Context context) {
        if (mKevinShortToast == null) {
            mKevinShortToast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.layout_tip_toast_no_image, null);
        mKevinShortToast.setView(v);
        TextView tv = (TextView) v.findViewById(R.id.toast_text);
        tv.setText(message);
        mKevinShortToast.setDuration(Toast.LENGTH_LONG);
        mKevinShortToast.show();
    }
}
