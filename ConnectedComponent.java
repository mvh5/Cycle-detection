import java.util.*;

public class ConnectedComponent {
	public Set<Vertex> vertices;
	int weight;
	int length;
	public Set<Vertex> cycle;
	
	public ConnectedComponent() {
		this.vertices = new HashSet<Vertex>();
		this.cycle = new HashSet<Vertex>();
	}
	
	

}
