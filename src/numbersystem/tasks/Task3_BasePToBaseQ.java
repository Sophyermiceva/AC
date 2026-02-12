package numbersystem.tasks;

import numbersystem.util.BaseConverter;

import java.math.BigInteger;
import java.util.Scanner;

public class Task3_BasePToBaseQ implements RunnableTask {

  @Override
  public void run(Scanner sc) {
    System.out.println("Task 3: Convert an integer from base p to base q.");

    System.out.print("Enter base p (2..36): ");
    int p;
    try {
      p = Integer.parseInt(sc.nextLine().trim());
      BaseConverter.validateBase(p);
    } catch (Exception e) {
      System.out.println("Invalid base p.");
      return;
    }

    System.out.print("Enter base q (2..36): ");
    int q;
    try {
      q = Integer.parseInt(sc.nextLine().trim());
      BaseConverter.validateBase(q);
    } catch (Exception e) {
      System.out.println("Invalid base q.");
      return;
    }

    System.out.print("Enter the number in base " + p + " (digits 0-9, A-Z): ");
    String digits = sc.nextLine().trim();

    try {
      BigInteger value = BaseConverter.parseToBigInteger(digits, p);
      String out = BaseConverter.toBaseString(value, q);
      System.out.println("Result in base " + q + ": " + out);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
