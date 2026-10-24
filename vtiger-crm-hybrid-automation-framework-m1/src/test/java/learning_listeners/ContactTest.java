package learning_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners_utility.List_Imp.class)
public class ContactTest {
	@Test
	public void createContactTest() {
		Assert.assertTrue(true);
		System.out.println("created Contact");
	}
	@Test
	public void modifyContactTest() {
		Assert.assertTrue(false);
		System.out.println("modified Contact");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		Assert.assertTrue(false);
		System.out.println("deleted Contact");
	}
}
