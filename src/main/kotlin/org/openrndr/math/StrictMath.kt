package org.openrndr.math

import kotlin.math.pow

class StrictMath {
  companion object {
    fun abs(x: Double) = kotlin.math.abs(x)
    fun pow(a: Double, b: Double) = a.pow(b)
    fun sqrt(x: Double) = kotlin.math.sqrt(x)
    fun max(a: Double, b: Double) = kotlin.math.max(a, b)
  }
}
