package com.htc.eleven.contentproviderwriter;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStore).setOnClickListener(this);
        editName = (EditText) findViewById(R.id.editName);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStore:
                ContentValues content = new ContentValues();
                content.put("name", editName.getText().toString());

                getContentResolver().insert(MyContentProvider.URI, content);
                Toast.makeText(MainActivity.this,"写入成功!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
