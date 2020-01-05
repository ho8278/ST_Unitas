package com.hyoungwoong.stunitas.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

class ScrollBehavior : CoordinatorLayout.Behavior<View> {
    constructor() : super()
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)


    private var dyConsumedSum = 0
    private var dyConsumedSum2 = 0
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
        val matrix = child.context.resources.displayMetrics
        val dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, matrix) + child.height
        dyConsumedSum += dyConsumed
        if (dyConsumed > 0 && dyConsumedSum > dp) {
            dyConsumedSum = dp.toInt()
        }
        if (dyConsumed < 0 && dyConsumedSum < 0){
                dyConsumedSum = 0
        }
        child.translationY = -dyConsumedSum.toFloat()
        return
    }
}