/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		//// Replace this comment with your code
		/// 
		/// 
		// bottom left
        double x1 = 0; 
        double y1 = 0;
        
        // bottom right
        double x2 = 1; 
        double y2 = 0;
        
        // top
        // height of triangle formula is sqrt(3)/2
        double x3 = 0.5; 
        double y3 = Math.sqrt(3) / 2;
        
        // recursion
        sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		//// Replace this comment with your code
		/// 
		/// 
		// base case - stop if 0
        if (n == 0) {
			//to stop the recursion
			//System.out.println("here 1");
            return ;
        }

        //draws the triangle
        double[] xCoordinates = {x1, x2, x3};
        double[] yCoordinates = {y1, y2, y3};
        StdDraw.polygon(xCoordinates, yCoordinates);
		//System.out.println("here 2");

        //middle of each point is (a+b)/2 - 1,3
        double middleX1X3 = (x1 + x3) / 2;
        double middleY1Y3 = (y1 + y3) / 2;
        
        // middle of each point is (a+b)/2 - 3,2
        double middleX3X2 = (x3 + x2) / 2;
        double middleY3Y2 = (y3 + y2) / 2;

        // middle of each point is (a+b)/2 - 1,2
        double middleX1X2 = (x1 + x2) / 2;
        double middleY1Y2 = (y1 + y2) / 2;

        //recursive call
        
        // top left
        sierpinski(n - 1, x1, middleX1X2, middleX1X3, y1, middleY1Y2, middleY1Y3);
        
        // top
        sierpinski(n - 1, middleX1X3, middleX3X2, x3, middleY1Y3, middleY3Y2, y3);
        
        // top right
        sierpinski(n - 1, middleX1X2, x2, middleX3X2, middleY1Y2, y2, middleY3Y2);
	}
}
