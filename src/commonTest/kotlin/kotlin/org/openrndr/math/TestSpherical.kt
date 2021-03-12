package org.openrndr.math

import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TestSpherical : Spek({

    val maxError = 0.0000001

    describe("Spherical operations") {
        it("converts between spherical and vector") {
            val sp = Spherical(100.0, 140.0, 140.0)
            val v = sp.cartesian
            val sp2 = v.spherical

            sp2.radius shouldBeEqualTo sp.radius
            sp2.phi shouldBeEqualTo sp.phi
            sp2.theta shouldBeEqualTo sp.theta

            val v2 = sp2.cartesian
            v2.x shouldBeEqualTo v.x
            v2.y shouldBeEqualTo v.y
            v2.z shouldBeEqualTo v.z
        }
    }
})