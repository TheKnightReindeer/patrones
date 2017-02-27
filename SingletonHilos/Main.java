//SingletonHilos
public class Main {

  public static void main(String [] args){
    // Proceso pro = new Proceso();
    ImporteConsAgua pro = new ImporteConsAgua();
    Thread h1 = new Thread(pro);
    Thread h2 = new Thread(pro);
    h1.start();
    h2.start();
    // ImporteConsAgua ica = new ImporteConsAgua();
    // Thread h1 = new Thread(ica);
    // Thread h2 = new Thread(ica);
    //
    // h1.start();
    // h2.start();
  }

}
