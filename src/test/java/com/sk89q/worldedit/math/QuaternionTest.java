package com.sk89q.worldedit.math;

import org.junit.*;

import com.sk89q.worldedit.Vector;

import static org.junit.Assert.*;

public class QuaternionTest {
    private static final double DELTA = 1e-14;

    @Test
    public void basicProperties() {
        assertQEquals(new Quaternion(-1, 0, 0, 0), Quaternion.I.multiply(Quaternion.I), DELTA);
        assertQEquals(new Quaternion(-1, 0, 0, 0), Quaternion.J.multiply(Quaternion.J), DELTA);
        assertQEquals(new Quaternion(-1, 0, 0, 0), Quaternion.K.multiply(Quaternion.K), DELTA);
        assertQEquals(new Quaternion(-1, 0, 0, 0), Quaternion.I.multiply(Quaternion.J).multiply(Quaternion.K), DELTA);

        assertQEquals(new Quaternion(0, 0, 0, 1), Quaternion.I.multiply(Quaternion.J), DELTA);
        assertQEquals(new Quaternion(0, 1, 0, 0), Quaternion.J.multiply(Quaternion.K), DELTA);
        assertQEquals(new Quaternion(0, 0, 1, 0), Quaternion.K.multiply(Quaternion.I), DELTA);

        assertQEquals(new Quaternion(0,  0,  0, -1), Quaternion.J.multiply(Quaternion.I), DELTA);
        assertQEquals(new Quaternion(0, -1,  0,  0), Quaternion.K.multiply(Quaternion.J), DELTA);
        assertQEquals(new Quaternion(0,  0, -1,  0), Quaternion.I.multiply(Quaternion.K), DELTA);
        /*cout << 1 - 2*quat::i + 3*quat::j + 4*quat::k << endl;
        cout << quat(1,2,3,4)/2 << endl;*/
        assertQEquals(Quaternion.I, Quaternion.rotationQuaternion(180, new Vector(1,0,0)), DELTA);
    }

    private static void assertQEquals(Quaternion expected, Quaternion actual, double delta) {
        String message = "expected:<"+expected+"> but was:<"+actual+">";
        assertSEquals(message, expected.getReal(), actual.getReal(), delta);
        assertVEquals(message, expected.getImaginary(), actual.getImaginary(), delta);
    }

    public static void assertSEquals(String message, final double expected, final double actual, double delta) {
        if (Double.compare(expected, actual) == 0) {
            return;
        }

        if (!(Math.abs(expected - actual) <= delta)) {
            fail(message);
        }
    }

    public static void assertVEquals(String message, final Vector expected, final Vector actual, double delta) {
        assertSEquals(message, expected.getX(), actual.getX(), delta);
        assertSEquals(message, expected.getY(), actual.getY(), delta);
        assertSEquals(message, expected.getZ(), actual.getZ(), delta);
    }
}
