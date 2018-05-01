/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competitors;

import ResultsCounting.LessCount;
import ResultsCounting.LongTime;
import ResultsCounting.MoreCount;
import ResultsCounting.ShortTime;
import ResultsCounting.TimeLongest;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class YoungerCompetitor extends OlderCompetitor{
    
    private ShortTime SprintY;
    private LongTime longRunY;
    private MoreCount coreExcersiceY;
    private MoreCount jockeyY;
    private LessCount flamingoExcersice;
    private TimeLongest hangingExcersice;
    
    public YoungerCompetitor()
    {
        super();
        SprintY = new ShortTime();
        longRunY = new LongTime();
        coreExcersiceY = new MoreCount();
        jockeyY = new MoreCount();
        flamingoExcersice = new LessCount();
        hangingExcersice = new TimeLongest();
    }
    
    public YoungerCompetitor(String line)
    {
        super(line);
        SprintY = new ShortTime();
        longRunY = new LongTime();
        coreExcersiceY = new MoreCount();
        jockeyY = new MoreCount();
        flamingoExcersice = new LessCount();
        hangingExcersice = new TimeLongest();
    }
    
    public ShortTime getSprintY()
    {
        return SprintY;
    }
    
    public LongTime getLongRunY()
    {
        return longRunY;
    }
    
    public MoreCount getCoreY()
    {
        return coreExcersiceY;
    }
    
    public MoreCount getJockey()
    {
        return jockeyY;
    }
    
    public LessCount getFlamingo()
    {
        return flamingoExcersice;
    }
    
    public TimeLongest getHanging()
    {
        return hangingExcersice;
    }
    
    public void setSprintY(String line)
    {
        SprintY.parse(line);
        super.resultsString[0] = line;
    }
    
    public void setLongRunY(String line)
    {
        longRunY.parse(line);
        super.resultsString[1] = line;
    }
    
    public void setCoreY(String line)
    {
        coreExcersiceY.parse(line);
        super.resultsString[2] = line;
    }
    
    public void setJockey(String line)
    {
        jockeyY.parse(line);
        super.resultsString[3] = line;
    }
    
    public void setFlamingo(String line)
    {
        flamingoExcersice.parse(line);
        super.resultsString[4] = line;
    }
    
    public void setHanging(String line)
    {
        hangingExcersice.parse(line);
        super.resultsString[5] = line;
    }
    
    public void setSavedResultsYounger()
    {
            setSprintY(super.resultsString[0]);
            setLongRunY(super.resultsString[1]);
            setCoreY(super.resultsString[2]);
            setJockey(super.resultsString[3]);
            setFlamingo(super.resultsString[4]);
            setHanging(super.resultsString[5]);
    }
    
    public void setSavedResultsYoungerM()
    {
            setSprintY(super.resultsString[0]);
            setLongRunY(super.resultsString[1]);
            setCoreY(super.resultsString[2]);
            setJockey(super.resultsString[3]);
            setFlamingo(super.resultsString[4]);
            setHanging(super.resultsString[5]);
    }
    
    @Override 
    public String toString()
    {
            return super.toString();// + String.format(";%s;%s;%s;%s;%s;%s", SprintY.toString(), longRunY.toString(), coreExcersiceY.toString(), jockeyY.toString(), flamingoExcersice.toString(), hangingExcersice.toString());
    }
    
     public final static Comparator<YoungerCompetitor> sortFlamingo =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c2.getFlamingo().compareTo(c1.getFlamingo());
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
     
     public final static Comparator<YoungerCompetitor> sortHanging =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.getHanging().compareTo(c2.getHanging());
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
     
     public final static Comparator<YoungerCompetitor> sortJockey =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.getJockey().compareTo(c2.getJockey());
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
     
     public final static Comparator<YoungerCompetitor> sortCoreY =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.coreExcersiceY.compareTo(c2.coreExcersiceY);
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
     
     
    // sarankiškai priderinkite prie Lambda funkcijų
    public final static Comparator<YoungerCompetitor> sortSprintY =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.SprintY.compareTo(c2.SprintY);
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
    
    public final static Comparator<YoungerCompetitor> sortLongRunY =
              new Comparator<YoungerCompetitor>() {
       @Override
       public int compare(YoungerCompetitor c1, YoungerCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.longRunY.compareTo(c2.longRunY);
          if(cmp != 0) return cmp;
          else
          {
              if(c1.getID() > c2.getID())
              {
                  return 1;
              }
              else
              {
                  return -1;
              }
          }
       }
    };
}
