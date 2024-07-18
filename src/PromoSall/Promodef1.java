package PromoSall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Promodef1 {

	public static String promo = "promoname.csv";
	public static ArrayList<String> uniqpromoname = new ArrayList<String>();
	public static ArrayList<String> pronamedefwrit = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
	
		promodefgetting(promo);
		promonamereading();
		arraylisttotexfile();
 
		 
	}

	private static void arraylisttotexfile() {
		String outfile = "20xxx.promdef_v2.csv";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
			
			for (String str :pronamedefwrit ) {
				
				System.out.println(str);
			    writer.write(str); 
                writer.newLine();
			}
			
			writer.close();
			System.out.println("ArrayList written to file successfully."); 
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
		
		
	}

	public static ArrayList<String> promodefgetting(String A) throws FileNotFoundException {
		
		
		BufferedReader br = new BufferedReader(new FileReader(promo)); 
		String test = null;
		try {
			while ((test=br.readLine()) != null)  {	
				uniqpromoname.add(test);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		return uniqpromoname;
		
	}

	private static void promonamereading() throws Exception {
			
		String promodef = "PROMO_svwapn38a.FREEDOM_dGW_PRO_PromoDefinition.2008331.da.csv";
		BufferedReader br = new BufferedReader(new FileReader(promodef)); 

		String test;
		while ((test=br.readLine()) != null)  {	
			String[] prname = test.split(",");

			for (int i = 0; i < uniqpromoname.size(); i++) {
			if (uniqpromoname  != null && uniqpromoname.get(i).equals(prname[0]))  {
				System.out.println ("matched Zanifbaba" + i);
				System.out.println (uniqpromoname.get(i));
				System.out.println (prname[0]);
					prodefwriting(test);
				}	
			}

		}

		br.close();
		
	}

	private static void prodefwriting(String A) {
		pronamedefwrit.add(A);
		System.out.println(pronamedefwrit);
		
		
	}
	
}
