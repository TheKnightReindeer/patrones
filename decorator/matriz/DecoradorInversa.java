public class DecoradorInversa extends Decorador {
  public DecoradorInversa(Matriz m){
    super(m);
  }

  @Override
  public void mostrar_valores(){
    m.mostrar_valores();
    System.out.println("Matriz inversa:");
    inversa(m);
  }

  public void inversa(Matriz m){
    //[[a b] [x y]]
  }
}
