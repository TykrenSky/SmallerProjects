import java.util.*;

public class Virus {
   public static void main(String[] args) {
      solve();
   }
   
   public static void solve() {
      Map<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
      for (int x = 0; x < 4; x++) {
         for (int y = 0; y < 4; y++) {
            map.put((x * 10) + y, true);
         }
      }
      explore(0, 3, "", map);
   }
   
   public static void explore(int x, int y, String path, Map<Integer, Boolean> map) {
      if (map.get((x*10) + y)) {
         map.put((x*10)+y, false);
         if (y > 0) {
            explore(x, y - 1, path + "N ", map);
         }
         if (x < 3) {
            explore(x + 1, y, path + "E ", map);
         }
         if (y < 3) {
            explore(x, y + 1, path + "S ", map);
         }
         if (x > 0) {
            explore(x - 1, y, path + "W ", map);
         }
         
         if (x == 3 && y == 3 && solved(map)) {
            System.out.println(path);
            System.exit(1);
         }
         
         System.out.println(path + "FAIL");
         
         map.put((x*10)+y, true);
      }
   }
   
   public static boolean solved(Map<Integer, Boolean> map) {
      boolean solved = !map.values().stream().reduce(false, (a, b) -> a || b);
      return solved;
   }
}