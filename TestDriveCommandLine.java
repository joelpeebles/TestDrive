import java.util.Scanner;


public class TestDriveCommandLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		car.prepareToDrive();
		Thread drive = new Thread(car);
		drive.start();
		
		while(car.driving)
		{
			System.out.println("simulation running");
			Scanner in = new Scanner(System.in);
			car.carPosition = in.nextInt();
			try {
//				car.carPosition --;
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
