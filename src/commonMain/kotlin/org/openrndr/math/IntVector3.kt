package org.openrndr.math

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.math.sqrt

/**
 * Integer vector 3
 */
@Suppress("unused")
@Serializable
data class IntVector3(val x: Int, val y: Int, val z: Int) {
    companion object {
        val ZERO = IntVector3(0, 0, 0)
        val UNIT_X = IntVector3(1, 0, 0)
        val UNIT_Y = IntVector3(0, 1, 0)
        val UNIT_Z = IntVector3(0, 0, 1)
    }

    val length get() = sqrt(1.0 * x * x + y * y + z * z)
    val squaredLength get() = x * x + y * y + z * z
    infix fun dot(right: IntVector3) = x * right.x + y * right.y + z * right.z
    @Transient
    val xy get() = IntVector2(x, y)
    @Transient
    val yx get() = IntVector2(y, x)
    @Transient
    val xx get() = IntVector2(x, x)
    @Transient
    val yy get() = IntVector2(y, y)
    operator fun plus(v: IntVector3) = IntVector3(x + v.x, y + v.y, z + v.z)
    operator fun minus(v: IntVector3) = IntVector3(x - v.x, y - v.y, z - v.z)
    operator fun times(d: Int) = IntVector3(x * d, y * d, z * d)
    operator fun div(d: Int) = IntVector3(x / d, y / d, z / d)
    @Transient
    val vector3 get() = Vector3(this.x.toDouble(), this.y.toDouble(), this.z.toDouble())
}

operator fun Int.times(v: IntVector3) = v * this