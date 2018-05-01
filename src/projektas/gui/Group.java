/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas.gui;

import Competitors.Competitor;
import Competitors.OlderCompetitor;
import Competitors.YoungerCompetitor;
import ResultsCounting.LessCount;
import ResultsCounting.LongTime;
import ResultsCounting.MoreCount;
import ResultsCounting.ShortTime;
import ResultsCounting.TimeLongest;
import ResultsCounting.UniqList;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author User
 */
public class Group{
    
    private ArrayList<YoungerCompetitor> competitorsGroupList;
    private String groupName;
    private String Gender;
    private int yearFrom;
    private int yearTo;
    
    public Group(String groupName, int yearFrom, int yearTo)
    {
        competitorsGroupList = new ArrayList<YoungerCompetitor>();
        this.groupName = groupName;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }
    
    public void add(YoungerCompetitor c)
    {
        competitorsGroupList.add(c);
    }
    
    public String getGroup()
    {
        return groupName;
    }
    
    public int getStartingYear()
    {
        return yearFrom;
    }
    
    public int getEndYear()
    {
        return yearTo;
    }
    
    public ArrayList<YoungerCompetitor> getGroupList()
    {
        return competitorsGroupList;
    }
    
    public void clearScores()
    {
        for(Competitor c: competitorsGroupList)
        {
            c.resetScore();
        }
    }
    
    public void clearPlaces()
    {
        for(Competitor c: competitorsGroupList)
        {
            c.resetPlace();
        }
    }
    
    public void setCompetitors(ArrayList<YoungerCompetitor> competitorsList)
    {
        for(YoungerCompetitor c: competitorsList)
        {
            if(c.getYears() >= yearFrom && c.getYears() <= yearTo && c.getGender().equals(Gender))
            {
                competitorsGroupList.add(c);
            }
        }
    }
    
