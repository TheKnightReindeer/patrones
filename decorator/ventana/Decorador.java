import javax.swing.*;
public abstract class Decorador implements Ventana {
  protected Ventana v;

  public Decorador(Ventana v){
    this.v = v;
  }

  public void dibujar(){
    v.dibujar();
  }

  public String getNombre(){
    return v.getNombre();
  }

  public void add(Object j){
    add((JButton)j);
  }
}
