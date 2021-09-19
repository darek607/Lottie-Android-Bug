package com.example.lottie_bug

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieAnimationView

class AnimationFragment : Fragment() {

    private lateinit var animView: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animView = view.findViewById(R.id.animView)
        Log.d(LOG_TAG, "onViewCreated")

        playAnimation()

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            goToSecondFragment()
        }
    }

    // To play anim again after returning back from the [SecondFragment]
    // we have to set android:saveEnabled to false on the LottieAnimationView.
    private fun playAnimation() {
        animView.setMaxProgress(0.3f)
        animView.progress = 0f
        animView.playAnimation()
    }

    private fun goToSecondFragment() {
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, SecondFragment.newInstance())
            .commit()
    }

    companion object {
        private const val LOG_TAG = "AnimationFragment"

        fun newInstance() = AnimationFragment()
    }
}