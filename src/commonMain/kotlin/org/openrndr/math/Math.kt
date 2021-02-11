package org.openrndr.math

class Math {
  companion object {
    const val DEGREES_TO_RADIANS = 0.017453292519943295
    const val RADIANS_TO_DEGREES = 57.29577951308232
    fun sqrt(x: Double) = kotlin.math.sqrt(x)
    fun toRadians(angdeg: Double) = angdeg * DEGREES_TO_RADIANS
    fun toDegrees(angrad: Double) = angrad * RADIANS_TO_DEGREES
    fun tan(x: Double) = kotlin.math.tan(x)
    fun sin(x: Double) = kotlin.math.sin(x)
    fun cos(x: Double) = kotlin.math.cos(x)
    /*fun getExponent(d: Double): Int {
      /*
         * Bitwise convert d to long, mask out exponent bits, shift
         * to the right and then subtract out double's bias adjust to
         * get true exponent value.
         */
      return ((java.lang.Double.doubleToRawLongBits(d) and jdk.internal.math.DoubleConsts.EXP_BIT_MASK shr
          jdk.internal.math.DoubleConsts.SIGNIFICAND_WIDTH - 1) - jdk.internal.math.DoubleConsts.EXP_BIAS)
    }
    fun ulp(d: Double): Double {
      var exp: Int = java.lang.Math.getExponent(d)
      return when (exp) {
        java.lang.Double.MAX_EXPONENT + 1 -> java.lang.Math.abs(d)
        java.lang.Double.MIN_EXPONENT - 1 -> Double.MIN_VALUE
        else -> {
          assert(exp <= java.lang.Double.MAX_EXPONENT && exp >= java.lang.Double.MIN_EXPONENT)

          // ulp(x) is usually 2^(SIGNIFICAND_WIDTH-1)*(2^ilogb(x))
          exp = exp - (jdk.internal.math.DoubleConsts.SIGNIFICAND_WIDTH - 1)
          if (exp >= java.lang.Double.MIN_EXPONENT) {
            java.lang.Math.powerOfTwoD(exp)
          } else {
            // return a subnormal result; left shift integer
            // representation of Double.MIN_VALUE appropriate
            // number of positions
            java.lang.Double.longBitsToDouble(
              1L shl
                  exp - (java.lang.Double.MIN_EXPONENT - (jdk.internal.math.DoubleConsts.SIGNIFICAND_WIDTH - 1))
            )
          }
        }
      }
    }*/
  }
}
