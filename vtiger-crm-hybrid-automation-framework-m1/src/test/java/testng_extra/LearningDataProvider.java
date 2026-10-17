package testng_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearningDataProvider {
//	executing same test script multiple times
//	with the different set of data
	@Test(dataProvider = "getData")
	public void case1(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

//	Mark a method as supplying data for a test method.
	@DataProvider
	public Object[][] getData() {
		Object[][] creds = new Object[5][2];
//						num of row = num of execution
//						num of col = num of parameters in @Test method
		creds[0][0] = "Arushi";
		creds[0][1] = "1234567890";

		creds[1][0] = "Anshu";
		creds[1][1] = "1234567890";

		creds[2][0] = "Ananta";
		creds[2][1] = "Anant@123";

		creds[3][0] = "kunal";
		creds[3][1] = "Test@123";

		creds[4][0] = "Rahul";
		creds[4][1] = "RK#Tester@2026";
		return creds;
	}
}
