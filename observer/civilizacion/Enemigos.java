import java.util.ArrayList;
import java.util.Iterator;
public class Enemigos implements Observador {
  private Sujeto suj;

  public Enemigos(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    imprimirEnemigos();
  }
  public void imprimirEnemigos(){
    System.out.println("Enemigos");
    ArrayList enemigos = suj.getDatos();
    Iterator it = enemigos.iterator();
    while(it.hasNext()){
      Civilizacion c = (Civilizacion)it.next();
      if(c.getColor() != suj.getColor()){
        System.out.println(c.getNombre() + ": " + c.getColor());
      }
    }
    System.out.println();
  }
}
