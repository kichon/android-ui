package net.kichon.drawlayout_viewpager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	private static final String TAG = "MainActivity";
	
	DrawerLayout mDrawerLayout;
	ActionBarDrawerToggle mDrawerToggle;
	ListView mDrawerList;
	
	ViewPager vp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* for 横スライド */
		ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
        
        // DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        
        // DrawerListを開く/閉じるトグルボタン
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.open,
                R.string.close
        ) {
        	/**
        	 * 閉じきった
        	 */
        	@Override
            public void onDrawerClosed(View drawerView) {
        		Log.d(TAG, "onDrawerClosed");
        	}
        	
        	/**
        	 * 開ききった
        	 */
        	@Override
            public void onDrawerOpened(View drawerView) {
        		Log.d(TAG, "onDrawerOpened");
        	}
        	
        	/**
        	 * スライド中
        	 */
        	@Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
        		super.onDrawerSlide(drawerView, slideOffset);
        		Log.d(TAG, "onDrawerSlide");
        	}
        	
        	/**
        	 * ナビゲーションドロワーの状態が変わった
        	 * 表示済み、閉じ済みの状態：0
             * ドラッグ中状態:1
             * ドラッグを放した後のアニメーション中：2
        	 */
        	@Override
            public void onDrawerStateChanged(int newState) {
        		Log.d(TAG, "onDrawerStateChanged: state: " + newState);
        	}
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        
        // DrawerList
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.list, android.R.layout.simple_list_item_1);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(mOnItemClickListener);
        
        
        /* viewpager */
		vp = (ViewPager) findViewById(R.id.pager);
		
		vp.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
		
		PagerTabStrip strip = (PagerTabStrip)findViewById(R.id.tabstrip);
		strip.setDrawFullUnderline(true);
		strip.setTabIndicatorColor(0xAAFFAA);

	}

	/**
     * onStartの後に呼ばれる
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // DrawerToggleの状態を同期する
        mDrawerToggle.syncState();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // DrawerLayoutを閉じる
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    };
    
    /**
     * 画面の向きを変更した場合などに呼ばれる
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // DrawerToggleの状態を同期する
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
	public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

		public MyFragmentStatePagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub			
		    switch(arg0){
		    case 0:
		      return new F1();
		    case 1:
		      return new F2();
		    default:
		      return new F3();
		    }
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 3;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			return "Page " + position;
		}
	}
}
