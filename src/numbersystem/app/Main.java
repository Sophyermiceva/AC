package numbersystem.app;

import numbersystem.tasks.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Map<Integer, RunnableTask> tasks = new LinkedHashMap<>();
    tasks.put(1, new Task1_ConvertDecimal());
    tasks.put(2, new Task2_BasePToDecimal());
    tasks.put(3, new Task3_BasePToBaseQ());
    tasks.put(4, new Task4_AsciiSum());

    try (Scanner sc = new Scanner(System.in)) {
      while (true) {
        printMenu();
        String choiceRaw = sc.nextLine().trim();

        if (choiceRaw.equalsIgnoreCase("0") || choiceRaw.equalsIgnoreCase("exit")) {
          System.out.println("Bye!");
          return;
        }

        int choice;
        try {
          choice = Integer.parseInt(choiceRaw);
        } catch (NumberFormatException e) {
          System.out.println("Invalid choice. Enter 1..4 or 0 to exit.\n");
          continue;
        }

        RunnableTask task = tasks.get(choice);
        if (task == null) {
          System.out.println("No such option. Enter 1..4 or 0 to exit.\n");
          continue;
        }

        System.out.println();
        task.run(sc);
        System.out.println();
      }
    }
  }

  private static void printMenu() {
    System.out.println("Number System Tasks ");
    System.out.println("1) Decimal -> Binary/Octal/Hex");
    System.out.println("2) Base p -> Decimal");
    System.out.println("3) Base p -> Base q");
    System.out.println("4) ASCII codes + Sum of string");
    System.out.println("0) Exit");
    System.out.print("Choose: ");
  }
}
