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
    public String name;
    public int x,y;
    public int cost;
    public City parent;
    public ArrayList<Connection> connections;

    public City (String _name, int _x, int _y) {
      name = _name;
      x = _x;
      y = _y;
    }

    public static double getDistanceFromPoint(int targetX, int targetY) {
      return(4.3); // TODO: write getDistanceFromPoint method
    }
  }

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
    System.out.println("Edited from IntelliJ");
    City n = new City("Philly",1,1);
    Connection c = new Connection("Route 66", n, n);
  }
}