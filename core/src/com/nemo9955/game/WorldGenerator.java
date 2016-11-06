package com.nemo9955.game;

import com.badlogic.gdx.math.MathUtils;

public class WorldGenerator {

    static void generateNoiseWorld(World world) {
	int[] ofs = { +1, 0, +1, -1, 0, -1, -1, 0, -1, +1, 0, +1 };
	float chanceAllive = 0.4f;
	int birthLimit = 4;
	int deathLimit = 4;
	int steps = 1;

	boolean[][] map = new boolean[world.maxWidth][world.maxHeight];
	for (int i = 0; i < map.length; i++)
	    for (int j = 0; j < map[0].length; j++)
		map[i][j] = MathUtils.randomBoolean(chanceAllive) ? true : false;

	int fq = world.maxWidth / 2;
	int fr = world.maxHeight / 2;

	map[fq][fr] = false;
	for (int o = 0; o < ofs.length; o += 2)
	    map[fq + ofs[o]][fr + ofs[o] + 1] = false;

	for (int step = 0; step < steps; step++) {
	    boolean[][] temp = new boolean[world.maxWidth][world.maxHeight];
	    for (int x = 0; x < map.length; x++) {
		for (int y = 0; y < map[0].length; y++) {
		    int nbs = countAliveNeighbours(map, x, y);
		    if (map[x][y]) {
			if (nbs < deathLimit)
			    temp[x][y] = false;
			else
			    temp[x][y] = true;
		    } else {
			if (nbs > birthLimit)
			    temp[x][y] = true;
			else
			    temp[x][y] = false;
		    }
		}
	    }
	    map = temp;
	}

	for (int i = 0; i < map.length; i++)
	    for (int j = 0; j < map[0].length; j++)
		if (map[i][j])
		    world.makeEntity().addTextureHexCoord("Grass", i, j);
		else if (MathUtils.randomBoolean(0.8f))
		    world.makeEntity().addTextureHexCoord("Rock", i, j);
		else
		    world.makeEntity().addTextureHexCoord("Water", i, j);

    }

    static void generateNewRandWorld(World world) {
	for (int col = 0; col < world.maxHeight; col++)
	    for (int row = world.maxWidth - 1; row > -1; row--)
		world.makeEntity().addTextureHexCoord("Grass", col, row);
    }

    static int countAliveNeighbours(boolean[][] map, int x, int y) {
	int count = 0;
	for (int i = -1; i < 2; i++) {
	    for (int j = -1; j < 2; j++) {
		int neighbour_x = x + i;
		int neighbour_y = y + j;
		if (i == 0 && j == 0) {
		} else if (neighbour_x < 0 || neighbour_y < 0 || neighbour_x >= map.length || neighbour_y >= map[0].length) {
		    count = count + 1;
		} else if (map[neighbour_x][neighbour_y]) {
		    count = count + 1;
		}
	    }
	}
	return count;
    }

}
