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

package com.sk89q.worldedit.spout;

import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.math.Vector;
import com.sk89q.worldedit.math.WorldVector;

import org.spout.api.Game;
import org.spout.api.geo.World;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.block.BlockFace;
import org.spout.api.player.Player;

import java.util.HashMap;
import java.util.Map;

public class SpoutUtil {
    private SpoutUtil() {
    }

    private static final Map<World, LocalWorld> wlw = new HashMap<World, LocalWorld>();

    public static LocalWorld getLocalWorld(World w) {
        LocalWorld lw = wlw.get(w);
        if (lw == null) {
            lw = new SpoutWorld(w);
            wlw.put(w, lw);
        }
        return lw;
    }

    public static Vector toVector(Block block) {
        return new Vector(block.getX(), block.getY(), block.getZ());
    }

    public static Vector toVector(BlockFace face) {
        return toVector(face.getOffset());
    }

    public static WorldVector toWorldVector(Block block) {
        return new WorldVector(getLocalWorld(block.getWorld()), block.getX(), block.getY(), block.getZ());
    }

    public static Vector toVector(Point loc) {
        return new Vector(loc.getX(), loc.getY(), loc.getZ());
    }

    public static Vector toVector(org.spout.api.math.Vector3 vector) {
        return new Vector(vector.getX(), vector.getY(), vector.getZ());
    }

    public static Point toPoint(WorldVector location) {
        final Vector position = location.getPosition();
        return new Point(toWorld(location), (float)position.getX(), (float)position.getY(), (float)position.getZ());
    }

    public static Point toPoint(World world, Vector pt) {
        return new Point(world, (float)pt.getX(), (float)pt.getY(), (float)pt.getZ());
    }

    public static Point center(Point loc) {
        return new Point(
                loc.getWorld(),
                loc.getX() + 0.5F,
                loc.getY() + 0.5F,
                loc.getZ() + 0.5F
        );
    }

    public static Player matchSinglePlayer(Game game, String name) {
        return game.getPlayer(name, false);
    }

    public static Block toBlock(WorldVector location) {
        final Vector position = location.getPosition();
        return toWorld(location).getBlock(position.getBlockX(), position.getBlockY(), position.getBlockZ());
    }

    public static World toWorld(WorldVector pt) {
        return ((SpoutWorld) pt.getWorld()).getWorld();
    }
}
