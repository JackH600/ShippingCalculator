package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    EditText wghtET;
    ShipItem shipItem;
    TextView baseText;
    TextView addedText;
    TextView totalText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wghtET = (EditText)findViewById(R.id.editText);
        wghtET.addTextChangedListener(weightTextWatcher);



        baseText = (TextView)findViewById(R.id.textView5);
        addedText = (TextView)findViewById(R.id.textView6);
        totalText = (TextView)findViewById(R.id.textView7);

        shipItem = new ShipItem();


    }
    private TextWatcher weightTextWatcher =  new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            try{
                double weight =  Double.parseDouble(charSequence.toString());
                shipItem.setOunces(weight);

            }
            catch(NumberFormatException e){
                shipItem.setOunces(0.00);

            }
            displayCost();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void displayCost(){
        String base = "$" + String.format("%.02f", shipItem.getBaseCost());
        baseText.setText(base);
        String added = "$" + String.format("%.02f", shipItem.getAddedCost());
        addedText.setText(added);
        String total = "$" + String.format("%.02f", shipItem.getTotalCost());
        totalText.setText(total);
    }



}
