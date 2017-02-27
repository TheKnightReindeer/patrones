// import java.util.loggin.Logger;
public class Proceso implements Runnable {
  //Ejemplo de un proceso donde se trata de crear tres  instancias
  private SingletonParaHilos osc; 

  @Override
  public void run() {
    osc =  SingletonParaHilos.getInstance();
    System.out.println("Se creo una nueva instancia "+osc.nins());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      // Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex);
    }
    osc = SingletonParaHilos.getInstance();
    System.out.println("Se creo una nueva instancia " + osc.nins());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      // Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex);
    }
  }   

}
