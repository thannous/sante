package com.cloudtech.sante;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
 
import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RemoteViews;
 
public class SanteWidgetService extends Service {
 
	AsyncImageLoader loader;
	protected boolean isLoaded = false;
	AppWidgetManager appWidgetManager;
 
	protected Handler handler = new Handler();
 
	SharedPreferences prefs;
 
	@Override
	public void onStart(Intent intent, int startId)
	{
		this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
 
		this.appWidgetManager = AppWidgetManager.getInstance(this
				.getApplicationContext());
 
		int[] allWidgetIds = intent
				.getIntArrayExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS);
 
		for(int widgetId : allWidgetIds)
		{
			if(widgetId == 0)
				continue;
 
			RemoteViews remoteViews = new RemoteViews(this
					.getApplicationContext().getPackageName(),
					R.layout.sante_widget_layout);
 
			// Chargement
			remoteViews.setImageViewResource(R.id.widget_image, android.R.color.transparent);
			this.appWidgetManager.updateAppWidget(widgetId, remoteViews);
 
			// Clique sur l'image
			Intent clickIntentRefresh = new Intent(this.getApplicationContext(),
					SanteWidgetProvider.class);
			clickIntentRefresh.setData(Uri.withAppendedPath(Uri.parse("imgwidget://widget/id/"), String.valueOf(widgetId)));
 
			clickIntentRefresh.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			clickIntentRefresh.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
					new int[] { widgetId });
 
			PendingIntent pendingIntentRefresh = PendingIntent.getBroadcast(
					getApplicationContext(), 0, clickIntentRefresh,
					PendingIntent.FLAG_UPDATE_CURRENT);
 
			remoteViews.setOnClickPendingIntent(R.id.widget_image, pendingIntentRefresh);

