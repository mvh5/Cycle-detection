
public class Vertex {
	public boolean discovered;
	public boolean fullyDiscovered;
	public int dfsNumber;
	public int destination;
	public int source; //this node
	public ConnectedComponent connectedComponent;
	
	
	public Vertex (int source, int destination ) {
		this.source = source;
		discovered = false;
		fullyDiscovered = false;
		dfsNumber = -1;
		this.destination = destination;
		this.connectedComponent = null;
		
	}
	
	public String toString() {
		//return "This is vertex " + source + " pointing to "+destination;
		return ""+source;
	}
}
