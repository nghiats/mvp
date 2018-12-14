package com.nghiadev.mvppractice.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.nghiadev.mvppractice.R;
import com.nghiadev.mvppractice.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @BindView(R.id.btn_test)
    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void setUp() {

    }


    @OnClick(R.id.btn_test)
    public void onViewClicked() {

    }

    @Override
    public void showSuccessToast() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}
