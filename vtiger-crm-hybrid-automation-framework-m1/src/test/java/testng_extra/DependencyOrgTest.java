package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyOrgTest {

//	dependsOnMethods => to add dependency between 2 test cases
//					 => suppose tc2 is dependent on tc1 
//					 => if tc1 gets pass, then tc2 will run
//					 => if tc1 gets fail, then tc2 will be skipped
	
	@Test
	public void createOrgTest() {
		System.out.println("created qspiders");
	}
	
	@Test(dependsOnMethods = "createOrgTest")
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("modified qspiders to spiders");
	}
	
	@Test(dependsOnMethods = "modifyOrgTest")
	public void deleteOrgTest() {
		System.out.println("deleted spiders");
	}
}