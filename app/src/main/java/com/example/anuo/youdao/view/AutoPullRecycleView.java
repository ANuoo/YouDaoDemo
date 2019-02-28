package com.example.anuo.youdao.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import java.lang.ref.WeakReference;

public class AutoPullRecycleView extends RecyclerView {
    private static final  long TIME_AUTO_PULL = 16;
    private static final  long TIME_AUTO_PULL_ONE = 2000;
    AutoPullTask autoPullTask;
    AutoPullTaskOne autoPullTaskOne;
    private int index = 0;
    private boolean running;
    private boolean canRun;
    private final int mTouchSlop;

    public AutoPullRecycleView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

        autoPullTask = new AutoPullTask(this);
        autoPullTaskOne = new AutoPullTaskOne(this);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    static class AutoPullTask implements Runnable{
        private final WeakReference<AutoPullRecycleView> mReference;

        public AutoPullTask(AutoPullRecycleView recycleView){
            this.mReference = new WeakReference<AutoPullRecycleView>(recycleView);
        }

        @Override
        public void run() {
            AutoPullRecycleView autoPullRecycleView = mReference.get();
            if(autoPullRecycleView != null && autoPullRecycleView.running&&autoPullRecycleView.canRun){
                autoPullRecycleView.scrollBy(2,2);
                autoPullRecycleView.postDelayed(autoPullRecycleView.autoPullTask,autoPullRecycleView.TIME_AUTO_PULL);

            }
        }
    }

    static class AutoPullTaskOne implements Runnable{
        private final WeakReference<AutoPullRecycleView> mReference;

        public AutoPullTaskOne(AutoPullRecycleView recycleView){
            this.mReference = new WeakReference<AutoPullRecycleView>(recycleView);
        }

        @Override
        public void run() {
            AutoPullRecycleView autoPullRecycleView = mReference.get();
            if(autoPullRecycleView != null && autoPullRecycleView.running && autoPullRecycleView.canRun){
                autoPullRecycleView.smoothScrollToPosition(++autoPullRecycleView.index);
                autoPullRecycleView.postDelayed(autoPullRecycleView.autoPullTaskOne,TIME_AUTO_PULL_ONE);
            }
        }
    }

    public void start(){
        if(running)
            stop();
        canRun = true;
        running = true;
        postDelayed(autoPullTaskOne,TIME_AUTO_PULL_ONE);
    }

    public void stop(){
        running = false;
        removeCallbacks(autoPullTaskOne);
    }

    int lastX = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                lastX = (int)ev.getRawX();
                if (running)
                    stop();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_OUTSIDE:
                int nowX = (int)ev.getRawX();
                if(nowX - lastX > mTouchSlop){
                    smoothScrollToPosition(index==0?0:--index);
                    if(canRun)
                        start();
                    return true;
                }else if(lastX - nowX >mTouchSlop){
                    smoothScrollToPosition(++index);
                    if(canRun)
                        start();
                    return true;
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
