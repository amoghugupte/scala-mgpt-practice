package huntfor.gold

object Main {
  def main(args: Array[String]) {
    val size: String = scala.io.StdIn.readLine();
    val sizeArr: Array[String] = size.split(" ");
    val field: Array[Array[CellPoint]] = readField(sizeArr);
    val playerInfo: Array[Array[Int]] = readPlayer();
    var winningSteps: Int = -1;
    for (i <- 0 to playerInfo.length - 1) {
      val goldHunt: GoldHunt = new GoldHunt(field.length, field(0).length);
      val newWinner: Int = goldHunt.run(field, playerInfo(i)(1), playerInfo(i)(2), playerInfo(i)(0), winningSteps);
      if (newWinner != -1 && newWinner < winningSteps) {
        winningSteps = newWinner;
      }
    }
  }

  def readField(sizeArr: Array[String]): Array[Array[CellPoint]] = {
    val field: Array[Array[CellPoint]] = new Array[Array[CellPoint]](sizeArr(0).toInt);
    for (i <- 0 to (sizeArr(0).toInt - 1)) {
      field(i) = new Array[CellPoint](sizeArr(1).toInt);
      val currline: String = scala.io.StdIn.readLine();
      val currLineAttrib: Array[String] = currline.split(" ");
      var index: Int = 0;
      for (j <- 0 to field(i).length - 1) {
        val cellType: String = currLineAttrib(index);
        index = index + 1;
        var x: Int = 0;
        var y: Int = 0;
        if ("D".equals(cellType)) {
          x = currLineAttrib(index).toInt;
          index = index + 1;
          y = currLineAttrib(index).toInt;
          index = index + 1;
        }

        field(i)(j) = new CellPoint(cellType, x, y);
      }
    }
    return field;
  }

  def readPlayer(): Array[Array[Int]] = {
    val playerCount = scala.io.StdIn.readInt();
    val players: Array[Array[Int]] = new Array[Array[Int]](playerCount);

    for (i <- 0 to players.length - 1) {
      players(i) = new Array[Int](3);
      val currLine: String = scala.io.StdIn.readLine();
      val splitLine: Array[String] = currLine.split(" ");
      players(i)(0) = splitLine(0).toInt;
      players(i)(1) = splitLine(1).toInt;
      players(i)(2) = splitLine(2).toInt;
    }
    return players;
  }
}
