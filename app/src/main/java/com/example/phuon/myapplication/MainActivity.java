package com.example.phuon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (EditText) findViewById(R.id.editText);

        String[] buttons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "="};
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tblLayout);
        TableRow tr = new TableRow(this);
        for (int i = 0; i < buttons.length; i++) {
            if (i % 4 == 0) {
                tr = new TableRow(this);
            }
            Button btn = new Button(this);
            btn.setText(String.valueOf(buttons[i]));
            btn.setOnClickListener(MainActivity.this);
            tr.addView(btn);
            if (tr.getParent() != null) {
                ((ViewGroup) tr.getParent()).removeView(tr);
            }
            tableLayout.addView(tr);

        }
    }

    private String clipboard = "";
    private String operator = "";
    private String oldNum = "";

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        String btnContent = btn.getText().toString();
        if (btnContent.equals("+")) {
            screen.setText("");
            operator = "+";
            oldNum = String.valueOf(clipboard);
            clipboard = "";
        } else if (btnContent.equals("-")) {
            screen.setText("");
            operator = "-";
            oldNum = String.valueOf(clipboard);
            clipboard = "";
        } else if (btnContent.equals("*")) {
            screen.setText("");
            operator = "*";
            oldNum = String.valueOf(clipboard);
            clipboard = "";
        } else if (btnContent.equals("/")) {
            screen.setText("");
            operator = "/";
            oldNum = String.valueOf(clipboard);
            clipboard = "";
        } else if (btnContent.equals("=")) {
            int a = Integer.parseInt(oldNum);
            int b = Integer.parseInt(screen.getText().toString());
            int rs = 0;
            switch (operator) {
                case "+":
                    rs = a + b;
                    break;
                case "-":
                    rs = a - b;
                    break;
                case "*":
                    rs = a * b;
                    break;
                case "/":
                    rs = a / b;
                    break;
            }
            clipboard = String.valueOf(rs);
            screen.setText(clipboard);
        } else {
            clipboard += String.valueOf(btnContent);
            screen.setText(clipboard);
        }
    }
}
