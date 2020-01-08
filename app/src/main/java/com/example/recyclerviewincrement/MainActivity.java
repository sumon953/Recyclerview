package com.example.recyclerviewincrement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.onContractClickListner{

    //Find View;
    EditText phoneNumber,name;
    Button submit;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerAdapter.onContractClickListner onContractClickListner;

    ArrayList<MyViewHolder> contacts = new ArrayList<MyViewHolder>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onContractClickListner=this;
        Initialize();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().equals("") || phoneNumber.getText().toString().equals(""))
                {

                    Toast.makeText(MainActivity.this, "Vai vugi chuki korin na.!!", Toast.LENGTH_SHORT).show();
                }
                else {

                    String Name,PhoneNumber;
                    Name = name.getText().toString();
                    PhoneNumber = phoneNumber.getText().toString();

                    MyViewHolder temp = new MyViewHolder(Name,PhoneNumber);
                    contacts.add(temp);
                    adapter.notifyDataSetChanged();

                }
            }
        });

    }

    public void Initialize(){

        //Find View;
        phoneNumber = findViewById(R.id.phone);
        name = findViewById(R.id.name);
        submit = findViewById(R.id.submit);
        recyclerView = findViewById(R.id.recyclerview);

        //RecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(contacts,onContractClickListner);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onContractClick(int position) {

        //position++;
        //Toast.makeText(this, "Position: "+position, Toast.LENGTH_SHORT).show();

        MyViewHolder temp = contacts.get(position);
        Toast.makeText(this, "Name: "+temp.getName(), Toast.LENGTH_SHORT).show();

    }
}
