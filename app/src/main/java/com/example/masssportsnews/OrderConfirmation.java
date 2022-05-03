package com.example.masssportsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrderConfirmation extends AppCompatActivity
{

    Button orderconfirmationBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);


        orderconfirmationBack = findViewById(R.id.orderconfirmationBack);

        orderconfirmationBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(OrderConfirmation.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}