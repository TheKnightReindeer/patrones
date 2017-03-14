import javax.swing.*;
public class ManipulaTexto extends Manipulador {
  // private etiquetas;
  // private botones;

  public Figura crearFigura(Object elemento, String nombre, Object texto, int tamaño, int x, int y){
    figura = new Texto((JLabel)elemento, nombre, (String)texto, tamaño, x, y);
    return figura;
  }
} 
