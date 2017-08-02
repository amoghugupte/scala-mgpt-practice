package word.chain

object Main {
  def main(args: Array[String]) {
    val arrSize: Int = scala.io.StdIn.readInt();
    val wordArray: Array[String] = new Array[String](arrSize);
    for (i <- 0 to wordArray.length - 1) {
      wordArray(i) = scala.io.StdIn.readLine();
    }

    val wordOutputArray: Array[String] = new Array[String](arrSize);
    wordOutputArray(0) = wordArray(0);

    if (chainWords(wordArray(0), filterIndex(wordArray, 0), wordOutputArray, 1)) {
      for (i <- 0 to wordOutputArray.length - 1) {
        println(wordOutputArray(i));
      }
    } else {
      println("IMPOSSIBLE");
    }
  }

  def wordMatch(word1: String, word2: String): Boolean = {
    var wordsMatch: Boolean = false;
    for (i <- 3 to word1.length()) {
      wordsMatch = wordsMatch || word2.toLowerCase().startsWith(word1.toLowerCase().substring(word1.length() - i));
    }
    return wordsMatch;
  }

  def chainWords(word: String, wordArray: Array[String], wordOutputArray: Array[String], index: Int): Boolean = {
//    println(word);
    if (wordArray.length == 1) {
      if (wordMatch(word, wordArray(0))) {
        wordOutputArray(index) = wordArray(0);
        return true;
      }
    } else {
      for (i <- 0 to wordArray.length - 1) {
        if (wordMatch(word, wordArray(i))) {
          wordOutputArray(index) = wordArray(i);
          if (chainWords(wordArray(i), filterIndex(wordArray, i), wordOutputArray, index + 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  def filterIndex(wordArray: Array[String], index: Int): Array[String] = {
    val retArray: Array[String] = new Array[String](wordArray.length - 1);
    var j: Int = 0;
    for (i <- 0 to wordArray.length - 1) {
      if (i != index) {
        retArray(j) = wordArray(i);
        j = j + 1;
      }
    }
    return retArray;
  }
}
