public class Main {
  public static void main(String args []){
    // Ventana v = new VentanaSimple("ventana1");
    // v.dibujar();

    Ventana v2 = new VentanaSimple("ventana2");
    v2 = new DecoradorBoton(v2);
    v2.dibujar();
  }
}
