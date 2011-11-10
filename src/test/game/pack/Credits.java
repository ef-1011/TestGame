package test.game.pack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Credits extends BaseServiceConnect {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credits);
		
        TextView tv = (TextView) findViewById(R.id.back);
        tv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Credits.this, MainActivity.class));
			}
		});

	}
}
