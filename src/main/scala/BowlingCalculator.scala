object BowlingCalculator {
  def calculateScore(list: List[Frame]): Int = {
    list match {
      case Nil => 0
      case head :: Nil => head.first + head.second + head.third.getOrElse(0)
      case head :: tail if head.first == 10 => head.first + calculateStrikeBonus(tail) + calculateScore(tail)
      case head :: tail if head.first + head.second == 10 => head.first + head.second + calculateSpareBonus(tail) + calculateScore(tail)
      case head :: tail => head.first + head.second + calculateScore(tail)
    }
  }

  def calculateStrikeBonus(list: List[Frame]): Int = {
    list match {
      case Nil => 0
      case head :: Nil => head.first + head.second
      case head :: tail if head.first == 10 => head.first + tail.head.first
      case head :: _ => head.first + head.second
    }
  }

  def calculateSpareBonus(list: List[Frame]): Int = {
    list match {
      case Nil => 0
      case head :: _ => head.first
    }
  }
}

case class Frame(first: Int, second:Int, third: Option[Int] = None)