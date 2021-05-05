package tk.williamsouza.thoughtsregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.get
import androidx.navigation.findNavController
import tk.williamsouza.thoughtsregister.databinding.ActivityNavigationBinding

const val DEBUG_TAG = "Debug"


class NavigationActivity :
    AppCompatActivity(),
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {
    private lateinit var binding: ActivityNavigationBinding
    private lateinit var mDetector: GestureDetectorCompat

    companion object {
        lateinit var navStack: String
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mDetector = GestureDetectorCompat(this, this)
        mDetector.setOnDoubleTapListener(this)
        navStack = MainFragment::class.java.name

    }

    override fun onDown(e: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG, "Down pressed")
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        Log.d(DEBUG_TAG, "show pressed")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG, "single tap up pressed")
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onScroll $e1 - $e2 pressed")
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        Log.d(DEBUG_TAG, "Long pressed")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onFling $e1 - $e2 pressed")

        val action = when(navStack) {
            MainFragment::class.java.name -> {
                navStack = ActivatingEventFragment::class.java.name
                MainFragmentDirections.actionMainFragment2ToActivatingEventFragment()
            }
            ActivatingEventFragment::class.java.name -> {
                navStack = ThoughtFragment::class.java.name
                ActivatingEventFragmentDirections.actionActivatingEventFragmentToThoughtFragment()
            }
            ThoughtFragment::class.java.name -> {
                navStack = FeelingFragment::class.java.name
                ThoughtFragmentDirections.actionThoughtFragmentToFeelingFragment()
            }
            FeelingFragment::class.java.name -> {
                navStack = BehaviorFragment::class.java.name
                FeelingFragmentDirections.actionFeelingFragmentToBehaviorFragment()
            }
            BehaviorFragment::class.java.name -> {
                navStack = MainFragment::class.java.name
                BehaviorFragmentDirections.actionBehaviorFragmentToMainFragment2()
            }
            else -> {
                navStack = MainFragment::class.java.name
                MainFragmentDirections.actionMainFragment2ToActivatingEventFragment()
            }
        }

        if (velocityX < 0) {
            findNavController(R.id.navGraph).navigate(action)
        } else if (velocityX > 0) {
            findNavController(R.id.navGraph).navigateUp()
        }
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG, "onSingleTap pressed")
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTap pressed")

        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTapEvent pressed")
        return true
    }

}