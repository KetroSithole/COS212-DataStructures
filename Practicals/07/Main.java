public class Main {
	/* some helper functions to help you construct the two types of graphs */

	private static void connectDirectedVertices(Vertex sourceVertex, Vertex destinationVertex, double cost) {
		Edge e = new Edge(sourceVertex, destinationVertex, cost); /* edge has a cost */
		sourceVertex.addNeighbour(e); /* only direct the edge from the source vertex to destination (but not vice-versa) */
	}

	private static void connectUndirectedVertices(Vertex v1, Vertex v2) {
		Edge e = new Edge(v1, v2, 0); /* the weight of these edges are all set to 0 and can be ignored */
		v1.addNeighbour(e);
		v2.addNeighbour(e); /* add the edge to both vertices essentially making the edge function in both directions */
	}

	public static void main(String[] args) {

		// TASK 1: Shortest path test

		Vertex vertexL = new Vertex("L");
		Vertex vertexM = new Vertex("M");
		Vertex vertexN = new Vertex("N");
		Vertex vertexO = new Vertex("O");
		Vertex vertexP = new Vertex("P");

		connectDirectedVertices(vertexL, vertexN, 10);
		connectDirectedVertices(vertexL, vertexM, 17);
		connectDirectedVertices(vertexN, vertexM, 5);
		connectDirectedVertices(vertexN, vertexO, 9);
		connectDirectedVertices(vertexN, vertexP, 11);
		connectDirectedVertices(vertexM, vertexO, 1);
		connectDirectedVertices(vertexO, vertexP, 6);

		WeightedDirectedGraph directedGraph = new WeightedDirectedGraph();
		directedGraph.addVertex(vertexL);
		directedGraph.addVertex(vertexM);
		directedGraph.addVertex(vertexN);
		directedGraph.addVertex(vertexO);
		directedGraph.addVertex(vertexP);

		System.out.println("\u001b[33m\u001b[1mBASIC TEST PROVIDED IN MAIN\u001b[0m");
		System.out.println("Shortest Path from " + vertexL.getName() + " to " + vertexP.getName() + " : " + directedGraph.getShortestPath(vertexL, vertexP));
		String out = new String("Shortest Path from " + vertexL.getName() + " to " + vertexP.getName() + " : " + directedGraph.getShortestPath(vertexL, vertexP));
		String correct = new String("Shortest Path from L to P : [L, N, P]");
		if (out.equals(correct)) {
			System.out.println("\u001b[32m\u001b[1mPASSED ✓\u001b[0m");
		} else
			System.out.println("\u001b[31m\u001b[1mFAILED ✕\u001b[0m");
		System.out.println();
		System.out.println("\u001b[33m\u001b[1mTESTING A CASE WHERE THE VERTEX IS NOT ACCESSABLE\u001b[0m");
		System.out.println("Shortest Path from " + vertexO.getName() + " to " + vertexL.getName() + " : " + directedGraph.getShortestPath(vertexO, vertexL));
		out = new String("Shortest Path from " + vertexO.getName() + " to " + vertexL.getName() + " : " + directedGraph.getShortestPath(vertexO, vertexL));
		correct = new String("Shortest Path from O to L : []");
		if (out.equals(correct)) {
			System.out.println("\u001b[32m\u001b[1mPASSED ✓\u001b[0m");
		} else
			System.out.println("\u001b[31m\u001b[1mFAILED ✕\u001b[0m");
		System.out.println();
		System.out.println("\u001b[33m\u001b[1mTESTING PATH L AND M\u001b[0m");
		System.out.println("Shortest Path from " + vertexL.getName() + " to " + vertexM.getName() + " : " + directedGraph.getShortestPath(vertexL, vertexM));
		out = new String("Shortest Path from " + vertexL.getName() + " to " + vertexM.getName() + " : " + directedGraph.getShortestPath(vertexL, vertexM));
		correct = new String("Shortest Path from L to M : [L, N, M]");
		if (out.equals(correct)) {
			System.out.println("\u001b[32m\u001b[1mPASSED ✓\u001b[0m");
		} else
			System.out.println("\u001b[31m\u001b[1mFAILED ✕\u001b[0m");
		System.out.println();
		System.out.println("\u001b[33m\u001b[1mCREATING NEGATIVE CYCLE\u001b[0m");
		System.out.println("\u001b[35m\u001b[1mNOTE AN INFINITE LOOP AHEAD MAKE SURE TO CHECK FOR NEGATIVE CYCLES\u001b[0m");
		Vertex vertexQ = new Vertex("Q");
		Vertex vertexR = new Vertex("R");
		Vertex vertexS = new Vertex("S");
		Vertex vertexT = new Vertex("T");


		connectDirectedVertices(vertexQ, vertexR, 1);
		connectDirectedVertices(vertexR, vertexS, -1);
		connectDirectedVertices(vertexS, vertexT, -1);
		connectDirectedVertices(vertexT, vertexQ, -1);


		WeightedDirectedGraph directedGraphNegative1 = new WeightedDirectedGraph();
		directedGraphNegative1.addVertex(vertexQ);
		directedGraphNegative1.addVertex(vertexR);
		directedGraphNegative1.addVertex(vertexS);
		directedGraphNegative1.addVertex(vertexT);

		System.out.println("Shortest Path from " + vertexQ.getName() + " to " + vertexT.getName() + " : " + directedGraphNegative1.getShortestPath(vertexQ, vertexT));
		out = new String("Shortest Path from " + vertexQ.getName() + " to " + vertexT.getName() + " : " + directedGraphNegative1.getShortestPath(vertexQ, vertexT));
		correct = new String("Shortest Path from Q to T : null");

		if (out.equals(correct)) {
			System.out.println("\u001b[32m\u001b[1mPASSED ✓\u001b[0m");
		} else
			System.out.println("\u001b[31m\u001b[1mFAILED ✕\u001b[0m");
		System.out.println();
		System.out.println("\u001b[35m\u001b[1mNOTE ANOTHER POTENTIAL INFINITE LOOP\u001b[0m");

		Vertex vertexU = new Vertex("U");
		Vertex vertexV = new Vertex("V");
		Vertex vertexW = new Vertex("W");
		Vertex vertexX = new Vertex("X");

		connectDirectedVertices(vertexV, vertexU, 4);
		connectDirectedVertices(vertexV, vertexW, -3);
		connectDirectedVertices(vertexU, vertexW, -2);
		connectDirectedVertices(vertexW, vertexX, 2);
		connectDirectedVertices(vertexX, vertexV, -1);


		WeightedDirectedGraph directedGraphNegative2 = new WeightedDirectedGraph();
		directedGraphNegative2.addVertex(vertexU);
		directedGraphNegative2.addVertex(vertexV);
		directedGraphNegative2.addVertex(vertexW);
		directedGraphNegative2.addVertex(vertexX);

		System.out.println("Shortest Path from " + vertexU.getName() + " to " + vertexX.getName() + " : " + directedGraphNegative2.getShortestPath(vertexU, vertexX));
		out = new String("Shortest Path from " + vertexU.getName() + " to " + vertexX.getName() + " : " + directedGraphNegative2.getShortestPath(vertexU, vertexX));
		correct = new String("Shortest Path from U to X : null");

		if (out.equals(correct)) {
			System.out.println("\u001b[32m\u001b[1mPASSED ✓\u001b[0m");
		} else
			System.out.println("\u001b[31m\u001b[1mFAILED ✕\u001b[0m");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\u001b[34m\u001b[1mI AM MOVING ON GUYS 'SAID WITH THE VOICE OF OUR TUTOR' 😂\u001b[0m");

		//An empty list should be returned.
		/* Expected output
		   Shortest Path from L to P : [L, N, P]
		*/

	}
}