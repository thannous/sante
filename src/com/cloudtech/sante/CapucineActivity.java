package com.cloudtech.sante;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

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
        progress2 = (ProgressBar) findViewById(R.id.progressStep1);
    }

    private ProgressBar progress2;
    private Handler mHandler = new Handler();
    private int mProgressStatus = 0;

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


                    View layout = findViewById(R.id.step2);
                    View progress = findViewById(R.id.progressStep1);

                    layout.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);

                    // Start lengthy operation in a background thread
                    new Thread(new Runnable() {
                        public void run() {

                            while (mProgressStatus < 200) {
                                mProgressStatus++;
                                try
                                {
                                Thread.sleep(50);
                                }
                                catch (InterruptedException e)
                                {
                                    return;
                                }
                                progress2.setProgress(mProgressStatus);

                                // Update the progress bar
                               /* mHandler.post(new Runnable() {
                                    public void run() {
                                        progress2.setProgress(mProgressStatus);
                                    }
                                });*/
                            }
                            finish();
                        }
                    }).start();
                }
            }

            super.handleMessage(msg);
        }
    };
}