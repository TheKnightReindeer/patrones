public class Main {
  public static void main(String args []){
    PancakeHouseMenu phm = new PancakeHouseMenu();
    DinerMenu dm = new DinerMenu();

    Waitress w = new Waitress(phm, dm);
    // w.printMenu();
    // w.printRange(1, 5);
    // w.printRange(1, 3);
    // w.printNames();
    w.printRangeIn(1, 10, 3); //vi, vf, step
  }
}
