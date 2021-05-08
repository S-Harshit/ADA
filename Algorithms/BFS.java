
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void Bfs(int graph[][]) {

		int color[] = new int[graph.length];
		int distance[] = new int[graph.length];

		for (int i = 0; i < graph.length; i++) {
			color[i] = 0;
			distance[i] = 99999999;
		}

		color[0] = 1;
		distance[0] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);

		while (!q.isEmpty()) {
			int u = q.remove();
			for (int i = 0; i < graph.length; i++) {
				if ((graph[u][i]) == 1) {
					if (color[i] == 0) {
						color[i] = 1;
						distance[i] = distance[u] + 1;
						q.add(i);
					}
				}
			}
			color[u] = 2;
			System.out.print(u + " --> ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int graph[][] = { { 0, 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 1 } };
		Bfs(graph);

	}

}
