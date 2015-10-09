package SecondHomeTask;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AirCompany {
	public static void main(String[] args) {
		List<Plane> planes = new LinkedList<>();
		
		initPlane(planes);
		int capacity = generalCapacity(planes);
		System.out.println("General people capacity: " + capacity);
		
		int lift = generalLift(planes);
		System.out.println("General lift capacity: " + lift);
		
		Collections.sort(planes);
		System.out.println("Sorted:\n" + planes);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a low-fuel border:");
		int lowFuel = scanner.nextInt();
		System.out.println("Enter a high-fuel border:");
		int highFuel = scanner.nextInt();
		
		List<Plane> necessaryPlane = findPlane(planes, lowFuel, highFuel);
		System.out.println("Fuel:\n" + necessaryPlane);
	}
	
	private static List<Plane> findPlane(List<Plane> planes, int lowFuel, int highFuel) {
		List<Plane> tmp = new LinkedList<>(); 
		ListIterator<Plane> iterator = planes.listIterator();
		Plane p;
		while(iterator.hasNext()){
			p = iterator.next();
			if(p.isPositiveFuelCondition(lowFuel, highFuel)){
				tmp.add(p);
			}
		}
		return tmp;
	}

	private static int generalLift(List<Plane> planes) {
		int lift = 0;
		ListIterator<Plane> iterator = planes.listIterator();
		while(iterator.hasNext()){
			lift += iterator.next().getLift();
		}
		return lift;
	}

	private static int generalCapacity(List<Plane> planes) {
		int capacity = 0;
		ListIterator<Plane> iterator = planes.listIterator();
		while(iterator.hasNext()){
			capacity += iterator.next().getCapacity();
		}
		
		return capacity;
	}

	private static void initPlane(List<Plane> planes) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String model = "";
		int fuel = 0;
		int capacity = 0;
		int lift = 0;
		int range = 0;
		
		System.out.println("Enter how many plane are you need:");
		int sum = scanner.nextInt();
		for(int i = 0; i < sum; ++i){
			System.out.println("Plane#" + (i + 1));
			model = i + "";
			System.out.println("Enter a fuel capacity:");
			fuel = scanner.nextInt();
			System.out.println("Enter a people capacity:");
			capacity = scanner.nextInt();
			System.out.println("Enter a lift capacity:");
			lift = scanner.nextInt();
			System.out.println("Enter a flyght range:");
			range = scanner.nextInt();
			Plane tmp;
			tmp = Plane.createPlane(model, fuel, capacity, lift, range);
			planes.add(tmp);
			System.out.println();
		}		
	}
}
