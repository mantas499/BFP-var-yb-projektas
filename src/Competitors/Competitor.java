/*
 * Varžybų dalyvio klasė, realizuojanti interface'sa KTUable
 * Šioje klasėje aprašomi dalyvio duomenys
 */
package Competitors;
import ResultsCounting.EventResult;
import java.io.Serializable;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author manant1
 */
public class Competitor implements KTUable<Competitor>{

    protected String[] resultsString;
    protected String[] eventName;
    protected String[] eventResult;
    private int ID;
    private String Name;
    private String LastName;
    private String Gender;
    private int Born;
    private String City;
    private String Coach;
    private int Place;
    private double Score;
    
    public Competitor()
    {   
        this.resultsString = new String[6];
        this.eventName = new String[6];
        this.eventResult = new String[6];
    }
    
    public Competitor(int ID, String Name, String LastName, int Born, String City, String Coach, String Gender)
    {
        this.ID = ID;
        this.Name = Name;
        this.LastName = LastName;
        this.Born = Born;
        this.City = City;
        this.Coach = Coach;
        Place = 0;
        Score = 0.0;
        this.Gender = Gender;
        this.resultsString = new String[6];
        this.eventResult = new String[6];
        this.eventName = new String[6];
    }
    
    public Competitor(String DateString)
    {
        this.eventResult = new String[6];
        this.eventName = new String[6];
        this.parse(DateString);
    }
    
    public void setResultsString(String[] results)
    {
        resultsString = results;
    }
    
    public String[] getResultsString()
    {
        return resultsString;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public int getYears()
    {
        return Born;
    }
    
    public String getCoach()
    {
        return Coach;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getLastName()
    {
        return LastName;
    }
    
    public String getCity()
    {
        return City;
    }
    
    public String getFullName()
    {
        return (Name + " " + LastName);
    }
    
    public String getGender()
    {
        return Gender;
    }
    
    public double getScore()
    {
        return Score;
    }
    
    public int getPlace()
    {
        return Place;
    }
    
    public void setScore(double EventScore)
    {
        Score += EventScore;
    }
    
    public void setEventsScores(String[] eventResults)
    {
        this.eventResult = eventResults;
    }
    
    public String[] getEventsScores()
    {
        return eventResult;
    }
    
    public void setEventName(String name, int eventNumber)
    {
        if(name == null && name.isEmpty())
        {
            eventName[eventNumber] = "";
        }
        else
        {
            eventName[eventNumber] = name;
        }
    }
    
    public void setEventScore(String score, int eventNumber)
    {
        if(score == null)
        {
            eventResult[eventNumber] = "";
        }
        else
        {
            eventResult[eventNumber] = score;
        }
    }
    
    public void resetScore()
    {
        Score = 0;
    }
    
    public void resetPlace()
    {
        Place = 0;
    }
    
    public void setPlace(int Place)
    {
        this.Place = Place;
    }
    
    public void setGender(String genderString)
    {
        Gender = genderString;
    }
    
    public void setName(String name)
    {
        Name = name;
    }
    
    public void setSurname(String surname)
    {
        LastName = surname;
    }
    
    public void setCoach(String coach)
    {
        Coach = coach;
    }
    
    public void setCity(String city)
    {
        City = city;
    }
    
    public void setAge(int years)
    {
        Born = years;
    }
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
            
    @Override 
    public String toString()
    {
            return String.format("%d,%d,%s,%s,%d,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
                    Place, ID, Name, LastName, Born, City, Coach, Gender, resultsString[0], resultsString[1],resultsString[2], resultsString[3], resultsString[4], resultsString[5]);
    }
    
    public String toStringInfo()
    {
            return String.format("%d,%s,%s,%d,%s,%s", 
                    ID, Name, LastName, Born, City, Coach);
    }
    
    public KTUable create(String dataString) {
        Competitor d = new Competitor();
        d.parse(dataString);
        return d;
    }

    public String validate() {
       String klaidosTipas = "";
        if(Name == null || LastName == null)
        {
            klaidosTipas = "Neteisingi duomenys (vardas, pavardė)";
        }
        return klaidosTipas;
    }

    public void parse(String dataString) {
        try
        {
            Scanner sc = new Scanner(dataString);
            sc.useDelimiter(",");
            ID = sc.nextInt();
            Name = sc.next();
            LastName = sc.next();
            Born = sc.nextInt();
            City = sc.next();
            Coach = sc.next();
            Place = 0;
            Score = 0;
            Gender = sc.next();
            for(int i=0;i<6;i++)
            {
                if(sc.hasNext())
                {
                    resultsString[i] = sc.next();
                }
                else
                {
                    resultsString[i] = "";
                }
            }
        }
        catch (InputMismatchException  e) {
            System.out.println("Wrong data format -> " + dataString);
        } catch (NoSuchElementException e) {
            System.out.println("Incomplete data -> " + dataString);
        }
    }
    
    @Override
    public boolean equals(Object o)
    {
        Competitor c = (Competitor) o;
        if(ID == c.ID)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //lygina dalyvių ID
    public int compareTo(Competitor e) {
        if(e == null)
            return -1;
        if(e.ID == ID)
            return 0;
        if(ID > e.ID)
            return 1;
        else
            return -1;
    }
    
    // sarankiškai priderinkite prie Lambda funkcijų
    public final static Comparator<Competitor> sortFirstLastName =
              new Comparator<Competitor>() {
       @Override
       public int compare(Competitor c1, Competitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.getLastName().compareTo(c2.getLastName());
          if(cmp != 0) return cmp;
          return c1.getName().compareTo(c1.getName());
       }
    };
    public final static Comparator sortByID = new Comparator() {
       // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
       @Override
       public int compare(Object o1, Object o2) {
          double k1 = ((Competitor) o1).getID();
          double k2 = ((Competitor) o2).getID();
          // didėjanti tvarka, pradedant nuo mažiausios
          if(k1<k2) return -1;
          if(k1>k2) return 1;
          return 0;
       }
    };
    public final static Comparator sortByYears = new Comparator() {
       // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
       @Override
       public int compare(Object o1, Object o2) {
          Competitor a1 = (Competitor) o1;
          Competitor a2 = (Competitor) o2;
          // metai mažėjančia tvarka, esant vienodiems lyginama kaina
          if(a1.getYears() > a2.getYears()) return 1;
          if(a1.getYears() < a2.getYears()) return -1;
          return 0;
       }
    };
    
    public final static Comparator sortByScore = new Comparator() {
       // sarankiškai priderinkite prie generic interfeiso ir Lambda funkcijų
       @Override
       public int compare(Object o1, Object o2) {
          Competitor a1 = (Competitor) o1;
          Competitor a2 = (Competitor) o2;
          // metai mažėjančia tvarka, esant vienodiems lyginama kaina
          if(a1.getScore() > a2.getScore()) return 1;
          if(a1.getScore() < a2.getScore()) return -1;
          return 0;
       }
    };
}