import javax.swing.plaf.SliderUI;


public class Car implements Runnable {
	
	int carPosition; // scaled from 1-9 (1 is leftmost postion, 9 is rightmost position)
	boolean driving;
	
	Car()
	{
		carPosition = 5;
		driving = false;
	}
	
	public void prepareToDrive()
	{
		driving = true;
		System.out.println("start your engines!");
	}
	
	public void stopDriving()
	{
		driving = false;
	}

	// monitor the position on the road and make corrections as necessary
	@Override
	public void run() {
		while(driving)
		{
			if(carPosition == 5)
			{
				System.out.println("driving straight ahead");
			}
			else if(carPosition < 5)
			{
				if(carPosition < 1)
				{
					System.out.println("pending head on collision!  Goodbye");
					driving = false;
				}
				else if(carPosition < 2)
				{
					System.out.println("too close to oncoming traffic.  making immediate correction");
					carPosition++;
				}
				else if(carPosition < 3)
				{
					System.out.println("watch that yellow line.  moving back to center");
					carPosition++;
				}
				else if(carPosition < 4)
				{
					System.out.println("focus is good.  you may need some more.  moving lightly to the right");
					carPosition++;
				}
				else
				{
					System.out.println("vearing to the left.  making slight correction");
					carPosition++;
				}
			}
			else if(carPosition < 11)
			{
				if(carPosition < 7)
				{
					System.out.println("vearing to the right.  making slight correction");
					carPosition--;
				}
				else if(carPosition < 8)
				{
					System.out.println("focus is good.  you may need some more.  moving slightly to the left");
					carPosition--;
				}
				else if(carPosition < 9)
				{
					System.out.println("appoaching the shoulder.  moving back to center");
					carPosition--;
				}
				else if(carPosition < 10)
				{
					System.out.println("driving drunk is illegal.  moving quickly to the left");
					carPosition--;
				}
				else
				{
					System.out.println("driving on the shoulder can be quite dangerous! go back to driving school!");
					driving = false;
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(carPosition > 0 && carPosition < 10) System.out.println("new car position in lane: " + carPosition);
		}
		
	}

}
