package caveExplorer;

public class InventoryNockles {
	
	private boolean hasMap;
	private String map;

	public InventoryNockles() {
		hasMap = true;
		updateMap();
	}

	public void updateMap() {
		CaveRoomPd8[][] caves = CaveExplorer.caves;
		//convert these caves to a string representation
		
		//create the top side
		//horizontal line across the top row, except for last column, with 4
		map = " ";
		for(int i = 0; i < caves[0].length - 1; i++){
			map += "____";
		}
		
		map += "___\n";
		
		//each room
		for(CaveRoomPd8[] row: caves){
			//there are three rows of text
			for(int textRow = 0; textRow < 3; textRow++){
				//the text is for each room
				for(CaveRoomPd8 cr : row){
					String str = "|   ";
					String contents = cr.getContents();
					if(textRow == 1){
						if(cr.getDoor(CaveRoomPd8.WEST) != null){
							str = "  " + contents + " ";
						}
						else{
							str = "| " + contents + " ";
						}
					}
					
					else{
						if(textRow == 2){
							if(cr.getDoor(CaveRoomPd8.SOUTH) != null && cr.getDoor(CaveRoomPd8.SOUTH).isOpen()){
								str = "|___";
							}
							else{
								str = "|_ _";
							}
						}
					}
					map += str;
				}//end of row of caverooms
				map += "|\n";
			}
		}
	}

	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public String getDescription() {
		if(hasMap){
			return map;
		}
		else{
			return "You have no inventory";
		}
	}

}
