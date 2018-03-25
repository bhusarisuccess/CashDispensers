package com.assignment.cashdispensers;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Dispenser dispenser;
    private TableLayout tableLayout;
    private EditText editAmount;
    private Button btnProcess, btnReset;

    //Count collum
    private TextView tvRs2000Count;
    private TextView tvRs1000Count;
    private TextView tvRs500Count;
    private TextView tvRs200Count;
    private TextView tvRs100Count;
    private TextView tvRs50Count;
    private TextView tvRs20Count;
    private TextView tvRs10Count;
    private TextView tvRs5Count;
    private TextView tvRs1Count;
    private TextView tvPaise50Count;
    private TextView tvPaise25Count;
    private TextView tvCountTotal;

    //Total collum
    private TextView tvRs2000Total;
    private TextView tvRs1000Total;
    private TextView tvRs500Total;
    private TextView tvRs200Total;
    private TextView tvRs100Total;
    private TextView tvRs50Total;
    private TextView tvRs20Total;
    private TextView tvRs10Total;
    private TextView tvRs5Total;
    private TextView tvRs1Total;
    private TextView tvPaise50Total;
    private TextView tvPaise25Total;
    private TextView tvTotalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editAmount = findViewById(R.id.editTextAmount);
        btnProcess = findViewById(R.id.btnProcess);
        btnReset = findViewById(R.id.btnReset);
        tableLayout = (TableLayout) findViewById(R.id.table);

        //Count collum
        tvRs2000Count = findViewById(R.id.tv2000Count);
        tvRs1000Count = findViewById(R.id.tv1000Count);
        tvRs500Count = findViewById(R.id.tv500Count);
        tvRs200Count = findViewById(R.id.tv200Count);
        tvRs100Count = findViewById(R.id.tv100Count);
        tvRs50Count = findViewById(R.id.tv50Count);
        tvRs20Count = findViewById(R.id.tv20Count);
        tvRs10Count = findViewById(R.id.tv10Count);
        tvRs5Count = findViewById(R.id.tv5Count);
        tvRs1Count = findViewById(R.id.tv1Count);
        tvPaise50Count = findViewById(R.id.tvPaise50Count);
        tvPaise25Count = findViewById(R.id.tvPaise25Count);
        tvCountTotal = findViewById(R.id.tvCountTotal);

        //Total collum
        tvRs2000Total = findViewById(R.id.tvRs2000Total);
        tvRs1000Total = findViewById(R.id.tvRs1000Total);
        tvRs500Total = findViewById(R.id.tvRs500Total);
        tvRs200Total = findViewById(R.id.tvRs200Total);
        tvRs100Total = findViewById(R.id.tvRs100Total);
        tvRs50Total = findViewById(R.id.tvRs50Total);
        tvRs20Total = findViewById(R.id.tvRs20Total);
        tvRs10Total = findViewById(R.id.tvRs10Total);
        tvRs5Total = findViewById(R.id.tvRs5Total);
        tvRs1Total = findViewById(R.id.tvRs1Total);
        tvPaise50Total = findViewById(R.id.tvPaise50Total);
        tvPaise25Total = findViewById(R.id.tvPaise25Total);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);

        btnProcess.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnProcess) {
            if (editAmount.getText().toString().equals("")) {
                Toast.makeText(MainActivity.this, "Please Enter the amount", Toast.LENGTH_LONG).show();
                editAmount.setError("Please Enter the amount");
            } else {
                double amount = Double.valueOf(editAmount.getText().toString());
                Dispenser dispenser = new Dispenser(MainActivity.this);

              /*  if (dispenser.getDecimalConverter(amount)!=0) {
                    editAmount.setError("Please Enter the valid amount");
                }*/
                if (dispenser.getDecimalPlacess(amount) > 2) {
                    editAmount.setError("Please Enter the valid amount");
                } else {
                    Currency currency = dispenser.getOpration(amount);
                    if (currency.getErrorMsg().equals("")) {
                        setAllViews(currency);
                    } else {

                        editAmount.setError(currency.getErrorMsg());
                    }

                }
            }
        }
        if (v.getId() == R.id.btnReset) {
            editAmount.setText("");
        }
    }

    public void setAllViews(Currency currency) {
        tvRs2000Count.setText("" + currency.getNotesOf2000());
        tvRs1000Count.setText("" + currency.getNotesOf1000());
        tvRs500Count.setText("" + currency.getNotesOf500());
        tvRs200Count.setText("" + currency.getNotesOf200());
        tvRs100Count.setText("" + currency.getNotesOf100());
        tvRs50Count.setText("" + currency.getNotesOf50());
        tvRs20Count.setText("" + currency.getNotesOf20());
        tvRs10Count.setText("" + currency.getNotesOf10());
        tvRs5Count.setText("" + currency.getNotesOf5());
        tvRs1Count.setText("" + currency.getNotesOf1());
        tvPaise50Count.setText("" + currency.getPaiseOf50());
        tvPaise25Count.setText("" + currency.getPaiseOf25());
        int countTotal = (currency.getNotesOf2000() + currency.getNotesOf1000() + currency.getNotesOf500()
                + currency.getNotesOf200() + currency.getNotesOf100() + currency.getNotesOf50()
                + currency.getNotesOf20() + currency.getNotesOf10()
                + currency.getNotesOf5() + currency.getNotesOf1()
                + currency.getPaiseOf50() + currency.getPaiseOf25());
        tvCountTotal.setText("" + countTotal);

        // Total Amount set
        tvRs2000Total.setText("2000*" + currency.getNotesOf2000());
        tvRs1000Total.setText("1000*" + currency.getNotesOf1000());
        tvRs500Total.setText("500*" + currency.getNotesOf500());
        tvRs200Total.setText("200*" + currency.getNotesOf200());
        tvRs100Total.setText("100*" + currency.getNotesOf100());
        tvRs50Total.setText("50*" + currency.getNotesOf50());
        tvRs20Total.setText("20*" + currency.getNotesOf20());
        tvRs10Total.setText("10*" + currency.getNotesOf10());
        tvRs5Total.setText("5*" + currency.getNotesOf5());
        tvRs1Total.setText("1*" + currency.getNotesOf1());
        tvPaise50Total.setText("0.50*" + currency.getPaiseOf50());
        tvPaise25Total.setText("0.25*" + currency.getPaiseOf25());

        double colculatedAmount = (2000*currency.getNotesOf2000() + 1000*currency.getNotesOf1000() + 500*currency.getNotesOf500()
                + 200*currency.getNotesOf200() + 100*currency.getNotesOf100() +50*currency.getNotesOf50()
                + 20*currency.getNotesOf20() + 10*currency.getNotesOf10()
                + 5*currency.getNotesOf5() + 1*currency.getNotesOf1()
                + 0.50*currency.getPaiseOf50() + 0.25*currency.getPaiseOf25());
        tvTotalAmount.setText(""+colculatedAmount);
        hideSoftKeyBoard();
    }

    private void hideSoftKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
