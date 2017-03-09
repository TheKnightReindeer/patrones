public class Main {
  public static void main(String args []){
    PancakeHouseMenu phm = new PancakeHouseMenu();
    DinerMenu dm = new DinerMenu();

    Waitress w = new Waitress(phm, dm);
    // w.printMenu();
    // w.printRango(3, 5);
    w.printRango(1, 9);
  }
}
