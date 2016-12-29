package kolokwium;

import java.applet.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Kolokwium extends Applet {
	
	Random rnd = new Random();
	private static final long serialVersionUID = 1L;
	//private Kwadrat square;//
	ArrayList<Kwadrat> square; 
//	private Kwadrat[] square;
	private int N = 3 + rnd.nextInt(10);
	
	@Override
	public void init() {
		setBackground(Color.blue);
		setSize(500,500);
		Dimension d = getSize();
//		square = new Kwadrat[N];
		square = new ArrayList();
		Iterator<Kwadrat> it = square.iterator(); 
		for (int i=0; i<N; i++)
//			square[i] = new Kwadrat(d);
			square.add(new Kwadrat(d));
		
		addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1){
					square.add(new Kwadrat(d));
				}
				if(e.getButton() == MouseEvent.BUTTON3){
					square.removeAll(square);
				}
				if(e.getButton() == MouseEvent.BUTTON2){
					for(Kwadrat kwadrat : square){
						if(kwadrat.zawiera(e.getX(), e.getY()))
							kwadrat.zmienKolor();
					}
				}
			}
			
		});
		
		
		class Animacja extends TimerTask {

			@Override
			public void run() {
				for (Kwadrat kwadrat : square)
					kwadrat.jakisRuch();
				repaint();
			}
		}
		
		Timer go = new Timer();
		go.schedule(new Animacja(), 500, 50);
	}

	

	@Override
	public void paint(Graphics g) {
		for (Kwadrat kwadrat : square)
			kwadrat.rysuj(g);
	}

}
