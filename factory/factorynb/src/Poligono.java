public class Poligono extends Figura {
  public Poligono(String nombre, Object valor, int tamaño, int x, int y){
    super(nombre, valor, tamaño, x, y);
    System.out.println("Se ha creado un poligono");
  }

  public Object dibujar(){
    //System.out.println("Número de lados: " + valor);
    return valor;
  }
}
