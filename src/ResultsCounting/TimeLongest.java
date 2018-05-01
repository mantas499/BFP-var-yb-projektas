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
public class TimeLongest implements Comparable<TimeLongest>, Serializable{
    
    private int minutes;
    private int seconds;
    private int miliseconds;
    private double points;

    public TimeLongest()
    {
        minutes = 0;
        seconds = 0;
        miliseconds = 0;
    }
    
    public TimeLongest(String line)
    {
        points = 0;
        minutes = 0;
        seconds = 0;
        miliseconds = 0;
    }
    
    public TimeLongest(int minutes, int seconds, int miliseconds)
    {
        points = 0;
        this.minutes = minutes;
        this.seconds = seconds;
        this.miliseconds = miliseconds;
    }
            
    
    /*
    jei geresnis laikas gražina 1
    */
    @Override
    public int compareTo(TimeLongest t) {
        if(minutes == t.minutes && seconds == t.seconds && miliseconds == t.miliseconds)
        {
            return 0;
        }
        else
        {
            if((minutes > t.minutes) || (minutes == t.minutes && seconds > t.seconds) || (minutes == t.minutes && seconds == t.seconds && miliseconds > t.miliseconds))
            {
                return -1;
            }
        }
        return 1;
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
            minutes = 00;
            seconds = 00;
            miliseconds = 00;
        }
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
            minutes = 00;
            seconds = 00;
            miliseconds = 00;
            System.out.println("Negalima konvertuoti reikšmės iš lentelės");
        }
    }
    
    @Override 
    public String toString()
    {
            return String.format("%d:%d,%d", Integer.toString(minutes), Integer.toString(seconds), Integer.toString(miliseconds));
    }
}
