public class Main {
  public static void main(String [] args){
    Manipulador m1 = new ManipulaTexto();
    // m1.crearFigura();
    Figura f1 = m1.crearFigura("texto1", "hola", 4, 0, 0);
    f1.dibujar();
    f1.escalar(10);
    f1.trasladar(10, 10);

    Manipulador m2 = new ManipulaPoligono();
    Figura f2 = m2.crearFigura("figura1", 5, 3, 0, 0);
    f2.dibujar();
    f2.escalar(10);
    f2.trasladar(10, 10);
  }
}
