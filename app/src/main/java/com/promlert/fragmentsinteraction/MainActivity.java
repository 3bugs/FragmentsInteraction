package com.promlert.fragmentsinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements FirstFragment.OnFragmentInteractionListener {

    private static final String TAG_FRAGMENT_1 = "fragment_1";
    private static final String TAG_FRAGMENT_2 = "fragment_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_1, new FirstFragment(), TAG_FRAGMENT_1)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_2, new SecondFragment(), TAG_FRAGMENT_2)
                .commit();
    }

    @Override
    public void onClickButton(String message) {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_2);
        if (fragment != null) {
            fragment.setMessage(message);
        }
    }
}
