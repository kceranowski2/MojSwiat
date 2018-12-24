import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Animal extends Organism {
    private int speed;
    private int hunger;
    private int eyesight;
    private int bleeding;

    public Animal(char sign, String name, int x, int y, int lifespan, int initiative, int speed, int hunger, int eyesight) {
        super(sign, name, x, y, lifespan, initiative);
        this.speed = speed;
        this.hunger = hunger;
        this.eyesight = eyesight;
        this.bleeding = 0;
    }

    private void die(){

    }

    private void wander(){
        Random rand = new Random();
        setX(getX() + rand.nextInt(3 + 2 * speed) - 1 - speed);
        setY(getY() + rand.nextInt(3 + 2 * speed) - 1 - speed);
    }


    private void getHungry() {
        this.hunger -= 1;
    }


    private boolean didSurvive() {
        if(this.hunger <= 0)
            return false;
        if(bleeding > 0){
            //Max bleeding = 7
            Random rand = new Random();
            if( bleeding + rand.nextInt(8) >= 8 )
                return false;
        }
        return true;
    }

//TODO
    private boolean isInDanger(){
        return false;
    }

    private boolean isHungry(){
        return false;
    }

    private boolean isHorny(){
        return false;
    }

    protected void takeAction(){

        if(didSurvive()) {
            if (isInDanger()) ;

            else if (isHungry()) ;

            else if (isHorny()) ;

            else
                wander();

            getHungry();
        }
        else die();
    }


    @Override
    public String toString() {
        return  super.toString() +
                "\n[speed] " + speed +
                "\n[hunger] " + hunger;
    }



}
