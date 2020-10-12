package com.example.calculator_assginment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.tv);
    }


    public void ButtonClick(View view){
        Button button =(Button) view;
        String data = button.getText().toString();

        switch (data) {
            //Em chưa làm được phần xử lý sự kiện đối với phần CE
//            case "CE":
//                if(input.split("\\+").length <= 1 || input.split("\\-").length <=1 || input.split("\\*").length <= 1 || input.split("\\/").length <= 1){
//                    String number [] = input.split()
//                }
//                break;
            case "C":
               input = " ";
                break;
            case "BS":
                if (input.length() > 0) {
                   String newText = input.substring(0, input.length() - 1);
                    input = newText;
                }
                break;
            case "=":
                slove();
                break;
            case "x":
                slove();
                input += "*";
                break;

            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/") ){
                    //In KQ
                    slove();
                }
                input += data;
        }
        textView.setText(input);
    }
    public void slove(){
        // Chuỗi vào của mình bao gồm: số hạng - toán hạng - số hạng.
        // Sử dụng cắt chuỗi thông qua hàm split => Tính toán với từng toán hạng

        //Phép nhân
        if(input.split("\\*").length == 2){
            String number[] = input.split("\\*");
            try {
                Integer mul = Integer.parseInt(number[0]) * Integer.parseInt(number[1]);
                input = mul + "";
            }catch (Exception e){

            }
        }

        //Phép cộng
        if(input.split("\\+").length == 2){
            String number[] = input.split("\\+");
            try {
               Integer sum = Integer.parseInt(number[0]) + Integer.parseInt(number[1]);
               input = sum + "";
            }catch (Exception e){

            }
        }

        //Phép trừ
        if(input.split("\\-").length == 2){
            String number[] = input.split("\\-");
            try {
                Integer sub = Integer.parseInt(number[0]) - Integer.parseInt(number[1]);
                input = sub + "";
            }catch (Exception e){

            }
        }

        //Phép chia
        if(input.split("\\/").length == 2){
            String number[] = input.split("\\/");
            try {
                Integer dev = Integer.parseInt(number[0]) / Integer.parseInt(number[1]);
                input = dev + "";
            }catch (Exception e){

            }
        }
    }
}

//Nút CE: Xóa toán hạng hiện tại về 0, nút C: xóa phép tính hiện tại, nút BS: xóa 1 chữ số của toán hạng hiện tại*/
