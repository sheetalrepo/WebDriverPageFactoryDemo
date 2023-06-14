package demo.listeners;

import com.helper.PropertyFileReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 
 * config.properties > failed_case_retry_count=5
 */
public class Retry implements IRetryAnalyzer {

	 private int retryCount = 0;
	 PropertyFileReader obj = new PropertyFileReader();
	 
	 
	    public boolean retry(ITestResult result) {
	    	
			//fetch retry count from property file
	    	int maxRetryCount = Integer.parseInt(obj.getPropertyMap().get("failed_case_retry_count"));
	    	
	        if (retryCount < maxRetryCount) {
	            System.out.println(">>> Retrying test " + result.getName() + " with status "
	                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	    
	    public String getResultStatusName(int status) {
	    	String resultName = null;
	    	if(status==1)
	    		resultName = "SUCCESS";
	    	if(status==2)
	    		resultName = "FAILURE";
	    	if(status==3)
	    		resultName = "SKIP";
			return resultName;
	    }

}
