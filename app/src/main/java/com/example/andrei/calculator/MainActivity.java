package com.example.andrei.calculator;

import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_clear, btn_division,btn_multiplication , btn_addition ,btn_subtraction,btn_parantheses,
            btn_result,btn_power, btn_point ,btn_root , btn_alternateSign ,btn_delete;

    Button btn_9, btn_8 ,btn_7, btn_6, btn_5, btn_4, btn_3 ,btn_2 ,btn_1 , btn_0;
    public static TextView input;
    private static final char ADDITION='+';
    private static final char SUBTRACTION='-';
    private static final char DIVISION='/';
    private static final char MULTIPLICATION='*';
    private static final char NONE='?';







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         input=(TextView)findViewById(R.id.input);

         btn_clear=(Button)findViewById(R.id.btn_clear);
         btn_division=(Button)findViewById(R.id.btn_division);
         btn_multiplication=(Button)findViewById(R.id.btn_multiplication);
         btn_addition=(Button)findViewById(R.id.btn_addition);
         btn_subtraction=(Button)findViewById(R.id.btn_subtraction);
         btn_parantheses=(Button)findViewById(R.id.btn_parantheses);
         btn_result=(Button)findViewById(R.id.btn_result);
         btn_point=(Button)findViewById(R.id.btn_point);
         btn_power=(Button)findViewById(R.id.btn_power);
         btn_root=(Button)findViewById(R.id.btn_root);
         btn_alternateSign=(Button)findViewById(R.id.btn_alternateSign);
         btn_delete=(Button)findViewById(R.id.btn_delete);

         btn_7=(Button)findViewById(R.id.btn_7);
         btn_8=(Button)findViewById(R.id.btn_8);
         btn_9=(Button)findViewById(R.id.btn_9);
         btn_6=(Button)findViewById(R.id.btn_6);
         btn_5=(Button)findViewById(R.id.btn_5);
         btn_4=(Button)findViewById(R.id.btn_4);
         btn_3=(Button)findViewById(R.id.btn_3);
         btn_2=(Button)findViewById(R.id.btn_2);
         btn_1=(Button)findViewById(R.id.btn_1);
         btn_0=(Button)findViewById(R.id.btn_0);




        btn_clear.setOnClickListener(clickListener);
        btn_division.setOnClickListener(clickListener);
        btn_multiplication.setOnClickListener(clickListener);
        btn_addition.setOnClickListener(clickListener);
        btn_subtraction.setOnClickListener(clickListener);
        btn_parantheses.setOnClickListener(clickListener);
        btn_result.setOnClickListener(clickListener);
        btn_point.setOnClickListener(clickListener);
        btn_power.setOnClickListener(clickListener);
        btn_root.setOnClickListener(clickListener);
        btn_alternateSign.setOnClickListener(clickListener);
        btn_delete.setOnClickListener(clickListener);

        btn_0.setOnClickListener(clickListener);
        btn_1.setOnClickListener(clickListener);
        btn_2.setOnClickListener(clickListener);
        btn_3.setOnClickListener(clickListener);
        btn_4.setOnClickListener(clickListener);
        btn_5.setOnClickListener(clickListener);
        btn_6.setOnClickListener(clickListener);
        btn_7.setOnClickListener(clickListener);
        btn_8.setOnClickListener(clickListener);
        btn_9.setOnClickListener(clickListener);






    }


    View.OnClickListener clickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_1:
                    if(input.getText().length()==0){
                        input.setText("1");
                    }else {
                        input.setText(input.getText()+"1");
                    }
                    break;
                case R.id.btn_2:
                    if(input.getText().length()==0){
                        input.setText("2");
                    }else {
                        input.setText(input.getText()+"2");
                    }
                    break;
                case R.id.btn_3:
                    if(input.getText().length()==0){
                        input.setText("3");
                    }else {
                        input.setText(input.getText()+"3");
                    }
                    break;
                case R.id.btn_4:
                    if(input.getText().length()==0){
                        input.setText("4");
                    }else {
                        input.setText(input.getText()+"4");
                    }
                    break;
                case R.id.btn_5:
                    if(input.getText().length()==0){
                        input.setText("5");
                    }else {
                        input.setText(input.getText()+"5");
                    }
                    break;
                case R.id.btn_6:
                    if(input.getText().length()==0){
                        input.setText("6");
                    }else {
                        input.setText(input.getText()+"6");
                    }
                    break;
                case R.id.btn_7:
                    if(input.getText().length()==0){
                        input.setText("7");
                    }else {
                        input.setText(input.getText()+"7");
                    }
                    break;
                case R.id.btn_8:
                    if(input.getText().length()==0){
                        input.setText("8");
                    }else {
                        input.setText(input.getText()+"8");
                    }
                    break;
                case R.id.btn_9:
                    if(input.getText().length()==0){
                        input.setText("9");
                    }else {
                        input.setText(input.getText()+"9");
                    }
                    break;
                case R.id.btn_0:
                    if(input.getText().length()>0){
                        input.setText(input.getText()+"0");
                    }
                    break;


                case R.id.btn_addition:
                    if(input.getText().length()>0){
                        if(input.getText().toString().contains("=")){

                        }
                        input.setText(input.getText()+"+");
                    }
                    break;
                case R.id.btn_subtraction:
                    if(input.getText().length()>0){
                        input.setText(input.getText()+"-");
                    }
                    break;
                case R.id.btn_division:
                    if(input.getText().length()>0){
                        input.setText(input.getText()+"/");
                    }
                    break;
                case R.id.btn_multiplication:
                    if(input.getText().length()>0){
                        input.setText(input.getText()+"*");
                    }
                    break;
                case R.id.btn_result:
                    if(input.getText().length()>2){
                        if(input.getText().toString().contains("=")){
                            break;
                        }
                        StringBuilder line=new StringBuilder(input.getText());
                        char sign=getOperation(line);
                        ArrayList<String> parameters=getParameters(line,String.valueOf(sign));
                            if (parameters.get(0).contains(".") || sign=='/'){
                            float result = performFloatComputations(parameters.get(0),parameters.get(1),sign);
                            if(result/(int)result==1){
                                int intRes=(int)result;
                                input.setText(input.getText()+" = "+intRes);
                            } else {
                                input.setText(input.getText()+" = "+result);
                            }

                        } else {
                            int result =performIntComputations(parameters.get(0),parameters.get(1),sign);
                            input.setText(input.getText()+" = "+result);
                        }
/*
                        float result = performFloatComputations(parameters.get(0),parameters.get(1),sign);
                        if(result/(int)result==1){
                            int intRes=(int)result;
                            input.setText(input.getText()+" = "+intRes);
                        } else {
                            input.setText(input.getText()+" = "+result);
                        }  */


                    }

                    break;

                case R.id.btn_delete:
                    if(input.getText().length()>1){
                        StringBuilder line=new StringBuilder(input.getText());
                        line.deleteCharAt(line.length()-1);
                        input.setText(line);
                    } else{
                        input.setText(" ");
                    }
                    break;
                case R.id.btn_clear:
                    if(input.getText().length()>0){
                        input.setText(" ");
                    }
                    break;
                case R.id.btn_point:
                    if(input.getText().length()>0){
                        input.setText(input.getText()+".");
                    }
                    break;

                case R.id.btn_alternateSign:
                    break;


            }
        }
    };


    public static char getOperation(StringBuilder sb){
         for (int i=0 ; i<sb.length() ;i++){
             char sign = sb.charAt(i);
             switch(sign){
                 case ADDITION:
                     return ADDITION;
                 case SUBTRACTION:
                     return SUBTRACTION;
                 case DIVISION:
                     return DIVISION;
                 case MULTIPLICATION:
                     return MULTIPLICATION;
             }

         }
         return NONE;
    }




    public static ArrayList<String> getParameters(StringBuilder sb, String sign){
        ArrayList<String> parameters=new ArrayList<>() ;
            int indexSign=sb.lastIndexOf(sign);
        parameters.add(sb.substring(0,indexSign).trim());
            Log.i("PARAMETER 1 = ",parameters.get(0));
        parameters.add(sb.substring(indexSign+1,sb.length()).trim());
            Log.i("PARAMETER 2 = ",parameters.get(1));


        return parameters;
    }

    public static int performIntComputations(String firstParam,String secondParam , char sign){
        int first=Integer.parseInt(firstParam);
        int second=Integer.parseInt(secondParam);
        int result=0;
        switch(sign){
            case ADDITION:
                result=first+second;
                break;
            case SUBTRACTION:
                result=first-second;
                break;
            case MULTIPLICATION:
                result=first*second;
                break;
            case DIVISION:
                result=first/second;
                break;
        }
        return result;
    }

    public static float performFloatComputations(String firstParam,String secondParam , char sign){
        float first=Float.parseFloat(firstParam);
        float second=Float.parseFloat(secondParam);
        float result=0;
        switch(sign){
            case ADDITION:
                result=first+second;
                break;
            case SUBTRACTION:
                result=first-second;
                break;
            case MULTIPLICATION:
                result=first*second;
                break;
            case DIVISION:
                result=first/second;
                break;
        }
        return result;

    }


public static boolean getResult(){
    boolean value=false;
    
    return false;
}


}
