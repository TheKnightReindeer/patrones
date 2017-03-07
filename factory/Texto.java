public class Texto extends Figura {
  public Texto(String nombre, Object valor, int tamaño, int x, int y){
    super(nombre, valor, tamaño, x, y);
    System.out.println("Se ha creado un texto");
  }
  public void dibujar(){
    System.out.println("texto: " + valor);
  }
}
