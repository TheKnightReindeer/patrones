public class DimensionLineal extends DatoMateComp {
  public DimensionLineal(double d1, double d2){
    super(d1, d2);
  }

  @Override
  public void mostrar(){
    System.out.println("dimensión lineal: " + valor1 + " mts. y " + valor2 + "cms");
  }
}
