package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * shows all the records
 * delete a record
 * update a record
 */
public class Records extends AppCompatActivity implements for_update{

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference().child("Data");

    Adapter adapter;
    ArrayList<Model> list;

    EditText sys, dias, bpm, user_com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        adapter=new Adapter(list, this, this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);


        databaseReference.addValueEventListener(new ValueEventListener() {
            /**
             * fetches data from database
             * @param snapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Model model = dataSnapshot.getValue(Model.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    //for deleting
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        /**
         * nothing will happen on data move
         * @param recyclerView
         * @param viewHolder
         * @param target
         * @return
         */
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        /**
         * for deleting a record on swip both left & right
         * @param viewHolder
         * @param direction
         */
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            String date = list.get(viewHolder.getLayoutPosition()).Date;
            String time = list.get(viewHolder.getLayoutPosition()).Time;
            String key = (date+time).replaceAll("\\s", "");
            //Toast.makeText(Records.this, key, Toast.LENGTH_SHORT).show();
            databaseReference.child(key).removeValue();
            list.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
            Toast.makeText(Records.this, "Deleted", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Records.this, DataPage.class);
            startActivity(i);
        }
    };

    /**
     * if a view if touched
     * it will open an dialogue for updating data
     * @param position
     */
    @Override
    public void onTouch(int position) {
        TextView e, f;
        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        Calendar calendar1=Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("hh:mm:ss");
        String time=currentTime.format(calendar.getTime());
        String newk = (currentDate+time).replaceAll("\\s", "");

        Dialog dialog = new Dialog(Records.this);
        dialog.setContentView(R.layout.update);

        sys=dialog.findViewById(R.id.edit_systolic_bp);
        dias=dialog.findViewById(R.id.edit_diastolic_bp);
        bpm=dialog.findViewById(R.id.edit_heart_rate);
        user_com=dialog.findViewById(R.id.edit_your_comment);
        e=dialog.findViewById(R.id.edit_date_of_submission);
        f=dialog.findViewById(R.id.edit_time);
        Button u = dialog.findViewById(R.id.updater);

        String s = list.get(position).systolic;
        sys.setText(s);
        dias.setText(list.get(position).diastolic);
        bpm.setText(list.get(position).bpm);
        user_com.setText(list.get(position).user_comment);
        e.setText(list.get(position).Date);
        f.setText(list.get(position).Time);

        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        dialog.show();
        u.setOnClickListener(new View.OnClickListener() {
            /**
             * will update data stored in databse
             * @param v
             */
            @Override
            public void onClick(View v) {
                String a, b, c, com, editdate, edittime, user_comment;
                a=sys.getText().toString();
                b=dias.getText().toString();
                c=bpm.getText().toString();
                user_comment = user_com.getText().toString();

                editdate=currentDate;
                edittime=time;

                String date = list.get(position).Date;
                String time = list.get(position).Time;
                String key = (date+time).replaceAll("\\s", "");

                HashMap<String, String> usermap = new HashMap<>();
                usermap.put("systolic", a);
                usermap.put("diastolic", b);
                usermap.put("bpm", c);
                usermap.put("user_comment", user_comment);
                usermap.put("Date", editdate);
                usermap.put("Time", edittime);

                Integer ints = Integer.parseInt(a);
                Integer intd = Integer.parseInt(b);
                Integer intb = Integer.parseInt(c);

                if(ints<120 && intd<80)
                {
                    com = "Normal";
                    usermap.put("comment", com);
                }
                else if ((ints<=129 && ints>=120) && intd <80)
                {
                    com = "Elevated";
                    usermap.put("comment", com);
                }
                else if ((ints<=139 && ints>=130) || (intd >=80 && intd<=89))
                {
                    com = "High Blood Pressure_Stage 1";
                    usermap.put("comment", com);
                }
                else if (ints>=140 || intd>=90)
                {
                    com = "High Blood Pressure_Stage 2";
                    usermap.put("comment", com);
                }
                databaseReference.child(key).removeValue();
                databaseReference.child(newk).setValue(usermap);
                dialog.dismiss();
                Toast.makeText(Records.this, "Data Changed", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Records.this, DataPage.class);
                startActivity(i);
            }
        });


    }
}