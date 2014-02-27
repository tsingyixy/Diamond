package com.example.russiandiamond;

import java.util.ArrayList;
import java.util.List;

public class Diamond {
    public int x;
    public int y;
	public Diamond() {
        this.x = 0;
        this.y = 0;
	}
    public Diamond(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class ShapeDiamond{
    public List<Diamond> diamonds;
	public int LeftMove(){ 
		for(Diamond d :diamonds)
			d.x -= 1;
		return 0;
		
	}
	public int RightMove(){
		for(Diamond d :diamonds)
			d.x += 1;
		return 0;
	}
    public int Transformation(){
    	return 0;
    }
    public int Accerlate(){           //down more quickly
    	return 0;
    }
    public void Down(int step){
    	for(Diamond d : diamonds)
    		d.y += step;
    }
    public void update(){
    	this.Down(1);
    }
}
class World{
	public List<Diamond> diamonds;
	private ShapeDiamond shape;
	private int sum[];
	//private boolean isNew;
	public World(){
		this.diamonds = new ArrayList<Diamond>();
		shape = new ShapeDiamond();
		sum = new int[20];
		//isNew = false;
	}
	public void update(){
		for(Diamond d :shape.diamonds){
			d.y += 1;
			if (diamonds.contains(d))
				{
                    d.y -= 1;				    
				    diamonds.addAll(shape.diamonds);
				    shape = new ShapeDiamond();
				    //isNew = true;
				    break;
				}
			else
				d.y -= 1;
		}
		//if (!isNew)
		    shape.update();

        for (Diamond d:diamonds) {
			sum[ d.y ] ++;
		}
        for (int i = 0; i < sum.length; i++) {
			if (sum[i] == 16)
				for(int j = 0 ; j < diamonds.size() ; ++j)
					if(diamonds.get(j).y == i)
						diamonds.remove(j);
					else if(diamonds.get(j).y < i)
						diamonds.get(j).y += 1;
		}
	}
}

