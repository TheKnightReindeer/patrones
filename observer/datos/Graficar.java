import java.util.ArrayList;
import java.util.Iterator;
public class Graficar implements Observador {
  private Sujeto suj;

  public Graficar(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    graficar();
  }
  public void graficar(){
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    System.out.println("Gráfica sencilla: ");
    while(it.hasNext()){
      int dato = (Integer)it.next();
      System.out.print(" " + dato + " : ");
      for(int i = 0; i < dato; i++){
        System.out.print("*");
      }
      System.out.println();
    }
    System.out.println("-------------------------");
  }
}
