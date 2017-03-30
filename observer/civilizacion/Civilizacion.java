import java.util.ArrayList;
import java.util.Iterator;
public class Civilizacion implements Sujeto {
  private String color;
  private String nombre;
  private ArrayList<Observador> observadores;
  private ArrayList<Civilizacion> visitados;

  public Civilizacion(String n, String c){
    visitados = new ArrayList<Civilizacion>();
    nombre = n;
    color = c;
    observadores = new ArrayList<Observador>();
  }
  
  public void explorar(Civilizacion c){
    visitados.add(c);
    notificar();
    // if(mismoColor(c)){
      notificarAliados();
    // }
    // if(!mismoColor(c)){
      notificarEnemigos();
    // }
  }
  public boolean mismoColor(Civilizacion c){
    return this.color == c.color;
  }

  public String getColor(){
    return color;
  }

  public String getNombre(){
    return nombre;
  }

  public void agregarObs(Observador o){
    observadores.add(o);
  }

  public void removerObs(Observador o){
    if(observadores.size() > 0){
      observadores.remove(o);
    }
  }

  public void notificarAliados(){
    Iterator it = observadores.iterator();
    while(it.hasNext()){
      Observador o = (Observador)it.next();
      if(o instanceof Aliados){
        o.actualiza(this);
      }
    }
  }

  public void notificarEnemigos(){
    Iterator it = observadores.iterator();
    while(it.hasNext()){
      Observador o = (Observador)it.next();
      if(o instanceof Enemigos){
        o.actualiza(this);
      }
    }
  }

  public void notificar(){
    Iterator it = observadores.iterator();
    while(it.hasNext()){
      Observador o = (Observador)it.next();
      if(o instanceof Visitados){
        o.actualiza(this);
      }
    }
  }


  public ArrayList getDatos(){
    return visitados;
  }
}
