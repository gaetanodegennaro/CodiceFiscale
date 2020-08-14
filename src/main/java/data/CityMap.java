package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class CityMap extends HashMap<String, String> {

	/**
	 * Using sub-procedures becouse methods couldn't have more than 65535 lines of code
	 */
    public CityMap()
    {
    	try
        {
            BufferedReader csvReader = new BufferedReader(new FileReader("elenco_comuni_province.csv"));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                this.put(data[2], data[0].toUpperCase());
            }
            csvReader.close();
            
            csvReader = new BufferedReader(new FileReader("elenco_stati.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                this.put(data[1], data[0].toUpperCase());
            }
            csvReader.close();
        }
        catch(IOException e) {e.printStackTrace();}
    }

    public String getKey(String s){
        String res = "";
        for (Map.Entry<String, String> e : this.entrySet()) {
            if(s.equals(e.getValue()))
                res = e.getKey();
        }
        return res;
    }

}
