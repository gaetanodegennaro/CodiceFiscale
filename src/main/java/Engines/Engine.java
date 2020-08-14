package Engines;
import java.io.IOException;

import data.Person;

//import utils.Utils;


public class Engine
{

    private final Person p;
    private String code="";

    private String consonanti_COGNOME="";
    private String vocali_COGNOME="";
    private String consonanti_NOME="";
    private String vocali_NOME="";

    public Engine(Person person) throws IOException
    {
        this.p=person;
        p.setName(p.getName().replaceAll("'", ""));
        p.setSurname(p.getSurname().replaceAll("'", ""));
        
        populateStrings();

        code=surnameCode()+nameCode()+bithDateCode()+birthPlaceCode();
        code+=controlCode(code);
    }

    public String getCode(){return birthPlaceCode().equals(Utils.ERROR) ? "" : code;}

    private String controlCode(String s)
    {
        String c="";
        String char_posPari="";
        String char_posDispari="";
        int counter=0;
        
        for(int i=0;i<s.length();i++)
        {
            if(i%2==0) char_posDispari+=s.charAt(i); //perchè per l'algoritmo la stringa comincia da 1 e non da 0 
            else char_posPari+=s.charAt(i);
        }
        
        for(int i=0;i<char_posDispari.length();i++)
        {
            switch(char_posDispari.charAt(i))
            {
                case '0': counter+=1;break;
                case '1': counter+=0;break;
                case '2': counter+=5;break;
                case '3': counter+=7;break;
                case '4': counter+=9;break;
                case '5': counter+=13;break;
                case '6': counter+=15;break;
                case '7': counter+=17;break;
                case '8': counter+=19;break;
                case '9': counter+=21;break;
                case 'A': counter+=1;break;
                case 'B': counter+=0;break;
                case 'C': counter+=5;break;
                case 'D': counter+=7;break;
                case 'E': counter+=9;break;
                case 'F': counter+=13;break;
                case 'G': counter+=15;break;
                case 'H': counter+=17;break;
                case 'I': counter+=19;break;
                case 'J': counter+=21;break;
                case 'K': counter+=2;break;
                case 'L': counter+=4;break;
                case 'M': counter+=18;break;
                case 'N': counter+=20;break;
                case 'O': counter+=11;break;
                case 'P': counter+=3;break;
                case 'Q': counter+=6;break;
                case 'R': counter+=8;break;
                case 'S': counter+=12;break;
                case 'T': counter+=14;break;
                case 'U': counter+=16;break;
                case 'V': counter+=10;break;
                case 'W': counter+=22;break;
                case 'X': counter+=25;break;
                case 'Y': counter+=24;break;
                case 'Z': counter+=23;break;
            }
        }
        
        for(int i=0;i<char_posPari.length();i++)
        {
            switch(char_posPari.charAt(i))
            {
                case '0': counter+=0;break;
                case '1': counter+=1;break;
                case '2': counter+=2;break;
                case '3': counter+=3;break;
                case '4': counter+=4;break;
                case '5': counter+=5;break;
                case '6': counter+=6;break;
                case '7': counter+=7;break;
                case '8': counter+=8;break;
                case '9': counter+=9;break;
                case 'A': counter+=0;break;
                case 'B': counter+=1;break;
                case 'C': counter+=2;break;
                case 'D': counter+=3;break;
                case 'E': counter+=4;break;
                case 'F': counter+=5;break;
                case 'G': counter+=6;break;
                case 'H': counter+=7;break;
                case 'I': counter+=8;break;
                case 'J': counter+=9;break;
                case 'K': counter+=10;break;
                case 'L': counter+=11;break;
                case 'M': counter+=12;break;
                case 'N': counter+=13;break;
                case 'O': counter+=14;break;
                case 'P': counter+=15;break;
                case 'Q': counter+=16;break;
                case 'R': counter+=17;break;
                case 'S': counter+=18;break;
                case 'T': counter+=19;break;
                case 'U': counter+=20;break;
                case 'V': counter+=21;break;
                case 'W': counter+=22;break;
                case 'X': counter+=23;break;
                case 'Y': counter+=24;break;
                case 'Z': counter+=25;break;
            }
        }
        
        switch(counter%26)
        {
            case 0: c="A";break;
            case 1: c="B";break;
            case 2: c="C";break;
            case 3: c="D";break;
            case 4: c="E";break;
            case 5: c="F";break;
            case 6: c="G";break;
            case 7: c="H";break;
            case 8: c="I";break;
            case 9: c="J";break;
            case 10: c="K";break;
            case 11: c="L";break;
            case 12: c="M";break;
            case 13: c="N";break;
            case 14: c="O";break;
            case 15: c="P";break;
            case 16: c="Q";break;
            case 17: c="R";break;
            case 18: c="S";break;
            case 19: c="T";break;
            case 20: c="U";break;
            case 21: c="V";break;
            case 22: c="W";break;
            case 23: c="X";break;
            case 24: c="Y";break;
            case 25: c="Z";break;
        }
        return c;
    }

