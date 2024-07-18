
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class Smarttab_v555 {

	public static ArrayList<String> targetpromoarray = new ArrayList<String>();
	public static ArrayList<String> deviceuniqsku = new ArrayList<String>();
	public static ArrayList<String> testfnc = new ArrayList<String>();
	public static HashMap<String,String> tabfinancehashdevice = new HashMap<String,String>();
	public static HashMap<String,String> tabfinanceduplidevice = new HashMap<String,String>();
	public static HashMap<String,String> skudevicename = new HashMap<String,String>();
	public static HashMap<String,String> skuandRP = new HashMap<String,String>();
	public static File file = new File("C:\\Users\\mmizanur\\eclipse-workspace\\Test\\output_zanif\\PROMOOutput.csv");
	public static String existingpromodevicefile = "uat.dGW_SmartTabLimitedOffer.9114484.da.csv";
	public static String smarttabfile = "zanifpromopricinginput.csv";
	public static String tabfinancefile = "uat.TabFinancingAllocations.9113843.da.csv";
	
	
	public static void main(String[] args) throws Exception {
			

		outfilecreation();
		uatpromo(existingpromodevicefile);
		promocsvreading(smarttabfile);
		tabfinancehash(tabfinancefile);
		formatoutput(targetpromoarray);

		System.out.println("Done..See the output file please. Thanks");
}
	public static void outfilecreation() {

		File existingFile = file;

		if (existingFile.exists() && existingFile.isFile()) {
		    existingFile.delete();
		  }
		
	}
	
	public static void outputfile(String S) {
	
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(S+"\n");
			bw.close();
			
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}	

	}
	public static  HashMap<String,String> tabfinancehash(String B) throws IOException {
		BufferedReader tabfinance = new BufferedReader(new FileReader(B));
		String tabline;
		int duplicatecount =0;
		while ((tabline = tabfinance.readLine()) != null) {
			String[] tabfspilt = tabline.split(",");
		if (!tabfinancehashdevice.containsKey(tabfspilt[2])) {
			tabfinancehashdevice.put(tabfspilt[2],tabfspilt[1]);
			}	
		}
		return tabfinancehashdevice;
	}

	public static String insertingcomma() {
	StringBuilder bld = new StringBuilder();
	String b=",";
	  for (int i = 0; i < 16; ++i) {
	    bld.append(b);
	  }
	 String str = bld.toString();
	  return str;
	}

	public static  ArrayList<String> uatpromo(String A) throws Exception {	
try {
	BufferedReader skuread = new BufferedReader(new FileReader(A));
	String devicesku;
	while ((devicesku = skuread.readLine()) !=null) {
	String[] splitString = devicesku.split(",");

	skudevicename.put(splitString[2], splitString[1]);
	skuandRP.put(splitString[0], splitString[2]);

	}
	
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
		return deviceuniqsku;
		
	}
		
	public static  ArrayList<String> promocsvreading(String A) throws IOException {
		try (BufferedReader smartread = new BufferedReader(new FileReader(A))) {	
			String eachlineread;
			while ((eachlineread = smartread.readLine()) != null) {
				String[] splitString = eachlineread.split(",");
				targetpromoarray.add(eachlineread);
			}
		}
		
	ArrayList<String> b = null;
	ArrayList<String> splitString = null;
	
	return targetpromoarray;
	}
	 
	public static  Object formatoutput(ArrayList<String> B) throws IOException {

			ArrayList<Object> testfnc = new ArrayList<Object>();
			for (int i=0; i<B.size(); i++ ) {
			String[] splitpromo = B.get(i).split(",");
			
if (skudevicename.containsKey(splitpromo[2])) {
	/*testfnc.add(splitpromo[0]+"," + skudevicename.get(splitpromo[2])+ ","+ splitpromo[2]+ "," + insertingcomma()+ ","+ splitpromo[3]+ "," + splitpromo[4]+ "," + ","+ 
					splitpromo[5]+ " " + "00:00:00" + ","+ splitpromo[6]+ " " + "00:00:00" +insertingcomma() + "NA"); */
String S = null;
 S = (splitpromo[0]+"," + skudevicename.get(splitpromo[2])+ ","+ splitpromo[2]+ "," + insertingcomma()+ ","+ splitpromo[3]+ "," + splitpromo[4]+ "," + ","+ splitpromo[5]+ " " + "00:00:00" + ","+ splitpromo[6]+ " " + "00:00:00" +insertingcomma() + "NA");
	outputfile(S);
}
				
else if (!skudevicename.containsKey(splitpromo[2]))  {
			
		/*	testfnc.add (splitpromo[0]+"," + tabfinancehashdevice.get(splitpromo[2])+ ","+ splitpromo[2]+ "," + insertingcomma()+ ","+ splitpromo[3]+ "," + splitpromo[4]+ "," + ","+ 
splitpromo[5]+ " " + "00:00:00" + ","+ splitpromo[6]+ " " + "00:00:00" +insertingcomma() + "NA"); */
	String O = null;		
	O = (splitpromo[0]+"," + tabfinancehashdevice.get(splitpromo[2])+ ","+ splitpromo[2]+ "," + insertingcomma()+ ","+ splitpromo[3]+ "," + splitpromo[4]+ "," + ","+ splitpromo[5]+ " " + "00:00:00" + ","+ splitpromo[6]+ " " + "00:00:00" +insertingcomma() + "NA");

	outputfile(O);
			}

			}
			
			return testfnc;
		}
		
	}

