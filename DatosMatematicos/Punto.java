public class Punto extends DatoMateComp{

  public Punto(double d1, double d2){
    super(d1, d2);
    opSumar = new SumaDirecta();
  }

  @Override
  public void mostrar(){
    System.out.println("punto: (" + valor1 + "," + valor2 + ")");
  }

}
