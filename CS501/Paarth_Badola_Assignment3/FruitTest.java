//Paarth Badola
//20012789

import java.util.ArrayList;
import java.util.Random;

public class FruitTest {
	public static void main(String[] args) {
		
		// making objects of classes according to given info
		Apple apple1 = new Apple("sweet", "crisp", "red", false);
		// keeping apple2 as reference for later question
		Apple apple2 = new Apple("tarte", "soft", "green", true);
		Apple apple3 = new Apple("tarte", "soft", "green", true);
		
		// initializing random for random sourness value  
		Random r = new Random();
		Lemon lemon1 = new Lemon(r.nextInt(100), "sour", false);
		Lemon lemon2 = new Lemon(r.nextInt(100), "sour", false);
		Lemon lemon3 = new Lemon(r.nextInt(100), "sour", false);
		
		Orange orange1 = new Orange("mandarin", "sweet", true);
		Orange orange2 = new Orange("mandarin", "sweet", true);
		
		// initializing fruit Array List
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		
		// adding created objects to the arrayList
		fruitArrayList.add(apple1);
		fruitArrayList.add(apple2);
		fruitArrayList.add(apple3);
		fruitArrayList.add(lemon1);
		fruitArrayList.add(lemon2);
		fruitArrayList.add(lemon3);
		fruitArrayList.add(orange1);
		fruitArrayList.add(orange2);
		
		// printing the fruit arrayList
		for (Fruit fruit : fruitArrayList) {
			System.out.println(fruit + "\n");
			System.out.println("**********");
		}
		

		// calculating average sourness
		int sum = 0;
		int count = 0;
		for (Fruit fruit : fruitArrayList) {
			if (fruit instanceof Lemon) {              // checking if object is instance of Lemon
				sum += ((Lemon) fruit).getSourness();  // type casting fruit to lemon and getting sourness value
				count += 1;							   // if condition satisfies we also increment count for average
			}
		}
		double avgSourness = sum / count;

		System.out.println("The average sourness of lemons is: " + avgSourness);
		System.out.println("**********");
		
		
		
		// create a temporary arrayList 
		ArrayList<Fruit> fruitTemp = new ArrayList<Fruit>();
		// looping through the list if new object append else skip
		for (Fruit dup : fruitArrayList) {
			if (!fruitTemp.contains(dup)) {
				fruitTemp.add(dup);
			}
		}
		
		// giving list without duplicates to fruitArrayList
		fruitArrayList = fruitTemp;
		
		// printing the remaining objects
		for (Fruit fruit : fruitArrayList) {
			System.out.println(fruit + "\n");
			System.out.println("**********");
		}
	}
}
