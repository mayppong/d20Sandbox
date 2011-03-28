package com.andrewnelder.d20.dungeon;

import java.util.Random;


public class DungeonGenerator {
	
	public DungeonGenerator() {
		// do something
	}
	
	private Map generateMap(int dungeonSize, int maxHeight, int maxWidth) {
		
		int[][] map = createEmptyMap(dungeonSize);
		map = placeHallways(map, maxHeight, maxWidth);
		
		return null;
	}
	
	/**
	 * Builds an empty map.
	 * @param dungeonSize
	 * @return
	 */
	private int[][] createEmptyMap(int dungeonSize) {
		int axis = dungeonSize*10;
		int[][] map = new int[axis][axis];
		return map;
	}
	
	private int[][] placeHallways(int[][] map, int maxHeight, int maxWidth) {
		
		Random generator = new Random();
		
		int x = generator.nextInt(map.length);
		int y = generator.nextInt(map.length);
		
		map[x][y] = 1;
		
		while (sum2DIntegerArray(map) < (map.length*map.length)/10) {
			
			int x_mod = 0, y_mod = 0;
			while (map[y+y_mod][x+x_mod] != 0) {
				x_mod = generator.nextInt(3)-1;
				y_mod = generator.nextInt(3)-1;
			}
			map[y+y_mod][x+x_mod] = 1;
			print2DIntegerArray(map);
			
		}
		
		return map;
	}
	
	public static void print2DIntegerArray(int[][] integerArray) {
		for (int[] i : integerArray) {
			for (int j : i) {
				System.out.print(i[j]);
			}
			System.out.print("\n");
		}
	}
	
	public static int sum2DIntegerArray(int[][] integerArray) {
		int sum = 0;
		for (int[] i : integerArray) {
			for (int j : i) {
				sum += j;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		DungeonGenerator x = new DungeonGenerator();
		x.generateMap(5, 3, 6);
	}
	
}
