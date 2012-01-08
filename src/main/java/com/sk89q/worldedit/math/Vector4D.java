// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com>
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

/**
 *
 * @author sk89q
 */
public class Vector4D {
    protected final double x, y, z, w;

    /**
     * Construct the Vector object.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Construct the Vector object.
     *
     * @param other
     */
    public Vector4D(Vector4D other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.w = other.w;
    }

    /**
     * Construct the Vector object.
     */
    public Vector4D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Set X.
     *
     * @param x
     * @return new vector
     */
    public Vector4D setX(double x) {
        return new Vector4D(x, y, z, w);
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * Set Y.
     *
     * @param y
     * @return new vector
     */
    public Vector4D setY(double y) {
        return new Vector4D(x, y, z, w);
    }

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * Set Z.
     *
     * @param z
     * @return new vector
     */
    public Vector4D setZ(double z) {
        return new Vector4D(x, y, z, w);
    }

    /**
     * @return the w
     */
    public double getW() {
        return w;
    }

    /**
     * Set W.
     *
     * @param w
     * @return new vector
     */
    public Vector4D setW(double w) {
        return new Vector4D(x, y, z, w);
    }

    /**
     * Adds two points.
     *
     * @param other
     * @return New point
     */
    public Vector4D add(Vector4D other) {
        return new Vector4D(x + other.x, y + other.y, z + other.z, w + other.w);
    }

    /**
     * Adds two points.
     *
     * @param x
     * @param y
     * @param z
     * @return New point
     */
    public Vector4D add(double x, double y, double z, double w) {
        return new Vector4D(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    /**
     * Adds points.
     *
     * @param others
     * @return New point
     */
    public Vector4D add(Vector4D... others) {
        double newX = x, newY = y, newZ = z, newW = w;

        for (int i = 0; i < others.length; ++i) {
            newX += others[i].x;
            newY += others[i].y;
            newZ += others[i].z;
            newW += others[i].w;
        }
        return new Vector4D(newX, newY, newZ, newW);
    }

    /**
     * Subtracts two points.
     *
     * @param other
     * @return New point
     */
    public Vector4D subtract(Vector4D other) {
        return new Vector4D(x - other.x, y - other.y, z - other.z, w - other.w);
    }

    /**
     * Subtract two points.
     *
     * @param x
     * @param y
     * @param z
     * @return New point
     */
    public Vector4D subtract(double x, double y, double z, double w) {
        return new Vector4D(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    /**
     * Subtract points.
     *
     * @param others
     * @return New point
     */
    public Vector4D subtract(Vector4D... others) {
        double newX = x, newY = y, newZ = z, newW = w;

        for (int i = 0; i < others.length; ++i) {
            newX -= others[i].x;
            newY -= others[i].y;
            newZ -= others[i].z;
            newW -= others[i].w;
        }
        return new Vector4D(newX, newY, newZ, newW);
    }

    /**
     * Component-wise multiplication
     *
     * @param other
     * @return New point
     */
    public Vector4D multiply(Vector4D other) {
        return new Vector4D(x * other.x, y * other.y, z * other.z, w * other.w);
    }

    /**
     * Component-wise multiplication
     *
     * @param x
     * @param y
     * @param z
     * @return New point
     */
    public Vector4D multiply(double x, double y, double z) {
        return new Vector4D(this.x * x, this.y * y, this.z * z, this.w * w);
    }

    /**
     * Component-wise multiplication
     *
     * @param others
     * @return New point
     */
    public Vector4D multiply(Vector4D... others) {
        double newX = x, newY = y, newZ = z, newW = w;

        for (int i = 0; i < others.length; ++i) {
            newX *= others[i].x;
            newY *= others[i].y;
            newZ *= others[i].z;
            newW *= others[i].w;
        }
        return new Vector4D(newX, newY, newZ, newW);
    }

    /**
     * Scalar multiplication.
     *
     * @param n
     * @return New point
     */
    public Vector4D multiply(double n) {
        return new Vector4D(this.x * n, this.y * n, this.z * n, this.w * n);
    }

    /**
     * Component-wise division
     *
     * @param other
     * @return New point
     */
    public Vector4D divide(Vector4D other) {
        return new Vector4D(x / other.x, y / other.y, z / other.z, w / other.w);
    }

    /**
     * Component-wise division
     *
     * @param x
     * @param y
     * @param z
     * @return New point
     */
    public Vector4D divide(double x, double y, double z, double w) {
        return new Vector4D(this.x / x, this.y / y, this.z / z, this.w / w);
    }

    /**
     * Scalar division.
     *
     * @param n
     * @return new point
     */
    public Vector4D divide(double n) {
        return new Vector4D(x / n, y / n, z / n, w / n);
    }
    /**
     * Get the length of the vector.
     *
     * @return length
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    /**
     * Get the length^2 of the vector.
     *
     * @return length^2
     */
    public double lengthSq() {
        return x * x + y * y + z * z + w * w;
    }

    /**
     * Get the distance away from a point.
     *
     * @param pt
     * @return distance
     */
    public double distance(Vector4D pt) {
        return Math.sqrt(
            Math.pow(pt.x - x, 2) +
            Math.pow(pt.y - y, 2) +
            Math.pow(pt.z - z, 2) +
            Math.pow(pt.w - w, 2)
        );
    }

    /**
     * Get the distance away from a point, squared.
     *
     * @param pt
     * @return distance
     */
    public double distanceSq(Vector4D pt) {
        return
            Math.pow(pt.x - x, 2) +
            Math.pow(pt.y - y, 2) +
            Math.pow(pt.z - z, 2) +
            Math.pow(pt.w - w, 2);
    }

    /**
     * Get the normalized vector.
     *
     * @return vector
     */
    public Vector4D normalize() {
        return divide(length());
    }

    /**
     * Gets the dot product of this and another vector.
     *
     * @param other
     * @return the dot product of this and the other vector
     */
    public double dot(Vector4D other) {
        return x * other.x + y * other.y + z * other.z + w * other.w;
    }

    /**
     * Checks to see if a vector is contained with another.
     *
     * @param min
     * @param max
     * @return
     */
    public boolean containedWithin(Vector4D min, Vector4D max) {
        return x >= min.getX() && x <= max.getX()
                && y >= min.getY() && y <= max.getY()
                && z >= min.getZ() && z <= max.getZ()
                && w >= min.getW() && w <= max.getW();
    }

    /**
     * Rounds all components down.
     *
     * @return
     */
    public Vector4D floor() {
        return new Vector4D(Math.floor(x), Math.floor(y), Math.floor(z), Math.floor(w));
    }

    /**
     * Rounds all components up.
     *
     * @return
     */
    public Vector4D ceil() {
        return new Vector4D(Math.ceil(x), Math.ceil(y), Math.ceil(z), Math.ceil(w));
    }

    /**
     * Rounds all components to the closest integer.<br>
     *<br>
     * Components < 0.5 are rounded down, otherwise up
     *
     * @return
     */
    public Vector4D round() {
        return new Vector4D(Math.floor(x + 0.5), Math.floor(y + 0.5), Math.floor(z + 0.5), Math.floor(w + 0.5));
    }

    /**
     * Checks if another object is equivalent.
     *
     * @param obj
     * @return whether the other object is equivalent
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector4D)) {
            return false;
        }

        Vector4D other = (Vector4D) obj;
        return other.x == this.x && other.y == this.y && other.z == this.z && other.w == this.w;
    }

    /**
     * Returns string representation "(x, y, z)".
     *
     * @return string
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }

    /**
     * Creates a 3D vector by dropping the W component from this vector.
     *
     * @return Vector
     */
    public Vector toVector() {
        return new Vector(x, y, z);
    }

    /**
     * Gets the minimum components of two vectors.
     *
     * @param v1
     * @param v2
     * @return minimum
     */
    public static Vector4D getMinimum(Vector4D v1, Vector4D v2) {
        return new Vector4D(
            Math.min(v1.x, v2.x),
            Math.min(v1.y, v2.y),
            Math.min(v1.z, v2.z),
            Math.min(v1.w, v2.w)
        );
    }

    /**
     * Gets the maximum components of two vectors.
     *
     * @param v1
     * @param v2
     * @return maximum
     */
    public static Vector4D getMaximum(Vector4D v1, Vector4D v2) {
        return new Vector4D(
            Math.max(v1.x, v2.x),
            Math.max(v1.y, v2.y),
            Math.max(v1.z, v2.z),
            Math.max(v1.w, v2.w)
        );
    }

    /**
     * Gets the midpoint of two vectors.
     *
     * @param v1
     * @param v2
     * @return maximum
     */
    public static Vector4D getMidpoint(Vector4D v1, Vector4D v2) {
        return new Vector4D(
            (v1.x + v2.x) / 2,
            (v1.y + v2.y) / 2,
            (v1.z + v2.z) / 2,
            (v1.w + v2.w) / 2
        );
    }
}
