package calculator.cosw.eci.edu.calculadorapolacainversacosw;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Double> array_values;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_ac, btn_point, btn_next, btn_sum, btn_subst, btn_mult,
    btn_div, btn_moreLess, btn_squared, btn_sqrt, btn_log;
    private TextView txt_operation;
    private double actualValue;
    private long actualValueLong;
    private boolean isDouble, isPendientDouble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculadora");
        array_values = new ArrayList<>();
        initialState();
        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);
        btn_ac=(Button)findViewById(R.id.btn_ac);
        btn_point=(Button)findViewById(R.id.btn_point);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_sum=(Button)findViewById(R.id.btn_more);
        btn_subst=(Button)findViewById(R.id.btn_subs);
        btn_mult=(Button)findViewById(R.id.btn_mult);
        btn_div=(Button)findViewById(R.id.btn_division);
        btn_moreLess=(Button)findViewById(R.id.btn_moreLess);
        btn_squared=(Button)findViewById(R.id.btn_squared);
        btn_sqrt=(Button)findViewById(R.id.btn_sqrt);
        btn_log=(Button)findViewById(R.id.btn_log);
        txt_operation= (TextView)findViewById(R.id.txt_operation) ;


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {addNumberActual("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNumberActual("9");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array_values.clear();
                initialState();
                drawOperation();
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDouble = true;
                actualValue = actualValueLong;
                isPendientDouble = true;
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToArrayValue();
                drawOperation();
            }
        });

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               preValidOperation();
               if(isOperationValidTwoFactors()){
                   double operando1 = 0, operando2 = 0, total=0;
                   operando1 = array_values.get(array_values.size()-1);
                   operando2 = array_values.get(array_values.size()-2);

                   removeTwoLastOperators();
                   total = operando1 + operando2;
                   array_values.add(total);
                   initialState();
               }
               else{
                   Toast.makeText(getApplicationContext(),"You need 2 values.", Toast.LENGTH_SHORT).show();;
               }
               drawOperation();
            }
        });
        btn_subst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidTwoFactors()){
                    double operando1 = 0, operando2 = 0, total=0;
                    operando2 = array_values.get(array_values.size()-1);
                    operando1 = array_values.get(array_values.size()-2);

                    removeTwoLastOperators();
                    total = operando1 - operando2;
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 2 values.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidTwoFactors()){
                    double operando1 = 0, operando2 = 0, total=0;
                    operando2 = array_values.get(array_values.size()-1);
                    operando1 = array_values.get(array_values.size()-2);
                    removeTwoLastOperators();
                    total = operando1 * operando2;
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 2 values.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidTwoFactors()){
                    double operando1 = 0, operando2 = 0, total=0;
                    operando2 = array_values.get(array_values.size()-1);
                    operando1 = array_values.get(array_values.size()-2);
                    if(operando2!=0) {
                        removeTwoLastOperators();
                        total = operando1 / operando2;
                        array_values.add(total);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Error! Can't be divided by 0.", Toast.LENGTH_SHORT).show();;
                    }
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 2 values.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_moreLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidOneFactor()){
                    double operando1 = 0, total=0;
                    operando1 = array_values.get(array_values.size()-1);
                    removeOneLastOperator();
                    total = operando1 * -1;
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_squared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidOneFactor()){
                    double operando1 = 0, total=0;
                    operando1 = array_values.get(array_values.size()-1);
                    removeOneLastOperator();
                    total = operando1 * operando1;
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidOneFactor()){
                    double operando1 = 0, total=0;
                    operando1 = array_values.get(array_values.size()-1);
                    removeOneLastOperator();
                    total = Math.sqrt(operando1);
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preValidOperation();
                if(isOperationValidOneFactor()){
                    double operando1 = 0, total=0;
                    operando1 = array_values.get(array_values.size()-1);
                    removeOneLastOperator();
                    total = Math.log10(operando1);
                    array_values.add(total);
                    initialState();
                }
                else{
                    Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
                }
                drawOperation();
            }
        });
    }


    private void drawOperation(){
        String operation = "";
        for(int i=0; i<array_values.size(); i++){
            operation = operation + array_values.get(i) + "  ";
        }

        if(isDouble){
            operation = operation + actualValue;
        }
        else{
            operation = operation + actualValueLong;
        }

        txt_operation.setText(operation);
    }

    private double convertStringToDouble(String value){
        double returnNum = 0;
        try{
            returnNum = Double.valueOf(value);
        }catch (NumberFormatException e){
            returnNum = 0;
        }
        return returnNum;
    }

    private long convertStringToLong(String value){
        long returnNum = 0;
        try{
            returnNum = Long.valueOf(value);
        }catch (NumberFormatException e){
            returnNum = 0;
        }
        return returnNum;
    }

    private void addNumberActual(String number){
        String valueTemp = "";
        if(isDouble){
            if(isPendientDouble){
                isPendientDouble = false;
                valueTemp = String.valueOf(actualValueLong)+"."+number;
            }
            else{
                valueTemp = String.valueOf(actualValue)+ number;
            }

            actualValue = convertStringToDouble(valueTemp);

        }
        else{
            valueTemp = String.valueOf(actualValueLong)+ number;
            actualValueLong = convertStringToLong(valueTemp);
        }

        drawOperation();
    }

    private void initialState(){
        actualValue = 0;
        actualValueLong = 0;
        isDouble = false;
        isPendientDouble = false;
    }

    private boolean isOperationValidTwoFactors(){
        if(array_values.size()<=1){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean isOperationValidOneFactor(){
        if(array_values.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }


    private void addToArrayValue(){
        if(isDouble){
            array_values.add(actualValue);
        }
        else{
            array_values.add(Double.valueOf(actualValueLong));
        }
        initialState();
    }

    private void removeTwoLastOperators(){
        array_values.remove(array_values.size()-1);
        array_values.remove(array_values.size()-1);
    }

    private void removeOneLastOperator(){
        array_values.remove(array_values.size()-1);
    }

    private void preValidOperation(){
        if(actualValue!=0 || actualValueLong!=0){
            addToArrayValue();
            drawOperation();
        }
    }

    public void calculateCos(View view) {
        preValidOperation();
        if(isOperationValidOneFactor()){
            double operando1 = 0, total=0;
            operando1 = array_values.get(array_values.size()-1);
            removeOneLastOperator();
            total = Math.cos(operando1);
            array_values.add(total);
            initialState();
        }
        else{
            Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
        }
        drawOperation();
    }

    public void calculateSen(View view) {
        preValidOperation();
        if(isOperationValidOneFactor()){
            double operando1 = 0, total=0;
            operando1 = array_values.get(array_values.size()-1);
            removeOneLastOperator();
            total = Math.sin(operando1);
            array_values.add(total);
            initialState();
        }
        else{
            Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
        }
        drawOperation();
    }

    public void calculateTan(View view) {
        preValidOperation();
        if(isOperationValidOneFactor()){
            double operando1 = 0, total=0;
            operando1 = array_values.get(array_values.size()-1);
            removeOneLastOperator();
            total = Math.tan(operando1);
            array_values.add(total);
            initialState();
        }
        else{
            Toast.makeText(getApplicationContext(),"You need 1 value.", Toast.LENGTH_SHORT).show();;
        }
        drawOperation();
    }
}
