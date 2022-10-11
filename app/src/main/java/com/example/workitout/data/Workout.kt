package com.example.workitout.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.workitout.R


/**
 * A data class to represent the information presented in the workout card
 */
data class Workout(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)

val workouts = listOf(
    Workout(R.drawable.cobra_stretch,R.string.cobra_stretch, R.string.cobra_stretch_description),
    Workout(R.drawable.squats,R.string.squats, R.string.squats_description),
    Workout(R.drawable.mountain_climber,R.string.mountain_climber, R.string.mountain_climber_description),
    Workout(R.drawable.abdominal_crunch,R.string.abdominal_crunch, R.string.abdominal_crunch_description),
    Workout(R.drawable.leg_raises,R.string.leg_raises, R.string.leg_raises_description),
    Workout(R.drawable.heel_touch,R.string.heel_touch, R.string.heel_touch_description),
    Workout(R.drawable.jumping_jacks,R.string.jumping_jacks, R.string.jumping_jacks_description),
    Workout(R.drawable.push_ups,R.string.push_ups,R.string.push_ups_description),
    Workout(R.drawable.russian_twist,R.string.russian_twist, R.string.russian_twist_description),
    Workout(R.drawable.plank,R.string.plank, R.string.plank_description)
)
