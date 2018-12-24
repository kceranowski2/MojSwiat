import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        TankEngine Gogol = new TankEngine('G',"Thomas", 0, 0, 50, 1, 0, 5, 10);

        TankEngine thomas = new TankEngine('T',"Thomas", 3, 3, 50, 1, 0, 5, 10);
//        for (int i = 0; i<= 10; i++) {
//            thomas.wander();
//            System.out.println(thomas);
//            thomas.getHungry();
//        }

//        System.out.println( thomas.getClass().getSuperclass() == Animal.class) ;

        TheWorld Ziemia = new TheWorld();
        Ziemia.drukuj();
        Ziemia.dodaj(thomas);
        Ziemia.dodaj(Gogol);
        Ziemia.drukuj();
//        Ziemia.timeMovesAgain();
//        Ziemia.possibleMoves(Gogol);
//        Ziemia.timeMovesAgain();
        Ziemia.possibleMoves(Gogol);
    }
}
