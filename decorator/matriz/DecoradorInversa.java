public class DecoradorInversa extends Decorador {
  protected double m11, m12, m13, m21, m22, m23, m31, m32, m33;
  //variables de la matriz indetidad
  protected double i12, i13, i21, i23, i31, i32;
  protected double i11 = 1.0;
  protected double i22 = 1.0;
  protected double i33 = 1.0;
  double[] valores = new double[9];

  public DecoradorInversa(Matriz m){
    super(m);
  }

  @Override
  public void mostrar_valores(){
    m.mostrar_valores();
    System.out.println("Matriz inversa:");
    inversa(m);
  }

  public void inversa(Matriz m){
    valores = m.getValores();
    m11 = valores[0]; m12 = valores[1]; m13 = valores[2];
    m21 = valores[3]; m22 = valores[4]; m23 = valores[5];
    m31 = valores[6]; m32 = valores[7]; m33 = valores[8];
    System.out.println("| " + m11 + " " + m12 + " " + m13 + " |" + i11 + " " + i12 + " " + i13);
    System.out.println("| " + m21 + " " + m22 + " " + m23 + " |" + i21 + " " + i22 + " " + i23);
    System.out.println("| " + m31 + " " + m32 + " " + m33 + " |" + i31 + " " + i32 + " " + i33);
    if(m.determinante() == 0){
      System.out.println("El determinante es 0, no es una matriz invertible");
      return;
    }
    //primer pivote: m11
    //volver a 1 el pivote en caso que no lo sea, se divide toda la fila entre pivote
    if(m11 != 1){
      double aux11 = m11; //respaldo del valor
      m11 = m11/aux11;
      m12 = m12/aux11;
      m13 = m13/aux11;
      i11 = i11/aux11;
      i12 = i12/aux11;
      i13 = i13/aux11;
    }
    //haciendo ceros bajo el pivote
    //elegir un coeficiente = el que está bajo el pivote, (si es m11, => coef = m21)
    //r2 = r2 - coef(r1)
    double coef = m21;
    m21 = m21 - (coef * m11);
    m22 = m22 - (coef * m12);
    m23 = m23 - (coef * m13);
    i21 = i21 - (coef * i11);
    i22 = i22 - (coef * i12);
    i23 = i23 - (coef * i13);
    //r3 = r3 - coef(r1)
    coef = m31;
    m31 = m31 - (coef * m11);
    m32 = m32 - (coef * m12);
    m33 = m33 - (coef * m13);
    i31 = i31 - (coef * i11);
    i32 = i32 - (coef * i12);
    i33 = i33 - (coef * i13);

    //2do pivote: m22
    // if(m22 != 1){
    //   double aux22 = m22;
    //   m21 = m21/aux22;
    //   m22 = m22/aux22;
    //   m23 = m23/aux22;
    //   i21 = i21/aux22;
    //   i22 = i22/aux22;
    //   i23 = i23/aux22;
    // }
    // //1ra fila
    // m11 = m11 - (m21 * m22);

    System.out.println("| " + m11 + " " + m12 + " " + m13 + " |" + i11 + " " + i12 + " " + i13);
    System.out.println("| " + m21 + " " + m22 + " " + m23 + " |" + i21 + " " + i22 + " " + i23);
    System.out.println("| " + m31 + " " + m32 + " " + m33 + " |" + i31 + " " + i32 + " " + i33);
  }

  public double [] getValores(){
    return m.getValores();
  }
}