            // Notre image al&#xfffd;atoire
			loadImage(remoteViews, widgetId, this.randomImg());
		}
 
		stopSelf();
 
		super.onStart(intent, startId);
	}
 
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
 
	private void loadImage(RemoteViews remoteViews, int widgetId, String url)
	{
		this.loader = new AsyncImageLoader(this, getFile(), this.handler, widgetId, remoteViews);
		this.loader.execute(url);
	}
 
	/*
	 * R&#xfffd;cup&#xfffd;ration d'une image al&#xfffd;atoire
	 */
	private String randomImg()
	{
		/*
		 * Notez que l'android virtual devide (avd) semble poser
		 * probl�me avec les domaines. (Soucis de DNS)
		 * Utilisez des ip direct pour vos test si vous en avez sinon
		 * vous pouvez utiliser votre ip local.
		 */
		ArrayList<String> urls = new ArrayList<String> ();
		urls.add("http://91.121.222.207/divers/android-1.jpg");
		urls.add("http://91.121.222.207/divers/android-2.jpg");
		urls.add("http://91.121.222.207/divers/android-3.jpg");
		urls.add("http://91.121.222.207/divers/android-4.jpg");
 
		return urls.get(new Random().nextInt(urls.size()));
	}
 
	private File getFile()
	{
		File cachedir = null;
		if (android.os.Environment.getExternalStorageState().equals( android.os.Environment.MEDIA_MOUNTED ))
			cachedir = new File( android.os.Environment.getExternalStorageDirectory(), "cache.jpg" );
		else
			cachedir = getApplicationContext().getCacheDir();
 
		try {
			cachedir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		synchronized (cachedir)
		{
			return cachedir;
		}
	}
 
	public void updateAppWidgetImage(int widgetId, RemoteViews remoteViews, Bitmap bitmap)
	{
		remoteViews.setImageViewBitmap(R.id.widget_image, bitmap);
		this.appWidgetManager.updateAppWidget(widgetId, remoteViews);
	}
 
	private static class AsyncImageLoader
		extends AsyncTask < String, Integer, Integer >
	{
		private static final int RESULT_SUCCESS = 0x00;
		private static final int RESULT_FAILED = 0x01;
		private static final int RESULT_CANCELLED = 0x02;
 
		SanteWidgetService activity;
		File file;
 
		private RemoteViews rv;
		private int viewId;
 
		private Handler handler;
 
		public void init(SanteWidgetService widgetImageUpdateService)
		{
			activity = widgetImageUpdateService;
		}
 
		public AsyncImageLoader(SanteWidgetService widgetImageUpdateService, File f, Handler h, int vid, RemoteViews remoteViews)
		{
			this.handler = h;
			file = f;
			this.rv = remoteViews;
			this.viewId = vid;
 
			init( widgetImageUpdateService );
		}
 
		@Override
		protected Integer doInBackground(String... params)
		{
			if (params.length != 1)
				return RESULT_FAILED;
 
			URL url;
			try
			{
				url = new URL( params[0] );
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
 
				if (isCancelled())
					return RESULT_CANCELLED;
 
				InputStream input = conn.getInputStream();
				OutputStream output = new FileOutputStream( file );
 
				byte[] bytes = new byte[4096];
				for (;;)
				{
					int count = input.read( bytes );
					if (count == -1)
						break;
 
					if (isCancelled())
					{
						output.close();
						file.delete();
						return RESULT_CANCELLED;
					}
 
					output.write( bytes, 0, count );
				}
				output.close();
			}
			catch (MalformedURLException e)
			{
				return RESULT_FAILED;
			}
			catch (IOException e)
			{
				return RESULT_FAILED;
			}
			return RESULT_SUCCESS;
		}
 
		@Override
		protected void onPostExecute(Integer result)
		{
			switch (result)
			{
			case RESULT_SUCCESS:
				final Bitmap bitmap = getBitmapFromFile( file );
				if (bitmap != null)
				{
					 this.handler.postDelayed(new Runnable() {
						public void run()
						{
							activity.updateAppWidgetImage(viewId, rv, bitmap);
						}
					 }, 100);
 
					activity.isLoaded = true;
				}
				break;
			case RESULT_FAILED:
				break;
			case RESULT_CANCELLED:
				break;
			}
 
			activity.loader = null;
		}
	}
 
	public static Bitmap getBitmapFromFile(File file)
	{
		try
		{
			BitmapFactory.Options opt = new BitmapFactory.Options();
			opt.inPreferredConfig = Bitmap.Config.RGB_565;
 
			opt.inJustDecodeBounds = true;
			BitmapFactory.decodeFile( file.getAbsolutePath(), opt );
 
			opt.inSampleSize = computeSampleSize( opt, -1, 2048 * 2048 );
			opt.inJustDecodeBounds = false;
			opt.inPurgeable = true;
			opt.inInputShareable = true;
 
			return BitmapFactory.decodeFile( file.getAbsolutePath(), opt );
		}
		catch (NullPointerException e)
		{
			Log.d("", "decode failed, NullPointerException occured.", e);
		}
		catch (OutOfMemoryError ex)
		{
			Log.d("", "decode failed, OutOfMemory occured." );
		}
		return null;
	}
 
 
	private static int computeSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels)
	{
		int initialSize = computeInitialSampleSize( options, minSideLength, maxNumOfPixels );
 
		int roundedSize;
		if (initialSize <= 8)
		{
			roundedSize = 1;
			while (roundedSize < initialSize)
				roundedSize <<= 1;
		}
		else
			roundedSize = (initialSize + 7) / 8 * 8;
 
		return roundedSize;
	}
 
	private static int computeInitialSampleSize(BitmapFactory.Options options, int minSideLength, int maxNumOfPixels)
	{
		double w = options.outWidth;
		double h = options.outHeight;
 
		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil( Math.sqrt( w * h / maxNumOfPixels ) );
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min( Math.floor( w / minSideLength ), Math.floor( h / minSideLength ) );
 
		if (upperBound < lowerBound)
			return lowerBound;
 
		if ((maxNumOfPixels == -1) && (minSideLength == -1))
			return 1;
		else if (minSideLength == -1)
			return lowerBound;
		else
			return upperBound;
	}
}