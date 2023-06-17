package other.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 * Not to use these classses
 * Refer utils/listeners
 */
/*
public class RetryListener implements IAnnotationTransformer {

	
	public void transform(ITestAnnotation testannotation, Class testClass,
			Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(Retry.class);
		}

	}
}

*/
public class RetryListener implements IAnnotationTransformer {
	@SuppressWarnings({ "rawtypes" })
	@Override
	public void transform(ITestAnnotation itestannotation, Class testClass, Constructor testConstructor, Method testMethod) {
		itestannotation.setRetryAnalyzer(Retry.class);
	}
}