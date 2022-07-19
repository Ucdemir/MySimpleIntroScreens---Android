package com.yhy.intro;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yhy.intro.databinding.ActivityMainBinding;

public class IntroPageFragment extends Fragment {

     //rivate FragmentPageIntro binding;

     private int backgroundImageResource;


     public IntroPageFragment() {


     }

     public IntroPageFragment(int backgroundImageResource ) {

          this.backgroundImageResource = backgroundImageResource;
     }

     @Nullable
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

          View rootView = inflater.inflate(R.layout.fragment_page_intro, container, false);

          ImageView backgroundImage = rootView.findViewById(R.id.backgroundImage);

          backgroundImage.setImageResource(backgroundImageResource);


          //binding = FragmentPageIntro.inflate(getLayoutInflater());
          //return super.onCreateView(inflater, container, savedInstanceState);


          return rootView;
     }


}
