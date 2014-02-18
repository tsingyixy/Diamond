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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn = (Button)findViewById(R.id.button1);
        rightBtn = (Button)findViewById(R.id.button2);
        transBtn = (Button)findViewById(R.id.button3);
        gv = (GameView)findViewById(R.id.gameView1);
        
    }

    class ShapeDiamond {
    	private int 
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
