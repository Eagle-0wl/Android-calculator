package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private TextView calcWinBottom;
    private TextView calcWinTop;
    double rootAnswer=0;
    double calculation=0;
    int equalSignCount=0;
    String lastSymbol="";
    int keyboardInput=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.calcWinBottom=findViewById(R.id.txtCalcWindBottom);
        this.calcWinTop=findViewById(R.id.txtCalcWindTop);
    }

    public void onBtnClickAdd1ToCalcWin(View view) {
        inputNumber(1);
    }

    public void onBtnClickAdd2ToCalcWin(View view) {
        inputNumber(2);
}

    public void onBtnClickAdd3ToCalcWin(View view) {
        inputNumber(3);
    }

    public void onBtnClickAdd4ToCalcWin(View view) {
        inputNumber(4);
    }

    public void onBtnClickAdd5ToCalcWin(View view) {
        inputNumber(5);
    }

    public void onBtnClickAdd6ToCalcWin(View view) {
        inputNumber(6);
    }

    public void onBtnClickAdd7ToCalcWin(View view) {
        inputNumber(7);
    }

    public void onBtnClickAdd8ToCalcWin(View view) {
        inputNumber(8);
    }

    public void onBtnClickAdd9ToCalcWin(View view) {
        inputNumber(9);
    }

    public void onBtnClickClearAllText(View view) {
        this.calcWinTop.setText("");
        this.calcWinBottom.setText("0");
        calculation=0;
        equalSignCount=0;
        keyboardInput=0;
        lastSymbol="";
    }

    public void onBtnClickClearLastNmbr(View view) {
        this.calcWinBottom.setText("0");
        keyboardInput=0;
        keyboardInput=0;
    }

    public void onBtnClickRemoveLastSymbol(View view) {
       int helper= keyboardInput/10;
       keyboardInput = helper;
       this.calcWinBottom.setText(String.valueOf(keyboardInput));
    }

    public void onBtnClickChangeSigh(View view) {
        if(keyboardInput!=0) keyboardInput*=-1;
        this.calcWinBottom.setText(String.valueOf(keyboardInput));
    }

    public void onBtnClickAdd(View view) {
        lastSymbol="+";
        if (keyboardInput!=0 && calculation==0)
        {
            this.calcWinTop.setText(String.valueOf(keyboardInput)+lastSymbol);
            calculation=keyboardInput;
            keyboardInput=0;
        }
        this.calcWinTop.setText(String.valueOf(calculation)+lastSymbol);
    }

    public void onBtnClickAdd0ToCalcWin(View view) {
        int addNuber=0;
        if(keyboardInput!=0)
        {
            this.calcWinBottom.append(String.valueOf(addNuber));
            keyboardInput*=10+addNuber;
        }
    }

    public void onBtnClickSub(View view) {
        lastSymbol="-";
        if (keyboardInput!=0 && calculation==0)
        {
            this.calcWinTop.setText(String.valueOf(keyboardInput)+lastSymbol);
            calculation=keyboardInput;
            keyboardInput=0;
        }
        this.calcWinTop.setText(String.valueOf(calculation)+lastSymbol);
    }

    public void onBtnClickMultiply(View view) {
        lastSymbol="*";
        if (keyboardInput!=0 && calculation==0)
        {
            this.calcWinTop.setText(String.valueOf(keyboardInput)+lastSymbol);
            calculation=keyboardInput;
            keyboardInput=0;
        }
        this.calcWinTop.setText(String.valueOf(calculation)+lastSymbol);
    }

    public void onBtnClickSquarRoot(View view) {

        this.calcWinTop.append("√"+String.valueOf(keyboardInput));
        rootAnswer = Math.sqrt(keyboardInput);
        this.calcWinBottom.setText(String.valueOf(rootAnswer));
    }

    public void onBtnClickEquals(View view) {
        if(rootAnswer>0){


            if(lastSymbol=="")
            {
                calculation+=rootAnswer;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            else if(lastSymbol=="+")
            {
                calculation+=rootAnswer;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            else if(lastSymbol=="-")
            {
                calculation-=rootAnswer;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            else if(lastSymbol=="*")
            {
                calculation*=rootAnswer;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            else if(lastSymbol=="/")
            {
                calculation/=rootAnswer;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            if(equalSignCount==0)
            {
                this.calcWinTop.append("=");
            }
            keyboardInput=0;
            equalSignCount++;
            rootAnswer=0;
        }
        else {
            if (lastSymbol == "") {
                calculation += keyboardInput;
                this.calcWinBottom.setText(String.valueOf(calculation));
            } else if (lastSymbol == "+") {
                calculation += keyboardInput;
                this.calcWinBottom.setText(String.valueOf(calculation));
            } else if (lastSymbol == "-") {
                calculation -= keyboardInput;
                this.calcWinBottom.setText(String.valueOf(calculation));
            } else if (lastSymbol == "*") {
                calculation *= keyboardInput;
                this.calcWinBottom.setText(String.valueOf(calculation));
            } else if (lastSymbol == "/") {
                calculation /= keyboardInput;
                this.calcWinBottom.setText(String.valueOf(calculation));
            }
            if (equalSignCount == 0) {
                this.calcWinTop.append(String.valueOf(keyboardInput) + "=");
            }
            keyboardInput = 0;
            equalSignCount++;
        }
    }

    public void onBtnClickDiv(View view) {
        lastSymbol="/";
        if (keyboardInput!=0 && calculation==0)
        {
            this.calcWinTop.setText(String.valueOf(keyboardInput)+lastSymbol);
            calculation=keyboardInput;
            keyboardInput=0;
        }
        this.calcWinTop.setText(String.valueOf(calculation)+lastSymbol);
    }

    public void inputNumber(int addNumber){
        if(keyboardInput==0)
        {
            keyboardInput=addNumber;
        }
        else
        {
            keyboardInput=keyboardInput*10+addNumber;
        }
        this.calcWinBottom.setText(String.valueOf(keyboardInput));

    }

}

