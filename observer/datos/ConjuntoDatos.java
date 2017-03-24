import java.util.ArrayList;
import java.util.Iterator;
public class ConjuntoDatos implements Sujeto {
  private ArrayList<Integer> datos;
  private ArrayList<Observador> observadores;

  public ConjuntoDatos(){
    datos = new ArrayList<Integer>();
    observadores = new ArrayList<Observador>();
  }
  
  public void agregar(int d){
    datos.add(d);
    notificar();
  }
  public void agregarObs(Observador o){
    observadores.add(o);
  }

  public void removerObs(Observador o){
    if(observadores.size() > 0){
      observadores.remove(o);
    }
  }
  public void notificar(){
    Iterator it = observadores.iterator();
    while(it.hasNext()){
      Observador o = (Observador)it.next();
      o.actualiza(this);
    }
  }

  public ArrayList getDatos(){
    return datos;
  }
}
