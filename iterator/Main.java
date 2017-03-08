public class Main {
  public static void main(String args []){
    PancakeHouseMenu phm = new PancakeHouseMenu();
    DinerMenu dm = new DinerMenu();

    Waitress w = new Waitress(phm, dm);
    waitress.printMenu();
  }
}
