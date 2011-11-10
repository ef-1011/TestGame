package test.game.pack;

import java.util.Random;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends BaseServiceConnect implements OnClickListener {

	private static final Runnable OnClickListener = null;
	private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
	
        TextView tv = (TextView) findViewById(R.id.back);
        tv.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Game.this, MainActivity.class));
			}
		});

        Button b = (Button) findViewById(R.id.btake);
        b.setOnClickListener(bClick);
        Bild(LinearLayout());
        
    }
    
	private LinearLayout LinearLayout() {
		return (LinearLayout) findViewById(R.id.linearLayout1);
	}
	

	public void Bild(LinearLayout l){
		
		for (int i = 0; i < 13; i++) {
		  	Match imageView = new Match(this);
			imageView.setLayoutParams(new LayoutParams(300, 40));		
			imageView.setImageResource(R.drawable.list);
			imageView.setOnClickListener(this);
			l.addView(imageView);
		}
	}

   OnClickListener bClick =  new OnClickListener() {
		
		public void onClick(View v) {
	
			if(count!=0){
			LinearLayout l = LinearLayout();
			for (int i = l.getChildCount()-1; i >= 0; i--) {
				if(((Match)l.getChildAt(i)).state == false)
				l.removeView(l.getChildAt(i));	
				
			}
			
			count = 0;
			if(l.getChildCount()>=1){
				Win("win",l);
			}
			AI(l);
			Toast toast = Toast.makeText(getApplicationContext(),"  wait  ", Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			}
		}
	};
	
	private void AI(LinearLayout l){

		 new CountDownTimer(1000,1000) {
			    Button b = (Button) findViewById(R.id.btake);
			
				@Override
				public void onTick(long millisUntilFinished) {
					 b.removeCallbacks(OnClickListener);
				}
				
				@Override
				public void onFinish() {
					LinearLayout l = LinearLayout();
					Random rand = new Random();
					int countAi = 0;
					switch (l.getChildCount()) {
					case 2:countAi = 1;
						
						break;
					case 3:countAi = 2;
						
						break;

					default:countAi = rand.nextInt(3)+1;
						break;
					}
						
					for (int i = 0; i < countAi ; i++) {
						l.removeView(l.getChildAt(i));	
					}
					
					Win("lost",l);	
				    b.setOnClickListener(bClick);
				}
			}.start();

	}
	
	
	public void Win(String msg,final LinearLayout l){
		if(l.getChildCount()<=1){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("you "+msg)
			       .setCancelable(false)
			       .setPositiveButton("exit", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			        	   Game.this.finish();
			           }
			       })
			       .setNegativeButton("try again", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			                Bild(l);
			           }
			       });
			AlertDialog alert = builder.create();
			alert.show();
		}
	}

	public void onClick(View v) {
		
		Match iv = (Match) v;
			if(iv.state==true){
				if(count<3){
				iv.setImageResource(R.drawable.focus);
				iv.state=false;
				count++;}
			}
			else
			{
				iv.setImageResource(R.drawable.list);
				iv.state=true;
				count--;
			}
	}

	
	private class Match extends ImageView {

		public boolean state = true;
		
		public Match(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

	}

}