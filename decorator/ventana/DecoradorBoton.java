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
    agregarBoton(v);
  }

  private void agregarBoton(Ventana v){
    try{
      boton = new JButton(text);
      v.add(boton);
      System.out.println("Ventana decorada con un botón");
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
