package com.cloudtech.sante;

import java.io.File;
import java.util.List;

import android.app.ListActivity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

public class GalleryActivity extends ListActivity {
	// Standard storage location for digital camera files
	private static final String CAMERA_DIR = "/dcim/";
	private String albumName;
	private List<Drawable> mDrawables;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String path;
		albumName = getString(R.string.album_name);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			path = 	Environment.getExternalStorageDirectory()
					+ CAMERA_DIR
					+ albumName;
		} else {
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + albumName;
		}

		File dir = new File(path);
		File[] filelist = dir.listFiles();
		for (File f : filelist) { 
			Drawable mDrawable = Drawable.createFromPath(f.getAbsolutePath());
			mDrawables.add(mDrawable);
		}

	}

}
