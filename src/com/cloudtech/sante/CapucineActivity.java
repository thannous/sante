package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

/**
 * Created by a.talviy on 28/07/13.
 */
public class CapucineActivity extends Activity {

    private static final int STOP = 0;
    /**
     * Default duration for the splash screen (milliseconds)
     */
    private static final long SPLASHTIME = 3000;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.capucine_layout);

        //ACTION BAR
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Message msg = new Message();
        msg.what = STOP;
        step1Handler.sendMessageDelayed(msg, SPLASHTIME);
    }

    private Handler mHandler = new Handler();
    private  int progressBarStatus = 0;
    ProgressDialog progressBar;

    private int doWork(int value)
    {
        int i = 0;

        while (i < 5000000)
            i++;
      return value+1;
    }

    /**
     * Handler to close this activity and to start automatically
     * {@link MainActivity} after <code>SPLASHTIME</code> seconds.
     */
    private final transient Handler step1Handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == STOP) {
                if (!isFinishing()) {
                    View progress = findViewById(R.id.progressStep1);
                    progress.setVisibility(View.INVISIBLE);


                    // prepare for a progress bar dialog
                     progressBar = new ProgressDialog(progress.getContext());
                    progressBar.setCancelable(false);
                    progressBar.setMessage("Téléchargement des données");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    progressBar.show();


                    new Thread(new Runnable() {
                        public void run() {
                            while (progressBarStatus < 100) {
                                try {
                                    Thread.sleep(50);

                                } catch (InterruptedException e) {
                                    return;
                                }
                                // process some tasks
                                progressBarStatus++;
                                // Update the progress bar
                                mHandler.post(new Runnable() {
                                    public void run() {
                                        progressBar.setProgress(progressBarStatus);
                                    }
                                });
                            }
                                // close the progress bar dialog
                                progressBar.dismiss();
                            finish();
                        }
                    }).start();
                }
            }

            super.handleMessage(msg);
        }
    };
}