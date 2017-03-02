public class DimensionArea extends DatoMateComp {
  public DimensionArea(double d1, double d2){
    super(d1, d2);
  }

  @Override
  public void mostrar(){
    System.out.println("dimensión area: " + valor1 + " largo y " + valor2 + " ancho");
  }
}
