package com.lucianpiros.algorithms.unionfind;

import java.util.Collection;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class QuickFindUFParametrisedTest {
	enum UnionFindImp {
		QUICKFIND,
		QUICKFINDLAMBDA,
		QUICKUNION
	}

	private Random random;
	private int size;
	private UnionFindImp type;

	public QuickFindUFParametrisedTest(UnionFindImp type) {
		this.type = type;
	}

	@Before
	public void initialize() {
		random = new Random();
		size = 1 + random.nextInt(1000);	
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {
			{UnionFindImp.QUICKFIND}, 
		  	{UnionFindImp.QUICKFINDLAMBDA},
			{UnionFindImp.QUICKUNION}
			});
	}

	private UnionFind instance() {
		UnionFind uf = null;

		if(type == UnionFindImp.QUICKFIND) {
			uf = new QuickFindUF(size);
		}
		if(type == UnionFindImp.QUICKFINDLAMBDA) {
			uf = new QuickFindUFLambda(size);
		}
		if(type == UnionFindImp.QUICKUNION) {
			uf = new QuickUnionUF(size);
		}

		return uf;
	}

	@Test
	public void reflexiveProperty() {
		UnionFind qf = instance();
		for(int i = 0; i < size; i++) {	
			assertTrue(qf.connected(i,i));
		}
	}  

	@Test
	public void longChain() {
		UnionFind qf = instance();
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
		UnionFind qf = instance() ;

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
		UnionFind qf = instance();
		for(int i = 0; i < size-1; i += 2) {
			qf.union(i, i+1);	
		}

		for(int i = 0; i < size-2; i += 2) {
			assertTrue(qf.connected(i, i+1));
			assertFalse(qf.connected(i+1, i+2));
		}	
	}
}
