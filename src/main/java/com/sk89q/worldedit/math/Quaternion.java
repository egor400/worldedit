// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.math;

import com.sk89q.worldedit.Vector;

public class Quaternion {
    public static final Quaternion I = new Quaternion(0, 1, 0, 0);
    public static final Quaternion J = new Quaternion(0, 0, 1, 0);
    public static final Quaternion K = new Quaternion(0, 0, 0, 1);

    private final double real;
    private final Vector imaginary;

    public Quaternion() {
        this(0, 0, 0, 0);
    }

    public Quaternion(double real, double i, double j, double k) {
        this(real, new Vector(i, j, k));
    }

    public Quaternion(double real) {
        this(real, 0, 0, 0);
    }

    public Quaternion(Vector imaginary) {
        this(0, imaginary);
    }

    public Quaternion(double real, Vector imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    public double getReal() {
        return this.real;
    }

    public Quaternion setReal(double real) {
        return new Quaternion(real, this.imaginary);
    }

    public Vector getImaginary() {
        return this.imaginary;
    }

    public Quaternion setImaginary(Vector imaginary) {
        return new Quaternion(this.real, imaginary);
    }

    public Quaternion setImaginary(double i, double j, double k) {
        return setImaginary(new Vector(i, j, k));
    }


    public double getI() {
        return this.imaginary.getX();
    }

    public Quaternion setI(double i) {
        return new Quaternion(this.real, this.imaginary.setX(i));
    }

    public double getJ() {
        return this.imaginary.getY();
    }

    public Quaternion setJ(double j) {
        return new Quaternion(this.real, this.imaginary.setY(j));
    }

    public double getK() {
        return this.imaginary.getZ();
    }

    public Quaternion setK(double k) {
        return new Quaternion(this.real, this.imaginary.setZ(k));
    }


    public double lengthSq() {
        return this.real * this.real + this.imaginary.lengthSq();
    }

    public double length() {
        return Math.sqrt(lengthSq());
    }

    public Quaternion conjugated() {
        return new Quaternion(this.real, this.imaginary.multiply(-1.0));
    }

    public Quaternion inverse() {
        final double lengthSq = lengthSq();

        return new Quaternion(this.real / lengthSq, this.imaginary.divide(-lengthSq));
    }


    public Quaternion add(Quaternion other) {
        return add(other.real, other.imaginary);
    }

    public Quaternion add(double real, Vector imaginary) {
        return new Quaternion(this.real + real, this.imaginary.add(imaginary));
    }

    public Quaternion add(double real, double i, double j, double k) {
        return new Quaternion(this.real + real, this.imaginary.add(i, j, k));
    }

    public Quaternion subtract(Quaternion other) {
        return subtract(other.real, other.imaginary);
    }

    public Quaternion subtract(double real, Vector imaginary) {
        return new Quaternion(this.real - real, this.imaginary.subtract(imaginary));
    }

    public Quaternion subtract(double real, double i, double j, double k) {
        return new Quaternion(this.real - real, this.imaginary.subtract(i, j, k));
    }

    public Quaternion multiply(Quaternion other) {
        return multiply(other.real, other.imaginary);
    }

    public Quaternion multiply(double real, Vector imaginary) {
        return new Quaternion(
            this.real*real - this.imaginary.dot(imaginary),
            imaginary.multiply(this.real).add(this.imaginary.multiply(real)).add(this.imaginary.cross(imaginary))
        );
    }

    public Quaternion multiply(double real, double i, double j, double k) {
        return multiply(real, new Vector(i, j, k));
    }

    public Quaternion multiply(double scalar) {
        return new Quaternion(this.real * scalar, this.imaginary.multiply(scalar));
    }

    public Quaternion divide(Quaternion other) {
        return divide(other.real, other.imaginary);
    }

    public Quaternion divide(double real, Vector imaginary) {
        final double lengthSq = real*real + imaginary.lengthSq();

        return multiply(real / lengthSq, imaginary.divide(-lengthSq));
    }

    public Quaternion divide(double real, double i, double j, double k) {
        return divide(real, new Vector(i, j, k));
    }

    public Quaternion divide(double scalar) {
        return new Quaternion(this.real / scalar, this.imaginary.divide(scalar));
    }


    public Quaternion exp() {
        final double imaglen = imaginary.length();
        final double expReal = Math.exp(this.real);

        return new Quaternion(
            Math.cos(expReal * imaglen),
            this.imaginary.multiply(expReal * Math.sin(imaglen) / imaglen)
        );
    }

    public Quaternion log() {
        final double l = length();
        if (l == 0.0) {
            return new Quaternion(-Double.POSITIVE_INFINITY, 0, 0, 0);
        }

        final double ureal = this.real / l;
        final Vector uimag = this.imaginary.divide(l);

        final double m = uimag.length();
        if (m == 0.0) {
            return new Quaternion(Math.log(l), 0, 0, 0);
        } else {
            return new Quaternion(Math.log(l), uimag.multiply(Math.acos(ureal) / m));
        }
    }

    public Quaternion pow(double exponent) {
        return log().multiply(exponent).exp();
    }

    public Quaternion slerp(Quaternion other, double t) {
        return multiply(inverse().multiply(other)).pow(t);
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quaternion))
            return false;

        Quaternion other = (Quaternion) obj;
        return real == other.real && imaginary.equals(other.imaginary);
    }

    @Override
    public String toString() {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        if (this.real != 0.0) {
            sb.append(this.real);
            flag = true;
        }

        final double i = getI();
        if (i != 0.0) {
            appendElement(sb, i, flag);
            sb.append("i");
            flag = true;
        }

        final double j = getJ();
        if (j != 0.0) {
            appendElement(sb, j, flag);
            sb.append("j");
            flag = true;
        }

        final double k = this.getK();
        if (k != 0.0) {
            appendElement(sb, k, flag);
            sb.append("k");
            flag = true;
        }

        if (!flag) {
            return "0";
        }

        return sb.toString();

        //return getReal() + " + " + getI() + "i + " + getJ() + "j + " + getK() + "k";
    }

    private void appendElement(StringBuilder sb, double element, boolean flag) {
        // i -i 2i -2i
        if (element > 0) {
            // i 2i
            if (flag) {
                // foo + x
                sb.append(" + ");
            }
            if (element != 1.0) {
                // 2i
                sb.append(element);
            }
        }
        else {
            // -i -2i
            if (flag) {
                // foo - x
                sb.append(" - ");
                if (element != -1.0) {
                    // foo - 2i
                    sb.append(-element);
                }
            }
            else if (element == -1.0) {
                // -i
                sb.append("-");
            }
            else {
                // -2i
                sb.append(element);
            }
        }
    }

    public static Quaternion rotationQuaternion(double degrees, Vector axis) {
        final double radians = Math.toRadians(degrees);

        return new Quaternion(
            Math.cos(radians/2),
            axis.normalize().multiply(Math.sin(radians/2))
        );
    }

    public static Quaternion rotationQuaternion(double pitch, double yaw, double roll) {
        // TODO: fix axes
        Quaternion qp = rotationQuaternion(Math.toRadians(pitch), new Vector(1, 0, 0));
        Quaternion qy = rotationQuaternion(Math.toRadians(yaw  ), new Vector(0, 1, 0));
        Quaternion qr = rotationQuaternion(Math.toRadians(roll ), new Vector(0, 0, 1));
        return qy.multiply(qp.multiply(qr));
    }
}
