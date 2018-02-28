package com.postapp.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.postapp.rxjava.Contant.LOAD_FAILED;
import static com.postapp.rxjava.Contant.showContent;
import static com.postapp.rxjava.Contant.showReload;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.progressLayout)
    MyProgressLayout progressLayout;
    @Bind(R.id.loding)
    TextView loding;
    @Bind(R.id.loding_ret)
    TextView lodingRet;
    @Bind(R.id.loding_erro_ret)
    TextView lodingErroRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.loding, R.id.loding_ret, R.id.loding_erro_ret})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.loding:
                showReload(progressLayout);
                progressLayout.showLoading();
                break;
            case R.id.loding_ret:
                showContent(progressLayout);
                break;
            case R.id.loding_erro_ret:
                showReload(progressLayout);
                showError(false, LOAD_FAILED, "重试", "一条数据都没有");
                break;
        }

    }

    public void showError(boolean isHasBack, final int type, String butError, String tvError) {

        progressLayout.showErrorView(isHasBack, type, butError, tvError, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_try:
                        showReload(progressLayout);
                        progressLayout.showLoading();
                        break;
                }

            }
        });
    }
}
