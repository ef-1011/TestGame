package test.game.pack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Options extends BaseServiceConnect {
	private Button play = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		
		
        TextView tv = (TextView) findViewById(R.id.back);
        tv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Options.this, MainActivity.class));
			}
		});
        
       play = (Button) findViewById(R.id.play);
       play.setOnClickListener(ClickPlay);  
       play.setText("Play");
	}
	
	   OnClickListener ClickPlay = new OnClickListener() {
			
			public void onClick(View v) {
				if(play.getText() == "Play")
				{
				mBoundService.mpStart();	
				play.setText("Stop");
				mBoundService.text = "Stop";
				}
				else
				{
				mBoundService.mpStop();
				play.setText("Play");
				mBoundService.text = "Play";
				}                
			}
		}; 	
		
		protected void addContent(){
			play.setText(mBoundService.text);
		}
}
