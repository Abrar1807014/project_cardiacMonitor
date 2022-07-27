package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Adddatalist implements  Comparable<Adddatalist>{
    List<Model>Lists = new ArrayList<>();
    public  void Addoneonerecord(Model a)
    {
        if(Lists.contains(a))
        {
            throw new IllegalArgumentException();
        }
        else
        {
            Lists.add(a);
        }

    }
    public int itemcount()
    {
        return Lists.size();
    }

    @Override
    public int compareTo(Adddatalist o) {
        return 0;
    }
}
