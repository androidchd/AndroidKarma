package com.KarmaLakeLand1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class SendMessagesActivity extends Activity {
    ListView listView;
    String TAG;
    ContactsAdapter c1 = null;
    ImageButton back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcontacts);
        listView = (ListView) findViewById(R.id.contactsView);

        back = (ImageButton) findViewById(R.id.favriot);
        back.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(SendMessagesActivity.this, Bookingconfirmation.class);
                startActivity(intent);
                finish();
            }
        });
        c1 = new ContactsAdapter(SendMessagesActivity.this, Bookingconfirmation.contact);
        try {
            listView.setAdapter(c1);
        } catch (NullPointerException e) {

        }

    }

}

/*
package com.karmalakeland;





import com.karmalakeland.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class SendMessagesActivity extends Activity {
	ListView listView;
	EditText editMessage;
	ProgressDialog progressDialog;
	Handler progresshandler;
	Button btnSend;
	private String contactID;
	private Uri uriContact;
	String TAG;
	SimpleCursorAdapter mAdapter;
	MatrixCursor mMatrixCursor;
	ImageButton back;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontacts);
		listView = (ListView) findViewById(R.id.contactsView);

		back=(ImageButton)findViewById(R.id.favriot);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		ContactsAdapter c1= new ContactsAdapter(getApplicationContext(), Bookingconfirmation.contact);
		listView.setAdapter(c1);

	}

}*/
/*
package com.karmalakeland;





import com.karmalakeland.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class SendMessagesActivity extends Activity {
	ListView listView;
	EditText editMessage;
	ProgressDialog progressDialog;
	Handler progresshandler;
   Button btnSend;
   private String contactID;
   private Uri uriContact;
   String TAG;
   SimpleCursorAdapter mAdapter;
	MatrixCursor mMatrixCursor;	
	 ImageButton back;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontacts);
		listView = (ListView) findViewById(R.id.contactsView);
      
        back=(ImageButton)findViewById(R.id.favriot);
        back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
       ContactsAdapter c1= new ContactsAdapter(getApplicationContext(), Bookingconfirmation.contact);
       listView.setAdapter(c1);
		
	}	
		 	
}*/
