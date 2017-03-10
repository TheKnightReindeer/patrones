public class Main {
  public static void main(String args []){
    PancakeHouseMenu phm = new PancakeHouseMenu();
    DinerMenu dm = new DinerMenu();

    Waitress w = new Waitress(phm, dm);
    // w.printMenu();
    // w.printRange(3, 5);
    // w.printRange(1, 9);
    w.printNames();
  }
}
