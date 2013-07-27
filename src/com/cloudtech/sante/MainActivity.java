package com.cloudtech.sante;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	static final String EXTRA_MAP = "map";

	static final LauncherIcon[] ICONS = {
			new LauncherIcon(R.drawable.user_info, "Mes document",
					"user_info.png"),
			new LauncherIcon(R.drawable.user_info, "Mes infos de santé",
					"user_info.png"),
			new LauncherIcon(R.drawable.user_info, "Urgence",
					"user_info.png"),
			new LauncherIcon(R.drawable.user_info, "Mon evolution",
					"user_info.png"),
			new LauncherIcon(R.drawable.user_info, "Memo",
					"user_info.png"),
			new LauncherIcon(R.drawable.user_info, "Timeline",
					"user_info.png")};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView gridview = (GridView) findViewById(R.id.dashboard_grid);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(this);

		// Hack to disable GridView scrolling
		gridview.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return event.getAction() == MotionEvent.ACTION_MOVE;
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Intent intent = null;
		if(position ==0){
			intent = new Intent(this, DocumentActivity.class);
		}else if( position == 1){
			intent = new Intent(this, InfoActivity.class);
		}else if( position == 2){
			intent = new Intent(this, UrgenceActivity.class);
		}else if( position == 3){
			 intent = new Intent(this, EvolutionActivity.class);
		}else if( position == 4){
			 intent = new Intent(this, MemoActivity.class);
		}else if( position == 5){
			 intent = new Intent(this, TimelineActivity.class);
		}

		intent.putExtra(EXTRA_MAP, ICONS[position].map);
		startActivity(intent);
	}

	static class LauncherIcon {
		final String text;
		final int imgId;
		final String map;

		public LauncherIcon(int imgId, String text, String map) {
			super();
			this.imgId = imgId;
			this.text = text;
			this.map = map;
		}

	}

	static class ImageAdapter extends BaseAdapter {
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
		}

		@Override
		public int getCount() {
			return ICONS.length;
		}

		@Override
		public LauncherIcon getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		static class ViewHolder {
			public ImageView icon;
			public TextView text;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			ViewHolder holder;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) mContext
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				v = vi.inflate(R.layout.dashboard_icon, null);
				holder = new ViewHolder();
				holder.text = (TextView) v
						.findViewById(R.id.dashboard_icon_text);
				holder.icon = (ImageView) v
						.findViewById(R.id.dashboard_icon_img);
				v.setTag(holder);
			} else {
				holder = (ViewHolder) v.getTag();
			}

			holder.icon.setImageResource(ICONS[position].imgId);
			holder.text.setText(ICONS[position].text);

			return v;
		}

	}
}
