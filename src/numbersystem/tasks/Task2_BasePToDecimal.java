package numbersystem.tasks;

import numbersystem.util.BaseConverter;

import java.math.BigInteger;
import java.util.Scanner;

public class Task2_BasePToDecimal implements RunnableTask {

  @Override
  public void run(Scanner sc) {
    System.out.println("Task 2: Convert a number from base p to decimal.");
    System.out.print("Enter base p (2..36): ");
    String baseRaw = sc.nextLine().trim();

    int p;
    try {
      p = Integer.parseInt(baseRaw);
      BaseConverter.validateBase(p);
    } catch (Exception e) {
      System.out.println("Invalid base. Must be 2..36.");
      return;
    }

    System.out.print("Enter the number in base " + p + " (digits 0-9, A-Z): ");
    String digits = sc.nextLine().trim();

    try {
      BigInteger value = BaseConverter.parseToBigInteger(digits, p);
      System.out.println("Decimal: " + value.toString());
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
