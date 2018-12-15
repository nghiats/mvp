package com.nghiadev.mvppractice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nghiadev.mvppractice.ui.BaseActivity;
import com.nghiadev.mvppractice.ui.MvpView;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    public void setUnBinder(Unbinder mUnBinder) {
        this.mUnBinder = mUnBinder;
    }

    @Override
    public void onDestroy() {
        if (mUnBinder !=null) mUnBinder.unbind();
        super.onDestroy();
    }

    protected abstract void setUp(View view);

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
