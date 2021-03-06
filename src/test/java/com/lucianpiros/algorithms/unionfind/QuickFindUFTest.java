package com.lucianpiros.algorithms.unionfind;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import java.util.Random;

public class QuickFindUFTest {
	private Random random;
	private int size;

	@Before
	public void initialize() {
		random = new Random();
		size = 1 + random.nextInt(1000);	
	}

	@Test
	public void reflexiveProperty() {
		UnionFind qf = new QuickFindUF(size);
		for(int i = 0; i < size; i++) {	
			assertTrue(qf.connected(i,i));
		}
	}  

	@Test
	public void longChain() {
		UnionFind qf = new QuickFindUF(size);
		for(int i = 0; i < size-1; i++) {
			qf.union(i, i+1);
		}
		
		int noTests = 1 + random.nextInt(size);	
		for(int i = 0; i < noTests; i++) {
			int p = random.nextInt(size);
			int q = random.nextInt(size);
			assertTrue(qf.connected(p, q));
		}
	}

	@Test
	public void noConnectedComponents() {
		UnionFind qf = new QuickFindUF(size);

		int noTests = 1 + random.nextInt(size);
		for(int i = 0; i < noTests; i++) {
			int p = random.nextInt(size);
			int q = random.nextInt(size);
			if(p != q) {
				assertFalse(qf.connected(p,q));
			}
		}
	}

	@Test
	public void connect2by2() {
		UnionFind qf = new QuickFindUF(size);
		for(int i = 0; i < size-1; i += 2) {
			qf.union(i, i+1);	
		}

		for(int i = 0; i < size-2; i += 2) {
			assertTrue(qf.connected(i, i+1));
			assertFalse(qf.connected(i+1, i+2));
		}	
	}
}
