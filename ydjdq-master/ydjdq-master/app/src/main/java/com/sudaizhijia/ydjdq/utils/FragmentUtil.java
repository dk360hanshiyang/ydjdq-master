package com.sudaizhijia.ydjdq.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;


/**
 * Created by aensun on 2018/4/10.
 */

public class FragmentUtil {
    private MainActivity mainActivity;


    public FragmentUtil(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    private Fragment fragments;

    /**
     * 添加fragment 显示和隐藏
     * @param fragment
     */
    public  void dataFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            if (fragments != fragment) {
                fragmentTransaction.hide(fragments);
                fragmentTransaction.show(fragment);
                fragments = fragment;
            }
        } else {
            fragmentTransaction.add(R.id.fl, fragment);
            if (fragments != null) {
                if (fragments != fragment) {
                    fragmentTransaction.hide(fragments);
                }
            }

            fragments = fragment;
        }

        fragmentTransaction.commit();
    }






}
