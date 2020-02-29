
/**
 * Just some Java code to allow you to explore inheritance, constructor
 * chaining, and polymorphism ("dynamic method lookup")
 * 
 */

import edu.princeton.cs.introcs.*;

public class PlayWithInheritance
{
	public static int CONSTRUCTOR_CHAINING = 1;
	public static int PRINTING_REFERENCES = 2;
	public static int USING_SUPER = 3;
	public static int INVOKING_AGAINST_SUPERCLASS_REF = 4;
	public static int DYNAMIC_METHOD_LOOKUP = 5;
	public static int OVERRIDING_STATIC = 6;

	public static int RUN_EXAMPLE = 1; // change below to run different methods
										// thus exploring different behaviors

	public static void main(String[] args)
	{
		StdOut.println();

		// common to all examples...

		// which constructors are called in the following?

		Die aSingleDie = new Die();
		CrookedDie1 crooked1 = new CrookedDie1();
		CrookedDie2 crooked2 = new CrookedDie2();

		StdOut.println();

		// change RUN_EXAMPLE above to run any one of the following 6 examples

		if (RUN_EXAMPLE == CONSTRUCTOR_CHAINING)
		{
			StdOut.println("Note the output: constructor chaining.");
		}
		else if (RUN_EXAMPLE == PRINTING_REFERENCES)
		{
			// When a reference is treated like a String
			// => toString() is automatically invoked, and its returned value
			// used instead!

			StdOut.print("toString() automatically called when reference treated as String: ");
			StdOut.println(aSingleDie);

			StdOut.println("Concatenating a string to a reference: " + aSingleDie);
		}
		else if (RUN_EXAMPLE == USING_SUPER)
		{
			// concatenate " " + super.toString() to end of toString() code
			// inside each of 3 classes, then watch the result when run again.

			StdOut.println("die1's toString(): '" + aSingleDie + "'");
			StdOut.println("crooked1's toString(): '" + crooked1 + "'");
			StdOut.println("crooked2's toString(): '" + crooked2 + "'");
		}
		else if (RUN_EXAMPLE == INVOKING_AGAINST_SUPERCLASS_REF)
		{
			// Die alias = die1; // try replacing this line with either below
			Die alias = crooked1; // upcasting!
			// Die alias = crooked2; // ditto

			StdOut.println("alias's toString(): '" + alias.toString() + "'");
			StdOut.println();
		}
		else if (RUN_EXAMPLE == DYNAMIC_METHOD_LOOKUP)
		{
			Die alias;

			double toss = Math.random(); // [0.0..1.0)

			if (toss < 0.333)
				alias = aSingleDie;
			else if (toss < 0.666)
				alias = crooked1;
			else
				alias = crooked2;

			// Can the compiler figure out the actual type
			// of alias in the following call?
			// No => dynamic runtime lookup happens

			describe("Which toString() is called? Answer is: ", alias);
		}
		else if (RUN_EXAMPLE == OVERRIDING_STATIC)
		{
			// your [H2-9] code goes here
		}

		StdOut.println();
	}

	/**
	 * Shows polymorphism via passing either Die ref as toDescribe, or
	 * CrookedDie1 or CrookedDie2 ref instead
	 * 
	 * @param msg
	 * @param toDescribe
	 */

	public static void describe(String msg, Die toDescribe)
	{
		StdOut.printf("%s '%s' \n", msg, toDescribe.toString());
	}

}
