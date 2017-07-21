package huntfor.gold

object Main {
  def main(args: Array[String]) {
    val size:String = scala.io.StdIn.readLine();
    val sizeArr:Array[String] = size.split(" ");
    val field:Array[Array[CellPoint]] = new Array[Array[CellPoint]] (sizeArr(0).toInt);
    for(i <- 0 to (sizeArr(0).toInt -1 )) {
      field(i) = new Array[CellPoint](sizeArr(1).toInt);
      for (j <- 0 to field(i).length -1) {
        
      }
    }
  }
}