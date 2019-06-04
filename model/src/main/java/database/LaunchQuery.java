package database;

import database.ConvertTXTtoInt;
import database.ReadDB;

public class LaunchQuery {
		
	int[][] mapUse;
	int width_Map, height_Map, spwanXPlayer, spwanYPlayer;
	
	public int[][] callDB(int idMap){
		
		
			ReadDB db = new ReadDB();
			db.read(idMap);
			height_Map = db.getHeight_Map();
			width_Map = db.getWidth_Map();
			spwanXPlayer = db.getPosX_Player();
			spwanYPlayer = db.getPosY_Player();
			String map = db.getMap();
			ConvertTXTtoInt txtInt = new ConvertTXTtoInt();
			txtInt.txtToInt(map, width_Map, height_Map);
			mapUse = txtInt.getMap();
			return mapUse;
	}
	
	public int getWidthMap(){
		return width_Map;
	}
	public int getHeightMap(){
		return height_Map;
	}
	public int getSpwanXPlayer(){
		return spwanXPlayer;
	}
	public int getSpwanYPlayer(){
		return spwanYPlayer;
	}
}