import java.util.Scanner;

/**
 * Created by ganymed on 10/06/16.
 */
public class Praktikum5 {


  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);

      Complex complex01 = liesComplex(scanner);
      Complex complex02 = liesComplex(scanner);
      Complex complex01Clone = (Complex) complex01.clone();

      System.out.println();
      System.out.println("c1 : " + complex01 + "  =  " + complex01.toPolarStr());
      System.out.println("c1 : " + complex02 + "  =  " + complex02.toPolarStr());

      Complex additionComplex = complex01.add(complex02);
      System.out.println();
      System.out.println("Addition : c3=c1+c2");
      System.out.println("c3 : " + additionComplex + "  =  " + additionComplex.toPolarStr());

      Complex subtractionComplex = complex01.sub(complex02);
      System.out.println();
      System.out.println("Subtraktion : c3=c1-c2");
      System.out.println("c3 : " + subtractionComplex + "  =  " + subtractionComplex.toPolarStr());

      Complex multiplicationComplex = complex01.mult(complex02);
      System.out.println();
      System.out.println("Addition : c3=c1*c2");
      System.out.println("c3 : " + multiplicationComplex + "  =  " + multiplicationComplex.toPolarStr());

      Complex divisionComplex = complex01.div(complex02);
      System.out.println();
      System.out.println("Division : c3=c1/c2");
      System.out.println("c3 : " + divisionComplex + "  =  " + divisionComplex.toPolarStr());

    } catch(Exception e) {
      System.out.println("An Exception occurred during test of class Complex: " + e.getMessage());
      e.printStackTrace();
    }
  }


  public static Complex liesComplex(Scanner scanner) {
    System.out.println();
    System.out.print("Realteil     ? ");
    double realPart = scanner.nextDouble();

    System.out.print("Imaginaerteil ? ");
    return new Complex(realPart, scanner.nextDouble());
  }

}
