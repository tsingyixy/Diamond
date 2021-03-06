/**
 * 
 */
package com.example.diamond;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
//import android.view.View;

/**
 * @author hutan
 *
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	public static int[][] _diamonds;
	private int _height;
	private int _width;
	private static int LEN = 20;
	private PaintThread paintThread;
	private SurfaceHolder holder;
	/**
	 * @param context
	 */
	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
//		_height = getHeight() / LEN;
//		_width = getWidth() / LEN;
//		_diamonds = new int[_width][_height];           //initial to 0
//	    holder = this.getHolder();
//	    paintThread = new PaintThread(holder);
//	    paintThread.start();
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		_height = 800 / LEN;
		_width = 600 / LEN;
		_diamonds = new int[_width][_height];           //initial to 0
	    holder = this.getHolder();
	    paintThread = new PaintThread(holder);
	    paintThread.start();
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
//		_height = getHeight() / LEN;
//		_width = getWidth() / LEN;
//		_diamonds = new int[_width][_height];           //initial to 0
//	    holder = this.getHolder();
//	    paintThread = new PaintThread(holder);
//	    paintThread.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	public void DrawDiamond(Canvas c,float left,float top,float right,float bottom,Paint p){
		c.drawRect(left, top, right, bottom, p);
	}
	class PaintThread extends Thread{
        private boolean isRun;
        private Canvas canvas;
        private SurfaceHolder holder;
        public PaintThread(SurfaceHolder holder){
        	isRun = true;
        	this.holder = holder;
        }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRun){
				try {
					synchronized (holder) {
					    canvas = holder.lockCanvas();
					    canvas.drawColor(Color.WHITE);
					    Paint pen = new Paint();
					    pen.setColor(Color.BLUE);
					    int sum = 0;
					    canvas.drawText((_width)+","+(_height), 300, 200, pen);
					    for (int j = _height - 1; j >= 0; j--) {
					    	sum = 0;
								for (int i = 0; i <_width; i++) {
								sum += _diamonds[i][j];
							}
							if (sum == _width)
							{
								for (int i = _height - 1; i >= 0; i--) {
									for (int k = 0; k < _width; k++) {
										if(i == 0)
											_diamonds[i][k] = 0;
										else
										    _diamonds[i][k] = _diamonds[i][k] -1;
									}
								}
							  j ++;
							}
						}
					    for (int i = 0; i < _width; i++) {
							for (int j = 0; j < _height; j++) {
							    if(_diamonds[i][j] == 1)
							    	DrawDiamond(canvas,i*LEN, j*LEN, (i+1)*LEN, (j+1)*LEN, pen);
							}
						}
					    Thread.sleep(250);
					}} catch (Exception e) {
					// TODO: handle exception
				}
				finally{
					if(canvas != null)
						holder.unlockCanvasAndPost(canvas);
				}
			}
		}
		
	}

}
