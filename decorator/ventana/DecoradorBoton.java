import javax.swing.JButton;
public class DecoradorBoton extends Decorador {
  public DecoradorBoton(Ventana v){
    super(v);
  }

  @Override
  public void dibujar(){
    v.dibujar();
    agregarBoton(v);
  }

  private void agregarBoton(Ventana v){
    JButton boton = new JButton("any");
    boton.setBounds(100, 150, 100, 30);
    v.add(boton);
    // v.add(new JButton("any").setBounds(100, 150, 100, 30));
    System.out.println("Ventana decorada con un botón");
  }
}
