public class ManipulaPoligono extends Manipulador {

  public Figura crearFigura(String nombre, Object valor, int tamaño, int x, int y){
    figura = new Poligono(nombre, valor, tamaño, x, y);
    return figura;
  }
}
