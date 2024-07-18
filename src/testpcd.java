import java.util.ArrayList;
import java.util.Arrays;

public class testpcd {

	public static void main(String[] args) {
		ArrayList<String> testarraylist = new ArrayList<String>();
		testarraylist.add("Zanif");
		testarraylist.add("Baba");
	//	System.out.println(testarraylist.get(0));
		String a = "Zanif, BMW, Ford, Mazda";
		
		String [] toarryzanif = new String[testarraylist.size()];
		toarryzanif = testarraylist.toArray(toarryzanif);
		
	// 	String str = Arrays.toString(testarraylist.toArray());


		String[] testarray2 = a.split(",");
	
		System.out.println (toarryzanif[0]);
		System.out.println (testarray2[0]);
		
	//	if (toarryzanif[0].equals(testarray2[0])) {
			
			if (testarraylist.get(0).equals(testarray2[0])) {
			System.out.println("Matched");
		}
		// System.out.println(testarraylist.getClass().getSimpleName());
	//	System.out.println(testarray1.getClass().getSimpleName());
		// System.out.println(str.getClass().getSimpleName());
		// System.out.println(testarray2[0]);
		System.out.println(toarryzanif.getClass().getSimpleName()); 
		System.out.println(testarray2.getClass().getSimpleName()); 
	}

}
