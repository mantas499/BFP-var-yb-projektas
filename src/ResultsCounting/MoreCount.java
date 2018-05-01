/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultsCounting;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class MoreCount implements Comparable<MoreCount>, Serializable{
    
    private int count;
    private double points;
    
    public MoreCount()
    {
        count = 0;
    }
    
    public MoreCount(String line)
    {
        points = 0;
        parse(line);
        count = 0;
    }
    
    public MoreCount(int count)
    {
        points = 0;
        this.count = count;
    }

    public void setPoints(double p)
    {
        points = p;
    }
    
    public double getPoints()
    {
        return points;
    }
    
    @Override
    public int compareTo(MoreCount t) {
        if(count == t.count)
        {
            return 0;
        }
        else
        {
            if(count < t.count)
                return 1;
            else
                return -1;
        }
    }
    
    
    public void parse(String line)
    {
        if(line.equals("") || line.equals(null) || line.equals(" "))
        {
            count = Integer.MIN_VALUE;
        }
        else
        {
            try
            {
                count = Integer.parseInt(line);
            }
            catch(Exception e)
            {
                count = Integer.MIN_VALUE;
                System.out.println("Negalima konvertuoti reikšmės iš lentelės");
            }
        }
    }
    
    @Override 
    public String toString()
    {
            return String.format("%s", Integer.toString(count));
    }
}
