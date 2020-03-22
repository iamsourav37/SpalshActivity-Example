package com.backpakcersourav.basiccomponent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tvShow;
    RadioGroup rgCourses;
    RadioButton rbCourseSelected;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn = findViewById(R.id.button);
        rgCourses = findViewById(R.id.rgCourses);
        tvShow = findViewById(R.id.tvShow);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int checkedId = rgCourses.getCheckedRadioButtonId();
                    Log.d("myapp","id is : "+checkedId);
                    if(checkedId != -1){
                        rbCourseSelected = findViewById(checkedId);
                        String str = rbCourseSelected.getText().toString();
                        tvShow.setText(str);
                    }else {
                        AlertDialog.Builder alertDialog  = new AlertDialog.Builder(MainActivity.this);
                        alertDialog.setTitle("Error ");
                        alertDialog.setIcon(R.drawable.ic_clear_black_24dp);
                        alertDialog.setMessage("Please choose one course");
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertDialog.setNegativeButton("Autoselect", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                rbCourseSelected = findViewById(R.id.rbFlutter);
                                rbCourseSelected.setChecked(true);
                                String str = rbCourseSelected.getText().toString();
                                tvShow.setText(str);
                                return;
                            }
                        });
                        alertDialog.show();
                        tvShow.setText("Not Selected");
                    }


            }
        });

    }



}
