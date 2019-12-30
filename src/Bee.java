import java.awt.image.BufferedImage;

public class Bee extends FlyingObject {
	private int xStep; 
	private int yStep; 
	private int awardType; 
	public static int DOUBLE_FIRE = 0;
	public static int LIFE = 1;
	
	public Bee(){
		width = 60;
		height = 51;
		x = (int)(Math.random()*(World.WIDTH-this.width));
		y = -this.height;
		xStep = 1;
		yStep = 2;
		awardType = (int)(Math.random()*2);
	}
	
	
	public void step(){
		x+=xStep;
		y+=yStep;
		if(x>=World.WIDTH-this.width || x<=0){
			xStep*=-1;
		}
	}

	int deadIndex = 1;
	public BufferedImage getImage(){
		if(isLife()){
			return Images.bees[0];
		}else if(isDead()){
			BufferedImage img = Images.bees[deadIndex++];
			if(deadIndex==Images.bees.length){
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
	
	public int getType(){
		return awardType;
	}
	
	public boolean outOfBounds(){
		return this.y>=World.HEIGHT;
	}
}




