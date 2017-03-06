public abstract class DatoMateComp {
  protected Sumar opSumar; //de la interface Sumar
  // protected Multiplicar opMultiplicar; //de la interfaz Multiplicar
  protected double valor1;
  protected double valor2;
  protected char simbolo;

  public DatoMateComp(double d1, double d2){
    valor1 = d1;
    valor2 = d2;
  }

  public void leer(){
  }

  public void mostrar(){
  }

  public boolean equals(DatoMateComp dato2){
    return this.valor1 == dato2.valor1 && this.valor2 == dato2.valor2;
  }

  // public DatoMateComp ejeSumar(DatoMateComp punto2){
  //   return opSumar.sumar(this, punto2);
  // }
}
