public abstract class Decorador implements Matriz {
  protected Matriz m;

  public Decorador(Matriz m){
    this.m = m;
  }

  public void mostrar_valores(){
    m.mostrar_valores();
  }

  public double determinante(){
    return m.determinante();
  }
}
