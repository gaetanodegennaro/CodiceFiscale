package data;

import java.util.Map;
import java.util.TreeMap;

import Engines.Utils;

@SuppressWarnings("serial")
public class CitiesCodes extends TreeMap<String, String>
{
    CityMap ccA = new CityMap();

    public CitiesCodes()
    {      
        this.putAll(ccA);
    }

    public String getKey(String s){
        String res = Utils.ERROR;
        for (Map.Entry<String, String> e : this.entrySet()) {
            if(s.equals(e.getValue()))
                res = e.getKey();
        }
        return res;
    }
    
    public String getValue(String s){
        return this.get(s);
    }

}
