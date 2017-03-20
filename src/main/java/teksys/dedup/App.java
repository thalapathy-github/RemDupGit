package teksys.dedup;

import java.util.LinkedHashSet;
import java.util.Set;

import teksys.dedup.serImpl.DupeRemoveImpl;
import teksys.dedup.service.DupeRemove;

/**
 * App class is used to remove the duplicate ints in an array.
 * 
 * @author Thalapathy. Mar 15, 2017.
 */
/*
 * 1. 3 different methods are implemented.
 * 2. Method #1 uses purely Array logic, faster. Method # 2 and 3 uses Collection objects and is simpler logic.
 *    Method #3 preserves insertion order.
 * 3. Methods are synchronized : though read only operation, if different users are to pass different arrays,
 *    when collection objects are used, useful for multi threading operations.
 * 4. The above are the positive and negavites. 
 * 5. Different ways to implement : possibly Java 8's features can be used. 
 *    If the int array is huge : say a million elements, the array can be split and each can be processed using
 *    multiple threads.
 *    Logging and more exception handling to be done. (time constraint, so left it as such.)
 *    Testing code : using either JUnit or if needed, Mockito can be used.
 *    I would like to implement this as a servie and expose it as a Spring Boot / Rest service application. This
 *    main class could be the RestController and the other as Service class.
 */
public class App {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		App app = new App();
		DupeRemove dr = new DupeRemoveImpl();
		System.out.println("Calling method #1 :");
		int retArr[] = dr.removeDuplicate(app.randomIntegers);
		if(retArr == null || retArr.length==0){
			//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Duplicate in Array could not be removed or an error occurred. Please contact Administrator.");
		}else{
			printNoDupeArray(retArr);
		}

		/*int count = 0;
		for (int x : iii) {
			if (x != 0) {
				count++;
			}
		}
		int retArr[] = new int[count];
		int z = 0;
		for (int yyy : iii) {
			if (yyy != 0)
				retArr[z++] = yyy;

		}*/

		/*
		 * for(int a : retArr){ System.out.print("---"+a); }
		 */
		System.out.println("");
		System.out.println("==========================");

		System.out.println("Calling with List - method #2 :");
		// getOrderedNoDup(app.randomIntegers);
		retArr  = dr.remDuplicateUseList(app.randomIntegers);
		if(retArr== null || retArr.length==0){
			//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Duplicate in Array could not be removed or an error occurred. Please contact Administrator.");
		}else{
			printNoDupeArray(retArr);
		}
		System.out.println("");
		System.out.println("==========================");
		System.out.println("Calling with List and Ordered - method #3 :");
		  retArr = dr.getOrderedNoDup(app.randomIntegers);
		  
		  if(retArr == null || retArr.length==0){
				//exception to be logged.//
	    		//printed to console for now.
	    		System.out.println("Duplicate in Array could not be removed or an error occurred. Please contact Administrator.");
			}else{
				printNoDupeArray(retArr);				}
		 		  	 
	}


	private static void printNoDupeArray(int[] ia){
		for(int i : ia){
			
			System.out.print("-" + i);
			
		}

	}
	
	
	

}
