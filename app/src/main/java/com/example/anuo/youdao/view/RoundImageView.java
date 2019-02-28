package com.example.anuo.youdao.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class RoundImageView extends AppCompatImageView{
    private int mBorderRadius = 10;
    private Paint paint;
    private Matrix matrix;

    public RoundImageView(Context context){
        this(context , null);
    }

    public RoundImageView(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }

    public RoundImageView(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        matrix = new Matrix();
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(getDrawable() == null){
            return;
        }
        Bitmap bitmap = drawableToBitmap(getDrawable());
        BitmapShader bitmapShader = new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        float scale = 1.0f;
        if(!(bitmap.getWidth() == getWidth() && bitmap.getHeight() == getHeight() )){
            scale = Math.max(getWidth() * 1.0f/bitmap.getWidth(),getHeight()*1.0f/bitmap.getHeight());
            matrix.setScale(scale,scale);
            bitmapShader.setLocalMatrix(matrix);
            paint.setShader(bitmapShader);
            canvas.drawRoundRect(new RectF(0,0,getWidth(),getHeight()),mBorderRadius,mBorderRadius,paint);
        }
        super.onDraw(canvas);
    }

    private Bitmap drawableToBitmap(Drawable drawable){
        if(drawable instanceof BitmapDrawable){
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }

        int w = drawable.getIntrinsicWidth() <= 0?getWidth():drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight() <= 0?getHeight():drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,w,h);
        drawable.draw(canvas);
        return bitmap;
    }
}
