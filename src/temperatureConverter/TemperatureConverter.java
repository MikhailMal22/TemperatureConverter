package temperatureConverter;
import java.util.Scanner;
public class TemperatureConverter 
{

	public static void main(String[] args) 
	{
		String[] arr = new String[]{"0","Celsius","Fahrenheit","Kelvin"};
		int from = 6, to = 6;
		double tem= -999, tem2 = 0;
		while(true) 
		{
			while(from >= 5 || from <= 0) {
				System.out.println("Convert from? (1)-Celsius,(2)-Fahrenheit,(3)-Kelvin (4)-Quit");
				Scanner scan = new Scanner(System.in);
				if(scan.hasNextInt()) 
				{
					from = scan.nextInt();
					if(from >= 5 || from <= 0) {
						System.out.println("Invalid input!");
					}
				}
				else {
					System.out.println("Invalid input! Please enter a number!");
				}
				
			}
			if(from == 4) {
				System.out.println("Quitting program...");
				break;
			}
			else {
				System.out.println("Selected "+arr[from]);
			}
			
			
			while(to >= 5 || to <= 0 || to == from) {
				System.out.println("Convert to? (1)-Celsius,(2)-Fahrenheit,(3)-Kelvin (4)-Quit");
				Scanner scan = new Scanner(System.in);
				if(scan.hasNextInt()) 
				{
					to = scan.nextInt();
					if(to >= 5 || to <= 0) {
						System.out.println("Invalid input!");
					}
					else if(to == from) {
						System.out.println("Already selected "+arr[from]+",please select a different system.");
					}
				}
				else {
					System.out.println("Invalid input! Please enter a number!");
				}
			}
			if(to == 4) {
				System.out.println("Quitting program...");
				break;
			}
			else {
				System.out.println("Selected "+arr[to]);
			}
			
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter temperature in "+arr[from]+":");
				if(scan.hasNextDouble()) 
				{
					tem = scan.nextDouble();
					break;
				}
				else {
					System.out.println("Invalid input! Please enter a number!");
				}
			}
			tem2 = Convert(from,to,tem);
			
			System.out.println(tem+" degrees "+arr[from]+" is equivalent to "+String.format("%.3f", tem2)+" degrees "+ arr[to]);
			to = 6;
			from = 6;
			tem = -999;
		}
		
	}
	public static double Convert(int a,int b,double t) 
	{
		double t2 = 0;
		if(a == 3) {
			t2 = t-273.15;
			if(b == 1) {
				return t2;
			}
			t2 = (t2*1.8) + 32;
			return t2;
		}
		if(a == 2) 
		{
			t2 = (t-32) * 5/9;
			if(b == 1) {
				return t2;
			}
			t2 += 273.15;
			return t2;
		}
		if(b==2) 
		{
			t2 = (t*1.8) + 32;
			return t2;
		}
		t2 = t+273.15;
		return t2;
		
	}

}
