public class Tiempo extends DatoMateComp {
  public Tiempo(double d1, double d2){
    super(d1, d2);
  }

  @Override
  public void mostrar(){
    System.out.println("tiempo: " + valor1 + " horas y " + valor2 + " minutos");
  }
}
