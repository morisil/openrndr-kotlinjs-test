package org.openrndr.math

import org.amshove.kluent.shouldBeInRange
import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TestQuaternion : Spek({
    describe("a quaternion") {
        it("IDENTITY times IDENTITY should result in IDENTITY") {
            val q0 = Quaternion.IDENTITY
            val q1 = Quaternion.IDENTITY
            val qm = q0 * q1

            qm.x shouldBeEqualTo 0.0
            qm.y shouldBeEqualTo 0.0
            qm.z shouldBeEqualTo 0.0
            qm.w shouldBeEqualTo 1.0
        }

        it ("matrix to quaternion to matrix") {
            val q0 = Quaternion.fromMatrix(Matrix33.IDENTITY)
            val m0 = q0.matrix
            m0 shouldBeEqualTo Matrix33.IDENTITY
        }

        it ("quaternion look +Z") {
            val q0 = Quaternion.fromLookAt(Vector3.ZERO, Vector3(0.0, 0.0, 1.0), Vector3.UNIT_Y)
            val v0 = q0 * Vector3.UNIT_Z
            v0.x.shouldBeInRange(-0.0001, 0.0001)
            v0.y.shouldBeInRange(-0.0001, 0.0001)
            v0.z.shouldBeInRange(1-0.0001,1+ 0.0001)
        }

        it ("quaternion look -Z") {
            val q0 = Quaternion.fromLookAt(Vector3.ZERO, Vector3(0.0, 0.0, -1.0), Vector3.UNIT_Y)
            val v0 = q0 * Vector3.UNIT_Z
            v0.x.shouldBeInRange(-0.0001, 0.0001)
            v0.y.shouldBeInRange(-0.0001, 0.0001)
            v0.z.shouldBeInRange(-1-0.0001,-1+ 0.0001)
        }

        it ("quaternion look +X") {
            val q0 = Quaternion.fromLookAt(Vector3.ZERO, Vector3(1.0, 0.0, 0.0), Vector3.UNIT_Y)
            val v0 = q0 * Vector3.UNIT_Z
            v0.x.shouldBeInRange(1-0.0001,1+ 0.0001)
            v0.y.shouldBeInRange(-0.0001, 0.0001)
            v0.z.shouldBeInRange(-0.0001, 0.0001)
        }

        it ("quaternion look -X") {
            val q0 = Quaternion.fromLookAt(Vector3.ZERO, Vector3(-1.0, 0.0, 0.0), Vector3.UNIT_Y)
            val v0 = q0 * Vector3.UNIT_Z
            v0.x.shouldBeInRange(-1-0.0001,-1+ 0.0001)
            v0.y.shouldBeInRange(-0.0001, 0.0001)
            v0.z.shouldBeInRange(-0.0001, 0.0001)
        }

        it("quaternion.identity * vector3") {
            Quaternion.IDENTITY * Vector3.UNIT_X shouldBeEqualTo Vector3.UNIT_X
            Quaternion.IDENTITY * Vector3.UNIT_Y shouldBeEqualTo Vector3.UNIT_Y
            Quaternion.IDENTITY * Vector3.UNIT_Z shouldBeEqualTo Vector3.UNIT_Z
        }
    }
})