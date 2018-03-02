package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created on 2018/1/4.
 *
 * @author 00224524
 */

public class GroupItemClickListener implements RecyclerView.OnItemTouchListener {
    GroupItemDecoration mDecoration;
    OnGroupItemClickListener mListener;
    GestureDetector mGestureDetector;

    public interface OnGroupItemClickListener {
        void onGroupItemClick(GroupItem groupItem);

        void onGroupItemLongClick(GroupItem groupItem);
    }

    public GroupItemClickListener(final GroupItemDecoration decoration, OnGroupItemClickListener listener) {
        mDecoration = decoration;
        mListener = listener;
        mGestureDetector = new GestureDetector(decoration.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                GroupItem groupItem = decoration.findGroupItemUnder((int) e.getX(), (int) e.getY());
                if (groupItem != null && mListener != null) {
                    mListener.onGroupItemClick(groupItem);
                }
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                GroupItem groupItem = decoration.findGroupItemUnder((int) e.getX(), (int) e.getY());
                if (groupItem != null && mListener != null) {
                    mListener.onGroupItemLongClick(groupItem);
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
