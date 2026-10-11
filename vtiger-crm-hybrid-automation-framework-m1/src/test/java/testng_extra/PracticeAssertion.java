package testng_extra;

import static org.junit.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeAssertion {
	@Test
	public void case1() {
		boolean a = true;
		boolean b = false;

		String c = "abc";
		String d = "xyz";
		String e = "pqr";
		String f = "xyz";

		Object g = null;
		Object h = new Object();

//		Assert.assertTrue(b);
//		Assert.assertFalse(a);
//		
//		Assert.assertEquals(c, f);
//		Assert.assertNotEquals(d, f);
//		
//		Assert.assertNull(h);
//		Assert.assertNotNull(g);

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(b);
		sa.assertFalse(a);

		sa.assertEquals(c, f);
		sa.assertNotEquals(d, f);

		sa.assertNull(h);
		sa.assertNotNull(g);

		sa.assertAll();
	}
}
