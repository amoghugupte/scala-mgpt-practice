package huntfor.gold

class GoldHunt(val mazeSizeX: Int, val mazeSizeY: Int) {
  def moveToNext(arr: Array[Array[CellPoint]], currLocation: Location): Location = {
    val x: Int = currLocation.intX;
    val y: Int = currLocation.intY;

    val curr: CellPoint = arr(x)(y);
    if (curr.cellType.equals("D")) {
      val newX = (x + curr.intX + mazeSizeX) % mazeSizeX;
      val newY = (y + curr.intY + mazeSizeY) % mazeSizeY;
//      println("moveToNext - x = " + x + "\ty = " + y + "\tcurr.intX = " + curr.intX + "\tcurr.intY = " + curr.intY + "\tnewX = " + newX + "\tnewY=" + newY);
      val nextLocation = new Location(newX, newY);
      return nextLocation;
    }
    return currLocation;
  }

  def run(arr: Array[Array[CellPoint]], startX: Int, startY: Int, id: Int, currWinner: Int): Int = {
//    println("id = " + id);
    var condition: Boolean = true;
    var currPoint: Location = new Location(startX, startY);
    var steps: Int = 0;

    while (condition) {
      currPoint = moveToNext(arr, currPoint);
      condition = (currWinner != -1 || steps < currWinner) && arr(currPoint.intX)(currPoint.intY).cellType.equals("D");
//      println("condition = " + condition + "\tarr (currPoint.intX)(currPoint.intY).cellType = " + arr(currPoint.intX)(currPoint.intY).cellType);
      if (arr(currPoint.intX)(currPoint.intY).cellType.equals("G")) {
        println(id);
      } else if (!condition) {
        steps = -2;
      }
      steps = steps + 1;
    }
    return steps;
  }
}