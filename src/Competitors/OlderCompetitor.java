/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Competitors;

import ResultsCounting.LongTime;
import ResultsCounting.MoreCount;
import ResultsCounting.ShortTime;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class OlderCompetitor extends Competitor implements KTUable<Competitor>{
    
    private ShortTime Sprint;
    private LongTime longRun;
    private MoreCount benchPress;
    private MoreCount benchPull;
    private MoreCount coreExcersice;
    private MoreCount pullUps;
    
    public OlderCompetitor()
    {
        super();
        Sprint = new ShortTime();
        longRun = new LongTime();
        benchPress = new MoreCount();
        benchPull = new MoreCount();
        coreExcersice = new MoreCount();
        pullUps = new MoreCount();
    }
    
    public OlderCompetitor(String line)
    {
        super(line);
        Sprint = new ShortTime();
        longRun = new LongTime();
        benchPress = new MoreCount();
        benchPull = new MoreCount();
        coreExcersice = new MoreCount();
        pullUps = new MoreCount();
    }
    
    public ShortTime getSprint()
    {
        return Sprint;
    }
    
    public LongTime getLongRun()
    {
        return longRun;
    }
    
    public MoreCount getBenchPress()
    {
        return benchPress;
    }
    
    public MoreCount getBenchPull()
    {
        return benchPull;
    }
    
    public MoreCount getCore()
    {
        return coreExcersice;
    }
    
    public MoreCount getPullUps()
    {
        return pullUps;
    }
    
    public void setSprint(String line)
    {
        Sprint.parse(line);
        super.resultsString[0] = line;
    }
    
    public void setLongRun(String line)
    {
        longRun.parse(line);
        super.resultsString[1] = line;
    }
    
    public void setBenchPress(String line)
    {
        benchPress.parse(line);
        super.resultsString[2] = line;
    }
    
    public void setBenchPull(String line)
    {
        benchPull.parse(line);
        super.resultsString[3] = line;
    }
    
    public void setCore(String line)
    {
        coreExcersice.parse(line);
        super.resultsString[4] = line;
    }
    
    public void setPullUps(String line)
    {
        pullUps.parse(line);
        super.resultsString[5] = line;
    }
    
    @Override 
    public String toString()
    {
            return super.toString();
    }
    
    public void setSavedResultsOlder()
    {
        setSprint(super.resultsString[0]);
        setLongRun(super.resultsString[1]);
        setBenchPress(super.resultsString[2]);
        setBenchPull(super.resultsString[3]);
        setCore(super.resultsString[4]);
        setPullUps(super.resultsString[5]);
    }
    
    // sarankiškai priderinkite prie Lambda funkcijų
    public final static Comparator<OlderCompetitor> sortSprint =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.Sprint.compareTo(c2.Sprint);
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
    
    public final static Comparator<OlderCompetitor> sortLongRun =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.longRun.compareTo(c2.longRun);
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
    
    public final static Comparator<OlderCompetitor> sortBenchPress =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.benchPress.compareTo(c2.benchPress);
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
    
    public final static Comparator<OlderCompetitor> sortBenchPull =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.benchPull.compareTo(c2.benchPull);
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
    
    public final static Comparator<OlderCompetitor> sortCore =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.coreExcersice.compareTo(c2.coreExcersice);
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
    
    public final static Comparator<OlderCompetitor> sortPullUps =
              new Comparator<OlderCompetitor>() {
       @Override
       public int compare(OlderCompetitor c1, OlderCompetitor c2) {
          // pradžioje pagal markes, o po to pagal modelius
          int cmp = c1.pullUps.compareTo(c2.pullUps);
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
