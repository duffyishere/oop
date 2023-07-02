package org.duffy.game_of_life;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public Pair getNewMovedPair(int nx, int ny) {
        return new Pair(this.x + nx, this.y + ny);
    }

    public boolean isValid(int widthMaxValue, int heightMaxValue) {
        return 0 <= this.x
                && 0 <= this.y
                && this.x < widthMaxValue
                && this.y < heightMaxValue;
    }
}
