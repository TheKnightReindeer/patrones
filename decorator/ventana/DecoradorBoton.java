import javax.swing.JButton;
public class DecoradorBoton extends Decorador {
  private JButton boton;
  private String text;
  public DecoradorBoton(Ventana v, String text){
    super(v);
    this.text = text;
  }

  @Override
  public void dibujar(){
    v.dibujar();
    System.out.println("Ventana decorada con un botón");
    agregarBoton(v);
  }

  private void agregarBoton(Ventana v){
    boton = new JButton(text);
    v.add(boton);
  }

  @Override
  public int capacidad(){
    return v.capacidad() + 15; //agrega un peso extra por tener un botón
  }
}
