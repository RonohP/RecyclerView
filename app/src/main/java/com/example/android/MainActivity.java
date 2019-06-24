package com.example.android;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word" + mCount++);
            Log.d("WordList", mWordList.getLast());
        }

        //Get a	handle to the RecyclerView.
        final RecyclerView mRecyclerView = findViewById(R.id.recyclerview);
        //Create an	adapter	and	supply the	data to	be	displayed.
        WordListAdapter mAdapter = new WordListAdapter(this, mWordList);
        //	Connect	the	adapter	with the	RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        //	Give the RecyclerView a	default	layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //	Add	a floating action click	handler	for	creating new	entries.
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public	void onClick(View view){
                int	wordListSize = mWordList.size();
                //	Add	a new	word to	the	end	of	the	wordList.
                mWordList.addLast("+Word"	+	wordListSize);
                //	Notify	the	adapter,that the data has changed	so	it	can
                // 	update	the	RecyclerView to	display	the	data.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                //Scroll to	the	bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);}
        });
    }
}
