package com.app.rakez.acid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SwipeTab extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_tab);
        viewPager= (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));


    }
    public class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag = null;
            if(position==0){
                frag = new FSwipeA();
            }else if(position==1){
                frag = new FSwipeB();
            }else if(position==2){
                frag = new FSwipeC();
            }

            return frag;

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if(position==0){
                title = "Tab 1";
            }else if(position==1){
                title = "Tab 2";
            }else if(position==2){
                title="Tab 3";
            }
            return title;

        }
    }
}
