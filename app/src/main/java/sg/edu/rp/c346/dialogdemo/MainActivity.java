package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnExercise3;
    Button btnDemo4;
    Button btnDemo5;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvExercise3;
    TextView tvDemo4;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise3 = findViewById(R.id.buttonEx3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvExercise3 = findViewById(R.id.textViewEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                /*
                // Set the dialog details
                myBuilder.setTitle("Demo 1-Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */
                // Custom modified codes
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

                btnDemo2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setTitle("Demo 2 Buttons Dialog");
                        myBuilder.setMessage("Select one of the Button below");
                        myBuilder.setCancelable(false);

                        // Configure the 'positive' button
                        myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvDemo2.setText("You have selected Positive.");
                            }
                        });

                        // Configure the 'negative' button
                        myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvDemo2.setText("You have selected Negative.");
                            }
                        });

                        // Configure the 'neutral' button
                        myBuilder.setNeutralButton("Cancel", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();


                    }
                });
                btnDemo3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Inflate the input.xml layout file
                        LayoutInflater inflater =
                                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View viewDialog = inflater.inflate(R.layout.input, null);

                        // Obtain the UI component in the input.xml layout
                        // It needs to be defined as "final", so that it can used in the onClick() method later
                        final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog); // Set the view of the dialog
                        myBuilder.setTitle("Demo 3-Text Input Dialog");
                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Extract the text entered by the user
                                String message = etInput.getText().toString();
                                // Set the text to the TextView
                                tvDemo3.setText(message);
                            }
                        });
                        myBuilder.setNegativeButton("CANCEL", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();
                    }
                });
                btnExercise3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Inflate the inputtwo.xml layout file
                        LayoutInflater inflater =
                                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View viewDialog = inflater.inflate(R.layout.inputtwo, null);

                        // Obtain the UI component in the inputtwo.xml layout
                        // It needs to be defined as "final", so that it can used in the onClick() method later
                        final EditText etInput = viewDialog.findViewById(R.id.editTextNo);
                        final EditText etInput2 = viewDialog.findViewById(R.id.editTextNo2);

                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                        myBuilder.setView(viewDialog); // Set the view of the dialog
                        myBuilder.setTitle("Exercise 3");
                        myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Extract the text entered by the user
                                int value1 = Integer.parseInt(etInput.getText().toString());
                                int value2 = Integer.parseInt(etInput2.getText().toString());
                                // Set the text to the TextView
                                Integer total = value1 +value2;
                                tvExercise3.setText(String.valueOf(total));
                            }
                        });
                        myBuilder.setNegativeButton("CANCEL", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();
                    }
                });
                btnDemo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Create the Listener to set the date
                        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                            }
                        };

                        // Create the Date Picker Dialog
                        Calendar c = Calendar.getInstance();
                        int mYear = c.get(Calendar.YEAR);
                        int mMonth = c.get(Calendar.MONTH);
                        int mDay = c.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                                myDateListener, mYear, mMonth, mDay);
                        myDateDialog.show();
                    }
                });
                btnDemo5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Create the Listener to set the time
                        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                            }
                        };

                        // Create the Time Picker Dialog
                        Calendar c = Calendar.getInstance();
                        int mHour = c.get(Calendar.HOUR_OF_DAY);
                        int mMinute = c.get(Calendar.MINUTE);
                        TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, mHour, mMinute, true);

                        myTimeDialog.show();
                    }
                });
            }
        });
    }
}
