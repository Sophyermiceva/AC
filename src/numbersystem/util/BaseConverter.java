package numbersystem.util;

import java.math.BigInteger;

public final class BaseConverter {
  private BaseConverter() {}

  public static void validateBase(int base) {
    if (base < 2 || base > 36) {
      throw new IllegalArgumentException("Base must be in range [2..36].");
    }
  }

  public static BigInteger parseToBigInteger(String digits, int base) {
    validateBase(base);
    if (digits == null) throw new IllegalArgumentException("Number is null.");

    String s = digits.trim();
    if (s.isEmpty()) throw new IllegalArgumentException("Empty number.");

    // Optional leading sign
    boolean negative = false;
    int i = 0;
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      negative = (s.charAt(0) == '-');
      i = 1;
      if (i >= s.length()) throw new IllegalArgumentException("No digits after sign.");
    }

    BigInteger result = BigInteger.ZERO;
    BigInteger b = BigInteger.valueOf(base);

    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      int val = digitValue(c);
      if (val < 0 || val >= base) {
        throw new IllegalArgumentException("Invalid digit '" + c + "' for base " + base + ".");
      }
      result = result.multiply(b).add(BigInteger.valueOf(val));
    }

    return negative ? result.negate() : result;
  }

  public static String toBaseString(BigInteger value, int base) {
    validateBase(base);
    if (value == null) throw new IllegalArgumentException("Value is null.");

    if (value.equals(BigInteger.ZERO)) return "0";

    boolean negative = value.signum() < 0;
    BigInteger x = value.abs();
    BigInteger b = BigInteger.valueOf(base);

    StringBuilder sb = new StringBuilder();
    while (x.compareTo(BigInteger.ZERO) > 0) {
      BigInteger[] divRem = x.divideAndRemainder(b);
      int rem = divRem[1].intValue(); // safe: rem < base <= 36
      sb.append(digitChar(rem));
      x = divRem[0];
    }

    if (negative) sb.append('-');
    return sb.reverse().toString();
  }

  private static int digitValue(char c) {
    if (c >= '0' && c <= '9') return c - '0';
    if (c >= 'A' && c <= 'Z') return 10 + (c - 'A');
    if (c >= 'a' && c <= 'z') return 10 + (c - 'a');
    return -1;
  }

  private static char digitChar(int v) {
    if (v >= 0 && v <= 9) return (char) ('0' + v);
    return (char) ('A' + (v - 10));
  }
}
