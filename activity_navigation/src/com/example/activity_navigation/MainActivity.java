package com.example.activity_navigation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		// 複数の Intent をスタックして起動する
        TaskStackBuilder builder = TaskStackBuilder.create(MainActivity.this);
        builder.addNextIntent(new Intent(MainActivity.this, GrandParentActivity.class));
        builder.addNextIntent(new Intent(MainActivity.this, ParentActivity.class));
        builder.addNextIntent(new Intent(MainActivity.this, ParentActivity.class));
        builder.addNextIntent(new Intent(MainActivity.this, MainActivity.class));
        builder.addNextIntent(new Intent(MainActivity.this, MainActivity.class));
        builder.startActivities();
        finish();	
	}

}
