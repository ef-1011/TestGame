package test.game.pack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;




public class MainActivity extends BaseServiceConnect {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        
        Button game = (Button) findViewById(R.id.game);
        game.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Game.class));
				
			}
		});
        
        Button help = (Button) findViewById(R.id.help);
        help.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Help.class));
				
			}
		});
        
        Button options = (Button) findViewById(R.id.options);
        options.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Options.class));
				
			}
		});
        
        Button credits = (Button) findViewById(R.id.credits);
        credits.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, Credits.class));
				
			}
		});
    }

}