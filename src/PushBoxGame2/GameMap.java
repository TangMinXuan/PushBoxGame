package PushBoxGame2;

public class GameMap{
	int [][] maparr = { { 0,0,1,1,1,1,0,0 }, { 0,0,1,0,0,1,1,1, }, { 1,1,1,0,0,0,0,1, }, 
			{ 1,0,0,2,0,1,0,1, }, { 1,0,0,2,2,0,0,1, }, { 1,1,1,0,3,1,1,1 },
			{ 0,0,1,0,0,1,0,0}, { 0,0,1,1,1,1,0,0 } };
	
	int [][] mapBackUp;
	
	public GameMap() {
		mapBackUp = new int[8][8];
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				mapBackUp[i][j] = maparr[i][j];
			}
		}
	}
}
