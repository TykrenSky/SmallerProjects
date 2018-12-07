import java.util.*;

public class Queens {
   public static void main(String[] args) {
      for (int[] place : solve().get(0)) {
         System.out.print("(" + place[0] + ", " + place[1] + ") ");
      }
   }
   
   public static List<List<int[]>> solve(){
      List<List<int[]>> solutions = new ArrayList<List<int[]>>();
      explore(new ArrayList<int[]>(), solutions);
      return solutions;
   }
   
   public static void explore(List<int[]> places, List<List<int[]>> solutions) {
      if (places.size() == 8) {
         solutions.add(places);
      } else {
         for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               if (!threatened(row, col, places)) {
                  List<int[]> newPlaces = new ArrayList<int[]>(places);
                  newPlaces.add(new int[]{row, col});
                  explore(newPlaces, solutions);
               }
            }
         }
      }
   }
   
   public static boolean threatened(int row, int col, List<int[]> places) {
      for (int[] place : places) {
         if (row == place[0]) {
            return true;
         }
         if (col == place[1]) {
            return true;
         }
         if (Math.abs(row - place[0]) == Math.abs(col - place[1])) {
            return true;
         }
      }
      return false;
   }
}