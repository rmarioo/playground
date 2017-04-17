package com.rmarioo.playground.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest
{

  private final Bowling bowling = new Bowling();

  @Test
  public void allZeroRolls() throws Exception
  {
    rollMany(0, 20);
    assertThat(bowling.score(),is(0));
  }

  @Test
  public void aNotZeroRoll() throws Exception
  {
    bowling.roll(2);
    rollMany(0, 19);
    assertThat(bowling.score(),is(2));
  }

  @Test
  public void moreNotZeroRolls() throws Exception
  {
    bowling.roll(2);
    bowling.roll(3);
    rollMany(0, 18);
    assertThat(bowling.score(),is(5));
  }

  @Test
  public void aSpareAtTheBeginningOfGame() throws Exception
  {
    spare();
    bowling.roll(3);
    rollMany(0, 17);
    assertThat(bowling.score(),is(2+8+ 3+3));

  }

  @Test
  public void aStrikeAtBeginningOfGame() throws Exception
  {
    strike();
    bowling.roll(7);
    bowling.roll(1);
    rollMany(0,16);
    assertThat(bowling.score(),is(10+ 7+1+ 7+1));

  }

  private void strike()
  {
    bowling.roll(10);
  }

  private void spare()
  {
    bowling.roll(2);
    bowling.roll(8);
  }

  private void rollMany(int score, int howMany)
  {
    for (int i = 0; i < howMany; i++)
    {
      bowling.roll(score);
    }
  }
}
