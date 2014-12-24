package com.example.notestakingapp;
import java.util.List;

import com.example.notestakingapp.data.NoteItem;
import com.example.notestakingapp.data.NotesDataSource;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private NotesDataSource dataSource;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        setContentView(R.layout.activity_main);
        
        dataSource = new NotesDataSource(MainActivity.this);
        List<NoteItem> notes = dataSource.findAll();
       
        NoteItem note = notes.get(0);
        
        note.setText("Updated");
        Log.d("Notes", "step1");
        
        dataSource.update(note);    
        Log.d("Notes", "step2");
        
        notes = dataSource.findAll();
        note = notes.get(0);
        
        Log.d("Notes", note.getKey()+ " : "+note.getText());
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
