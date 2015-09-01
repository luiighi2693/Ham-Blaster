package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{

	Animation bucky, movingUp, movingDown, movingLeft, movingRight; 
	Image worldMap;
	boolean quit= false;
	int[] duration= {200,200}; 
	float buckyPositionX= 0;
	float buckyPositionY= 0;
	float shiftX = buckyPositionX+360;
	float shiftY = buckyPositionY+160;
	
	public Play(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		this.worldMap = new Image("res/world.png");
		//1 front, 2 back, 3 left, 4 right
		Image[] walkUp = {new Image("res/2.png"), new Image("res/2.png")};
		Image[] walkDown = {new Image("res/1.png"), new Image("res/1.png")};
		Image[] walkLeft = {new Image("res/3.png"), new Image("res/3.png")};
		Image[] walkRight = {new Image("res/4.png"), new Image("res/4.png")};
		
		this.movingUp = new Animation(walkUp, duration, false);
		this.movingDown = new Animation(walkDown, duration, false);
		this.movingLeft = new Animation(walkLeft, duration, false);
		this.movingRight = new Animation(walkRight, duration, false);
		
		this.bucky = movingDown;
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		this.worldMap.draw(this.buckyPositionX, this.buckyPositionY);
		this.bucky.draw(this.shiftX, this.shiftY);
		g.drawString("Buckys x: " + this.buckyPositionX+ "\nBuckys y: " + this.buckyPositionY, 400, 2);
		
		if(quit==true){
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
			if(this.quit==false){
				g.clear();
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{ 
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)){
			this.bucky = this.movingUp;
			this.buckyPositionY+= delta*.1f;
			if(this.buckyPositionY>157){
				this.buckyPositionY -= delta*.1f;
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			this.bucky = this.movingDown;
			this.buckyPositionY-= delta*.1f;
			if(this.buckyPositionY<-300){
				this.buckyPositionY += delta*.1f;
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			this.bucky = this.movingLeft;
			this.buckyPositionX+= delta*.1f;
			if(this.buckyPositionX>354){
				this.buckyPositionX -= delta*.1f;
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			this.bucky = this.movingRight;
			this.buckyPositionX-= delta*.1f;
			if(this.buckyPositionX<-296){
				this.buckyPositionX += delta*.1f;
			}
		}
		
		//escape
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit=true;
		}
		
		//when the menu is true
		if(quit==true){
			if(input.isKeyDown(Input.KEY_R)){
				quit=false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
		}
	}
	
	public int getID(){
		return 1;
	}
}
