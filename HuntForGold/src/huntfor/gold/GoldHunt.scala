package huntfor.gold

class GoldHunt {
  def moveToNext(arr: Array[Array[CellPoint]], x: Int, y: Int): CellPoint = {
    val curr:CellPoint = arr(x)(y);
    if (curr.cellType.equals("D")) {
      return arr (x + curr.intX)(y + curr.intY);
    }
    return arr(x)(y);
  }
  
  def run (arr:Array [Array[CellPoint]], startX: Int, startY: Int, id: Int): CellPoint = {
    var condition:Boolean = true;
    var x:Int = startX;
    var y:Int = startY;
    
    while (condition) {
      val currPoint:CellPoint = moveToNext(arr, x, y);
      condition = currPoint.cellType.equals("D");
      if (currPoint.cellType.equals("G")) {
        println(id);
      }
    }
    return null;
  }
}