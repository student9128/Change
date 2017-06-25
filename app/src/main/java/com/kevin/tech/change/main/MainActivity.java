package com.kevin.tech.change.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.kevin.tech.change.ActivityUtils;
import com.kevin.tech.change.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.fl_content);
        }
//        MainPresenter mainPresenter = new MainPresenter();
//        mainFragment.setPresenter(mainPresenter);
    }
}
