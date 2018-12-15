package com.nghiadev.mvppractice.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.nghiadev.mvppractice.R;
import com.nghiadev.mvppractice.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.btn_test)
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        mPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }


    @OnClick(R.id.btn_test)
    public void onViewClicked() {
        mPresenter.onButtonClicked();
    }

    @Override
    public void showSuccessToast() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}
