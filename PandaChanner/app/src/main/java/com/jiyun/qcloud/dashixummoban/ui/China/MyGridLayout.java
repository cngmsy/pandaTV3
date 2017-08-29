package com.jiyun.qcloud.dashixummoban.ui.China;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2017/6/25.
 */

public class MyGridLayout extends GridLayout{

    private boolean ableDrag;
    private Rect[] rects;
    private View dragView;
    private OnItemClickListener itemClickListener;
    public MyGridLayout(Context context) {
        this(context, null);
    }

    public MyGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setColumnCount(4);
        setLayoutTransition(new LayoutTransition());
    }

    //定义方法，由外部传递一个栏目的数据集合进来，在这里根据数据集合动态创建表格界面
    public void setItemList(List<String> items) {
        for (String item : items) {
            addItem(item);
        }
    }

    //定义方法，设置是否允许拖拽
    public void setEnableDrag(boolean EnableDrag) {
        ableDrag = EnableDrag;
        if (ableDrag) {
            setOnDragListener(odl);
        } else {
            setOnDragListener(null);
        }
    }

    //定义接口回调
    public interface OnItemClickListener {
        public void onItemClick(TextView tv);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public void addItem(String item) {
        TextView tv = getNewTextView();
        tv.setText(item);
        this.addView(tv);
    }

    //定义方法，外部传入子条目的背景资源Id,外边距margin（px）,tv内边距padding（px）
    private final float scale = getContext().getResources().getDisplayMetrics().density;
    private int resId;
    private int margin;
    private int padding;

    public void setResource(int ResourceId, int margin, int padding) {
        this.resId = ResourceId;
        this.margin = (int) (margin * scale + 0.5f);
        this.padding = (int) (padding * scale + 0.5f);
    }


    public TextView getNewTextView() {

        LayoutParams layoutParams = new LayoutParams();
        int mMargin = 8;
        layoutParams.width = getResources().getDisplayMetrics().widthPixels / 4
                - mMargin * 2;
        layoutParams.height = LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(8, 6, 8, 6);

        TextView tv = new TextView(getContext());
        tv.setLayoutParams(layoutParams);
        tv.setGravity(Gravity.CENTER);
//        tv.setBackgroundResource(R.drawable.drag_item_selector);
        tv.setPadding(6, 6, 6, 6);

        if (ableDrag) {
            tv.setOnLongClickListener(olcl);
        } else {
            tv.setOnLongClickListener(null);
        }

        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick((TextView) view);
                }
            }
        });
        return tv;

    }
    //拖拽监听
    private OnDragListener odl = new OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            switch (dragEvent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //当拖拽事件产生时，给每个子控件创建出对应的矩形
                    initRects();
                    break;
                case DragEvent.ACTION_DRAG_LOCATION:
                    //当手指移动时，判断当前进入了哪一个子控件范围内，并返回对应子控件的索引
                    int touchIndex = getTouchIndex(dragEvent);
                    if (touchIndex > -1 && dragView != null && dragView != MyGridLayout.this.getChildAt(touchIndex)) {
                        //先把拖拽的view从当前位置删除，再添加到touchIndex上
                        MyGridLayout.this.removeView(dragView);
                        MyGridLayout.this.addView(dragView, touchIndex);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if (dragView != null) {
                        dragView.setEnabled(true);
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
    };
    //长按监听
    private OnLongClickListener olcl = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            //长按事件发生时，即给dragView赋值
            dragView = view;
            //拖拽事件
            view.startDrag(null, new DragShadowBuilder(view), null, 0);
            view.setEnabled(false);
            return false;
        }
    };


    private int getTouchIndex(DragEvent dragEvent) {
        for (int i = 0; i < rects.length; i++) {
            Rect rect = rects[i];
            if (rect.contains((int) dragEvent.getX(), (int) dragEvent.getY())) {
                return i;
            }
        }
        return -1;
    }

    //创建子控件对应的矩形
    private void initRects() {
        //给容器中的每一个子控件都新建一个矩形
        rects = new Rect[getChildCount()];
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            rects[i] = new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        }
    }


}
