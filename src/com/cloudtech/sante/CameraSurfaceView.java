package com.cloudtech.sante;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

	private Camera mCamera;
	private SurfaceHolder mHolder;

	CameraSurfaceView(Context context, Camera camera) {
		super(context);

		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			
			
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
		} catch (IOException e) {
			 Log.d("CAMERA", "Error setting camera preview: " + e.getMessage());
		}

	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		if (mHolder.getSurface() == null){
	          // preview surface does not exist
	          return;
	        }
		 // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e){
          // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            mCamera.startPreview();

        } catch (Exception e){
            Log.d("CAMERA", "Error starting camera preview: " + e.getMessage());
        }
	}

	

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// Surface will be destroyed when replaced with a new screen
		// Always make sure to release the Camera instance
		mCamera.stopPreview();
		mCamera.release();
		mCamera = null;
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
	}

	public void takePicture(PictureCallback imageCallback) {
		mCamera.takePicture(null, null, imageCallback);
	}

}