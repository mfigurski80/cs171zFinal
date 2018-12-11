import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    public double x,y;
    public double cost;
    public Connection parent;
    public ArrayList<Connection> connections = new <Connection>ArrayList();

    public City (String _name, double _x, double _y) {
      name = _name;
      x = _x;
      y = _y;
    }

    public double distanceFrom(double targetX, double targetY) {
      double dX = x - targetX;
      double dY = y - targetY;
      return 2*adjustMetersForCurvature(100*(Math.sqrt(dX*dX + dY*dY)));
    }
    public double distanceFrom(City target) {
      return (distanceFrom(target.x, target.y));
    }
    private double adjustMetersForCurvature(double meters) {
      // TODO: wtf do I even do here
      return meters;
    }

    public void addConnection(Connection con) {
      connections.add(con);
    }

    public String toString() {
      return java.lang.String.format("%s -- x:%s; y:%s; cost:%s", name, x, y, cost);
    }
  }

  /**
   * Class to hold connections between individual cities
   * Constructor needs:
   * @param name
   * @param city to begin at
   * @param city to end at
   * @param cost of route
   */
  private static class Connection {
    public String name;
    public City[] connects = new City[2];
    public int cost;

    public Connection (String _name, City a, City b, int _cost) {
      name = _name;
      connects[0] = a;
      connects[1] = b;
      cost = _cost;
    }

    public String toString() {
      return java.lang.String.format("%s, from %s to %s, cost: %s", name, connects[0].name, connects[1].name, cost);
    }
  }

  /**
   * MAIN CLASS BEGINS HERE
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("[Running...]");

    Scanner sc;
    try {
      sc = new Scanner(new File(args[0]));
    } catch(FileNotFoundException err) { // woot, file doesn't exist.
      System.out.println("[Couldn't find " + args[0] + ". You got some serious problems rn]");
      sc = new Scanner(System.in);
    }

    int citiesCount = sc.nextInt(); // get amount of cities
    sc.nextLine(); // clear rest of that line (it's empty)

    // GET CITY DATA
    String[] cityNames = new String[citiesCount]; // holds all the NAMES of the cities
    City[] cities = new City[citiesCount];        // hold all the city OBJECTS (index same as ^)
    // ^^ 2 VERY IMPORTANT VARIABLES THERE. Used as datastructure
    for (int i = 0; i < citiesCount; i++) { // divide string into these 2 ^
      String[] data = sc.nextLine().split("\\s+");
      cityNames[i] = data[0];
      cities[i] = new City(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }
    // GET CONNECTION DATA
    for (int i = 0; i < citiesCount; i++) { // for each connected city
      String line = sc.nextLine(); // get next line
      if (line.length() == 0) { // skip line if its empy
        i--;
        continue;
      }
      String[] data = line.split("\\s+"); // split the data (for city)
      for (int j = 0; j < Integer.parseInt(data[1]); j++) { // second datapoint gives you how many connections
        String[] conData = sc.nextLine().split("\\s+"); // NOTE: conData[0] is empty
        City a = cities[i]; // assume city connections and city list are in same order
        City b = cities[indexOf(cityNames, conData[1])]; // get index of city name
        Connection cur = new Connection(conData[3], a, b, Integer.parseInt(conData[2]));
        a.addConnection(cur);
        // don't add cur to b's connections. That'll happen when b's connections get analyzed
        // altho that ^ will result in lots of memory wasted for making new objects.
      }
    }

    // Testing for now
    System.out.println(getBestRoute("Atlanta", "Philadelphia", cityNames, cities));

  }


  /**
   * Implementation of A* algorithm to find shortest route between given cities
   * @param start
   * @param end
   * @param cityNames
   * @param cities
   * @return path
   */
  public static String getBestRoute(String startName, String endName, String[] cityNames, City[] cities) {
    City start = cities[indexOf(cityNames, startName)]; // get the referenced cities
    City end = cities[indexOf(cityNames, endName)];

    for (int i = 0; i < start.connections.size(); i++) {
      Connection cur = start.connections.get(i);
      cur.connects[1].cost = start.cost + cur.cost + cur.connects[1].distanceFrom(end);
      // ^ cost of city = distance traveled previously + distance traveled now + estimated distance to end
      System.out.println(cur.connects[1].toString());
    }

    // TODO: add priority queue, iterator, etc

    return "\nidk";
  }





  /**
   * Converts an array to an okay-looking string for debug
   * @param arr
   * @return fullString
   */
  public static String StringifyArray(Object[] arr) {
    String returnable = "";
    for (Object i : arr) {
      returnable += i.toString() + "\n";
    }
    return returnable;
  }

  /**
   * Looks for thing in the array, and returns it's index. Only tested on strings
   * @param arr
   * @param thing
   * @return index
   */
  public static int indexOf(Object[] arr, Object thing) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(thing)) return i;
    }
    return -1;
  }
}