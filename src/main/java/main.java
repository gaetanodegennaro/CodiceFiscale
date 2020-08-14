import java.io.IOException;

import Engines.Engine;
import Engines.ReverseEngine;
import data.Person;

public class main
{
    public static void main(String args[])
    {
        try
        {
            System.out.println("From person to code:");
            Engine engine = new Engine(new Person("Mario","Rossi","Albania","-","04-04-1995",'M'));
            System.out.println(engine.getCode());
            
            System.out.println("\nFrom person to code:");
            engine = new Engine(new Person("Mario","Rossi","Molfetta","BA","04-04-1995",'M'));
            System.out.println(engine.getCode());

            System.out.println("\nFrom code to person:");
            ReverseEngine reverseEngine = new ReverseEngine("RSSMRA95D04F284X");
            System.out.println(reverseEngine.getCity());
            System.out.println(reverseEngine.getCountry());
            System.out.println(reverseEngine.getDay()+"-"+reverseEngine.getMonth()+"-"+reverseEngine.getYear());
            System.out.println(reverseEngine.getSex());
        }
        catch(IOException e) {e.printStackTrace();}
        
        System.exit(0);
    }
}
