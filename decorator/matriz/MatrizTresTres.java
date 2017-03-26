public class MatrizTresTres implements Matriz{
  private int [][] valores = new int[2][2];
  private double m11, m12, m13, m21, m22, m23, m31, m32, m33;

  public MatrizTresTres(
    double a, double b, double c,
    double d, double e, double f,
    double g, double h, double i){
    m11 = a; m12 = b; m13 = c;
    m21 = d; m22 = e; m23 = f;
    m31 = g; m32 = h; m33 = i;
  }

  public double determinante(){
    double pos = (m11 * m22 * m33) + (m12 * m23 * m31) + (m13 * m21 * m32);
    double neg = (m13 * m22 * m31) + (m12 * m21 * m33) + (m11 * m23 * m32);
    System.out.println(pos);
    System.out.println(neg);
    return pos - neg;
  }

  private double multiplica_tres(double a, double b, double c){
    return a * b * c;
  }

  public void mostrar_valores(){
    System.out.println("Matriz de 3 x 3");
    System.out.println(m11 + " " + m12 + " " + m13);
    System.out.println(m21 + " " + m22 + " " + m23);
    System.out.println(m31 + " " + m32 + " " + m33);
    System.out.println("determinante: " + determinante());
  }
}
