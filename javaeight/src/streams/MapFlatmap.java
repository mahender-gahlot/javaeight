package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFlatmap {

	public static void main(String[] args) {
		
		
		List<Integer> nums=Arrays.asList(1,2,3,4,5);
		
		List<Integer> sqrs=nums.stream().map(n->n*n).collect(Collectors.toList());
		
		System.out.println(sqrs);
		
		
		List<Integer> list1=Arrays.asList(2,3);
		List<Integer> list2=Arrays.asList(4,5,6);
		
		List<int[]> pais= list1.stream().flatMap(i->list2.stream().map(j->new int[] {i,j})).collect(Collectors.toList());
		
		for (int[] ks : pais) {
			for (int k : ks) {
				System.out.print(k);
			}
			System.out.println("");
		}
		
		
		
	}
}