    private String birthPlaceCode() {return Utils.getCitiesCodes().getKey(p.getBirthPlace().toUpperCase());}

    private String bithDateCode()
    {
        int giorno=Integer.parseInt(p.getBirthDay());

        String s="";
        String annoS=Integer.parseInt(p.getBirthYear())+"";
        s=s+annoS.charAt(2)+annoS.charAt(3);
        switch(Integer.parseInt(p.getBirthMonth()))
        {
            case 1: s+="A";break;
            case 2: s+="B";break;
            case 3: s+="C";break;
            case 4: s+="D";break;
            case 5: s+="E";break;
            case 6: s+="H";break;
            case 7: s+="L";break;
            case 8: s+="M";break;
            case 9: s+="P";break;
            case 10: s+="R";break;
            case 11: s+="S";break;
            case 12: s+="T";break;
        }

        if(p.getSex()=='M')
        {
            if(giorno<10) s+="0"+giorno;
            else s+=giorno;
        }
        else s+=(giorno+40);

        return s;
    }

    private String nameCode()
    {
        String s="";
        if(consonanti_NOME.length()>3)
        {
            s=s+consonanti_NOME.charAt(0)+consonanti_NOME.charAt(2)+consonanti_NOME.charAt(3);
            return s;
        }
        if(consonanti_NOME.length()==3)
        {
            for(int i=0;i<3;i++) s=s+consonanti_NOME.charAt(i);
            return s;
        }
        if(consonanti_NOME.length()==2)
        {
            s=s+consonanti_NOME.charAt(0)+consonanti_NOME.charAt(1)+vocali_NOME.charAt(0);
            return s;
        }
        if(consonanti_NOME.length()==1)
        {
            s=s+consonanti_NOME.charAt(0)+vocali_NOME.charAt(0)+vocali_NOME.charAt(1);
            return s;
        }
        else
        {
            for(int i=0;i<3;i++) s=s+vocali_NOME.charAt(i);
            return s;
        }
    }

    private String surnameCode()
    {
        String s="";
        if(consonanti_COGNOME.length()>=3)
        {
            for(int i=0;i<3;i++) s=s+consonanti_COGNOME.charAt(i);
            return s;
        }
        if(consonanti_COGNOME.length()==2)
        {
            s=s+consonanti_COGNOME.charAt(0)+consonanti_COGNOME.charAt(1)+vocali_COGNOME.charAt(0);
            return s;
        }
        if(consonanti_COGNOME.length()==1)
        {
            s=s+consonanti_COGNOME.charAt(0)+vocali_COGNOME.charAt(0)+vocali_COGNOME.charAt(1);
            return s;
        }
        else
        {
            for(int i=0;i<3;i++) s=s+vocali_COGNOME.charAt(i);
            return s;
        }
    }

    private void populateStrings()
    {
        String cognome = p.getSurname().toUpperCase();
        for(int i=0;i<cognome.length();i++)
        {
            if(isVocal(cognome.charAt(i))) vocali_COGNOME=vocali_COGNOME+cognome.charAt(i);
            else if(cognome.charAt(i)!=' ') consonanti_COGNOME=consonanti_COGNOME+cognome.charAt(i);
        }
                
        String nome = p.getName().toUpperCase();
        for(int i=0;i<nome.length();i++)
        {
            if(isVocal(nome.charAt(i))) vocali_NOME=vocali_NOME+nome.charAt(i);
            else if(nome.charAt(i)!=' ') consonanti_NOME=consonanti_NOME+nome.charAt(i);
        }
    }

    private boolean isVocal(char c){return c=='A' || c=='E' || c=='I' || c=='O' || c=='U';}
	
}
