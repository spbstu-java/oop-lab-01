import java.util.EnumMap;
import java.util.Map;
import java.util.EnumSet;
import java.util.Set;

public class LocationGraph {
  private final Map<Location, Map<Location, ConnectionType>> connections = new EnumMap<>(Location.class);

  public LocationGraph() {
    for (Location location : Location.values()) {
      connections.put(location, new EnumMap<>(Location.class));
    }
  }

  public void connect(Location from, Location to, ConnectionType type) {
    connections.get(from).put(to, type);
    connections.get(to).put(from, type);
  }

  public ConnectionType getConnectionType(Location from, Location to) {
    return connections.get(from).get(to);
  }

  public Location getNextStep(Location from, Location to) {
    return getNextStep(from, to, EnumSet.noneOf(Location.class));
  }

  private Location getNextStep(Location from, Location to, Set<Location> visited) {
    visited.add(from);

    if (from == to) {
      return null;
    }

    for (Location neighbor : connections.get(from).keySet()) {
      if (!visited.contains(neighbor)
          && (neighbor == to || getNextStep(neighbor, to, visited) != null)) {
        return neighbor;
      }
    }

    return null;
  }
}
