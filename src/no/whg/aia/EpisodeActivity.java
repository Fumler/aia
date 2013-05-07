package no.whg.aia;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;

public class EpisodeActivity extends Activity {
	
	private SimpleSideDrawer mNav;
	private LinearLayout ll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_episode);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
		mNav = new SimpleSideDrawer(this);
        mNav.setLeftBehindContentView(R.layout.activity_behind_left);
        
        ll = (LinearLayout) findViewById(R.id.ll);
        refreshEpisode();
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	private void refreshEpisode() {
		String episode = getIntent().getExtras().getString("episode");
		
        List<TextView> tv_ep = new ArrayList<TextView>(5);
        List<ImageView> iv_ep = new ArrayList<ImageView>(5);
        
        for (int i = 0; i < 5; i++) {
        	String tv_id = "tv_ep" + (i+1);
        	String iv_id = "iv_ep" + (i+1);
        	
        	int tv_idInt = getResources().getIdentifier(tv_id, "id", "no.whg.aia");
        	int iv_idInt = getResources().getIdentifier(iv_id, "id", "no.whg.aia");
        	
        	tv_ep.add(i, (TextView) findViewById(tv_idInt));
        	iv_ep.add(i, (ImageView) findViewById(iv_idInt));
        	
        	tv_ep.get(i).setVisibility(View.GONE);
        	iv_ep.get(i).setVisibility(View.GONE);
        }
		
		
		if (episode.contains("s1e1")) {
			setTitle(getResources().getString(R.string.tv_s1e1));
			LayoutInflater inflater = LayoutInflater.from(this);
			TextView tv = (TextView) inflater.inflate(R.id.tv_styler, ll, false);
			tv.setText("herp i derp i derp");
			//ll.addView(tv);
		} else if (episode.contains("s1e2")) {
			setTitle(getResources().getString(R.string.tv_s1e2));
		} else if (episode.contains("s1e3")) {
			setTitle(getResources().getString(R.string.tv_s1e3));
		} else if (episode.contains("s1e4")) {
			setTitle(getResources().getString(R.string.tv_s1e4));
		} else if (episode.contains("s1e5")) {
			setTitle(getResources().getString(R.string.tv_s1e5));
		} else if (episode.contains("s1e6")) {
			setTitle(getResources().getString(R.string.tv_s1e6));
		} else if (episode.contains("s1e7")) {
			setTitle(getResources().getString(R.string.tv_s1e7));
		} else if (episode.contains("s1e8")) {
			setTitle(getResources().getString(R.string.tv_s1e8));
		} else if (episode.contains("s2e1")) {
			setTitle(getResources().getString(R.string.tv_s2e1));
		} else if (episode.contains("s2e2")) {
			setTitle(getResources().getString(R.string.tv_s2e2));
		} else if (episode.contains("s2e3")) {
			setTitle(getResources().getString(R.string.tv_s2e3));
		} else if (episode.contains("s2e4")) {
			setTitle(getResources().getString(R.string.tv_s2e4));
		} else if (episode.contains("s2e5")) {
			setTitle(getResources().getString(R.string.tv_s2e5));
		} else if (episode.contains("s2e6")) {
			setTitle(getResources().getString(R.string.tv_s2e6));
		} else if (episode.contains("s2e7")) {
			setTitle(getResources().getString(R.string.tv_s2e7));
		} else if (episode.contains("s2e8")) {
			setTitle(getResources().getString(R.string.tv_s2e8));
		} else if (episode.contains("s3e1")) {
			setTitle(getResources().getString(R.string.tv_s3e1));
		} else if (episode.contains("s3e2")) {
			setTitle(getResources().getString(R.string.tv_s3e2));
		} else if (episode.contains("s3e3")) {
			setTitle(getResources().getString(R.string.tv_s3e3));
		} else if (episode.contains("s3e4")) {
			setTitle(getResources().getString(R.string.tv_s3e4));

		} else {
			TextView tv = new TextView(getApplicationContext());
		    tv.setText("No episodes selected.");
		    ll.addView(tv);
		}
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		refreshEpisode();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.episodes: mNav.toggleLeftDrawer(); 
        List<TextView> s1_tv = new ArrayList<TextView>(8);
        Log.w("no.whg.aia", ":::::::: ARRAY SIZE: " + s1_tv.size());
        
        for (int i = 0; i < 8; i++) {
        	String tv_id = "s1_e" + (i+1);
        	
        	final int j = i+1;
        	int tv_idInt = getResources().getIdentifier(tv_id, "id", "no.whg.aia");
        	Log.w("no.whg.aia", "::::::: tv_idInt: " + tv_idInt);
        	Log.w("no.whg.aia", "::::::: R id: " + R.id.s1_e1);
        	s1_tv.add(i, (TextView) findViewById(tv_idInt));
        	
        	s1_tv.get(i).setClickable(true);
        	
        	s1_tv.get(i).setOnClickListener(new View.OnClickListener() {
        		@Override
        		public void onClick(View v) {
        			Intent intent = new Intent(getApplicationContext(), EpisodeActivity.class);
        			intent.putExtra("episode", "s1e"+j);
        			startActivity(intent);
        		}
        		
        		
        	});
        }
        break;
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
