package com.lucianpiros.algorithms.unionfind;

import java.util.List;
import java.util.ArrayList;  
import java.util.stream.IntStream;

public class QuickFindUFLambda implements UnionFind {
	class ConnectedGroup {
		public int cg;

		public ConnectedGroup(int cg) {
			this.cg = cg;
		}
	}

	private List<ConnectedGroup> id;

	public QuickFindUFLambda(int N) {
		id = new ArrayList<>();
		IntStream.range(0, N)
			.forEach(i -> id.add(new ConnectedGroup(i)));
	}

	public boolean connected(int p, int q) {
		return id.get(p).cg == id.get(q).cg;
	}

	public void union(int p, int q) {
		int pid = id.get(p).cg;
		int qid = id.get(q).cg;
		id.stream()
			.filter( s -> s.cg == pid) 
			.forEach( s -> s.cg = qid ); 
	}
}
