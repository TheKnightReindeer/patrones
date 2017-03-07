public class ManipulaTexto extends Manipulador {
  // private etiquetas;
  // private botones;

  public Figura crearFigura(String nombre, Object texto, int tamaño, int x, int y){
    figura = new Texto(nombre, texto, tamaño, x, y);
    return figura;
  }
} 
