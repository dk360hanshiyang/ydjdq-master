package com.sudaizhijia.ydjdq.ui.newpdu.after;


import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.AfterProductAdapter;
import com.sudaizhijia.ydjdq.bean.AfterExpandItem;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.newpdu.now.SpaceItemDecoration;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class AfterFragment extends MVPBaseFragment<AfterContract.View, AfterPresenter> implements AfterContract.View {

    @BindView(R.id.after_recycler)
    RecyclerView afterRecycler;
    private NewProductBean mHomeBean;
    private long time_Current;
    private int i=0;
    //by 王学岗
    private Handler handler_timeCurrent = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time_Current = time_Current + 1000;
            i++;
            if(i>10){
                i=10;
            }
            afterProductAdapter.notifyDataSetChanged();
            afterProductAdapter.setI(time_Current);
            handler_timeCurrent.sendEmptyMessageDelayed(0, 1000);

        }
    };
    private AfterProductAdapter afterProductAdapter;

    @Override
    protected void init() {
        mHomeBean = (NewProductBean) getArguments().getSerializable("homebean");
        initRecycler();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_after;
    }

    private void initRecycler() {
        ArrayList<MultiItemEntity> list = generateData();
        afterProductAdapter = new AfterProductAdapter(list);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return afterProductAdapter.getItemViewType(position) == CusConstants.TYPE_AFTER ? 1 : manager.getSpanCount();
            }

        });
        afterRecycler.addItemDecoration(new SpaceItemDecoration(0, 0, 1, 1));
        afterRecycler.setAdapter(afterProductAdapter);
        afterRecycler.setLayoutManager(manager);
        afterProductAdapter.expandAll();
        if(i==0) {
            handler_timeCurrent.sendEmptyMessageDelayed(0, 1000);
        }
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("明日预告"); //统计页面("MainScreen"为页面名称，可自定义)
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("明日预告");
    }


    private int position;

    private ArrayList<MultiItemEntity> generateData() {
        List<NewProductBean.ObjectBean.TomorrowListBean> tomorrowList = mHomeBean.getObject().getTomorrowList();
        ArrayList<MultiItemEntity> res = new ArrayList<>();
       AfterExpandItem lv0 = null;
        for (int i = 0; i < tomorrowList.size(); i++) {
//            boolean onFocus = tomorrowList.get(i).isOnFocus();
//            if (onFocus) {
//                position = i;
//            }
            if (tomorrowList.get(i).getCountDown() <= 0) {
                lv0 = new AfterExpandItem(tomorrowList.get(i).getTitle(), tomorrowList.get(i).getProductShowList().size() + "", i, false, 0);
            } else {
                lv0 = new AfterExpandItem(tomorrowList.get(i).getTitle(), "0", i, true, tomorrowList.get(i).getCountDown());
            }
            for (int i1 = 0; i1 < tomorrowList.get(i).getProductShowList().size(); i1++) {
                NewProductBean.ObjectBean.TomorrowListBean.ProductShowListBean productShowListBean = tomorrowList.get(i).getProductShowList().get(i1);
                lv0.addSubItem(productShowListBean);
            }
            res.add(lv0);
        }
        return res;
    }
}
