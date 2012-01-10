package com.perfectpixel.android.tdba;
import android.graphics.Canvas;
 
public class RPGLoop extends Thread {
	
	static final long fps = 30;
	
	private RPGView view;
	private boolean running = false;
      
	public RPGLoop(RPGView _view) {
		view = _view;
	}
 
	public void setRun(boolean input) {
		running = input;
	}
 
	@Override
	public void run() {
		
		while (running) {
			
			Canvas c = null;
			
			try {
				c = view.getHolder().lockCanvas();
				synchronized (view.getHolder()) {
						view.onDraw(c);
				}
			}
			finally {
				if (c != null) {
					view.getHolder().unlockCanvasAndPost(c);
				}
			}
            
			try {
				sleep(1000/fps);
            }
            catch (Exception e) {
            }
		}
	}
}  