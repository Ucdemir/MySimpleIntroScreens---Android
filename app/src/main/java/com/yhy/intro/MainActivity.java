package com.yhy.intro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.widget.ViewPager2;


import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import com.yhy.intro.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;


    private ArrayList<IntroPageFragment> list = new ArrayList<IntroPageFragment>();

    private ImageView btnNext;
    private Button btnDone;
    private Button btnSkip;

    private String nextActivity= "";


    public MainActivity(){

    }

    public MainActivity(String nextActivity){
        this.nextActivity = nextActivity;
    }



    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewPager);
        btnNext = findViewById(R.id.btnNext);
        btnDone = findViewById(R.id.btnDone);
        btnSkip = findViewById(R.id.btnSkip);


        WormDotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);


        pagerAdapter = new IntroPageAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        dotsIndicator.setViewPager2(viewPager);


        addIntroPage(new IntroPageFragment(R.drawable.intro2));
        addIntroPage(new IntroPageFragment(R.drawable.intro2));


        pagerAdapter.notifyDataSetChanged();


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                if(position == list.size()-1){


                    btnDone.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);

                }else{
                    btnDone.setVisibility(View.GONE);
                    btnNext.setVisibility(View.VISIBLE);
                }
            }
        });



        btnNext.setOnClickListener(v->{
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        });

        btnDone.setOnClickListener(v->{
            finishIntroStartActivty();
        });

        btnSkip.setOnClickListener(v->{
            finishIntroStartActivty();

        });

        //setSupportActionBar(binding.toolbar);


        //appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }


    private void finishIntroStartActivty(){

        try{
            Intent intent = new Intent(MainActivity.this,Class.forName(nextActivity));

        }catch (Exception e){

        }
    }




    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/


    public void addIntroPage(IntroPageFragment introPageFragment){
        list.add(introPageFragment);
    }


    private class IntroPageAdapter extends FragmentStateAdapter {

        @Override
        public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);


        }

        public IntroPageAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return list.get(position);
        }


        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}