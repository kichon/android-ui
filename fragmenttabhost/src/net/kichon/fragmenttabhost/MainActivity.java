package net.kichon.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
		host.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		
		TabSpec tabSpec1 = host.newTabSpec("tab1").setIndicator("Tab1");
		/*
		Button button1 = new Button(this);
		button1.setBackgroundResource(R.drawable.tab1);
		tabSpec1.setIndicator(button1);
		*/
		Bundle bundle1 = new Bundle();
		bundle1.putString("name", "Tab1");
		host.addTab(tabSpec1, SampleFragment.class, bundle1);
		
		TabSpec tabSpec2 = host.newTabSpec("tab2").setIndicator("Tab2");
		/*
		Button button2 = new Button(this);
		button2.setBackgroundResource(R.drawable.tab2);
		tabSpec2.setIndicator(button2);
		*/
		Bundle bundle2 = new Bundle();
		bundle2.putString("name", "Tab2");
		host.addTab(tabSpec2, SampleFragment.class, bundle2);

		TabSpec tabSpec3 = host.newTabSpec("tab3").setIndicator("Tab3");
		/*
		Button button3 = new Button(this);
		button3.setBackgroundResource(R.drawable.tab3);
		tabSpec3.setIndicator(button3);
		*/
		Bundle bundle3 = new Bundle();
		bundle3.putString("name", "Tab3");
		host.addTab(tabSpec3, SampleFragment.class, bundle3);
		
		TabSpec tabSpec4 = host.newTabSpec("tab4").setIndicator("Tab4");
		/*
		Button button4 = new Button(this);
		button4.setBackgroundResource(R.drawable.tab4);
		tabSpec4.setIndicator(button4);
		*/
		Bundle bundle4 = new Bundle();
		bundle4.putString("name", "Tab4");
		host.addTab(tabSpec4, SampleFragment.class, bundle4);

		TabSpec tabSpec5 = host.newTabSpec("tab5").setIndicator("Tab5");
		/*
		Button button5 = new Button(this);
		button5.setBackgroundResource(R.drawable.tab5);
		tabSpec5.setIndicator(button5);
		*/
		Bundle bundle5 = new Bundle();
		bundle5.putString("name", "Tab5");
		host.addTab(tabSpec5, SampleFragment.class, bundle5);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public static class SampleFragment extends Fragment {
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(getArguments().getString("name"));
			
			return textView;
		}
	}

}
