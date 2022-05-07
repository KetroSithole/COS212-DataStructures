/**
 * Name:    Isheanesu Joseph Dzingirai
 * Student Number:  u20536951
 */

public class Vertex {
   
    public Coordinates coords;
    public boolean isVisited;
    private char s;
    public int distance;
    public Vertex predecessor;
    
    public Vertex() { }

    public Vertex (Integer row, Integer col, char s) {
        coords = new Coordinates(row, col);
        isVisited = false;
        this.s = s;
        predecessor = null;
    }

    public char getSymbol() {
        return s;
    }
}
