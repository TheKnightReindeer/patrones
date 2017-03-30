import java.util.ArrayList;
import java.util.Iterator;
public class Visitados implements Observador {
  private Sujeto suj;

  public Visitados(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    imprimirVisitados();
  }
  public void imprimirVisitados(){
    System.out.println("Civilizacion: " + suj.getNombre() + " color: " + suj.getColor());
    ArrayList visitados = suj.getDatos(); //arraylist de Civilizaciones
    Iterator it = visitados.iterator();
    System.out.println("Visitados: ");
    while(it.hasNext()){
      Civilizacion c = (Civilizacion)it.next();
      System.out.println("-> " + c.getNombre());
    }
    System.out.println();
  }
}
