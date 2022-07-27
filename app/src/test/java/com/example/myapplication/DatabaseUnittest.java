package com.example.myapplication;


import android.accounts.AbstractAccountAuthenticator;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseUnittest {
    /**
     * Testing to ad new data to Adddatalist
     *
     */

    @Test
    public void testAddinglist()
    {
        Adddatalist list = new Adddatalist();
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dates = new SimpleDateFormat("DD-MM-YYYY");
        String s1 = time.format(date);
        String s2 = dates.format(date);
        String  systolic = "80";
        String  diastolic = "120";
        String  bpm = "60";
        String comment = "Normal";
        list.Addoneonerecord(new Model(s1,s2,systolic,diastolic,bpm,comment));
        assertEquals(1,list.itemcount());
          systolic = "120";
          diastolic = "150";
          bpm = "70";
          comment = "High pressure";
        list.Addoneonerecord(new Model(s1,s2,systolic,diastolic,bpm,comment));
          systolic = "70";
          diastolic = "100";
          bpm = "60";
          comment = "Low pressure";
        list.Addoneonerecord(new Model(s1,s2,systolic,diastolic,bpm,comment));
        assertEquals(3,list.itemcount());
    }

    /**
     * Test for data delete from dataaddinglist
     */
    @Test
    public void testdelete()
    {

    }
    /**
     * Test for Test data add from dataaddinglist
     */
    @Test
    public void testdataadd()
    {


    }



}
