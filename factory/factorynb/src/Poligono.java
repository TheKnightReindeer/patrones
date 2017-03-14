import java.awt.Graphics;
public class Poligono extends Figura {
  Graphics elemento;
  int valor;
  public Poligono(Graphics elemento, String nombre, int valor, int tamaño, int x, int y){
    super(elemento, nombre, valor, tamaño, x, y);
    System.out.println("Se ha creado un poligono");
  }

  public void dibujar(){
    //elemento.algo()
  }
}
