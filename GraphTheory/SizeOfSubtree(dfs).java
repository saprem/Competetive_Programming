public static void dfs(int u) {
		vis[u] = true;
		size[u] = 1;
		for (int v : al[u]) {
			if (!vis[v]) {
				dfs(v);
				size[u] += size[v];
			}
	}
