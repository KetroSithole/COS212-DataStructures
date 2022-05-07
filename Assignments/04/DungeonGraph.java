/*
  Name:    Isheanesu Joseph Dzingirai
  Student Number:  u20536951
 */
import java.io.*;
import java.util.Scanner;


public class DungeonGraph {

    private Vertex[][] dungeon;
    private int rows;
    private int cols;
    private String final_path;

    /*
        =============================
        ===        TASK 1         ===
        =============================
     */

    // Constructor
    public DungeonGraph() {
        rows = 0;
        cols = 0;
        final_path = "";
        dungeon = null;
    }

    // Create a new graph to represent the given dungeon.
    public void createGraph(String filename) {
        // Get number of non-blank lines
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "", line_data;
        while (true){
            try {
                if ((line = reader.readLine()) == null)
                    break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            if(!"".equals(line.trim()))
                rows++;
        }

        // Store map dungeon in 2D char array
        dungeon = new Vertex[rows][];
        File file = new File(filename);
        Scanner sc = null;
        int x = 0;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line_data = sc.nextLine();
                if (line_data.length() != 0) {
                    this.cols = line_data.length();
                    dungeon[x] = new Vertex[line_data.length()];
                    for (int y=0;   y<line_data.length();       y++) {
                        dungeon[x][y] = new Vertex(x, y, line_data.charAt(y));
                    }
                    x++;
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Getter
    public Vertex getVertex(Integer row, Integer col) {
        return (row >= 0 && row < rows &&  col >= 0 && col < cols && dungeon[row][col].getSymbol() != '#') ? this.dungeon[row][col] : null;
    }

    // toString
    public String toString() {
        if (dungeon == null) return "";
        clear();
        DFS(getDoor());
        clear();
        return final_path.substring(0, final_path.length()-1);            
    }

    //  DFS
    public void DFS(Vertex start) {
        if (!start.isVisited) {
            start.isVisited = true;
            final_path += "(" + start.coords.row + "," + start.coords.col + "),";
            for (Vertex v : getAdjacentVertices(start))
                if (!v.isVisited) DFS(v);
        }
    }

    // Return the vertices adjacent to the given vertex. The vertices in the returned array must be sorted in the following order: left, top, right, bottom. Return an empty array if there are no adjacent vertices
    public Vertex[] getAdjacentVertices(Vertex vertex) {
        if (getVertex(vertex.coords.row, vertex.coords.col) != null) {
            int count = 0, index =0;
            if (vertex.coords.col-1 >= 0 && dungeon[vertex.coords.row][vertex.coords.col-1].getSymbol() != '#') count++;
            if (vertex.coords.row-1 >= 0 && dungeon[vertex.coords.row-1][vertex.coords.col].getSymbol() != '#') count++;
            if (vertex.coords.col+1 < cols && dungeon[vertex.coords.row][vertex.coords.col+1].getSymbol() != '#') count++;
            if (vertex.coords.row+1 < rows && dungeon[vertex.coords.row+1][vertex.coords.col].getSymbol() != '#') count++;
            if (dungeon[vertex.coords.row][vertex.coords.col].getSymbol() == '!') count++;

            Vertex [] adjacentV = new Vertex[count];
            if (vertex.coords.col-1 >= 0 && dungeon[vertex.coords.row][vertex.coords.col-1].getSymbol() != '#') adjacentV[index++] = dungeon[vertex.coords.row][vertex.coords.col-1];
            if (vertex.coords.row-1 >= 0 && dungeon[vertex.coords.row-1][vertex.coords.col].getSymbol() != '#') adjacentV[index++] = dungeon[vertex.coords.row-1][vertex.coords.col];
            if (vertex.coords.col+1 < cols && dungeon[vertex.coords.row][vertex.coords.col+1].getSymbol() != '#') adjacentV[index++] = dungeon[vertex.coords.row][vertex.coords.col+1];
            if (vertex.coords.row+1 < rows && dungeon[vertex.coords.row+1][vertex.coords.col].getSymbol() != '#') adjacentV[index++] = dungeon[vertex.coords.row+1][vertex.coords.col];
            if (vertex.getSymbol() == '!')
                adjacentV[index] = getVertex(getTeleports(vertex.coords).row, getTeleports(vertex.coords).col); 
            return adjacentV;
        }
        return new Vertex[0];
    }

    // Return the vertex corresponding to the dungeon entrance.
    public Vertex getDoor() {
        for (int x=0;   x<rows;     x++)
            for (int y=0;   y<cols;     y++)
                if (dungeon[x][y].getSymbol() == 'E')
                    return dungeon[x][y];
        return null;
    }

    // Return the vertex corresponding to the key tile.
    public Vertex getKey() {
        for (int x=0;   x<rows;     x++)
            for (int y=0;   y<cols;     y++)
                if (dungeon[x][y].getSymbol() == 'K')
                    return dungeon[x][y];
        return null;
    }

    // Return the vertex corresponding to the treasure tile.
    public Vertex getTreasure() {
        for (int x=0;   x<rows;     x++)
            for (int y=0;   y<cols;     y++)
                if (dungeon[x][y].getSymbol() == 'T')
                    return dungeon[x][y];
        return null;
    }




    /*
        =============================
        ===        TASK 2         ===
        =============================
     */ 

    // Clear
    public void clear() {
        for (int x=0;       x<rows;     x++)
            for (int y=0;   y<cols;     y++)
                this.dungeon[x][y].isVisited = false;
    }

    // Empty
    public boolean isEmpty(Vertex arr[]) {
        for (Vertex v : arr)
            if (v != null)
                return false;
        return true;
    }

    // contains
    public boolean contains(Vertex []arr, Vertex search) {
        for (Vertex v : arr)
            if (v.equals(search))
                return true;
        return false;

    }

    // Add Vertex
    public Vertex[] add(Vertex []arr, Vertex v) {
        Vertex []newArr = new Vertex[arr.length+1];
        int pos = 0;   
        for (Vertex u : arr)
            newArr[pos++] = u;
        newArr[pos] = v;
        return newArr;
    }

    public void addVertex(Vertex []arr, Vertex v) {
        if (arr.length - 1 >= 0) System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        arr[0] = v; 
    }

    // remove
    public Vertex[] remove(Vertex []arr) {
        arr[0] = null;
        int size = 0;
        for (Vertex vertex : arr)
            if (vertex != null)
                size++;

        Vertex []newArr = new Vertex[size];
        int pos = 0;
        for (Vertex v : arr)
            if (v != null)
                newArr[pos++] = v;
        return newArr;
    }

    public Coordinates getTeleports(Coordinates first) {
        for (int x=0;   x<rows;     x++)
            for (int y=0;   y<cols;     y++)
                if (dungeon[x][y].getSymbol() == '!' && !dungeon[x][y].coords.equals(first))
                    return dungeon[x][y].coords;
        return null;
    }

    //  getShortestPath with coordinates
    public Vertex[] getShortestPath(Coordinates start, Coordinates end) {
        if (getVertex(start.row, start.col) != null && getVertex(end.row, end.col) != null && getDoor() != null && getTreasure() != null && getKey() != null) {
            Vertex []toBeChecked = new Vertex[1];

            for (int x=0;   x<rows;     x++) {
                for (int y=0;   y<cols;     y++) {
                    if (dungeon[x][y].getSymbol() != '#') {
                        dungeon[x][y].distance = 50000;
                        dungeon[x][y].predecessor = null;
                    }
                }
            }

            Vertex startV = dungeon[start.row][start.col];
            startV.distance = 0;
            toBeChecked[0] = startV;

            while (!isEmpty(toBeChecked)) {
                Vertex curr = toBeChecked[0];
                toBeChecked = remove(toBeChecked);
                for (Vertex v : getAdjacentVertices(curr)) {
                    int weight = (v.getSymbol() == 'X' || curr.getSymbol() == 'X') ? 2 : 1;
                    int newDist = curr.distance + weight;
                    if (newDist < v.distance) {
                        v.distance = newDist;
                        v.predecessor = curr;

                        if (v.getSymbol() == '!') {
                            Coordinates other_teleport = getTeleports(v.coords);
                            Vertex teleport = getVertex(other_teleport.row, other_teleport.col);
                            if (!teleport.isVisited) {
                                teleport.isVisited = true;
                                if (teleport.distance > v.distance + 1) {
                                    teleport.distance = v.distance + 1;
                                    teleport.predecessor = v;
                                    toBeChecked = add(toBeChecked, teleport);
                                }
                            }
                        }
                        if (!contains(toBeChecked, v))
                            toBeChecked = add(toBeChecked, v);
                    }
                }                    
            }

            int count = 0;
            for (Vertex target=getVertex(end.row, end.col);     target != null;     target = target.predecessor)
                count++;

            Vertex []shortestPath = new Vertex[count];
            Vertex target = getVertex(end.row, end.col);

            while (target != null) {
                if(target != getVertex(start.row, start.col) && target.predecessor == null)
                    return new Vertex[0];
                addVertex(shortestPath, target);
                target = target.predecessor;
            }
            return shortestPath;
        }
        return new Vertex[0];
    }

    //  getShortestPath from Entrance, Key, Treasure, Key
    public Vertex[] getShortestPath() {
        if (getDoor() != null && getTreasure() != null && getKey() != null) {
            Vertex []E_to_K = getShortestPath(getDoor().coords, getKey().coords);
            Vertex []K_to_T = getShortestPath(getKey().coords, getTreasure().coords);
            Vertex []T_to_E = getShortestPath(getTreasure().coords, getDoor().coords);

            if (E_to_K.length !=0 && K_to_T.length != 0 && T_to_E.length != 0) {

                int arr_size = E_to_K.length + K_to_T.length - 1 + T_to_E.length - 1;
                Vertex[] shortestPath = new Vertex[arr_size];
                int counter = 0;
                for (Vertex v : E_to_K)
                    shortestPath[counter++] = v;
                for (Vertex v : K_to_T)
                    if (!v.equals(getKey())) shortestPath[counter++] = v;
                for (Vertex v : T_to_E)
                    if (!v.equals(getTreasure()))
                        shortestPath[counter++] = v;
                return shortestPath;
            }
        }
        return new Vertex[0];
    }

    //  getShortestPathLength with coordinates
    public Integer getShortestPathLength(Coordinates start, Coordinates end) {
        if (getVertex(start.row, start.col) != null && getVertex(end.row, end.col) != null) {
            Vertex []shortestPath = getShortestPath(start, end);
            return (shortestPath.length != 0) ? shortestPath[shortestPath.length-1].distance : null;
        }
        return null;
    }

    //  getShortestPathString with coordinates
    public String getShortestPathString(Coordinates start, Coordinates end) {
        if (getVertex(start.row, start.col) != null && getVertex(end.row, end.col) != null && getDoor() != null && getTreasure() != null && getKey() != null) {
            Vertex[] shortestPath = getShortestPath(start, end);
            if (shortestPath.length > 1) {
                StringBuilder path = new StringBuilder();
                for (int i = 0; i < shortestPath.length - 1; i++) {
                    if (i != shortestPath.length - 1) {
                        if (shortestPath[i].coords.col.equals(shortestPath[i+1].coords.col) && Math.abs(shortestPath[i].coords.row - shortestPath[i+1].coords.row) > 1) path.append("teleport, ");
                        else if (shortestPath[i].coords.row.equals(shortestPath[i+1].coords.row) && Math.abs(shortestPath[i].coords.col - shortestPath[i+1].coords.col) > 1) path.append("teleport, ");
                        else if (Math.abs(shortestPath[i].coords.row - shortestPath[i+1].coords.row) > 1 || Math.abs(shortestPath[i].coords.col - shortestPath[i+1].coords.col) > 1) path.append("teleport, ");
                        else if (shortestPath[i].coords.row.equals(shortestPath[i + 1].coords.row) && shortestPath[i].coords.col.compareTo(shortestPath[i + 1].coords.col) > 0) path.append("left, ");
                        else if (shortestPath[i].coords.row.equals(shortestPath[i + 1].coords.row) && shortestPath[i].coords.col.compareTo(shortestPath[i + 1].coords.col) < 0) path.append("right, ");
                        else if (shortestPath[i].coords.col.equals(shortestPath[i + 1].coords.col) && shortestPath[i].coords.row.compareTo(shortestPath[i + 1].coords.row) > 0) path.append("up, ");
                        else path.append("down, ");
                    }
                }
                return path.substring(0, path.length()-2) + ".";
            }
        }
        return "";
    }

    //  getShortestPathString from Entrance, Key, Treasure, Key
    public String getShortestPathString() {
        if (getDoor() != null && getTreasure() != null && getKey() != null) {
            Vertex []shortestPath = getShortestPath();
            if (shortestPath.length > 1) {
                String path = "";
                for (int i = 0; i < shortestPath.length - 1; i++) {
                    if (i != shortestPath.length - 1) {
                        if (shortestPath[i].coords.col.equals(shortestPath[i+1].coords.col) && Math.abs(shortestPath[i].coords.row - shortestPath[i+1].coords.row) > 1) path += "teleport, ";
                            else if (shortestPath[i].coords.row.equals(shortestPath[i+1].coords.row) && Math.abs(shortestPath[i].coords.col - shortestPath[i+1].coords.col) > 1) path += "teleport, ";
                            else if (Math.abs(shortestPath[i].coords.row - shortestPath[i+1].coords.row) > 1 || Math.abs(shortestPath[i].coords.col - shortestPath[i+1].coords.col) > 1) path += "teleport, ";
                            else if (shortestPath[i].coords.row.equals(shortestPath[i + 1].coords.row) && shortestPath[i].coords.col.compareTo(shortestPath[i + 1].coords.col) > 0) path += "left, ";
                            else if (shortestPath[i].coords.row.equals(shortestPath[i + 1].coords.row) && shortestPath[i].coords.col.compareTo(shortestPath[i + 1].coords.col) < 0) path += "right, ";
                            else if (shortestPath[i].coords.col.equals(shortestPath[i + 1].coords.col) && shortestPath[i].coords.row.compareTo(shortestPath[i + 1].coords.row) > 0) path += "up, ";
                            else path += "down, ";
                    }
                }
                return path.substring(0, path.length()-2) + ".";
            }
        }
        return "";
    }
    /*
      =============================
      ===        TASK 3         ===
      =============================
     */

    /*
      No additional methods need to be implemented, but you must expand your code to work with traps and teleports.
     */

}