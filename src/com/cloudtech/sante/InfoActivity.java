package com.cloudtech.sante;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class InfoActivity extends Activity{

    private GestureDetector gestureDetector;
    private Fragment currentTab;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //TABS
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

//        gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.OnGestureListener() {
//            private static final int SWIPE_MIN_DISTANCE = 120;
//            private static final int SWIPE_THRESHOLD_VELOCITY = 100;
//
//            @Override
//            public boolean onDown(MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public void onShowPress(MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public boolean onSingleTapUp(MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
//                return false;
//            }
//
//            @Override
//            public void onLongPress(MotionEvent motionEvent) {
//
//            }
//
//            @Override
//            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                    // Right to left, your code here
//                    return true;
//                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) >  SWIPE_THRESHOLD_VELOCITY) {
//                    // Left to right, your code here
//                    return true;
//                }
//                if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
//                    // Bottom to top, your code here
//                    return true;
//                } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
//                    // Top to bottom, your code here
//                    return true;
//                }
//                return false;
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        final Dialog dialog = new Dialog(this);

        switch (item.getItemId()) {
            case R.id.action_add:
                dialog.setTitle(((InfoFragment)currentTab).getFragmentCreateTitle());
                dialog.setContentView(R.layout.add_info_dialog);
                dialog.setCancelable(true);
                Button btnSave =(Button)dialog.findViewById(R.id.btn_save);
                Button btnCancel =(Button)dialog.findViewById(R.id.btn_cancel);
                btnSave.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v)
                    {
                        dialog.cancel();
                    }
                });

                btnCancel.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v)
                    {
                        dialog.cancel();
                    }
                });
                break;
            default:
                break;
        }

        dialog.show();

        return super.onMenuItemSelected(featureId, item);
    }

    @SuppressLint("ValidFragment")
	public class SanteTabListener implements ActionBar.TabListener{
        public Fragment fragment;

        public SanteTabListener(Fragment fragment){
            currentTab = fragment;
            this.fragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft)
        {


        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            currentTab = fragment;
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft)
        {
            ft.remove(fragment);
        }
    }


    @SuppressLint("ValidFragment")
	public class InfoFragment extends Fragment
    {
        public String getFragmentName(){
            return "pouet";
        }

        public String getFragmentCreateTitle(){
            return "pouet";
        }

    }


    @SuppressLint("ValidFragment")
	public class TreatmentFragment extends InfoFragment
    {
        @Override
        public String getFragmentName(){
            return getResources().getString(R.string.treatment);
        }

        @Override
        public String getFragmentCreateTitle(){
            return getResources().getString(R.string.add_treatment);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.treatment_fragment, container, false);
        }
    }

    @SuppressLint("ValidFragment")
	public class AntecedentFragment extends TreatmentFragment
    {
        @Override
        public String getFragmentName(){
            return getResources().getString(R.string.antecedent);
        }

        @Override
        public String getFragmentCreateTitle(){
            return getResources().getString(R.string.add_antecedent);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.antecedent_fragment, container, false);
        }
    }

    @SuppressLint("ValidFragment")
	public class AllergyFragment extends TreatmentFragment{
        @Override
        public String getFragmentName(){
            return getResources().getString(R.string.allergy);
        }

        @Override
        public String getFragmentCreateTitle(){
            return getResources().getString(R.string.add_allergy);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.allergy_fragment, container, false);
        }
    }

    @SuppressLint("ValidFragment")
	public class VaccinFragment extends TreatmentFragment
    {
        @Override
        public String getFragmentName(){
            return getResources().getString(R.string.vaccine);
        }

        @Override
        public String getFragmentCreateTitle(){
            return getResources().getString(R.string.add_vaccine);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.vaccine_fragment, container, false);
        }
    }

}