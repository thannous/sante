package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class InfoActivity extends Activity{

    private GestureDetector gestureDetector;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab  treatmentTab = actionBar.newTab().setText(R.string.treatments);
        ActionBar.Tab  antecedentTab = actionBar.newTab().setText(R.string.antecedents);
        ActionBar.Tab  allergiesTab = actionBar.newTab().setText(R.string.allergies);
        ActionBar.Tab  vaccinesTab = actionBar.newTab().setText(R.string.vaccines);

        Fragment TreatmentFragment = new TreatmentFragment();
        Fragment AntecedentFragment = new AntecedentFragment();
        Fragment AllergyFragment = new AllergyFragment();
        Fragment VaccinFragment = new VaccinFragment();

        treatmentTab.setTabListener(new SanteTabListener(TreatmentFragment));
        antecedentTab.setTabListener(new SanteTabListener(AntecedentFragment));
        allergiesTab.setTabListener(new SanteTabListener(AllergyFragment));
        vaccinesTab.setTabListener(new SanteTabListener(VaccinFragment));

        actionBar.addTab(treatmentTab);
        actionBar.addTab(antecedentTab);
        actionBar.addTab(allergiesTab);
        actionBar.addTab(vaccinesTab);

        gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.OnGestureListener() {
            private static final int SWIPE_MIN_DISTANCE = 120;
            private static final int SWIPE_THRESHOLD_VELOCITY = 100;

            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    // Right to left, your code here
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) >  SWIPE_THRESHOLD_VELOCITY) {
                    // Left to right, your code here
                    return true;
                }
                if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    // Bottom to top, your code here
                    return true;
                } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    // Top to bottom, your code here
                    return true;
                }
                return false;
            }
        });


    }

    public class SanteTabListener implements ActionBar.TabListener{
        public Fragment fragment;

        public SanteTabListener(Fragment fragment){
            this.fragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
        {


        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            ft.remove(fragment);
        }
    }

    public class TreatmentFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.treatment_fragment, container, false);
        }
    }

    public class AntecedentFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.antecedent_fragment, container, false);
        }
    }

    public class AllergyFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.allergy_fragment, container, false);
        }
    }

    public class VaccinFragment extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.vaccine_fragment, container, false);
        }
    }

}