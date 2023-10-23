package com.example.diagnosisapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private List<String> titleList, desList, formulaList,linkList;
    String titleTXT,desTXT,formulaTXT,linkTXT;
    EditText title, desc, formula,link;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        title = findViewById(R.id.title);
        desc = findViewById(R.id.des);
        formula = findViewById(R.id.formula);
        link = findViewById(R.id.link);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        titleList= new ArrayList<>();
        desList= new ArrayList<>();
        formulaList= new ArrayList<>();
        linkList= new ArrayList<>();

//        titleList.add("Allergy");
//        desList.add("Allergy is a very individualor to-each-his-own medical condition. Put simply, what your body may be allergic to, the other person may not be and the other way round. Allergy is a sudden hypersensitive reaction that presents itself with a number of symptoms following contact with an allergen. Now, what is an allergen? It’s an agent that is harmful to a sensitive or allergic person but does not have any effect on others. The main allergens are dust mites, pollens, animal danders and certain food items like eggs. The main allergies are nasal allergy, allergic cough, food allergies, dust allergy and skin rash. Some persons are very allergic to hair dyesas well. The Homeopathic remedies for allergy not only helps in providing relief in acute attacks of allergy, but also works to cure the allergy by extracting the underlying root cause. The Homeopathic treatment for allergy is completely safe, since the homeopathic medicines are sourced out of natural substances and there are no toxins involved. The natural Homeopathic remedies that are best suited are chosen on the basis of the symptoms and characteristics narrated by each patient.");
//        formulaList.add("Apis Mellifica$•Arsenic Album$•Natrum Mur$ Sulphur");
//        linkList.add("https://www.drhomeo.com/allergy/top-homeopathic-remedies-for-allergy/");
//
//        titleList.add("Dust allergy");
//        desList.add("Dust allergy is an immediate allergic response caused by exposure to dust and dust mites. Dust mites are tiny microorganisms found mostly in bed linen, mattresses, and furniture. Dust allergy usually occurs in people who live in warm, humid and damp places. Symptoms of dust allergy range from mild to severe. The main symptoms of dust allergy are sneezing, a runny nose, and itching of the eyes and nose. The patient may also have difficulty in breathing, a cough, and itching on the roof of the mouth. Dust allergy which persists for a long time may result in chronic cases of asthma. Homeopathic treatment for dust allergy is a permanent, rapid and safe cure. It is made of natural substances which are not toxic and do not have any side effects. They are not habit forming and can be safely taken for extended periods of time. This treatment works to stimulate the weakened immune system. The benefit of using homeopathy is that it stops the recurrent episodes of disease. Homeopathy is effective in all age groups.  ");
//        formulaList.add("Allium Cepa$•Arsenic Album$•Arundo$•Sabadilla");
//        linkList.add("https://www.drhomeo.com/homeopathic-treatment/homeopathic-treatment-dust-allergy/");

//
//        for ( int j=0; j<titleList.size(); j++ )
//        {
//            titleTXT=titleList.get(j);
//            desTXT=desList.get(j);
//            formulaTXT=formulaList.get(j);
//            linkTXT=linkList.get(j);
//
//            Boolean checkinsertdata= DB.insertuserdata(titleTXT,desTXT,formulaTXT,linkTXT);
//            if(checkinsertdata==true)
//            {
//                Toast.makeText(MainActivity2.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(MainActivity2.this, "Failed to Insert Entry", Toast.LENGTH_SHORT).show();
//            }
//        }

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titleTXT = title.getText().toString();
                String desTXT = desc.getText().toString();
                String formulaTXT = formula.getText().toString();
                String linkTXT = link.getText().toString();



                Boolean checkinsertdata= DB.insertuserdata(titleTXT,desTXT,formulaTXT,linkTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity2.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity2.this, "Failed to Insert Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titleTXT = title.getText().toString();
                String desTXT = desc.getText().toString();
                String formulaTXT = formula.getText().toString();
                String linkTXT = link.getText().toString();

                Boolean checkupdatedata= DB.updateuserdata(titleTXT,desTXT,formulaTXT,linkTXT);
                if(checkupdatedata==true)
                {
                    Toast.makeText(MainActivity2.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity2.this, "Failed to Update Entry", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titleTXT = title.getText().toString();

                Boolean checkdeletedata= DB.deletedata(titleTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(MainActivity2.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity2.this, "Entry not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity2.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                     return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Title :"+res.getString(0)+"\n");
                    buffer.append("Description :"+res.getString(1)+"\n");
                    buffer.append("Formula: "+res.getString(2)+"\n");
                    buffer.append("Link :"+res.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }

    public void btn_jump(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}