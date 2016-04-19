package net.kvedalen.sandbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GridAnimationActivity extends Activity {

    private ImageView homer_img;
    private ImageView marge_img;
    private boolean imgIsHomer;
    private float rotation;
    private float flip;

    public void spinHomer(View v) {
        Toast.makeText(getApplicationContext(),"Spin!",Toast.LENGTH_SHORT).show();
        rotation = rotation + 720f;
        if (imgIsHomer) {
            homer_img.animate().rotation(rotation).setDuration(1000);
        } else {
            marge_img.animate().rotation(rotation).setDuration(1000);
        }
    }

    public void xfadeHomer(View v) {
        Toast.makeText(getApplicationContext(),"X-fade!",Toast.LENGTH_SHORT).show();
        if (imgIsHomer) {
            homer_img.animate().alpha(0f).setDuration(1000);
            marge_img.animate().alpha(1f).setDuration(1000);
            imgIsHomer = false;
        } else {
            homer_img.animate().alpha(1f).setDuration(1000);
            marge_img.animate().alpha(0f).setDuration(1000);
            imgIsHomer = true;
        }
    }

    public void flipHomer(View v) {
        Toast.makeText(getApplicationContext(),"Flip!",Toast.LENGTH_SHORT).show();
        flip = flip + 180f;
        if (imgIsHomer){
            homer_img.animate().rotationX(flip).setDuration(1000);
        } else {
            marge_img.animate().rotationX(flip).setDuration(1000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_grid_animation);
        imgIsHomer = true;

        homer_img = (ImageView) findViewById(R.id.homer);
        marge_img = (ImageView) findViewById(R.id.marge);

        rotation = 0f;
        flip     = 0f;
    }

}
