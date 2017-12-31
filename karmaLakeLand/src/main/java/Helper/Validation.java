package Helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;
import android.view.Gravity;
import android.widget.TextView;



public class Validation {

	// ------------------Email Check---------------

	public static boolean isValidEmail(CharSequence target) {
		try {
			if (target == null) {
				return false;
			} else {
				return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
						.matches();
			}
		} catch (NullPointerException exception) {
			return false;
		}
	}

	// ------------------Number Check---------------

	public static boolean isValidNumber(CharSequence target) {
		try {
			if (target.length() >= 10) {
				return android.util.Patterns.PHONE.matcher(target).matches();
			} else {
				return false;
			}
		} catch (NullPointerException exception) {
			return false;
		}
	}

	//-------------------------password length===========
	public static boolean isValidLength(CharSequence target) {
		try {
			if (target.length() >= 6) {
				return Patterns.EMAIL_ADDRESS.matcher(target).matches();
			} else {
				return false;
			}
		} catch (NullPointerException exception) {
			return false;
		}
	}

	// ------------------Internet Check---------------

	public static boolean networkChk(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
		}
		return false;
	}

	// ------------------Customize AlertBox---------------

	
	
	public static void  serverNotConnectedDialog(Context context)
	{
		// TODO Auto-generated method stub
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Network Error")
		.setMessage(
				"Network not available")
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(final DialogInterface dialog,
							final int id) {

					}
				});
		final AlertDialog alert = builder.create();
		alert.show();
		TextView messageText = (TextView) alert.findViewById(android.R.id.message);
		messageText.setGravity(Gravity.CENTER);
		
		int textViewId = alert.getContext().getResources().getIdentifier("android:id/alertTitle", null, null);
		TextView tv = (TextView) alert.findViewById(textViewId);
		if (tv != null) 
		{
			tv.setTextColor(context.getResources().getColor(android.R.color.black));
			

			tv.setTextSize(17f);
			tv.setGravity(Gravity.CENTER);
		}
		
		


	}

}
