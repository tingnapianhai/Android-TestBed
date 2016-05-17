package com.tingapianhai.android.testbed.myswiperefreshlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tingapianhai.android.testbed.R;

public class MySwipeRefreshLayoutFragment extends Fragment{

    final String TAG = MySwipeRefreshLayoutFragment.class.getSimpleName();
    private SwipeRefreshLayout refreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_swiperefreshlayout_view, container, false);
        getActivity().setTitle("swipe refresh layout title");
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.my_swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(onRefreshListener);
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //TODO doing stuff when swipe-refresh
            Log.v(TAG,"SwipeRefresh start");
            try {
                Thread.sleep(2000);//Simulate the refresh-action
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ///after swipe-refresh, setRefreshing to false
            refreshLayout.setRefreshing(false);
            Log.v(TAG,"SwipeRefresh end");
        }
    };

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * TODO
     */
    public interface onMySwipeRefreshActionListener {
        void onMySwipeRefreshAction();
    }

}
