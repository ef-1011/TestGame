package test.game.pack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Help extends BaseServiceConnect {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
        TextView tv = (TextView) findViewById(R.id.back);
        tv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Help.this, MainActivity.class));
			}
		});
	}

}
