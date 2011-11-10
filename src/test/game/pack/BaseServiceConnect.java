package test.game.pack;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class BaseServiceConnect extends Activity {
	public LocalService mBoundService = null;
	
	private ServiceConnection mConnection = new ServiceConnection() {
		
		public void onServiceConnected(ComponentName className, IBinder service) {
		mBoundService = ((LocalService.LocalBinder)service).getService();            
		mBoundService.mpPlay();
		addContent();
		}

		public void onServiceDisconnected(ComponentName className) {
		mBoundService = null;
		}
	};
	
    @Override
    protected void onStart() {
    	bindService(new Intent(BaseServiceConnect.this, LocalService.class), mConnection, Context.BIND_AUTO_CREATE);
    	super.onStart();
    	
    }
    
	@Override
	protected void onStop() {
		mBoundService.mpPause();
		unbindService(mConnection);
		super.onStop();
	}
	
	protected void addContent(){
		
	}
	
}
