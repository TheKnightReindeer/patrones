public class Main {
  public static void main(String args []){
    Ventana v = new VentanaSimple("ventana1");
    // v = new DecoradorBoton(v, "un boton");
    v.dibujar();

    Ventana v2 = new VentanaSimple("ventana2");
    v2 = new DecoradorBoton(v2, "un boton");
    v2 = new DecoradorBoton(v2, "otro boton");
    v2 = new DecoradorBoton(v2, "uno mas");
    v2 = new DecoradorBoton(v2, "4th grade");
    v2 = new DecoradorBoton(v2, "no hay quinto malo");
    v2.dibujar();
  }
}
