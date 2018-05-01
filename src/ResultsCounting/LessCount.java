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
public class LessCount  implements Comparable<LessCount>, Serializable{
    
    private int count;
    private double points;
    
    public LessCount()
    {
        count = Integer.MAX_VALUE;
    }
    
    public LessCount(String line)
    {
        points = 0;
        parse(line);
        count = Integer.MAX_VALUE;
    }
    
    public LessCount(int count)
    {
        count = Integer.MAX_VALUE;
        this.count = count;
    }

    @Override
    public int compareTo(LessCount t) {
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
    
    public void setPoints(double p)
    {
        points = p;
    }
    
    public double getPoints()
    {
        return points;
    }
    
    public void parse(String line)
    {
        if(line.equals("") || line.equals(null) || line.equals(" "))
        {
            count = Integer.MAX_VALUE;
        }
        else
        {
            try
            {
            count = Integer.parseInt(line);
            }
            catch(Exception e)
            {
                System.out.println("Negalima konvertuoti reikšmės iš lentelės");
                count = Integer.MAX_VALUE;
            }
        }
    }
    
    @Override 
    public String toString()
    {
        return String.format("%s", Integer.toString(count));
    }
}
