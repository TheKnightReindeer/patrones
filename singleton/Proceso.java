// import java.util.loggin.Logger;
public class Proceso implements Runnable {
  //Ejemplo de un proceso donde se trata de crear tres  instancias
  private SingletonClasico osc; 

  @Override
  public void run() {
    osc =  SingletonClasico.getInstancia();
    System.out.println("Se creo una nueva instancia "+osc.numInstancia());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      // Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex);
    }
    osc = SingletonClasico.getInstancia();
    System.out.println("Se creo una nueva instancia " + osc.numInstancia());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      // Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex);
    }
  }   

}
