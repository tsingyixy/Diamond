package com.example.diamond;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private GameView gv;
    private Button leftBtn;
    private Button rightBtn;
    private Button transBtn;
    private boolean isNew;
    private ShapeDiamond sd;
    private boolean bIsOld;
    //private int[][] diamonds;
    private int posx,posy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn = (Button)findViewById(R.id.button1);
        rightBtn = (Button)findViewById(R.id.button2);
        transBtn = (Button)findViewById(R.id.button3);
        gv = (GameView)findViewById(R.id.gameView1);
        isNew = true;
        //diamonds = gv._diamonds;
        posx = GameView._diamonds.length / 2;
        posy = 0;
        Player player = new Player();
        leftBtn.setOnClickListener(player);
        rightBtn.setOnClickListener(player);
        //Run();
        new CalThread().start();
    }
    class CalThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			Run();
		}
    	
    }
    class Player implements View.OnClickListener{
    	public void LeftGo(ShapeDiamond sd){
    		int[][] shape = sd.GetShape();
    		if(posx == 0)
    			return;
    		for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				GameView._diamonds[posx+i][j+posy] = 0;
    			}
    		}

        	posx -= 1;
        	if(posx < 0)
        		posx = 0;
        	for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				GameView._diamonds[posx+i][j+posy] |= shape[i][j];
    			}
    	}
    	}
        public void RightGo(ShapeDiamond sd){
    	  int[][] shape = sd.GetShape();
    	  if(posx == GameView._diamonds.length -2)
    		  return;
  		  for (int i = 0; i < shape.length; i++) {
  			for (int j = 0; j < shape[i].length; j++) {
  				GameView._diamonds[posx+i][j+posy] = 0;
  			}
  		  }
      	  posx += 1;
      	  for (int i = 0; i < shape.length; i++) {
  			  for (int j = 0; j < shape[i].length; j++) {
  				GameView._diamonds[posx+i][j+posy] |= shape[i][j];
  			 }
         }
        }
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v == leftBtn)
				LeftGo(sd);
			else if (v == rightBtn)
				RightGo(sd);
		}
    }
    public void Calculate(ShapeDiamond sd){
    	
    	int[][] shape = sd.GetShape();
    	if(isNew){
        	for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				GameView._diamonds[posx+i][j+posy] |= shape[i][j];
    			}
    		}
        	posy++;
        	isNew = false;
    	}
    	else{
        	if ((posy == GameView._diamonds[0].length -shape[0].length - 1) || GameView._diamonds[posx][posy +shape[0].length - 1 ] == 1)
        	{
        		posy = 0;
        		isNew = true;
        		return;
        	}
    		for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				GameView._diamonds[posx+i][j+posy] = 0;
    			}
    		}
        	posy++;

        	for (int i = 0; i < shape.length; i++) {
    			for (int j = 0; j < shape[i].length; j++) {
    				GameView._diamonds[posx+i][j+posy] |= shape[i][j];
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
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    				
    	}
    }
    class ShapeDiamond {
    	private int[][] shape;
    	//public static boolean isNew = false;
    	public ShapeDiamond(int flag){
    		//shape = new int[2][4];
    		posx = GameView._diamonds.length / 2;
    		posy = 0;
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
