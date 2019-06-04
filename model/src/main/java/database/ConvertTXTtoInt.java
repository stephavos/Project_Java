package database;

public class ConvertTXTtoInt {

	int[][] map;
	
		public int[][] txtToInt(String Map, int Width_Map, int Height_Map){

			Map = Map.replaceAll(System.getProperty("line.separator"), " ");

			String[] tableau = Map.split(" ");
			

			map = new int[Height_Map][Width_Map];
			
			for(int i = 0; i<(Width_Map * Height_Map); ++i){
				int jj = i%Width_Map;
				int ii = i/Width_Map;
				map[ii][jj] = Integer.parseInt(tableau[i]);
			}

			return map;
		}

		public int[][] getMap() {
			return map;
		}
		
		

}
