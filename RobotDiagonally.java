import java.util.Random;


/**
 * Write a description of class RobotDiagonally here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RobotDiagonally extends Robot
{
    // instance variables - replace the example below with your own
    private String colourBody = "YELLOW";
    private CanvasRobot canvasRobot;
    private Canvas canvas;
    private int xPosition;
    private int yPosition;
    private Random random;
    private boolean isAlive = true;
    private static final int MIN_POSITION = 2;
    private static final int MAX_POSITION = 9;
     
    /**
     * Constructor for objects of class RobotDiagonally
     */
    public RobotDiagonally (String name)
    {
        // initialise instance variables
        this.xPosition = 3;
        this.yPosition = 4;
        canvasRobot = new CanvasRobot(colourBody);
        this.random = new Random();
        draw();
    }
    
    public int getXPosition(){
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    protected boolean setYPosition(int y)
    {
        if ((MIN_POSITION<=y && y<=MAX_POSITION))
        {
            yPosition = y;
            this.canvasRobot.drawRobot(xPosition, yPosition);
            return true;
        }
        return false;
    }
    
    protected boolean setXPosition(int x)
    {
        if ((MIN_POSITION<=x && x<=MAX_POSITION))
        {
            xPosition = x;
            this.canvasRobot.drawRobot(xPosition, yPosition);
            return true;
        }
        else {return false;}
    }
    
    private void draw(){
        canvasRobot.drawRobot(this.xPosition, this.yPosition);
    }
    
    private void moveNE(){
        int distance = getRandomDistance();
        this.setXPosition(getXPosition() + distance);
        this.setYPosition (getYPosition() - distance);
    }
        
    private void moveSE(){
        int distance = getRandomDistance();
        this.setXPosition(getXPosition() + distance);
        this.setYPosition (getYPosition() + distance);
    }
    
    private void moveNO(){        
        int distance = getRandomDistance();
        this.setXPosition(getXPosition() - distance);
        this.setYPosition (getYPosition() - distance);
    }
    
    private void moveSO(){
        int distance = getRandomDistance();
        this.setXPosition(getXPosition() - distance);
        this.setYPosition (getYPosition() + distance);
    }
    
    enum Direction {
        NE, // Nord-Est
        SE, // Sud-Est
        NO, // Nord-Ouest
        SO  // Sud-Ouest
    }
    
    private Direction genererDirectionAleatoire() {
        Direction[] directions = Direction.values();
        int index = random.nextInt(directions.length); 
        return directions[index];
    }
    
    /*public void moveRandom(){
        Direction direction = genererDirectionAleatoire();
            if((this.xPosition >= 3 || this.xPosition <= 8) && (this.yPosition >= 3 || this.yPosition <= 8)){ 
            switch(direction){
                case NE : 
                    moveNE();
                    break;
                case SE :
                    moveSE();
                    break;
                case NO :
                    moveNO();
                    break;
                case SO :
                    moveSO();
                    break;}
        }
    }*/
    
    public void moveRandom(){
        Random rand = new Random();
        Direction direction = genererDirectionAleatoire();
        switch (direction) {
            case NE:
                moveNE();
                break;
            case SE:
                moveSE();
                break;
            case NO:
                moveNO();
                break;
            case SO:
                moveSO();
                break;      
            }
    }
    
    private void clearOldPosition() {
        // Effacer l'ancienne position du robot
        canvasRobot.drawRobot(xPosition, yPosition); // Redessiner l'ancienne position pour la nettoyer
    }
    
    private int getRandomDistance(){
        // Choisir une distance aléatoire (entre 1 et 3)
        Random rand = new Random();
        return rand.nextInt(2) + 1; 
    }
}