package com.assignment.cashdispensers;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Lenovo on 24-03-2018.
 */

public class Dispenser {
private  Currency currency;
private Context mcontext;

    public Dispenser(Context context) {
        this.mcontext=context;
        this.currency = new Currency();;
    }

    public Currency getOpration(double amount){

        int number = getInteger(amount);
        int decimalNum = getDecimalConverter(amount);
        if(number >=2000){
            int numberof2000Note=number/2000;
            number= number - numberof2000Note*2000;
            if(numberof2000Note>20){
              currency.setErrorMsg("Entered Amount is High");
            }
            currency.setNotesOf2000(numberof2000Note);

        }
        if(number >=1000){
            int numberof1000Note=number/1000;
            number= number - numberof1000Note*1000;
            currency.setNotesOf1000(numberof1000Note);

        } if(number >= 500){
            int numberof500Note=number/500;
            number= number - numberof500Note*500;
            currency.setNotesOf500(numberof500Note);

        }if(number >=200){
            int numberof200Note=number/200;
            number= number - numberof200Note*200;
            currency.setNotesOf200(numberof200Note);

        }
        if(number >= 100){
            int numberof100Note=number/100;
            number= number - numberof100Note*100;
            currency.setNotesOf100(numberof100Note);

        }if(number >=50){
            int numberof50Note=number/50;
            number= number - numberof50Note*50;
            currency.setNotesOf50(numberof50Note);

        }
        if(number >=20){
            int numberof20Note=number/20;
            number= number - numberof20Note*20;
            currency.setNotesOf20(numberof20Note);
        }if(number >=10){
            int numberof10Note=number/10;
            number= number - numberof10Note*10;
            currency.setNotesOf10(numberof10Note);

        }
        if(number >=5){
            int numberof5Note=number/5;
            number= number - numberof5Note*5;
            currency.setNotesOf5(numberof5Note);

        }if(number >= 1 ){
            int numberof1Note=number/1;
            number= number - numberof1Note*1;
            currency.setNotesOf1(numberof1Note);

        }
        if(decimalNum >= 50 ){
            int numberof50Paise=decimalNum/50;
            decimalNum = decimalNum - numberof50Paise*50;
            currency.setPaiseOf50(numberof50Paise);

        }
        if(decimalNum >= 25 ){
            int numberof25Paise=decimalNum/25;
            decimalNum = decimalNum - numberof25Paise*25;
            currency.setPaiseOf25(numberof25Paise);

        }
        return currency;
    }

    private  int getInteger(double decimalNumber) {
        int integer = (int)decimalNumber;
        return integer;
    }

    public  int getDecimalConverter(double number) {

        int integer = (int)number;
        double decimal = (10 * number - 10 * integer)/10;
      int  decimalNumber = (int) (decimal*100);
        return decimalNumber;
    }

    public int getDecimalPlacess(double decimal){
        double d= decimal;
        String text = Double.toString(Math.abs(d));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;
        return decimalPlaces;
    }
}
