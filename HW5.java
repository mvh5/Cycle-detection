
import java.io.*;
import java.util.*;

public class HW5 {
	static int dfsCounter = 0; // global variable
	static ArrayList<ConnectedComponent> connectedComponents = new ArrayList<ConnectedComponent>();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		Scanner fileScanner = new Scanner(new File("Small.txt"));
		
		String line = fileScanner.nextLine();
		Scanner lineScan = new Scanner(line);
		int numberOfVertices = lineScan.nextInt();
		
		Vertex [] graph = new Vertex[numberOfVertices];
		
		for (int i = 0 ; i < numberOfVertices; i++) {
			line = fileScanner.nextLine();
			lineScan = new Scanner(line);
			int vertexSource = lineScan.nextInt();
			int vertexDestination = lineScan.nextInt();
			graph[vertexSource-1] = new Vertex(vertexSource, vertexDestination);
			
		}
		
		for (int i = 0 ; i < numberOfVertices; i++) {
			if (!graph[i].fullyDiscovered) {
				dfs(graph[i], graph);
			}
		}
		
		for (int i = 0; i < connectedComponents.size(); i++) {
			System.out.println("Length: " + connectedComponents.get(i).length + 
					", Weight: " + connectedComponents.get(i).vertices.size());
		}
	}
	
	public static void dfs(Vertex v, Vertex[] graph) {
		dfsCounter = dfsCounter + 1;
		v.dfsNumber = dfsCounter;
		Vertex x = graph[v.destination - 1];
		if (x.dfsNumber == -1) {
			//System.out.println(v.source + " discovered " + v.destination);
			dfs(x, graph);
			v.connectedComponent = x.connectedComponent;
			v.connectedComponent.vertices.add(v);
		} else if (!x.fullyDiscovered && x.dfsNumber < v.dfsNumber) {
			//System.out.println("A cycle has been detected from " + x.source + " to " + v.source);
			ConnectedComponent newCC = new ConnectedComponent();
			newCC.vertices.add(v);
			v.connectedComponent = newCC;
			connectedComponents.add(newCC);
			newCC.length = getLength(v, graph);
			
		} else if (x.fullyDiscovered) {
			//System.out.println(v.source + " saw " + x.source + ", but was already discovered");
			v.connectedComponent = x.connectedComponent;
			v.connectedComponent.vertices.add(v);
		}
		v.fullyDiscovered = true;
		
	}
	
	public static int getLength(Vertex v, Vertex[] graph) {
		int count = 1;
		int destination = v.destination;
		while (destination != v.source) {
			count++;
			Vertex newVertex = graph[destination-1];
			destination = newVertex.destination;
		}
		
		return count;
	}

}
