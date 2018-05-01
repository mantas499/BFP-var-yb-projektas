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
public class LongTime  implements Comparable<LongTime>, Serializable{
    
    private int minutes;
    private int seconds;
    private int miliseconds;
    private double points;

    public LongTime()
    {
        minutes = 60;
        seconds = 60;
        miliseconds = 60;
    }
    
    public LongTime(String line)
    {
        points = 0;
        minutes = 60;
        seconds = 60;
        miliseconds = 60;
        parse(line);
    }
         
    
    public void setPoints(double p)
    {
        points = p;
    }
    
    public double getPoints()
    {
        return points;
    }
    
    /*
    jei geresnis laikas gražina 1
    */
    @Override
    public int compareTo(LongTime t) {
        if(minutes == t.minutes && seconds == t.seconds && miliseconds == t.miliseconds)
        {
            return 0;
        }
        else
        {
            if((minutes < t.minutes) || (minutes == t.minutes && seconds < t.seconds) || (minutes == t.minutes && seconds == t.seconds && miliseconds < t.miliseconds))
            {
                return -1;
            }
        }
        return 1;
    }
    
    public void parse(String line)
    {
        if(line.equals("") || line.equals(null) || line.equals(" "))
        {
            minutes = 60;
            seconds = 60;
            miliseconds = 60;
        }
        else
        {
            try
            {
                char[] tokens = line.toCharArray();
                if(tokens[0] == '0')
                {
                    String minutes = Character.toString(tokens[1]);
                    this.minutes = Integer.parseInt(minutes);
                }
                else
                {
                    String minutes = Character.toString(tokens[0]);
                    minutes += Character.toString(tokens[1]);
                    this.minutes = Integer.parseInt(minutes);
                }
                if(tokens[3] == '0')
                {
                    String seconds = Character.toString(tokens[4]);
                    this.seconds = Integer.parseInt(seconds);
                }
                else
                {
                    String seconds = Character.toString(tokens[3]);
                    seconds += Character.toString(tokens[4]);
                    this.seconds = Integer.parseInt(seconds);
                }
                if(tokens[6] == '0')
                {
                    String miliseconds = Character.toString(tokens[7]);
                    this.miliseconds = Integer.parseInt(miliseconds);
                }
                else
                {
                    String miliseconds = Character.toString(tokens[6]);
                    miliseconds += Character.toString(tokens[7]);
                    this.miliseconds = Integer.parseInt(miliseconds);
                }
            }
            catch(Exception e)
            {
                minutes = 60;
                seconds = 60;
                miliseconds = 60;
                System.out.println("Negalima konvertuoti reikšmės iš lentelės");
            }
        }
        System.out.println(minutes + " " + seconds + " " + miliseconds);
    }
    
    @Override 
    public String toString()
    {
            return String.format("%d:%d,%d", minutes, seconds, miliseconds);
    }
}
