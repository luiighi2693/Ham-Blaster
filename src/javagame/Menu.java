package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	Image playNow;
	Image exitGame;
	
	String t="";
	String mouse="";
	
	public Menu(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		playNow= new Image("res/playgame.png");
		exitGame= new Image("res/Exit.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("welcome to bucky land!", 50, 50);
		
		this.playNow.draw(100,100);
		this.exitGame.draw(100,200);
		//auxiliares
		g.drawString(t, 100, 300);
		g.drawString(mouse, 100, 330);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ 
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		mouse= posX + "  " + posY;
		//play now
		if(posX>100&&posX<212&&posY>217&&posY<261){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
		
		if(posX>100&&posX<212&&posY>119&&posY<161){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
	}
	
	public int getID(){
		return 0;
	}
}
