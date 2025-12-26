/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/


		/*int n = 3; 
    
    	//snowflake function
    	snowFlake(n);
		int n = 3; */
    

		/*int n=3;
		double x1 = 0.0;
		double y1 = 0.5;
		double x2 = 1.0;
		double y2 = 0.5;


		curve(n, x1, y1, x2, y2);*/


		int n = Integer.parseInt(args[0]); 
    
    	// snowflakes
    	snowFlake(n);



		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		//StdDraw.line(x1, y1, x2, y2); // this does stright lines and makes it a triangle - bad
		//// Write the rest of your code below.
		/// 
		/// 
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // recursion step
        double x_13 = x1 + (x2 - x1) / 3.0;
        double y_13 = y1 + (y2 - y1) / 3.0;
        
        double x_23 = x1 + 2.0 * (x2 - x1) / 3.0;
        double y_23 = y1 + 2.0 * (y2 - y1) / 3.0;

        // calculation using the provided formula in the HW7 sheet
        double x_tip = (x1 + x2) / 2.0 - Math.sqrt(3) / 6.0 * (y2 - y1);
        double y_tip = (y1 + y2) / 2.0 + Math.sqrt(3) / 6.0 * (x2 - x1);

        // recursion for new sides
        curve(n - 1, x1, y1, x_13, y_13);       // start to 1/3
        curve(n - 1, x_13, y_13, x_tip, y_tip); // 1/3 to the tip
        curve(n - 1, x_tip, y_tip, x_23, y_23); // Tip the 2/3 part
        curve(n - 1, x_23, y_23, x2, y2);       // 2/3 till End
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		/// 
		double x1 = 0.2, y1 = 0.25; // bottom left
        double x2 = 0.8, y2 = 0.25; // bottom right
        
        // Calculate using formula
        double h = Math.sqrt(3) / 2.0 * (x2 - x1); 
        double x3 = 0.5, y3 = y1 + h; // top center

		// draw the 3 sides - it was in the wrong order, changed it:

        /*curve(n, x1, y1, x2, y2); // bottom
        curve(n, x2, y2, x3, y3); // right
        curve(n, x3, y3, x1, y1); // left
		*/

		// draw in CLOCKWISE order - fixed
		// 1. bottom left to Top
		curve(n, x1, y1, x3, y3); 
		// 2. top to bottom right
		curve(n, x3, y3, x2, y2); 
		// 3. bottom right to bottom left
		curve(n, x2, y2, x1, y1);
	}
}