    public void calculateSprint()
    {
        competitorsGroupList.sort(OlderCompetitor.sortSprint);
        
        UniqList<ShortTime> results = new UniqList<ShortTime>(); 
        ShortTime[] eventResults = new ShortTime[competitorsGroupList.size()];
        int index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            ShortTime shortTime = c.getSprint();
            eventResults[index] = shortTime;
            index++;
        }
        
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 0);
            index++;
        }
    }
    
    public void calculateSprintY()
    {
        competitorsGroupList.sort(YoungerCompetitor.sortSprintY);
        UniqList<ShortTime> results = new UniqList<ShortTime>();
        ShortTime[] eventResults = new ShortTime[competitorsGroupList.size()];
        int index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            ShortTime shortTime = c.getSprintY();
            eventResults[index] = shortTime;
            index++;
        }
        
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 0);
            index++;
        }
    }
    
    public void calculateLongRun()
    {
        competitorsGroupList.sort(OlderCompetitor.sortLongRun);
        UniqList<LongTime> results = new UniqList<LongTime>();
        LongTime[] eventResults = new LongTime[competitorsGroupList.size()];
        int index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            eventResults[index] = c.getLongRun();
            index++;
        }
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 1);
            index++;
        }
    }
    
    public void calculateLongRunY()
    {
        competitorsGroupList.sort(YoungerCompetitor.sortLongRunY);
        UniqList<LongTime> results = new UniqList<LongTime>();
        LongTime[] eventResults = new LongTime[competitorsGroupList.size()];
        int index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            eventResults[index] = c.getLongRunY();
            index++;
        }
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 1);
            index++;
        }
    }
    
    /*
    int ID nuorodo pratimą: 1- bench press, 2 - bench pull, 3 - core, 4 - pull ups or pushups
    */
    public void calculateMoreCount(Comparator comparator, int ID)
    {
        competitorsGroupList.sort(comparator);
        UniqList<MoreCount> results = new UniqList<MoreCount>();
        MoreCount[] eventResults = new MoreCount[competitorsGroupList.size()];
        int index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            switch(ID)
            {
                case 1:
                    eventResults[index] = c.getBenchPress();
                    break;
                case 2:
                    eventResults[index] = c.getBenchPull();
                    break;
                case 3:
                    eventResults[index] = c.getCore();
                    break;
                case 4:
                    eventResults[index] = c.getPullUps();
                    break;
            }
            index++;
        }
        results.add(eventResults);
        double[] Results = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(Results[index]);
            c.setEventScore(Double.toString(Results[index]), ID+1);
            index++;
        }
    }
    
    /*
    int ID nuorodo pratimą: 1- core, 2 - jockey
    */
    public void calculateMoreCountY(Comparator comparator, int ID)
    {
        competitorsGroupList.sort(comparator);
        UniqList<MoreCount> results = new UniqList<MoreCount>();
        MoreCount[] eventResults = new MoreCount[competitorsGroupList.size()];
        int index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            switch(ID)
            {
                case 1:
                    eventResults[index] = c.getCoreY();
                    index++;
                    break;
                case 2:
                    eventResults[index] = c.getJockey();
                    index++;
                    break;
            }
        }
        results.add(eventResults);
        double[] Results = calculatePoints(results);
        index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            c.setScore(Results[index]);
            c.setEventScore(Double.toString(Results[index]), ID+1);
            index++;
        }
    }
    
    public void calculateTimeLongest()
    {
        competitorsGroupList.sort(YoungerCompetitor.sortHanging);
        UniqList<TimeLongest> results = new UniqList<TimeLongest>();
        TimeLongest[] eventResults = new TimeLongest[competitorsGroupList.size()];
        int index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            eventResults[index] = c.getHanging();
            index++;
        }
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 5);
            index++;
        }
    }
    
    public void calculateYLessCount()
    {
        competitorsGroupList.sort(YoungerCompetitor.sortFlamingo);
        UniqList<LessCount> results = new UniqList<LessCount>();
        LessCount[] eventResults = new LessCount[competitorsGroupList.size()];
        int index = 0;
        for(YoungerCompetitor c: competitorsGroupList)
        {
            eventResults[index] = c.getFlamingo();
            index++;
        }
        results.add(eventResults);
        double[] sprintResults = calculatePoints(results);
        index = 0;
        for(OlderCompetitor c: competitorsGroupList)
        {
            c.setScore(sprintResults[index]);
            c.setEventScore(Double.toString(sprintResults[index]), 4);
            index++;
        }
    }
    
    private double[] calculatePoints(UniqList eventResults)
    {
        double[] points = new double[eventResults.totalSize()];
        int givenPoints = 1;
        int index = 0;
        for(int i =0;i<eventResults.size();i++)
        {
            if(eventResults.getElementCount(i) == 0)
            {
                points[index] = givenPoints;
                givenPoints++;
                index++;
            }
            else
            {
                double count = 0;
                double pointsAvg = 0;
                for(int k = 0;k<eventResults.getElementCount(i) + 1; k++)
                {
                    pointsAvg += givenPoints;
                    count++;
                    givenPoints++;
                }
                for(int j = 0;j<eventResults.getElementCount(i) + 1; j++)
                {
                    points[index] = pointsAvg / count;
                    index++;
                }
            }
        }
        return points;
    }
    
    public void setPlaces()
    {
        competitorsGroupList.sort(YoungerCompetitor.sortByScore);
        int place = 1;
        boolean wasEqual = false;
        for(int i=1;i<competitorsGroupList.size();i++)
        {
            if(competitorsGroupList.get(i-1).getScore() != competitorsGroupList.get(i).getScore())
            {
                if(wasEqual == true)
                {
                    place += 2;
                    wasEqual = false;
                }
                else
                {
                    competitorsGroupList.get(i-1).setPlace(place);
                    place++;
                }
            }
            else
            {
                competitorsGroupList.get(i-1).setPlace(place);
                competitorsGroupList.get(i).setPlace(place);
                wasEqual = true;
            }
        }
        if(competitorsGroupList.get(competitorsGroupList.size()-2).getScore() == competitorsGroupList.get(competitorsGroupList.size()-1).getScore())
        {
            competitorsGroupList.get(competitorsGroupList.size()-1).setPlace(place);
        }
        else
        {
            competitorsGroupList.get(competitorsGroupList.size()-1).setPlace(place);
        }
    }
}
