package com.lucianpiros.algorithms.unionfind;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import java.util.Random;

public class QuickFindUFCrossTest {
	private Random random;
	private int size;

	@Before
	public void initialize() {
		random = new Random();
		size = 1 + random.nextInt(1000);	
	}

	@Test
	public void connectSameResult() {
		QuickFindUF qf = new QuickFindUF(size);
		QuickFindUFLambda qfl = new QuickFindUFLambda(size);
		int nu = 1 + random.nextInt(2*size);
		for(int i = 0; i < nu; i++ ) {
			int p = random.nextInt(size);
			int q = random.nextInt(size);
			qf.union(p, q);	
			qfl.union(p, q);
		}

		int nc = 1 + random.nextInt(2*size);
		for(int i = 0; i < nc; i++) {
			int p = random.nextInt(size);
			int q = random.nextInt(size);
			assertTrue(qf.connected(p, q) == qfl.connected(p, q));
		}	
	}
}
