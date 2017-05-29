package rkv.team.seminar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Keyboard extends Activity implements OnItemSelectedListener {
	Spinner spinner;
	EditText key1, key2, key3, keyb;
	List<String> categories;

	private int i = 0;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.keyboard);
		key1 = (EditText) findViewById(R.id.key1);
		key2 = (EditText) findViewById(R.id.key2);
		key3 = (EditText) findViewById(R.id.key3);
		keyb = (EditText) findViewById(R.id.keyb);
		spinner = (Spinner) findViewById(R.id.shortcut);
		spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.keys_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

	}

	public void onKeysubmit(View v) {
		try {
			SocketThread.ops.writeUTF("TYPE " + keyb.getText().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onKeyclear(View v) {
		keyb.setText("");
	}

	public void onClick(View v) {

		key1.setEnabled(true);
		key2.setEnabled(true);
		key3.setEnabled(true);
		key1.setText("");
		key2.setText("");
		key3.setText("");
		i = 1;

	}

	public void onSubmit(View v) {
		try {
			SocketThread.ops.writeUTF("KEYCOMBO " + key1.getText().toString()
					+ " " + key2.getText().toString() + " "
					+ key3.getText().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Toast.makeText(
				this,
				key1.getText().toString() + " " + key2.getText().toString()
						+ " " + key3.getText().toString(), Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		String item = parent.getItemAtPosition(position).toString();
		i++;
		if (i == 2) {
			if (!(item.equals("select.."))) {
				key1.setText(item);
				key1.setEnabled(false);

			}
		} else if (i == 3) {
			if (!(item.equals("select.."))) {
				key2.setText(item);
				key2.setEnabled(false);

			}
		} else if (i == 4) {
			if (!(item.equals("select.."))) {
				key3.setText(item);
				key3.setEnabled(false);

			}
		}

		// Showing selected spinner item
		Toast.makeText(parent.getContext(), "Selected: " + item,
				Toast.LENGTH_LONG).show();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
