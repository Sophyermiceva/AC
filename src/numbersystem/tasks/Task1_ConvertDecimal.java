package numbersystem.tasks;

import numbersystem.util.BaseConverter;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1_ConvertDecimal implements RunnableTask {

  @Override
  public void run(Scanner sc) {
    System.out.println("Task 1: Convert a natural number (decimal) to binary, octal, hexadecimal.");
    System.out.print("Enter a natural number (>= 0): ");

    String raw = sc.nextLine().trim();
    BigInteger n;
    try {
      n = new BigInteger(raw);
    } catch (Exception e) {
      System.out.println("Invalid decimal number.");
      return;
    }

    if (n.signum() < 0) {
      System.out.println("Expected a natural number (>= 0).");
      return;
    }

    String bin = BaseConverter.toBaseString(n, 2);
    String oct = BaseConverter.toBaseString(n, 8);
    String hex = BaseConverter.toBaseString(n, 16);

    System.out.println("Binary : " + bin);
    System.out.println("Octal : " + oct);
    System.out.println("Hexadecimal : " + hex);
  }
}
