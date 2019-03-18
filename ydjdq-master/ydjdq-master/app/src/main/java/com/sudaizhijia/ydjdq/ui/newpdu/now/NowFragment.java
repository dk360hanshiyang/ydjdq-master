package com.sudaizhijia.ydjdq.ui.newpdu.now;


import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.NewNowAdapter2;
import com.sudaizhijia.ydjdq.adapter.NewNowAdapter;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.bean.NowExpandItem;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class NowFragment extends MVPBaseFragment<NowContract.View, NowPresenter> implements NowContract.View {

    @BindView(R.id.recycler_now)
    RecyclerView recyclerNow;
    private NewProductBean mHomeBean;
    private NewNowAdapter2 newNowAdapter2;
    private NewNowAdapter newNowAdapter;
    private List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList;
    private long time_Current;
    private int i=0;
//    private Handler handler_timeCurrent = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            time_Current = time_Current + 1000;
//            i++;
//            if(i>10){
//                i=10;
//            }
//            newNowAdapter.notifyDataSetChanged();
//            newNowAdapter.setI(time_Current);
//            handler_timeCurrent.sendEmptyMessageDelayed(0, 1000);
//
//        }
//    };
    @Override
    protected void init() {
        mHomeBean = (NewProductBean) getArguments().getSerializable("homebean");
        initRecycler();
    }

    private void initRecycler() {
        ArrayList<MultiItemEntity> list = generateData();
        newNowAdapter2 = new NewNowAdapter2(list);
        newNowAdapter = new NewNowAdapter(list,getActivity(),todayNewList);


        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return newNowAdapter2.getItemViewType(position) == CusConstants.TYPE_NEWPRODUCT ? 1 : manager.getSpanCount();
            }

        });
        recyclerNow.addItemDecoration(new SpaceItemDecoration(0, 0, 1, 1));
        recyclerNow.setAdapter(newNowAdapter);
        recyclerNow.setLayoutManager(manager);
        newNowAdapter.setOnFoucus(mHomeBean.getObject().getTodayNewList());
//        if(i==0) {
//            handler_timeCurrent.sendEmptyMessageDelayed(0, 1000);
//        }

        int size = mHomeBean.getObject().getTodayNewList().size();


    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("今日上新"); //统计页面("MainScreen"为页面名称，可自定义)
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("今日上新");
    }

    private int position;

    private ArrayList<MultiItemEntity> generateData() {
        todayNewList = mHomeBean.getObject().getTodayNewList();
        ArrayList<MultiItemEntity> res = new ArrayList<>();
        NowExpandItem lv0 = null;
        for (int i = 0; i < todayNewList.size(); i++) {
            boolean onFocus = todayNewList.get(i).isOnFocus();
            if (onFocus) {
                position = i;
            }
            if (todayNewList.get(i).getCountDown() <= 0) {
                lv0 = new NowExpandItem(todayNewList.get(i).getTitle(), todayNewList.get(i).getProductShowList().size() + "", i, false, 0);
            } else {
                lv0 = new NowExpandItem(todayNewList.get(i).getTitle(), "0", i, true, todayNewList.get(i).getCountDown());
            }
            for (int i1 = 0; i1 < todayNewList.get(i).getProductShowList().size(); i1++) {
                NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX productShowListBeanX = todayNewList.get(i).getProductShowList().get(i1);
                lv0.addSubItem(productShowListBeanX);
            }
            res.add(lv0);
        }
        return res;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_now;
    }


}
