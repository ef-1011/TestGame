package test.game.pack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		startService(new Intent(Splash.this, LocalService.class));
		
		 new CountDownTimer(3000,3000) {
			ImageView iv = (ImageView) findViewById(R.id.imageView1);
			@Override
			public void onTick(long millisUntilFinished) {
				
			}
			@Override
			public void onFinish() {
				iv.setImageResource(R.drawable.wpapers);
				 new CountDownTimer(3000,3000) {
						@Override
						public void onTick(long millisUntilFinished) {
							
						}
						
						@Override
						public void onFinish() {
							startActivity(new Intent(Splash.this, MainActivity.class));
						}
					}.start();
			}
		}.start();
	}
}
