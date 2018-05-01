/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultsCounting;


/**
 *
 * @author User
 */
public class ShortTime implements Comparable<ShortTime>{
 
    private int seconds;
    private int miliseconds;
    private double points;

    public ShortTime()
    {
        seconds = 60;
        miliseconds = 60;
    }
    
    public ShortTime(String line)
    {
        parse(line);
        seconds = 60;
        miliseconds = 60;
    }
    
    public ShortTime(int seconds, int miliseconds)
    {
        this.seconds = seconds;
        this.miliseconds = miliseconds;
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
    public int compareTo(ShortTime t) {
        int cmp = 0;
        if(seconds == t.seconds && miliseconds == t.miliseconds)
        {
            cmp = 0;
        } 
        if((seconds < t.seconds) || (seconds == t.seconds && miliseconds < t.miliseconds))
        {
            cmp = -1;
        }
        if((seconds > t.seconds) || (seconds == t.seconds && miliseconds > t.miliseconds))
        {
            cmp = 1;
        }
        return cmp;
    }
    
    public void parse(String line)
    {
            if(line.equals("") || line.equals(null) || line.equals(" "))
            {
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
                        String ss = Character.toString(tokens[1]);
                        seconds = Integer.parseInt(ss);
                    }
                    else
                    {
                        String ss = Character.toString(tokens[0]);
                        ss += Character.toString(tokens[1]);
                        seconds = Integer.parseInt(ss);
                    }
                    if(tokens[3] == '0')
                    {
                        String ms = Character.toString(tokens[4]);
                        miliseconds = Integer.parseInt(ms);
                    }
                    else
                    {
                        String ms = Character.toString(tokens[3]);
                        ms += Character.toString(tokens[4]);
                        miliseconds = Integer.parseInt(ms);
                    }
                    }
                    catch(Exception e)
                    {
                        seconds = 60;
                        miliseconds = 60;
                        System.out.println("Negalima konvertuoti reikšmės iš lentelės");
                    }
        }
    }
}
