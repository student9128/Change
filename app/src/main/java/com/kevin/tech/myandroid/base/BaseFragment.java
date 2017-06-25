package com.kevin.tech.myandroid.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.kevin.tech.myandroid.utils.ToastUtils;
import com.kevin.tech.myandroid.view.LoadingDialog;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/5.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class BaseFragment extends Fragment {
    /**
     * Tag,can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();
    /**
     * can be prevent nullPointer.
     */
    protected FragmentActivity mActivity;
    private LoadingDialog mLoadingDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    /**
     * init Loading Dialog.
     */
    public void initLoadingDialog() {
        mLoadingDialog = new LoadingDialog();
    }

    /**
     * show Loading Dialog.
     */
    public void showLoadingDialog() {
        mLoadingDialog.show(getFragmentManager(), TAG);
    }

    /**
     * dismiss Loading Dialog.
     */
    public void dismissLoadingDialog() {
        if (mLoadingDialog.isAdded()) {
            mLoadingDialog.dismiss();
        }
    }

    public void showToast(String message) {
        ToastUtils.showMyToast(mActivity, message);
    }

    public void showLongToast(String message) {
        ToastUtils.showMyLongToast(mActivity, message);
    }
}
