
import org.hamcrest.core.Is.is
import org.junit.Assert._
import org.junit.Test


class BowlingCalculatorTest {

  @Test
  def shouldGetNullPointsIfAllBallsInGutter(): Unit = {
    val list = List(Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0),Frame(0,0))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(0))
  }

  @Test
  def shouldGetSixtyWithAllThree(): Unit = {
    val list = List(Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3),Frame(3,3))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(60))
  }


  @Test
  def shouldGet140WithFourAndSixInEachFrame(): Unit = {
    val list = List(Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6),Frame(4,6,Some(4)))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(140))
  }

  @Test
  def shouldGet240WithNineStrikesAndABlank(): Unit = {
    val list = List(Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(0,0))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(240))
  }


  @Test
  def shouldGet300WithPerfectRound(): Unit = {
    val list = List(Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10,10,Some(10)))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(300))
  }

  @Test
  def shouldGet290WithSpareOnLast(): Unit = {
    val list = List(Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(10, 0),Frame(5,5,Some(10)))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(275))
  }

  @Test
  def shouldGet190With9and1Spares(): Unit = {
    val list = List(Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9, 1),Frame(9,1,Some(9)))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(190))
  }

  @Test
  def quiteABadOneWithOneStrikeAndOneSpare(): Unit = {
    val list = List(Frame(3, 6),Frame(3, 1),Frame(1, 4),Frame(10, 0),Frame(2, 7),Frame(7, 3),Frame(0,0),Frame(6,2),Frame(1,1),Frame(3,4))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(73))
  }

  @Test
  def superTestFromPerok(): Unit = {
    val list = List(Frame(2, 4),Frame(0, 10),Frame(7, 0),Frame(10, 0),Frame(6, 2),Frame(9, 1),Frame(3,3),Frame(10,0),Frame(10,0),Frame(10,7,Some(2)))
    val score = BowlingCalculator.calculateScore(list)
    assertThat(score, is(151))
  }





}
