//Using Heaps. O()

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
