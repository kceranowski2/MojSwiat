abstract public class Organism extends Position{
    private String name;
    private int lifespan;
    private int initiative;
//    rośliny 0
//    roślinożercy 1
//    mięsożercy 2
//    dzieci mają największe, potem zmniejsza się przy 33% życia i 66% życia

    private char sign;

    public Organism(char sign, String name, int x, int y, int lifespan, int initiative) {
        super(x, y);
        this.name = name;
        this.sign = sign;
        this.lifespan = lifespan;
        this.initiative = initiative;
    }

    public char getSign() {
        return sign;
    }


    @Override
    public String toString() {
        return "\n[Name] " + name +
                super.toString();
    }


}