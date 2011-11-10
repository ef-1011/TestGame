package test.game.pack;

import android.app.Service;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;


public class LocalService extends Service {

	private final IBinder mBinder = new LocalBinder();
	private MediaPlayer mMediaPlayer;
	private boolean isPlay= false;
	private int flag=0;
	public String text ="Play";
	
	public class LocalBinder extends Binder {
	    LocalService getService() {
	        return LocalService.this;
	    }
	}
	
	@Override
	public void onCreate() {        
		if(mMediaPlayer==null)
		 mMediaPlayer = MediaPlayer.create(getApplicationContext(),  R.raw.gener);
	     mMediaPlayer.start(); 
		 mMediaPlayer.pause();
	}
	
	@Override
	public void onDestroy() {
	}
	
	public void mpStart() {
	
	    mMediaPlayer.start(); 
	    isPlay=true;
	    flag=1;
	}
	
	public void mpPlay() {
		if(isPlay){
	    mMediaPlayer.start(); 
		flag++;}
	
	}
	
	public void mpStop() {
		mMediaPlayer.pause();
	    isPlay=false;
	    flag=0;
	}
	
	public void mpPause() {
		if(flag<2){
	    mMediaPlayer.pause();
		}
	    flag=1;   
	}
	
	@Override
	public IBinder onBind(Intent intent) {              
	    return mBinder;
	}
	
	public boolean isPlay(){
		return mMediaPlayer.isPlaying();
	}

}