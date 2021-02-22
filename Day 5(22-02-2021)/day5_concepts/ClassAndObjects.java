package day5_concepts;

public class ClassAndObjects {
	public static void main(String[] args) {
		//SGBall sgball=new SGBall();
		DukeBall dukeball=new DukeBall();
		//sgball.makeSGBall();
		dukeball.makeDukeBall();
	}
}

abstract class Ball{
	abstract void makeBall();
}


/*
class SGBall{
	public void makeSGBall(){
		//Ball ball=new DukeBall().new CricketBall();
		Ball ball=new DukeBall().getCricketBall();
		ball.makeBall();
		System.out.println("SG ball for test matches is ready");
	}
}
*/

class DukeBall{
	public void makeDukeBall() {
		/*
		//Local Inner Class
		class CricketBall extends Ball{
			@Override
			void makeBall() {
				// TODO Auto-generated method stub
				System.out.println("Cricket Ball is Made !");
			}
		}
		Ball ball=new CricketBall();
		ball.makeBall();*/
		//Anonymous Inner Class 
		new Ball() {

			@Override
			void makeBall() {
				// TODO Auto-generated method stub
				System.out.println("Cricket Ball is Made !");
			}
			
		}.makeBall();;
		System.out.println("Duke ball for test matches is ready");
	}
	/*
	//Inner Class
	private class CricketBall extends Ball{
		@Override
		void makeBall() {
			// TODO Auto-generated method stub
			System.out.println("Cricket Ball is Made !");
		}
	}
	public CricketBall getCricketBall() {
		return new CricketBall();
	}
	*/
	
}