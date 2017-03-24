import java.util.ArrayList;
import java.util.Iterator;
public class Imprimir implements Observador {
  private Sujeto suj;

  public Imprimir(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    imprimir();
  }
  public void imprimir(){
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    while(it.hasNext()){
      System.out.println(" " + (Integer)it.next());
    }
    System.out.println("-------------------------");
  }
}
