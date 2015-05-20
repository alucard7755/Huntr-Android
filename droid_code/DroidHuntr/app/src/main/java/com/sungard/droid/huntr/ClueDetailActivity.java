package com.sungard.droid.huntr;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;


public class ClueDetailActivity extends ActionBarActivity implements View.OnClickListener, LocationListener {

    TextView detailTextView;
    String clueTitle;

    //location test variables
    private TextView latituteField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;
    private Button selectPictureClue;
    private Button takePictureClue;
    private ImageView cluePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue_detail);
        detailTextView = (TextView) findViewById(R.id.clue_title);

        clueTitle = this.getIntent().getExtras().getString("clueID");

        detailTextView.setText(clueTitle);

        cluePic = (ImageView) findViewById(R.id.clue_imageView);

        //set up buttons for listeners
        takePictureClue  = (Button) findViewById(R.id.takepicturebutton);
        selectPictureClue = (Button) findViewById(R.id.submitcluebutton);
        selectPictureClue.setOnClickListener(this);
        takePictureClue.setOnClickListener(this);

        latituteField = (TextView) findViewById(R.id.lat_textView);
        longitudeField = (TextView) findViewById(R.id.long_textView);

        // Get the location manager
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            latituteField.setText("Location not available");
            longitudeField.setText("Location not available");
        }

    } //end on create

    @Override
    public void onClick(View v) {
        //if button clicked, check which one
        if(v.equals(takePictureClue)){
            //if take picture button, open camera
            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePicture, 0);//zero can be replaced with any action code
            Toast.makeText(this, "Taking a picture",
                    Toast.LENGTH_SHORT).show();
        }

        if(v.equals(selectPictureClue)){
            //if select picture button, select a picture from gallery
            Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
            Toast.makeText(this, "Selecting a picture",
                    Toast.LENGTH_SHORT).show();
        }



        Log.d("omgAndroid", "click");
        locationManager.requestSingleUpdate(provider, this, this.getMainLooper());
    } //end on click

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Log.d("omgAndroid", resultCode + " ");
        switch(requestCode) {
            case 0:
                Log.d("omgAndroid", "case 0");
                if(resultCode == RESULT_OK){
                    Log.d("omgAndroid", "result okay!");
                    Uri selectedImage = imageReturnedIntent.getData();
                    Log.d("omgAndroid", "got data!");
                    resizeBitMapImage1(selectedImage.getPath(),cluePic.getMaxWidth(),cluePic.getMaxHeight());
                    cluePic.setImageURI(selectedImage);
                    Log.d("omgAndroid", "set image!");
                }

                break;
            case 1:
                Log.d("omgAndroid", "case 1");
                if(resultCode == RESULT_OK){
                    Log.d("omgAndroid", "result okay!");
                    Uri selectedImage = imageReturnedIntent.getData();
                    Log.d("omgAndroid", "got data!");
                    resizeBitMapImage1(selectedImage.getPath(),cluePic.getMaxWidth(),cluePic.getMaxHeight());
                    cluePic.setImageURI(selectedImage);
                    Log.d("omgAndroid", "set image!");
                }
                break;
        }
    } //end on activity result

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clue_detail, menu);
        return true;
    } //end on Create options menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } //end on options item selected

    @Override
    protected void onResume() {
        super.onResume();
        //locationManager.requestLocationUpdates(provider, 400, 1, this);
    } // end on resume

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        //locationManager.removeUpdates(this);
    } //end on pause


    @Override
    public void onLocationChanged(Location location) {
        double lat = (location.getLatitude());
        double lng = (location.getLongitude());
        latituteField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
    } //end on location changed

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();
    } //end on provider enabled

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    } //end on provider disabled

    public static Bitmap resizeBitMapImage1(String filePath, int targetWidth,
                                            int targetHeight) {
        Bitmap bitMapImage = null;
        // First, get the dimensions of the image
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        double sampleSize = 0;
        // Only scale if we need to
        // (16384 buffer for img processing)
        Boolean scaleByHeight = Math.abs(options.outHeight - targetHeight) >= Math
                .abs(options.outWidth - targetWidth);

        if (options.outHeight * options.outWidth * 2 >= 1638) {
            // Load, scaling to smallest power of 2 that'll get it <= desired
            // dimensions
            sampleSize = scaleByHeight ? options.outHeight / targetHeight
                    : options.outWidth / targetWidth;
            sampleSize = (int) Math.pow(2d,
                    Math.floor(Math.log(sampleSize) / Math.log(2d)));
        }

        // Do the actual decoding
        options.inJustDecodeBounds = false;
        options.inTempStorage = new byte[128];
        while (true) {
            try {
                options.inSampleSize = (int) sampleSize;
                bitMapImage = BitmapFactory.decodeFile(filePath, options);

                break;
            } catch (Exception ex) {
                try {
                    sampleSize = sampleSize * 2;
                } catch (Exception ex1) {

                }
            }
        }

        return bitMapImage;
    }

}
