package com.example.android.roomwordssample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditWordActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "com.example.android.wordlistsql.ID";
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);
        mEditWordView = findViewById(R.id.edit_word);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            mEditWordView.setText(intent.getStringExtra(EXTRA_REPLY));
        }else{
        }

        final Button button = findViewById(R.id.button_edit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    //VALIDACIÓN DE ID.
                    int id = getIntent().getIntExtra(EXTRA_ID, -1);
                    if (id != -1){
                        replyIntent.putExtra(EXTRA_ID, id);
                    }
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
