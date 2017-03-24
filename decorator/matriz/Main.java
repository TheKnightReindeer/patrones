public class Main {
  public static void main(String args []){
    Matriz m1 = new MatrizDosDos(2, 3, -1, 2);
    // m1.mostrar_valores();
    m1 = new DecoradorInversa(m1);
    m1.mostrar_valores();
  }
}
