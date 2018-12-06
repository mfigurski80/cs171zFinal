import java.util.ArrayList;

public class PathFind {

  /**
   * Class to hold individual point (city) that can be traveled through
   * Constructor needs:
   * @param name
   * @param position-x
   * @param position-y
   */
  private static class City {
    public boolean isOpen = true;
    public String name = new String();
    public int x,y;
    public int cost;
    public City parent;
    public ArrayList connections = new ArrayList();

    public City (String _name, int _x, int _y) {
      name = _name;
      x = _x;
      y = _y;
    }

    public static double getDistanceFromPoint(int targetX, int targetY) {
      return(4.3); // TODO: write getDistanceFromPoint method
    }
  }

  /**
   * Class to hold connections between individual cities
   * Constructor needs:
   * @param name
   * @param city to begin at
   * @param city to end at
   */
  private static class Connection {
    public String name;
    public City[] connects;

    public Connection (String _name, City a, City b) {
      name = _name;
      connects = new City[]{a,b};
    }
  }

  /**
   * MAIN CLASS BEGINS HERE
   * @param args
   */
  public static void main(String[] args) {
    City n = new City("Philly",1,1);
    Connection c = new Connection("Route 66", n, n);
    System.out.println(args);
    for (String arg : args) {
      System.out.println(arg);
    }
  }
}