package Engines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class ReverseEngine
{
    private final String code;
    
    public ReverseEngine(String code)
    {
        this.code = code;
    }
    
    public String getDay()
    {
        int day = Integer.parseInt(code.substring(9, 11));
        if(day>40) day-=40;
        String stringDay = Integer.toString(day);
        if(stringDay.length()==1) stringDay="0"+stringDay;
        return stringDay;
    }
    
    public String getMonth()
    {
        String month="";
        switch(code.charAt(8))
        {
            case 'A': month="01";break;
            case 'B': month="02";break;
            case 'C': month="03";break;
            case 'D': month="04";break;
            case 'E': month="05";break;
            case 'H': month="06";break;
            case 'L': month="07";break;
            case 'M': month="08";break;
            case 'P': month="09";break;
            case 'R': month="10";break;
            case 'S': month="11";break;
            case 'T': month="12";break;
        }
        return month;
    }
    
    public String getYear()
    {
        String year = code.substring(6, 8);
        if(Integer.parseInt(year)>=0 && Integer.parseInt(year)<=Integer.parseInt(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)).substring(2, 4)))
            return "20"+year;
        else return "19"+year;
    }
    
    public char getSex()
    {
        if(Integer.parseInt(code.substring(9, 11))>40) return 'F';
        else return 'M';
    }
    
    public String getCity()
    {
        String output="";
        String citta = Utils.getCitiesCodes().getValue(code.substring(11,15));
        String splittedCitta[] = citta.split(" ");
        for(String s: splittedCitta) output+= s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase()+" ";
        
        return output.substring(0, output.length()-1);
    }
    
    public String getCountry()
    {
        String codCitta = code.substring(11,15);
        String provincia = "";
        try
        {
            FileReader fr = new FileReader("res\\comuni_"+codCitta.charAt(0)+".csv");
            BufferedReader br = new BufferedReader(fr);

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                String splittedLine[] = sCurrentLine.split(";");
                if(splittedLine[2].equals(codCitta))
                {
                    provincia = splittedLine[1];
                    break;
                }
            }
            fr.close();
            br.close();
        }
        catch (IOException e) {e.printStackTrace();}
        return provincia;
    }
    
}
