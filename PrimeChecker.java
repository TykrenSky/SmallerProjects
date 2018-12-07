import java.util.*;

public class PrimeChecker {
   public static long TESTNUM = 10;
   
   public static List<Long> prime = new ArrayList<Long>();
   
   private static Scanner scanner = new Scanner(System.in);
   
   public static boolean primality = true;
   
   public static void main(String[] args) {
      char tester = 'n';
      do {
         prime.clear();
         primality = true;
         System.out.print("What prime do you want to test? ");
         String input = scanner.nextLine();
         TESTNUM = Long.parseLong(input);
         String numst = String.valueOf(TESTNUM);
         boolean determined = false;
         if (numst.length() >= 9 || TESTNUM <= 0) {
            System.out.println("That number is either too big or is negative, sorry, it can't be more than 8 digits\nfor fear of CPU fires");
            System.out.print("Do you still want to try? ");
            String input3 = scanner.nextLine();
            if (input3.equals("Y") || input3.equals("y")) {
               determined = true;
            }
         }
         if ((numst.length() < 9 && TESTNUM > 0) || determined == true) {
            findPrimes(TESTNUM);
            if (primality == false) {
               System.out.println("That number is not prime... you punk. ");
               findPrimesf(TESTNUM);
               System.out.println();
            } else {
               System.out.println("EGGPLANT!");
            }
         } 
         System.out.println();
         System.out.print("Would you like to do another? ");
         String input2 = scanner.nextLine();
         tester = Character.toLowerCase(input2.charAt(0));
      } while (tester != 'n');
   }
   
   public static void findPrimes(long max) {
      for (int i = 2; i < max; i++) {
         if (primer(i) == true) {
            prime.add(Long.valueOf(i));
            //System.out.println(i);
            if (primer(max) == false) {
               primality  = false;
               break;
            }
         }
      }
   }
   
   public static boolean primer(long test) {
      boolean isPrime = true;
      for (int i = 0; i < prime.size(); i++) {
         if (test % prime.get(i) == 0) {
            isPrime = false;
            break;
         }
      }
      return isPrime;
   }
   
   public static void findPrimesf(long max) {
      long runningmax = max;
      List<Long> factors = new ArrayList<Long>();
      for (int i = 0; i < prime.size(); i++) {
         while (runningmax % prime.get(i) == 0) {
            factors.add(prime.get(i));
            runningmax /= prime.get(i);
            //System.out.print(prime.get(i) + " ");
         }
         if (runningmax == 1) {
            break;
         }
      }
      if (runningmax != 1) {
         for (long i = prime.get(prime.size() - 1) + 1; i <= runningmax; i++) {
            if (primer(i) == true) {
               prime.add(i);
               //System.out.println(i);
               if (primer(runningmax) == false) {
                  while (runningmax % i == 0) {
                     factors.add(i);
                     runningmax /= i;
                     //System.out.print(i + " ");
                  }
               }
            }
         }
      }
      List<Long> factorprint = new ArrayList<Long>();
      List<Integer> helper = new ArrayList<Integer>();
      int j = -1;
      System.out.println("Here are its factors: ");
      for (int i = 0; i < factors.size(); i++) {
         if (factorprint.contains(factors.get(i)) == false) {
            factorprint.add(factors.get(i));
            helper.add(1);
            j++;
         } else {
            helper.add(j, helper.get(j) + 1);
            helper.remove(j + 1);
         }
      }
      for (int i = 0; i < factorprint.size(); i++) {
         System.out.print(factorprint.get(i) + "^" + helper.get(i));
         if (i < (factorprint.size() - 1)) {
            System.out.print(" * ");
         }
      }  
   }
}