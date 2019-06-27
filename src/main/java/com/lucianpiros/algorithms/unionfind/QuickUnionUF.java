package com.lucianpiros.algorithms.unionfind;

public class QuickUnionUF implements UnionFind {
	private int[] id;
	private int[] size;

	public QuickUnionUF(int N) {
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	private int root(int i) {
		while( i != id[i] ) {
			i = id[i];
		}

		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);

		if(rp != rq) {
			if(size[rp] < size[rq]) {
				id[rp] = rq;
				size[rq] += size[rp];
			}
			else {
				id[rq] = rp;
				size[rp] += size[rq];	
			}
		}
	}
}
