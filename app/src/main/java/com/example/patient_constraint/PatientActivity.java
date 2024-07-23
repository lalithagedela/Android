package com.example.patient_constraint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Calendar;

public class PatientActivity extends AppCompatActivity {
    Patient_Model data;
    Button save, male_button, female_button, others_button, single_button, married_button, divorced_button;
    Toast Toast;
    String gender,maritalStatus= " ";
    String str1, str2, str3,  str5, str6, str7, str8, str9, str10, str11, str12, str13;
    EditText firstname_edit, lastname_edit, email_edit, phonenumber_edit, address_edit,  city_edit, zipcode_edit, age_edit,state_edit;
    ImageView date_icon;
    TextView date,check_text;
    Spinner occupation_spinner, country_spinner;
    CheckBox ch;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_registration);

        firstname_edit = findViewById(R.id.firstname_edit);
        lastname_edit = findViewById(R.id.lastname_edit);
        email_edit = findViewById(R.id.Email_edit);
        phonenumber_edit = findViewById(R.id.PhoneNumber_edit);
        address_edit = findViewById(R.id.Address_edit);
        city_edit = findViewById(R.id.city_edit);
        state_edit = findViewById(R.id.state_edit);
        zipcode_edit = findViewById(R.id.zipcode_edit);
        country_spinner = findViewById(R.id.Country_edit);
        date=findViewById(R.id.date);
        date_icon = findViewById(R.id.date_icon);
        age_edit = findViewById(R.id.Age_edit);
        occupation_spinner = findViewById(R.id.occupation_edit);


        male_button = findViewById(R.id.male_button);
        female_button = findViewById(R.id.female_button);
        others_button = findViewById(R.id.others_button);
        single_button = findViewById(R.id.single_button);
        married_button = findViewById(R.id.married_button);
        divorced_button = findViewById(R.id.divorced_button);


        ch=findViewById(R.id.checkBox);
        check_text=findViewById(R.id.checktext);
        save = findViewById(R.id.save);

        Log.d("TAG", "onCreate: ");

//        SpannableString string = new SpannableString("Accept terms and conditions and privacy policy");
//        setSpan(string, string.toString().indexOf("terms"), string.toString().lastIndexOf("and"));
//        setSpan(string, string.toString().indexOf("privacy"), string.length());
//        check_text.setText(string);



        save.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(ch.isChecked()) {
                    isAllFieldsChecked = CheckAllFields();
                    Toast.makeText(getApplicationContext(), "Patient details are saved", Toast.LENGTH_SHORT).show();


                    str1 = firstname_edit.getText().toString();
                    str2 = lastname_edit.getText().toString();
                    str3 = email_edit.getText().toString();
                    str5 = phonenumber_edit.getText().toString();
                    str6 = address_edit.getText().toString();
                    str7 = city_edit.getText().toString();
                    str8 = state_edit.getText().toString();
                    str9 = zipcode_edit.getText().toString();
                    str10 = country_spinner.getSelectedItem().toString();
                    str11=date.getText().toString();
                    str12 = age_edit.getText().toString();
                    str13 = occupation_spinner.getSelectedItem().toString();



                    data = new Patient_Model();//default constructor


                    data.setFirstname(str1);
                    data.setLastname(str2);
                    data.setEmail(str3);
                    data.setPhoneNumber(str5);
                    data.setAddress(str6);
                    data.setCity(str7);
                    data.setState(str8);
                    data.setZipcode(str9);
                    data.setCountry(str10);
                    data.setDate(str11);
                    data.setAge(str12);
                    data.setOccupation(str13);
                    data.setGender(gender);
                    data.setMartial_status(maritalStatus);
                    if (isAllFieldsChecked) {
                        Intent intent = new Intent(PatientActivity.this, Patient_SecondActivity.class);
                        intent.putExtra("Details", data);
                        startActivity(intent);
                    }
                }
            }
        });


        



        date_icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PatientActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String selectedDate = dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
                                date.setText(selectedDate);
                                age_edit.setText(""+calculateAge(year,monthOfYear,dayOfMonth));
                            }

                        },
                        year,month,day);
                datePickerDialog.show();
            }
        });


        male_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gender = "male";
                selectGenderButton(male_button);
            }
        });


        female_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gender = "female";
                selectGenderButton(female_button);
            }
        });


        others_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gender = "others";
                selectGenderButton(others_button);
            }
        });


        single_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                maritalStatus = "single";
                selectMartialStatus(single_button);
            }
        });

        married_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                maritalStatus = "married";
                selectMartialStatus(married_button);
            }
        });

        divorced_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                maritalStatus = "unmarried";
                selectMartialStatus(divorced_button);
            }
        });

    }

    private boolean CheckAllFields() {
        if (firstname_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter First Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (lastname_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Last Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
            return false;

        } else if (!email_edit.getText().toString().endsWith("@gmail.com")) {
            Toast.makeText(getApplicationContext(), "Email must contain @gmail.com", Toast.LENGTH_SHORT).show();
            return false;
        }
        

        if (phonenumber_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Phone Number", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (address_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Address", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (city_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter City", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (city_edit.getText().toString().isEmpty())  {
            Toast.makeText(getApplicationContext(), "Please enter State", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (zipcode_edit.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter Zip Code", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (country_spinner.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please select one item", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (date_icon.toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter date of birth", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(age_edit.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter age", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (occupation_spinner.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please select one item", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void selectGenderButton(Button selectedButton) {
        male_button.setSelected(selectedButton == male_button);
        female_button.setSelected(selectedButton == female_button);
        others_button.setSelected(selectedButton == others_button);

    }

    private void selectMartialStatus(Button selectedButton){
        single_button.setSelected(selectedButton == single_button);
        married_button.setSelected(selectedButton == married_button);
        divorced_button.setSelected(selectedButton == divorced_button);
    }

    private int  calculateAge(int year, int monthOfYear, int dayOfMonth ) {
        Calendar dobCalendar = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        dobCalendar.set( year, monthOfYear,dayOfMonth);
        int age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);
        return age;
    }

    private SpannableString setSpan(SpannableString string, int startIndex, int endIndex) {
        string.setSpan(new UnderlineSpan(), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new ForegroundColorSpan(Color.BLUE), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return string;

    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause: ");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop: ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestart: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy: ");

    }

}
