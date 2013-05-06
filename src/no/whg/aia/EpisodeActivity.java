package no.whg.aia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;

public class EpisodeActivity extends Activity {
	
	private SimpleSideDrawer mNav;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_episode);
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
		mNav = new SimpleSideDrawer(this);
        mNav.setLeftBehindContentView(R.layout.activity_behind_left);
        
		String episode = getIntent().getExtras().getString("episode");
		TextView tv = (TextView) findViewById(R.id.episodeTv);
		
		if(episode != null) {
			if (episode == "s1e1") {
				tv.setText("I am s1e1");
			} else if (episode == "s1e2") {
				tv.setText("I am s1e2");
			} else {
				tv.setText("No episode selected.");
			}
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
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
		case R.id.episodes: mNav.toggleLeftDrawer(); break;
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
