import java.awt.Graphics;
public class ManipulaPoligono extends Manipulador {

  public Figura crearFigura(Object elemento, String nombre, Object valor, int tamaño, int x, int y){
    figura = new Poligono((Graphics)elemento, nombre, (int)valor, tamaño, x, y);
    return figura;
  }
  
  //el manipulador debe mover y escalar
  //figura solamente crea el elemento
}
