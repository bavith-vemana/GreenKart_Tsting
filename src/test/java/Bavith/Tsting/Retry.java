package Bavith.Tsting;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int i=0;
	int maxtry = 1;
	@Override
	public boolean retry(ITestResult result) {
		
		if(i<maxtry)
		{
			i++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
