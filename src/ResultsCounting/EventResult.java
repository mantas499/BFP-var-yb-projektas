/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultsCounting;

import java.util.ArrayList;

/**
 *
 * @author manant1
 */
public class EventResult {
    
    private String Name;
    private String Points;
    
    
    public EventResult()
    {
    }
    
    public EventResult(String Name, String Points)
    {
        this.Name = Name;
        this.Points = Points;
    }
    
    
    public void setName(String Name)
    {
        this.Name = Name;
    }
    
    public void setResults(String Points)
    {
        this.Points = Points;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getPoints()
    {
        return Points;
    }
}
