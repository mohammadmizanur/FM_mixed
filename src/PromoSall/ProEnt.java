package PromoSall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProEnt {
	
	public static String targetpromoname = "promoname.csv";
	public static String promoent = "PROMO_svwapn38a.FREEDOM_dGW_PRO_EntitlementCat.9100022.da.csv";
	public static ArrayList<String>targetpromolist = new ArrayList<String>();
	public static ArrayList<String>promoentarray = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		targetpromo();
		System.out.println(targetpromolist);
		prpmorulereading();
		System.out.println(promoentarray);
		arraylisttotexfile();

	}

	private static void arraylisttotexfile() {
		String outwritefile2 = "20xxx.promoent.csv";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outwritefile2));
			
			for (String str : promoentarray ) {
				
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

	private static void prpmorulereading() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(promoent));
		String rule;
		while (( rule = br.readLine()) != null) {
			String[] prrule = rule.split(",");
			
			for (int i = 0; i < targetpromolist.size(); i++) {
			if (targetpromolist  != null && targetpromolist.get(i).equals(prrule[0]))  {

				promoentarray.add(rule);
				}	
			}
			
		}
		}
		


	private static void targetpromo() throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(targetpromoname)); 
		String test = null;
		try {
			while ((test=br.readLine()) != null)  {	
				targetpromolist.add(test);

			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		br.close();	

		
	}


}
