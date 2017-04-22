package CircularTable;

import java.util.Scanner;

public class Stage2FinalCodeSkippingOneAtATime {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		noOfPeople = Total no. of people at the starting who are sitting around a circular table
		swordWithInitially = person's no. who has the sword initially or we can say the staring point or reference point
		lastManStanding = person who survives at the end 
		positionSurvived = Difference between starting point and the person who survives at the end
		 */
		int lastManStanding, swordWithInitially, noOfPeople, positionSurvived, power;

		boolean flag = true, flag1 = true, flag2 = true;

		System.out.println("Hello");
		System.out.println("What would you like to do: ");
		System.out.println(
				"1. Like to find out who survives, when total number on people and who is having sword initially are known.");
		System.out.println(
				"2. like to find the number of people, when who survies and who is having sword initially are known.");
		System.out.println(
				"3. like to find out who is having sword initially , when who survies and the number of people are known.");
		System.out.println(
				"4. like to find out best optimized solution for who is having sword initially and also the number of people , when who survies is known.");
		System.out.println("Please make a selection::");
		int option = scan.nextInt();

		if (option == 1) {
			System.out.println("Enter the number of people sitting around a circular table:");
			noOfPeople = scan.nextInt();
			System.out.println("Enter the person's number with whom the sword is initially :");
			swordWithInitially = scan.nextInt();
			if (swordWithInitially > noOfPeople) {
				flag = false;
			}
			if (flag == true && swordWithInitially != 0 && noOfPeople != 0) {
				// Calculating Difference :
				power = powerCalculation(noOfPeople);
				positionSurvived = (int) (2 * (noOfPeople - Math.pow(2, power)));
				lastManStanding = positionSurvived + swordWithInitially;
				if (lastManStanding > noOfPeople) {
					lastManStanding = lastManStanding - noOfPeople;
				}
				System.out.println("Last man left: " + lastManStanding);
			} else {
				System.out.println("Person having sword can not be greater than total no. of people");
				System.out.println("And neither of 'no. of people' and 'Person having sword' can be zero");
			}
		} else if (option == 2) {
			System.out.println("Enter the number of person who survives at the end:");
			lastManStanding = scan.nextInt();
			System.out.println("Enter the person's number with whom the sword is initially :");
			swordWithInitially = scan.nextInt();
			int minValue;
			if (swordWithInitially != 0 && lastManStanding != 0) {
				if (lastManStanding >= swordWithInitially) {
					positionSurvived = lastManStanding - swordWithInitially;
					if (positionSurvived % 2 == 0) {
						noOfPeople = lastManStanding;
						while (flag2) {
							if (positionSurvived == (int) (2
									* (noOfPeople - Math.pow(2, (int) (Math.log(noOfPeople) / Math.log(2)))))) {
								flag2 = false;
							} else {
								noOfPeople++;
							}
						}
						System.out.println("Number of people at the starting were : '" + noOfPeople + "'");
					} else {
						System.out.println("The pair 'Person having sword' and 'last man survive' in not valid");
						System.out.println("i.e if Sword is with '" + swordWithInitially
								+ "' person initially and the last person to survive is '" + lastManStanding
								+ "' , then there in no possible value for 'no. of people' which will work for it");
					}
				} else {
					double pow = (Math.log(swordWithInitially) / Math.log(2));
					double integerPart = Math.floor(pow);
					if (pow - integerPart == 0.0) {
						minValue = swordWithInitially;
						flag1 = false;
					} else {
						minValue = (int) (2 * (swordWithInitially - Math.pow(2, (int) pow)));
					}
					if (lastManStanding >= minValue) {
						noOfPeople = swordWithInitially + (lastManStanding - minValue);
					} else {
						if (flag1) {
							power = powerCalculation(swordWithInitially) + 2;
						} else {
							power = powerCalculation(swordWithInitially) + 1;
						}
						int nextTwosPower = (int) Math.pow(2, power);
						noOfPeople = nextTwosPower - (swordWithInitially - lastManStanding);
					}
					System.out.println("Number of people at the starting were : '" + noOfPeople + "'");
				}

			}else{
				System.out.println("And neither of 'Person having sword' and 'last man survive' can be zero");
			}
		} else if (option == 3) {
			System.out.println("Enter the number of people sitting around a circular table:");
			noOfPeople = scan.nextInt();
			System.out.println("Enter the number of person who survives at the end:");
			lastManStanding = scan.nextInt();
			if (lastManStanding > noOfPeople) {
				flag = false;
			}
			if (flag == true && noOfPeople != 0 && lastManStanding != 0) {
				power = powerCalculation(noOfPeople);
				positionSurvived = (int) (2 * (noOfPeople - Math.pow(2, power)));
				swordWithInitially = lastManStanding - positionSurvived;
				if (swordWithInitially < 1) {
					swordWithInitially = noOfPeople + swordWithInitially;
				}
				System.out.println("Sword initially was with : '" + swordWithInitially + "' position person");
			} else {
				System.out.println("'Last person survive' can not be greater than total no. of people");
				System.out.println("And neither of 'no. of people' and 'last man survive' can be zero");
			}
		} else if (option == 4) {
			System.out.println("Enter the number of person who survives at the end:");
			lastManStanding = scan.nextInt();
			noOfPeople =lastManStanding;
			if (lastManStanding > noOfPeople) {
				flag = false;
			}
			if (flag == true && noOfPeople != 0 && lastManStanding != 0) {
				power = powerCalculation(noOfPeople);
				positionSurvived = (int) (2 * (noOfPeople - Math.pow(2, power)));
				swordWithInitially = lastManStanding - positionSurvived;
				if (swordWithInitially < 1) {
					swordWithInitially = noOfPeople + swordWithInitially;
				}
				System.out.println("Sword initially was with : '" + swordWithInitially + "' position person and the 'no of people' in the starting were : '"+noOfPeople+"'");
			} else {
				System.out.println("'Last person survive' can not be greater than total no. of people");
				System.out.println("And neither of 'no. of people' and 'last man survive' can be zero");
			}
		} else {
			System.out.println("Selected option is incorrect");
		}

	}

	public static int powerCalculation(int numberOfPeople) {
		return (int) (Math.log(numberOfPeople) / Math.log(2));
	}
}