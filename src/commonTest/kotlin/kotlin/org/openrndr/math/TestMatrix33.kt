package org.openrndr.math

import org.amshove.kluent.shouldBeInRange
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TestMatrix33 : Spek({

    val maxError = 0.0000001

    describe("Matrix33 Operations") {

        it("trace of identity should be 3") {
            Matrix33.IDENTITY.trace.shouldBeInRange(3.0-maxError,3.0+maxError)
        }

        it("trace of identity minus identity should be 0") {
            (Matrix33.IDENTITY - Matrix33.IDENTITY).trace.shouldBeInRange(0.0-maxError,0.0+maxError)
        }

        it("determinant of identity ") {
            Matrix33.IDENTITY.determinant.shouldBeInRange(1.0-maxError, 1.0+maxError)
        }

        it("determinant of collinear points should be 0 ") {
            Matrix33.fromColumnVectors(Vector3.UNIT_X, Vector3.UNIT_X*2.0, Vector3.UNIT_X*3.0 ).determinant.shouldBeInRange(0.0-maxError, 0.0+maxError)
        }

        it("inverse of identity") {
            val inversed = Matrix33.IDENTITY.inversed
            inversed.trace.shouldBeInRange(3.0-maxError,3.0+maxError)
            inversed.determinant.shouldBeInRange(1.0-maxError,1.0+maxError)
        }

        it("inverse of non-identity diagonal") {
            val d = Matrix33.IDENTITY * 3.0
            val inversed = d.inversed
            inversed.trace.shouldBeInRange(1.0-maxError,1.0+maxError)
        }
        it("inverse of non-diagonal") {
            val nd = Matrix33.fromColumnVectors(Vector3(1.0, 0.0, 0.0), Vector3(0.0, 1.0, 0.0), Vector3(1.0, 1.0, 1.0))
            val inversed = nd.inversed
            (nd * inversed).trace.shouldBeInRange(3.0-maxError,3.0+maxError)
        }
    }
})