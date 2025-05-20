
import java.util.*;
public class txtnetadventure {
   // public static void main(String[] args) {
   // 	Scanner read = new Scanner(System.in);
   //     txtnetadventure obj = new txtnetadventure();
   //     obj.intro();

   // }
	public void intro() {


		Scanner read = new Scanner(System.in);
		
		
		System.out.println("Welcome to Soul City, a mystical place, home to the world of Mobius's finest creatures.");
		delay();
		System.out.println("For many creatures, it's a place of refuge from the wildlands, where demons of darkness prowel in the shadows.");
		delay();
		System.out.println("You recently moved into the city hoping for a fresh new life.");
		delay();
		System.out.println("Let the adventure Begin!");
		delay();
		System.out.println("Where to first?");
		System.out.println("1) The Chaos Chambers");
		System.out.println("2) The New's Station");;
		System.out.println("3) The Palace");
		
	
		
		int choice1 = 0;
		choice1 = read.nextInt();
		if (choice1 == 1)
		{
			chambers();
		}
		if (choice1 == 2)
		{
			news();
		}
		if (choice1 == 3)
		{
			palace();
		}

		
		
		
	
		
	}
	
public void chambers()
{
	Scanner read = new Scanner(System.in);

	System.out.println("You approched the chambers. Legend says that the chamber was sealed long ago, after the previous ruler contracted an chaotic crave for power.");
	delay();
	System.out.println("Since then, no one has entered the chamber");


	System.out.println("Tall Pillars tower over you, making you feel a sense of dread.");
	delay();
	delay();
	System.out.println("As you reach closer to the end, you feel like someone is watching you");
	delay();
	delay();
	System.out.println("However, you press on.");
	System.out.println("As you approch the chambers you feel a sense of power on the other side of the door.");
	delay();
	delay();
	System.out.println("The door is locked.");
	delay();
	delay();	
	System.out.println("You look behind you and are confronted by a robot.");
	delay();
	delay();
	System.out.println("Within moments you dodge and evade his attacks, and`find your way into a small opening");
	delay();
	delay();
	System.out.println("You find yourself inside the chamber, and see the great power, a giant red emerald");
	delay();
	delay();
	System.out.println("The emerald's power intrigues you, and you gain speed");
	delay();
	delay();
	System.out.println("However, you realize that you are trapped.");
	delay();
	delay();
	System.out.println("Ending 1/3 Locked out.");
	delay();
	delay();
	delay();
	delay();
	
	intro();

}
public void news()
{
	Scanner read = new Scanner(System.in);
	System.out.println("The News station is stagnant. Nothing news worthy has happened since the day they built this place");
	delay();
	System.out.println("The ruler thought that he would have to deal with constant conflict, how ever, with every bandit coupled up in prison,  there's no news to be shown.");
	delay();
	System.out.println("1)Enter the Station");	
	System.out.println("2)Explore the city.");
	int choice3 = 0;
	choice3 = read.nextInt();
	if (choice3 == 2)
	{
		intro();
	}
	if (choice3 == 1)
	{
	System.out.println("This Content is LOCKED | Play the Full game at https://www.net.com (Fake)");
	delay();
	delay();
	delay();
	delay();
	}
	
}
public void palace()
{
	Scanner read = new Scanner(System.in);
	System.out.println("The palace is usually only for the ruler to enter.");	 
	delay();
	System.out.println("However, in this case the doors were left open");	 
	delay();
	System.out.println("Entering now will mean that you cannot escape, as the door would lock behind you.");
	delay();
	System.out.println("It is advised to look at all locations in the city before entering the palace.");	
	delay();
	System.out.println("Enter the Palace?");	
	System.out.println("Explore the city.");
	
	int choice2 = 0;
	choice2 = read.nextInt();
	if (choice2 == 2)
	{
		intro();
	}
	if (choice2 == 1)
	{
	System.out.println("This Content is LOCKED | Play the Full game at https://www.net.com (Fake)");
	delay();
	delay();
	delay();
	delay();
	}
	
	
}
public void delay() {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
	e.printStackTrace();
		}
	}
}



