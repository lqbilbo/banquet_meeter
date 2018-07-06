package com.bm.kotlin.model

import com.bm.kotlin.entity.Place
import java.util.*

class ConditionParams(
        val place: Place,
        val label: String,
        val time: Date
) {
    override fun toString(): String {
        return "ConditionParams(place=$place, label='$label', time=$time)"
    }
}