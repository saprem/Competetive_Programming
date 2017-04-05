//Using Heaps. O()
public class C20_Djikstra {
	

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node[] arr = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new Node(i);
		}
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			Node n1 = arr[Integer.parseInt(st.nextToken())];
			Node n2 = arr[Integer.parseInt(st.nextToken())];
			int val = Integer.parseInt(st.nextToken());
			Edge e = new Edge(n1, n2, val);
			n1.neighbours.add(e);
			n2.neighbours.add(e);

		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Node root = arr[1];
		root.distance = 0;
		pq.add(root);
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			//if (cur.visited)
			//	continue;
			cur.visited = true;
			for (int i = 0; i < cur.neighbours.size(); i++) {
				Edge temp = cur.neighbours.get(i);
				Node f = temp.other(cur);
				if (f.visited)
					continue;
				if (f.distance > cur.distance + temp.val) {
					f.distance = cur.distance + temp.val;
					f.parent = cur;
					pq.add(f);
				}
				
			}
		}
		Node end = arr[n];
		if (end.distance == Integer.MAX_VALUE)
			System.out.println("-1");
		else {
			Stack<Integer> stack = new Stack<>();
			while (true) {
				stack.push(end.id);
				if (end == root)
					break;
				end = end.parent;
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
			}
			System.out.println(sb.toString());
		}
		br.close();
	}
	static class Node implements Comparable<Node> {
		int id;
		Node parent = null;
		int distance = Integer.MAX_VALUE;
		ArrayList<Edge> neighbours = new ArrayList<Edge>();
		boolean visited = false;

		public Node(int i) {
			id = i;
		}

		public void setD(int i) {
			distance = i;
		}

		public int compareTo(Node n) {
			return distance - n.distance;
		}
	}

	static public class Edge {
		Node n1, n2;
		int val;

		public Edge(Node v1, Node v2, int v) {
			n1 = v1;
			n2 = v2;
			val = v;
		}

		public Node other(Node n) {
			if (n == n1)
				return n2;
			return n1;
		}
	}
}
