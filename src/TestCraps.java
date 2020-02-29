
/**
 * Starting application for running multiple simulations of CrapsGame. This
 * gathers statistics (how many games were a win, and how many were a loss), and
 * prints out the results.
 * <p/>
 * 
 * You can vary the behavior of this simulation by changing the Dice object that
 * is used in it. It is set up with two Die dice, but you can replace one or
 * both of these with CrookedDie1 or CrookedDie2 dice instead.
 * <p/>
 * 
 * This application (including supporting classes) is meant to illustrate how
 * inheritance can be used to build a simple OO framework which allows easy
 * changes of behavior *without* needing to change much code.
 * <p/>
 * 
 * @author Eric Level
 * 
 */

import java.util.ArrayList;
import edu.princeton.cs.introcs.*;

public class TestCraps
{
	public static final int NUM_TO_PLAY = 10000;

	/**
	 * CrapsGame represents a single game of craps, which contains a single Dice
	 * object that is rolled when game.play() is called. This returns true if
	 * the game is a win, false otherwise.
	 */
	private CrapsGame game;

	/**
	 * Field <code>numWins</code> tracks the total number of wins out of
	 * <code>numPlays</code> total plays.
	 */
	private int numWins;

	/**
	 * Field <code>numPlays</code> counts the total number of individual games
	 * to play.
	 */
	private int numPlays;

	/**
	 * int array field <code>winsForNumberOfStepsOf</code> tracks number of wins
	 * w after exactly k rolls: <code>winsForNumberOfStepsOf[k]==w </code>, out
	 * of <code>numPlays</code> total plays.
	 */
	private int[] winsForNumberOfStepsOf = new int[100];
	private ArrayList<Integer> test;

	/**
	 * int array field <code>lossesForNumberOfStepsOf</code> tracks number of
	 * losses l after exactly k rolls:
	 * <code>lossesForNumberOfStepsOf[k]==l</code>, out of <code>numPlays</code>
	 * total plays.
	 */
	private int[] lossesForNumberOfStepsOf = new int[100];

	/**
	 * Constructor TestCraps() creates a new CrapsGame for subsequent play.
	 */
	public TestCraps()
	{
		// game = new CrapsGame();

		game = new CrapsGame(new Die(), new Die()); // two "fair" Die objects

		// we'll use the above to substitute Die subclass objects,
		// thus affecting the outcome
	}

	/**
	 * Instance method <code>public void play(int)</code> plays n games of
	 * craps, tracking the results of each: number of total wins out of n, and
	 * for each win, how many games end in a win/loss after exactly k plays:
	 * winSteps[k], lossSteps[k]
	 * 
	 * @param n
	 *            total number of games to play
	 */

	public void play(int n)
	{
		numPlays = n;
		numWins = 0;
		for (int i = 0; i < numPlays; i++)
		{
			if (game.playOneGame(winsForNumberOfStepsOf, lossesForNumberOfStepsOf))
			{
				numWins++;
			}
		}
	}

	/**
	 * Instance method <code>public void reportStats</code> prints out final
	 * value of number of how many games end in a win/loss after exactly k
	 * plays: winSteps[k], lossSteps[k]total wins out of n, and
	 * 
	 * It then prints out the winning percentage for all games played.
	 * 
	 */

	public void reportStats()
	{
		StdOut.println("\nNumber of (wins,losses) for games of given length follow:\n");
		for (int numSteps = 1; numSteps < winsForNumberOfStepsOf.length; numSteps++)
		{
			StdOut.println("(wins,losses) ending at " + numSteps + " roll" + ((numSteps > 1) ? "s" : "") + ": ("
					+ winsForNumberOfStepsOf[numSteps] + "," + lossesForNumberOfStepsOf[numSteps] + ")");
		}

		StdOut.println("\nPlayed " + numPlays + " games total.");

		StdOut.println("Won " + numWins + "/" + numPlays + "==" + 100.0 * (0.0 + numWins) / numPlays + "%");
	}

	/**
	 * TestCraps.main():
	 * 
	 * Build a TestCraps object, play NUM_TO_PLAY games, gathering and reporting
	 * the results.
	 * 
	 * We turn off console output by CrapsGame.showOutput = false, so that the
	 * simulation runs more quickly, then turn it back on to report the results
	 */

	public static void main(String[] args)
	{
		TestCraps test = new TestCraps();

		StdOut.println("Starting simulation of " + NUM_TO_PLAY + " games...");

		CrapsGame.showOutput = false; // turn off output to speed up
		// simulation

		test.play(NUM_TO_PLAY); // play games of craps

		StdOut.println("Done.");

		test.reportStats(); // report the output
	}
}