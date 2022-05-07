// Name:
// Student number:
import java.util.ArrayList;
import java.util.List;
 
public class Graph {
 
	private List<Vertex> verticesList;

	public Graph() {
		this.verticesList = new ArrayList<>();
	}

	public void addVertex(Vertex vertex) {
		this.verticesList.add(vertex);
	}

	public void reset() {
		for(Vertex vertex : verticesList) {
			vertex.setVisited(false);
			vertex.setPredecessor(null);
			vertex.setDistance(Double.POSITIVE_INFINITY);
		}
	}

	////// Implement the methods below this line //////

	public List<Vertex> getShortestPath(Vertex sourceVertex, Vertex targetVertex) {
		if (!NegativeCycle()) {
			List<Vertex> toBeChecked = new ArrayList<>(), visited = new ArrayList<>(), shortestPath = new ArrayList<>();
			for (Vertex v : verticesList) {
				v.setDistance(Double.POSITIVE_INFINITY);
				v.setPredecessor(null);
				v.setVisited(false);
				visited.add(v);
			 }

			sourceVertex.setDistance(0);
			toBeChecked.add(sourceVertex);
			// visited.add(sourceVertex);
			while (!visited.isEmpty()) {
				Vertex curr = visited.remove(0);

				for (Edge v: curr.getAdjacenciesList())	{
					double newDist = curr.getDistance() + v.getWeight();
					if (newDist < v.getEndVertex().getDistance()) {
						toBeChecked.add(v.getEndVertex());
						v.getEndVertex().setDistance(newDist);
						v.getEndVertex().setPredecessor(curr);
					}

					if(!visited.contains(v.getEndVertex()))
						visited.add(v.getEndVertex());
				}
			}

			for (Vertex target : toBeChecked){
				if (target == targetVertex && toBeChecked.contains(sourceVertex)) {
					while (target != null) {
						shortestPath.add(0, target);
						if (target != sourceVertex && target.getPredecessor() == null)
							return new ArrayList<Vertex>();
						target = target.getPredecessor();
					}
					if (shortestPath.size() == 0)
						return new ArrayList<>();
					return shortestPath;
				}
			}
			return new ArrayList<>();
		}
		return null;
	}

	public double getShortestPathDistance(Vertex sourceVertex, Vertex targetVertex) {
		if (!NegativeCycle()) {
			List<Vertex> toBeChecked = new ArrayList<>(), visited = new ArrayList<>(), shortestPath = new ArrayList<>();
			for (Vertex v : verticesList) {
				v.setDistance(Double.POSITIVE_INFINITY);
				v.setPredecessor(null);
				v.setVisited(false);
				visited.add(v);
			}

			sourceVertex.setDistance(0);
			toBeChecked.add(sourceVertex);
			// visited.add(sourceVertex);
			while (!visited.isEmpty()) {
				Vertex curr = visited.get(0);
				visited.remove(0);

				for (Edge v: curr.getAdjacenciesList())	{
					double newDist = curr.getDistance() + v.getWeight();
					if (newDist < v.getEndVertex().getDistance()) {
						toBeChecked.add(v.getEndVertex());
						v.getEndVertex().setDistance(newDist);
						v.getEndVertex().setPredecessor(curr);
					}

					if(!visited.contains(v.getEndVertex())) visited.add(v.getEndVertex());
				}
			}

			for (Vertex target : toBeChecked){
				if (target == targetVertex && toBeChecked.contains(sourceVertex)) {
					while (target != null) {
						shortestPath.add(0, target);
						if (target != sourceVertex && target.getPredecessor() == null)
							return Double.POSITIVE_INFINITY;
						target = target.getPredecessor();
					}
					if (shortestPath.size() == 0)
						return Double.POSITIVE_INFINITY;
					return shortestPath.get(shortestPath.size()-1).getDistance();
				}
			}
			return Double.POSITIVE_INFINITY;
		}
		return Double.NEGATIVE_INFINITY;
	}

	public boolean NegativeCycle(){
		double [][]weight = new double[verticesList.size()][verticesList.size()];
		for (int i=0;		i<verticesList.size();		i++)
			for (int j=0;		j<verticesList.size();		j++)
				weight[i][j] = Double.POSITIVE_INFINITY;

		for (int x=0;	x<verticesList.size();	x++){
			for (int y=0;	y<verticesList.get(x).getAdjacenciesList().size();	y++)
				for (int index = 0; index < verticesList.size(); index++)
					if (verticesList.get(index).getName() == verticesList.get(x).getAdjacenciesList().get(y).getEndVertex().getName())
						weight[x][index] = verticesList.get(x).getAdjacenciesList().get(y).getWeight();
		}

		for (int i=0;	i<verticesList.size();	i++)
			for (int j=0;	j<verticesList.size();	j++)
				for (int k=0;	k<verticesList.size();	k++)
					if (weight[j][k] > weight[j][i] + weight[i][k])
						weight[j][k] = weight[j][i] + weight[i][k];

		for (int xIndex=0;		xIndex<verticesList.size();		xIndex++)
			for (int yIndex=0;	yIndex<verticesList.size();	yIndex++)
				if (xIndex == yIndex && weight[xIndex][yIndex] < 0)
					return true;
		return false;
	}

}