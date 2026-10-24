package learning_baseClass;

import org.testng.annotations.Test;

import base_utlitiy.BaseClass;

public class LeadTest extends BaseClass {

	@Test
	public void createLeadTest() throws InterruptedException {
		System.out.println("create Lead");
		System.out.println("verify Lead");
	}
	
	@Test(enabled = false)
	public void modifyLeadTest() throws InterruptedException {
		System.out.println("modifed Lead");
		System.out.println("verify modified Lead");
	}
}







