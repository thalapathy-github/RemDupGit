package teksys.dedup.service;

public interface DupeRemove {
	public int[] removeDuplicate(int ir[]);

	public int[] remDuplicateUseList(int intArr[]);

	public int[] getOrderedNoDup(int[] intArr);

}
