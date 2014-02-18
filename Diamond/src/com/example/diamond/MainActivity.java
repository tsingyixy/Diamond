package com.example.diamond;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {
    private GameView gv;
    private Button leftBtn;
    private Button rightBtn;
    private Button transBtn;
    private boolean isNew;
    private ShapeDiamond sd;
    private int[][] diamonds;
    private int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn = (Button)findViewById(R.id.button1);
        rightBtn = (Button)findViewById(R.id.button2);
        transBtn = (Button)findViewById(R.id.button3);
        gv = (GameView)findViewById(R.id.gameView1);
        isNew = true;
        diamonds = gv._diamonds;
        pos = diamonds.length / 2 -1;
        
    }
    public void Calculate(ShapeDiamond sd){
    	
    	int[][] shape = sd.GetShape();
    	if(isNew){
        	for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				diamonds[pos+i][j] |= shape[i][j];
    			}
    		}
        	pos++;
        	isNew = false;
    	}
    	else{
    		for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				diamonds[pos+i][j] = 0;
    			}
    		}
        	pos++;
        	for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				diamonds[pos+i][j] |= shape[i][j];
    			}
    		}
    	}
    	
    	
    }
    private void Run(){
    	while(true){
    		if(isNew){
    			sd = new ShapeDiamond(0);
    		}
    		Calculate(sd);   		
    	}
    }
    class ShapeDiamond {
    	private int[][] shape;
    	//public static boolean isNew = false;
    	public ShapeDiamond(int flag){
    		//shape = new int[2][4];
    		Generate(flag);
    	}
    	public void Generate(int flag){
    		switch (flag) {
			case 0:
				shape = new int[][]{{0,1,1,0},{0,1,1,0}};
				break;
			case 1:
				shape = new int[][]{{0,0,1,0},{1,1,1,0}};
				break;
			default:
				break;
			}
    	}
    	public int[][] GetShape(){
    		return shape;
    	}
    	public void Transpos(){
    		int[][] temp = {{0,0},{0,0},{0,0},{0,0}};
    		for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[i].length; j++) {
					temp[i][j] = shape[j][i];
				}
			}
    		shape = temp;
    	}
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
