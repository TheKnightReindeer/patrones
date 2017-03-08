public abstract class Manipulador {
  protected int largo;
  protected int ancho;
  protected Figura figura;

  public abstract Figura crearFigura(
    String nombre,
    Object valor,
    int tamaño,
    int x,
    int y); //abstract methods cannot have a body

  public void generaFigura(int posicionx, int posiciony, Object tipo){

  }
}
