package learning_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners_utility.List_Imp.class)
public class OrgTest {
	@Test
	public void createOrgTest() {
		Assert.assertTrue(true);
		System.out.println("created org");
	}
	@Test
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("modified org");
	}
	@Test(dependsOnMethods = "modifyOrgTest")
	public void deleteOrgTest() {
		Assert.assertTrue(false);
		System.out.println("deleted org");
	}
}
