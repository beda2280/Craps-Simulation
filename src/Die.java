
public class Die
{
	private int lastRoll;

	public Die()
	{
		CrapsGame.println("Die() constructor called.");
		this.roll();
	}

	public Die(int firstValue) // overloaded constructor: different signature
	{
		CrapsGame.println("Die(int) constructor called.");
		setLastRoll(firstValue);
	}

	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	// protected => visible to subclasses and same-package classes
	protected void setLastRoll(int lastRoll) // setter or mutator method
	{
		this.lastRoll = lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		setLastRoll((int) (Math.random() * 6 + 1));
	}

	// try changing visibility of toString to protected...
	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "A Die object with roll " + this.getLastRoll();

		// add the following to the end of the above line:
		// + " " + super.toString()
	}

	public String toString(int msg) // Overloading... but NOT overriding!
	{
		return msg + this.toString();
	}
}
