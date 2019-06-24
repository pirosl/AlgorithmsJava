import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickFindUFTest {

	@Test
	public void flexiveProperty() {
		QuickFindUF qf = new QuickFindUF(10);
		assertTrue(qf.connected(0,0));
	}  
}
