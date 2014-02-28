package com.example.russiandiamond;

import android.graphics.Rect;

public class Screen {
	public int update(){
		return 0;
	}
	public int present(){
		return 0;
	}
}
class LoadingScreen extends Screen{
	private Graphics g;
	public static Rect screen;
	public LoadingScreen(Game game){
		super();
		g = game.getGraphics();
		Asset.bgImage = new Image("bgIamge path");
		Asset.diamondImage = new Image("diamondIamge path");
		Asset.loadingImage = new Image("loadingImage path");
		Asset.mainImage = new Image("bgImage path");
	}
	public int update(){
		return 0;
	}
	public int present(){
		g.DrawImage(Asset.loadingImage, screen);
		return 0;
	}
}
class MainScreen extends Screen{
	
}
class GameScreen extends Screen{
	
}
class EndScreen extends Screen{
	
}
