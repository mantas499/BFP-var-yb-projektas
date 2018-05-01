/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultsCounting;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author manant1
 * @param <E>
 */
public class UniqList<E extends Comparable<E>>{
    
    private ArrayList<E> listWithNoDuplicates;
    private int[] duplicatesCount;
    private int totalSize; // ir pasikartojanciu
    private int size;
    
    public UniqList()
    {
        listWithNoDuplicates = new ArrayList<E>();
        duplicatesCount = new int[1000];
    }
    
    public void add(E[] array)
    {
        int index = 0;
        for(int i = 0;i<array.length;i++)
        {
            if((index = contains(array[i])) != -1)
            {
                duplicatesCount[index]++;
                totalSize++;
            }
            else
            {
                listWithNoDuplicates.add(array[i]);
                size++;
                totalSize++;
            }
        }
    }
    
    private int contains(E e)
    {
        int index = 0;
        for(E element: listWithNoDuplicates)
        {
            if(element.compareTo(e) == 0)
            {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    public E getElement(int index)
    {
        return listWithNoDuplicates.get(index);
    }
    
    public int getElementCount(int index)
    {
        return duplicatesCount[index];
    }
    
    public int size()
    {
        return size;
    }
    
    public int totalSize()
    {
        return totalSize;
    }
}
