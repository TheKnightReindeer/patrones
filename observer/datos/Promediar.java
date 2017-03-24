import java.util.ArrayList;
import java.util.Iterator;
public class Promediar implements Observador {
  private Sujeto suj;

  public Promediar(Sujeto s){
    suj = s; //apuntar al sujeto a mirar
    suj.agregarObs(this);
  }

  public void actualiza(Sujeto s){
    suj = s;
    promediar();
  }
  public void promediar(){
    int acumulador = 0;
    ArrayList datos = suj.getDatos();
    Iterator it = datos.iterator();
    int cantidad_datos = datos.size();
    while(it.hasNext()){
      acumulador += (Integer)it.next();
    }
    System.out.println("Promedio: " + (float)(acumulador / cantidad_datos));
    System.out.println("-------------------------");
  }
}
