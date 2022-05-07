// Name: Isheanesu Joseph Dzingirai
// Student Number: u20536951

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String... args) {
        System.out.println(ANSI_RED + "===Task 1: Tests===" + ANSI_RESET);
       System.out.println(ANSI_GREEN + "Dungeon 1" + ANSI_RESET);
       DungeonGraph dung1 = new DungeonGraph();
       dung1.createGraph("dung1.txt");
       System.out.println("-Door coordinates: (" + dung1.getDoor().coords.row + "," + dung1.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung1.getTreasure().coords.row + "," + dung1.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung1.getKey().coords.row + "," + dung1.getKey().coords.col + ")");
       System.out.println("-Path: " + dung1.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 2" + ANSI_RESET);
       DungeonGraph dung2 = new DungeonGraph();
       dung2.createGraph("dung2.txt");
       System.out.println("-Door coordinates: (" + dung2.getDoor().coords.row + "," + dung2.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung2.getTreasure().coords.row + "," + dung2.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung2.getKey().coords.row + "," + dung2.getKey().coords.col + ")");
       System.out.println(dung2.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 3" + ANSI_RESET);
       DungeonGraph dung3 = new DungeonGraph();
       dung3.createGraph("dung3.txt");
       System.out.println("-Door coordinates: (" + dung3.getDoor().coords.row + "," + dung3.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung3.getTreasure().coords.row + "," + dung3.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung3.getKey().coords.row + "," + dung3.getKey().coords.col + ")");
       System.out.println("-Path: " + dung3.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 4" + ANSI_RESET);
       DungeonGraph dung4 = new DungeonGraph();
       dung4.createGraph("dung4.txt");
       System.out.println("-Door coordinates: (" + dung4.getDoor().coords.row + "," + dung4.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung4.getTreasure().coords.row + "," + dung4.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung4.getKey().coords.row + "," + dung4.getKey().coords.col + ")");
       System.out.println("-Path: " + dung4.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 5" + ANSI_RESET);
       DungeonGraph dung5 = new DungeonGraph();
       dung5.createGraph("dung5.txt");
       System.out.println("-Door coordinates: (" + dung5.getDoor().coords.row + "," + dung5.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung5.getTreasure().coords.row + "," + dung5.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung5.getKey().coords.row + "," + dung5.getKey().coords.col + ")");
       System.out.println("-Path: " + dung5.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 6" + ANSI_RESET);
       DungeonGraph dung6 = new DungeonGraph();
       dung6.createGraph("dung6.txt");
       System.out.println("-Door coordinates: (" + dung6.getDoor().coords.row + "," + dung6.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung6.getTreasure().coords.row + "," + dung6.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung6.getKey().coords.row + "," + dung6.getKey().coords.col + ")");
       System.out.println("-Path: " + dung6.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 7" + ANSI_RESET);
       DungeonGraph dung7 = new DungeonGraph();
       dung7.createGraph("dung7.txt");
       System.out.println("-Door coordinates: (" + dung7.getDoor().coords.row + "," + dung7.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung7.getTreasure().coords.row + "," + dung7.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung7.getKey().coords.row + "," + dung7.getKey().coords.col + ")");
       System.out.println("-Path: " + dung7.toString());

       System.out.println(ANSI_GREEN + "\nDungeon 8" + ANSI_RESET);
       DungeonGraph dung8 = new DungeonGraph();
       dung8.createGraph("dung8.txt");
       System.out.println("-Door coordinates: (" + dung8.getDoor().coords.row + "," + dung8.getDoor().coords.col + ")");
       System.out.println("-Treasure coordinates: (" + dung8.getTreasure().coords.row + "," + dung8.getTreasure().coords.col + ")");
       System.out.println("-Key coordinates: (" + dung8.getKey().coords.row + "," + dung8.getKey().coords.col + ")");
       System.out.println("-Path: " + dung8.toString());




       System.out.println(ANSI_RED + "\n\n\n===Task 2: Tests===" + ANSI_RESET);

       System.out.println(ANSI_GREEN + "Dungeon 1" + ANSI_RESET);
       Vertex []dung1_sp_coords = dung1.getShortestPath(dung1.getKey().coords, dung1.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung1_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung1_sp = dung1.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung1_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung1.getShortestPathLength(dung1.getDoor().coords, dung1.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung1.getShortestPathString(dung1.getDoor().coords, dung1.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung1.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 2" + ANSI_RESET);
       Vertex []dung2_sp_coords = dung2.getShortestPath(dung2.getKey().coords, dung2.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung2_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung2_sp = dung2.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung2_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung2.getShortestPathLength(dung2.getDoor().coords, dung2.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung2.getShortestPathString(dung2.getDoor().coords, dung2.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung2.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 3" + ANSI_RESET);
       Vertex []dung3_sp_coords = dung3.getShortestPath(dung3.getKey().coords, dung3.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung3_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung3_sp = dung3.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung3_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung3.getShortestPathLength(dung3.getDoor().coords, dung3.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung3.getShortestPathString(dung3.getDoor().coords, dung3.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung3.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 4" + ANSI_RESET);
       Vertex []dung4_sp_coords = dung4.getShortestPath(dung4.getKey().coords, dung4.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung4_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung4_sp = dung4.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung4_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung4.getShortestPathLength(dung4.getDoor().coords, dung4.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung4.getShortestPathString(dung4.getDoor().coords, dung4.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung4.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 5" + ANSI_RESET);
       Vertex []dung5_sp_coords = dung5.getShortestPath(dung5.getKey().coords, dung5.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung5_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung5_sp = dung5.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung5_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung5.getShortestPathLength(dung5.getDoor().coords, dung5.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung5.getShortestPathString(dung5.getDoor().coords, dung5.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung5.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 6" + ANSI_RESET);
       Vertex []dung6_sp_coords = dung6.getShortestPath(dung6.getKey().coords, dung6.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung6_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung6_sp = dung6.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung6_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung6.getShortestPathLength(dung6.getDoor().coords, dung6.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung6.getShortestPathString(dung6.getDoor().coords, dung6.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung6.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 7" + ANSI_RESET);
       Vertex []dung7_sp_coords = dung7.getShortestPath(dung7.getKey().coords, dung7.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung7_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung7_sp = dung7.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung7_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung7.getShortestPathLength(dung7.getDoor().coords, dung7.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung7.getShortestPathString(dung7.getDoor().coords, dung7.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung7.getShortestPathString());        // 5


       System.out.println(ANSI_GREEN + "\nDungeon 2" + ANSI_RESET);
       Vertex []dung8_sp_coords = dung8.getShortestPath(dung8.getKey().coords, dung8.getTreasure().coords);
       System.out.print("-getShortestPath with coords: ");              // 1
       for (Vertex v : dung8_sp_coords)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       Vertex []dung8_sp = dung8.getShortestPath();                    // 2
       System.out.print("-getShortestPath from E-K-T-E: ");
       for (Vertex v : dung8_sp)
           System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
       System.out.println();

       System.out.println("-getShortestPathLength with coords: " + dung8.getShortestPathLength(dung8.getDoor().coords, dung8.getKey().coords));        // 3
       System.out.println("-getShortestPathString with coords: " + dung8.getShortestPathString(dung8.getDoor().coords, dung8.getKey().coords));        // 4
       System.out.println("-getShortestPathString: " + dung8.getShortestPathString());        // 5

        System.out.println(ANSI_RED + "\n\n\n===Task 3: Tests===" + ANSI_RESET);

        System.out.println(ANSI_GREEN + "Dungeon 9" + ANSI_RESET);
        DungeonGraph dung9 = new DungeonGraph();
        dung9.createGraph("dung9.txt");
        Vertex []shortestPath = dung9.getShortestPath(dung9.getDoor().coords, dung9.getKey().coords);
        System.out.print("-getShortestPath with coords: ");              // 1
        for (Vertex v : shortestPath)
            System.out.print("(" + v.coords.row + "," + v.coords.col + ")");
        System.out.println();
        
        System.out.println(dung9.getShortestPathLength(dung9.getDoor().coords, dung9.getKey().coords));

    }
}