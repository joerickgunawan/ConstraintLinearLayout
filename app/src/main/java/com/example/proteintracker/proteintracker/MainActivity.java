package com.example.proteintracker.proteintracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.mainActivityTextView);
        textView.setText(R.string.test_untuk_update_view);
        Button helpBtn = (Button) findViewById(R.id.helpButton);
        helpBtn.setOnClickListener(helpButtonListener);

        if(savedInstanceState != null){
            Log.d("Protein Tracker",savedInstanceState.getString("abc"));
        }
    }

private View.OnClickListener myBtnClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            EditText myEditText = (EditText)findViewById(R.id.editText1);
            Log.d("ProteinTracker",myEditText.getText().toString());
            Button myBtn = (Button) findViewById(R.id.button1);
            myBtn.setOnClickListener(myBtnClickListener);
        }
    };


    private View.OnClickListener helpButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent (MainActivity.this,HelpActivity.class);
            Bundle b = new Bundle();
            EditText myEditText = (EditText)findViewById(R.id.editText1);
            b.putString("helpString",myEditText.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("abc","test");
        super.onSaveInstanceState(outState);
    };
}
