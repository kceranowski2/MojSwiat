import java.util.ArrayList;
import java.util.List;

public class TheWorld {

    static final int SIZE_OF_WORLD = 7;

    Organism[][][] world;
    Animal[] aliveAnimals;
    static int countOfAnimals = 0;
    Plant[] alivePlants;
    static int countOfPlants = 0;

    public TheWorld() {
        this.world = new Organism[SIZE_OF_WORLD][SIZE_OF_WORLD][2];
        for (int i = 0; i < SIZE_OF_WORLD; i++){
            for (int j = 0; j < SIZE_OF_WORLD; j++)
                for (int k = 0; k < 2; k++){
                this.world[i][j][k] = null;
            }
        }
        this.aliveAnimals = new Animal[SIZE_OF_WORLD * SIZE_OF_WORLD];
        this.alivePlants = new Plant[SIZE_OF_WORLD * SIZE_OF_WORLD];
    }

    public void dodaj(Organism org){
        if( org.getClass().getSuperclass() == Animal.class )
            if(this.world[org.getX()][org.getY()][1] == null) {
                this.world[org.getX()][org.getY()][1] = org;
                this.aliveAnimals[countOfAnimals] = (Animal)org;
                countOfAnimals++;
            }
            else throw new IllegalStateException("Próba wstawienia zwierzaczka na miejsce czegoś innego");
        else
        if( org.getClass().getSuperclass() == Plant.class )
            if (this.world[org.getX()][org.getY()][0] != null) {
                this.world[org.getX()][org.getY()][0] = org;
                this.alivePlants[countOfPlants] = (Plant)org;
                countOfPlants++;
            }
            else throw new IllegalStateException("Próba wstawienia rośliny na miejsce czegoś innego");

        else throw new IllegalStateException("Co za dziwny stwór chciał wejść na mapę?");


    }

    public void drukuj() {

        System.out.print("__|");
        for (int i = 0; i < SIZE_OF_WORLD; i++)
            System.out.print(i + ". ");
        System.out.println();

        for (int i = 0; i < SIZE_OF_WORLD; i++) {
            System.out.print(i + ". ");
            for (int j = 0; j < SIZE_OF_WORLD; j++) {
                for (int k = 0; k < 2; k++)
                    if(this.world[i][j][k] != null)
                        System.out.print(this.world[i][j][k].getSign());
                    else
                        System.out.print("_");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private void eraseLocation(Animal anim){
        this.world[anim.getX()][anim.getY()][1] = null;
    }

    public List<Position> possibleMoves (Animal anim) {
        List<Position> lista = new ArrayList<Position>();
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if ( anim.getX() + i >= 0 && anim.getY() + j >= 0 && anim.getX() + i < SIZE_OF_WORLD && anim.getY() + j < SIZE_OF_WORLD )
                    if ( this.world[anim.getX() + i][anim.getY() + j][1] == null )
                        lista.add(new Position(anim.getX() + i, anim.getY() + j));
        System.out.println(lista);
        return lista;
    }

    private void setLocation(Animal anim){
        this.world[anim.getX()][anim.getY()][1] = anim;
    }

    public void timeMovesAgain(){
        for (int i = 0; i < countOfAnimals; i++){
            eraseLocation(aliveAnimals[i]);
            aliveAnimals[i].takeAction();
            setLocation(aliveAnimals[i]);
        }
        this.drukuj();
    }

}

