public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    protected double distance(Position other) {
        return Math.sqrt(Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2));
    }

    public boolean equals(Position other) {
        return ((this.x == other.x) && (this.y == other.y));
    }


    @Override
    public String toString() {
        return "\n[x] " + this.x + " [y] " + this.y;
    }
}
