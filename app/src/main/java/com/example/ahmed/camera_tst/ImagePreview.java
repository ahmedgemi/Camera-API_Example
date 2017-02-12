package com.example.ahmed.camera_tst;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by ahmed on 10/02/17.
 */

public class ImagePreview extends SurfaceView implements SurfaceHolder.Callback {

    Camera myCamera;
    SurfaceHolder surfaceHolder;

    public ImagePreview(Context context ,Camera camera) {
        super(context);

        myCamera=camera;

        this.surfaceHolder = getHolder();
        this.surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        try {

            myCamera.setPreviewDisplay(holder);

            myCamera.startPreview();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        myCamera.stopPreview();
        myCamera.release();
    }
}
