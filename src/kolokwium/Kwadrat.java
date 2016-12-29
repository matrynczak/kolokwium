package kolokwium;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Kwadrat {
	private int x;
	private int y;
	private Color kolor;
	private int lengthx;
	private int lengthy;
	int dy = 1;
	int dx = 1;
	
	public Kwadrat(Dimension d){
		Random rnd = new Random();
		x = rnd.nextInt(d.width - 35);
		y = rnd.nextInt(d.height - 35);
		kolor = Color.white;
		lengthx = 10 + rnd.nextInt(35);
		lengthy = lengthx;
	}
	
	public void rysuj(Graphics g){
		g.setColor(kolor);
		g.fillRect(x, y, lengthx, lengthy);
	}
	
	public void jakisRuch(){

		lengthx = lengthx - dx;
		lengthy = lengthy - dy;
			
		if(lengthy == 0) dy = -1;
		if(lengthx == 0) dx = -1;
		if(lengthy == 45) dy = 1;
		if(lengthx == 45) dx = 1;
	}
	
	public boolean zawiera(int mx, int my){
		int dist = (mx-x)*(mx -x) + (my-y)*(my-y);
		return dist < lengthx*lengthx;
	}
	
	public void zmienKolor(){
		Random rnd = new Random();
		kolor = new Color(rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
	}

}
