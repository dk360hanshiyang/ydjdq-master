package com.sudaizhijia.ydjdq.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: William Wang
 * Date:   On 2018/12/4
 */
public abstract class BaseFragment extends Fragment implements BaseView {


    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        bind = ButterKnife.bind(this, view);
        PushAgent.getInstance(getContext()).onAppStart();
        baseInit();
        return view;
    }



    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void finishSelf() {
        getActivity().finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
