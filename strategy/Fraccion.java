public class Fraccion extends DatoMateComp {

  public Fraccion(int d1, int d2){
    super(d1, d2);
    opSumar = new SumaFrac();
  }
  
  @Override
  public void mostrar(){
    System.out.println("fraccion: " + (int)valor1 + "/" + (int)valor2);
  }

}
