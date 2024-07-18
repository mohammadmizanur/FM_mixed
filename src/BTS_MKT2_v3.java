import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BTS_MKT2_v3 {


	public static ArrayList<String> mktarray = new ArrayList<String>();
	public static ArrayList<String> channelcode = new ArrayList<String>();
	public static ArrayList<String> outputarrray = new ArrayList<String>();
	static String mktname = "BTS_MktName_ON_AB_BC_36.csv";
	static String channel = "BTS_ChanellCode_43.csv";
	static String outfile = "FinalOutputmkt.csv";
	
	public static void main(String[] args) throws Exception {
		mktread();
		channelread();
		filewrite();
		arraylisttotexfile ();
	}

	private static void arraylisttotexfile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
		for (String str :outputarrray ) {	
		    writer.write(str); 
            writer.newLine();
		}
		writer.close();
		
	}

	private static void filewrite() {
		String output = null;
		for (int i = 0; i < channelcode.size(); i++) {	
			for (int j = 0; j < mktarray.size(); j++) {		
			output = (channelcode.get(i) +','+ mktarray.get(j));
			System.out.println(channelcode.get(i) +','+ mktarray.get(j));
			outputarrray.add(output);
						
			}
		}	
		
	}

	private static void mktread() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(mktname)); 
		String mkt;
		int count = 0;
		while ((mkt=br.readLine()) != null)  {
			mktarray.add(mkt);
			count++;
	}
		System.out.println("Hello totalmkt count: "+count);
		br.close();
	}

	private static void channelread() throws IOException {	
		BufferedReader br = new BufferedReader(new FileReader(channel)); 
		int count = 0;
		try {
			while ((channel=br.readLine()) != null)  {	
				channelcode.add(channel);
				count++;
			}			
			System.out.println("HelloTotalchannel: "+count);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		br.close();

	}
}

