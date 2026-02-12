package numbersystem.tasks;

import java.util.Scanner;

public class Task4_AsciiSum implements RunnableTask {

  @Override
  public void run(Scanner sc) {
    System.out.println("Task 4: Convert characters to decimal codes and compute the sum.");
    System.out.print("Enter a string: ");
    String s = sc.nextLine();

    long sum = 0;

    System.out.println("\nChar -> Code");
    System.out.println("------------");
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int code = (int) c; // UTF-16 code unit (ASCII is a subset: 0..127)
      sum += code;

      String printable = (c == '\n') ? "\\n"
          : (c == '\t') ? "\\t"
          : (c == '\r') ? "\\r"
          : Character.isWhitespace(c) ? ("(whitespace U+" + String.format("%04X", code) + ")")
          : String.valueOf(c);

      String note = (code <= 127) ? "" : " (not ASCII)";
      System.out.println("'" + printable + "' -> " + code + note);
    }

    System.out.println("\nSum of codes: " + sum);
  }
}
