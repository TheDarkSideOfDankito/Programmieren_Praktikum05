/**
 * Created by ganymed on 10/06/16.
 */
public class Complex {

  private double realPart;
  private double imaginaryPart;

  private double absoluteValue; // magnitude
  private double phase; // argument


  public Complex() {
    this(0.0, 0.0);
  }

  public Complex(double realPart, double imaginaryPart) {
    this.realPart = realPart;
    this.imaginaryPart = imaginaryPart;

    this.absoluteValue = Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    this.phase = Math.atan2(imaginaryPart, realPart);
  }


  public double getRealPart() {
    return realPart;
  }

  public double getImaginaryPart() {
    return imaginaryPart;
  }

  public double getAbsoluteValue() {
    return absoluteValue;
  }

  public double getPhase() {
    return phase;
  }


  public Complex add(Complex other) {
    return new Complex(this.realPart + other.realPart, this.imaginaryPart + other.imaginaryPart);
  }

  public Complex sub(Complex other) {
    return new Complex(this.realPart - other.realPart, this.imaginaryPart - other.imaginaryPart);
  }

  public Complex mult(Complex other) {
    double realPart = this.realPart * other.getRealPart() - this.imaginaryPart * other.getImaginaryPart();
    double imaginaryPart = this.realPart * other.getImaginaryPart() + this.imaginaryPart * other.getRealPart();
    return new Complex(realPart, imaginaryPart);
  }

  public Complex div(Complex other) {
    double realPart = (this.realPart * other.getRealPart() + this.imaginaryPart * other.getImaginaryPart()) /
        (other.getRealPart() * other.getRealPart() + other.getImaginaryPart() * other.getImaginaryPart());

    double imaginaryPart = (this.imaginaryPart * other.getRealPart() - this.realPart * other.getImaginaryPart()) /
        (other.getRealPart() * other.getRealPart() + other.getImaginaryPart() * other.getImaginaryPart());

    return new Complex(realPart, imaginaryPart);
  }


  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Complex) {
      Complex other = (Complex)obj;
      return this.realPart == other.getRealPart() && this.imaginaryPart == other.getImaginaryPart();
    }

    return super.equals(obj);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new Complex(this.realPart, this.imaginaryPart);
  }

  @Override
  public String toString() {
    String sign = (this.imaginaryPart > 0 ? "+" : "-");
    return String.format("(%.6f" + sign + "j*%.6f)", this.realPart, Math.abs(this.imaginaryPart));
  }

  public String toPolarStr() {
    return String.format("%.6f*exp(%.6f*j)", this.absoluteValue, this.phase);
  }

}
