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

import com.sk89q.worldedit.LocalWorld;

/**
 * A vector with a world component.
 * 
 * @author sk89q
 */
public class WorldVector {
    /**
     * Represents the world.
     */
    private final LocalWorld world;
    private final Vector position;

    /**
     * Construct the Vector object.
     *
     * @param world 
     * @param x
     * @param y
     * @param z
     */
    public WorldVector(LocalWorld world, double x, double y, double z) {
        this(world, new Vector(x, y, z));
    }

    /**
     * Construct the Vector object.
     *
     * @param world 
     * @param position
     */
    public WorldVector(LocalWorld world, Vector position) {
        this.world = world;
        this.position = position;
    }

    /**
     * Construct the Vector object.
     * 
     * @param world 
     */
    public WorldVector(LocalWorld world) {
        this(world, 0, 0, 0);
    }

    /**
     * Get the world.
     * 
     * @return world
     */
    public LocalWorld getWorld() {
        return world;
    }

    /**
     * Get the position.
     * 
     * @return position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * Get a block point from a point.
     * 
     * @param world 
     * @param x
     * @param y
     * @param z
     * @return point
     */
    public WorldVector toBlockPoint() {
        return new WorldVector(world, position.floor());
    }
}
