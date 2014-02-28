package com.example.russiandiamond;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Graphics {
	//public SurfaceHolder holder;
	public Canvas canvas;
	public Paint pen;
    public Graphics(Canvas c){
    	this.canvas = c;
    	this.pen = new Paint();
    	pen.setColor(Color.BLUE);
    }
    public void DrawRect(Rect r){
    	canvas.drawRect(r, pen);
    }
    public void DrawImage(Image image,Rect dst){
    	Bitmap bitmap = image.getImage();
    	canvas.drawBitmap(bitmap, canvas.getClipBounds(), dst, null);
    }
}
