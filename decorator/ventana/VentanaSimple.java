import javax.swing.*;
public class VentanaSimple extends JFrame implements Ventana {
  private String nombre;

  public VentanaSimple(String n){
    nombre = n;
    JFrame v = new JFrame(n);
    setLayout(null);
    v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    v.setSize(290, 150);
    v.setVisible(true);
  }

  @Override
  public void dibujar(){
    System.out.println("Ventana simple");
    System.out.println("Nombre: " + getNombre());
  }

  public String getNombre(){
    return nombre;
  }

  public void add(Object j){
    add((JButton)j);
  }
}
