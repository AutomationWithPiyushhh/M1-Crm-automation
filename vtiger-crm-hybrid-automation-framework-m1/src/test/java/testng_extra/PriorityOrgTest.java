package testng_extra;

import org.testng.annotations.Test;

public class PriorityOrgTest {

//	priority => To change the order of execution we go for priority
//				lesser the value => earlier the execution
//				default value => 0
	
	@Test(priority = -1)
	public void createOrgTest() {
		System.out.println("created qspiders");
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("modified qspiders to spiders");
	}
	
	@Test(priority = 0)
	public void deleteOrgTest() {
		System.out.println("deleted spiders");
	}
}