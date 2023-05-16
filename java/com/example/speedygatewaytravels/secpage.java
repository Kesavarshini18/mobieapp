package com.example.speedygatewaytravels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class secpage extends AppCompatActivity {



    CardView plastic;
    CardView paper;
    CardView organic;
    CardView battery;
    CardView ewaste;
    CardView mixture;
    CardView metals;


//    Button btn;
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secpage);

        plastic = findViewById(R.id.plastic);
        paper = findViewById(R.id.paper);
        organic=findViewById(R.id.organic);
        battery = findViewById(R.id.battery);
        ewaste = findViewById(R.id.ewaste);
        mixture = findViewById(R.id.mixture);
        metals = findViewById(R.id.metals);
//        blog = findViewById(R.id.blog);
//        govtrules = findViewById(R.id.govtrules);

        plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,plastic.class));

            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,paper.class));

            }
        });
        organic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,organic.class));

            }
        });
        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,battery.class));

            }
        });
        ewaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,ewaste.class));

            }
        });
        mixture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,mixture.class));

            }
        });
        metals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(secpage.this,metals.class));

            }
        });
//        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
//        setToggleEvent(mainGrid);

//        btn=findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(secpage.this,"Your Ticket has been Booked",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void setToggleEvent(GridLayout mainGrid) {
        for(int i=0;i<mainGrid.getChildCount();i++){
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cardView.getCardBackgroundColor().getDefaultColor()==-1){
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(secpage.this,"State=True",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(secpage.this,"State=True",Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

    }
//    public void btnBack(View view) {
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
//    }

//    private void setSingleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            CardView cardView = (CardView) mainGrid.getChildAt(i);
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Intent intent = new Intent(secpage.this,Activity3.class);
//                    intent.putExtra("info","This is activity from card item index  "+finalI);
//                    startActivity(intent);
//
//                }
//            });
//        }
//    }


}
