package teksys.dedup.serImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import teksys.dedup.service.DupeRemove;

public class DupeRemoveImpl implements DupeRemove{

	/*
	 * (non-Javadoc)
	 * @see teksys.dedup.service.DupeRemove#removeDuplicate(int[])
	 * Method # 1: Uses purely Array logic.
	 */
	@Override
	public int[] removeDuplicate(int[] dupArr) {
		// TODO Auto-generated method stub
		
		int result[] = new int[dupArr.length]; 
		int retArr[] = null;
        try{
        int j=0;
        for (int i : dupArr) {
            if(!isAvailable(result, i))
                result[j++] = i;
        }
       
        
        int count = 0;
		for (int x : result) {
			if (x != 0) {
				count++;
			}
		}
		retArr = new int[count];
		int z = 0;
		for (int yyy : result) {
			if (yyy != 0)
				retArr[z++] = yyy;

		}
               
    	}catch(ArrayIndexOutOfBoundsException aiobe ){ //If > Java7, can use multiple exception handling here.
    		//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Exception in method :removeDuplicate " + aiobe.toString());
    	}catch(Exception e){
    		//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Exception in method :removeDuplicate " + e.toString());	
    	}
   
        return retArr;
    }
    private static boolean isAvailable(int[] arr, int value) throws Exception{
        for (int i : arr) {
            if(i==value)
                return true;
        }
        return false;
    }

    //2nd implementation:
    /*
     * (non-Javadoc)
     * @see teksys.dedup.service.DupeRemove#remDuplicateUseList(int[])
     * Method uses a Collection objects : List, ArrayList.
     * Advantage : Simpler logic.
     */
    @Override
    public synchronized int[] remDuplicateUseList(int[] list){
    	
    	int ir[] = new int[0];
    	try{
	        if(list.length == 0){
	            return ir;
	        }
	        if(list.length == 1){
	            return list;
	        }
	
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 0; i< list.length; i++){
	        if (!numbers.contains(list[i])){
	            numbers.add(list[i]);
	        }
	    }
	    Iterator<Integer> valueIterator = numbers.iterator();
	    int[] resultArray = new int[numbers.size()]; 
	    int i = 0;
	    while (valueIterator.hasNext()) {
	        resultArray[i] = valueIterator.next();
	        i++;
	    }
	    return resultArray;     
    	}catch(Exception e){
    		//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Exception in method :remDuplicateUseList " + e.toString());
    	}
    	return ir;
	}
    
//3rd implementation:
    /*
     * (non-Javadoc)
     * @see teksys.dedup.service.DupeRemove#getOrderedNoDup(int[])
     * Method # 3 uses Collection objects and preserves the insertion / original order.
     */
    @Override
    public synchronized int[] getOrderedNoDup(int[] intArr){
    	
    	int ir[] = new int[0];
    	try{
        Set<Integer> setInt = new LinkedHashSet<Integer>();
        for(int i=0;i<intArr.length;i++){
            setInt.add(intArr[i]);
        }
        int retArr[] = new int[setInt.size()];
        
        int cnt=0;
        for(int i : setInt){
        	retArr[cnt++] = i;
        }
        
        return retArr;
    	}catch(Exception e){
    		//exception to be logged.//
    		//printed to console for now.
    		System.out.println("Exception in method :getOrderedNoDup " + e.toString());
    	}
        return ir;
        
    }
	
		
		
}
