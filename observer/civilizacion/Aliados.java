import java.util.ArrayList;
import java.util.Iterator;
public class Aliados implements Observador {
  private Sujeto suj;

  public Aliados(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    imprimirAliados();
  }
  public void imprimirAliados(){
    System.out.println("Aliados");
    ArrayList visitados = suj.getDatos();
    Iterator it = visitados.iterator();
    while(it.hasNext()){
      Civilizacion c = (Civilizacion)it.next();
      if(c.getColor() == suj.getColor()){
        System.out.println(c.getNombre() + ": " + c.getColor());
      }
    }
    System.out.println();
  }
}
