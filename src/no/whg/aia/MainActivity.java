package no.whg.aia;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.navdrawer.SimpleSideDrawer;
public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	
	private SimpleSideDrawer mNav;
	/*
	@Override
	public void onAttachedToWindow() {
	    super.onAttachedToWindow();
	    Window window = getWindow();
	    window.setFormat(PixelFormat.RGBA_8888);
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		

        

        
        
		mNav = new SimpleSideDrawer(this);
        mNav.setLeftBehindContentView(R.layout.activity_behind_left);
        

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.episodes) {
			mNav.toggleLeftDrawer();
	        // set up menu¨
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
		} else if (item.getItemId() == android.R.id.home){
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase();
			case 1:
				return getString(R.string.title_section2).toUpperCase();
			case 2:
				return getString(R.string.title_section3).toUpperCase();
			case 3:
				return getString(R.string.title_section4).toUpperCase();
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	
        	Bundle args = getArguments();
        	int position = args.getInt(ARG_SECTION_NUMBER);
        	int tabLayout = 1;

        	switch(position) {
        	case 0:
        		tabLayout = R.layout.tab1;
        		break;
        	case 1:
        		tabLayout = R.layout.tab2;
        		break;
        	case 2:
        		tabLayout = R.layout.tab3;
        		break;
        	case 3:
        		tabLayout = R.layout.tab4;
        		break;
        		
        	}
        	
        	View view = inflater.inflate(tabLayout, container, false);

            return view;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
			Bundle args = getArguments();
			int position = args.getInt(ARG_SECTION_NUMBER);
			
			switch(position) {
			case 0: /* init here */ break;
			case 1: /* init here */ break;
			case 2: /* init here */ break;
			case 3: /* init here */ break;
			default: /* init here */ break;
			}
		}
	}

}
