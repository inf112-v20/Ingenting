package inf112.ingenting.roborally.gui;

import com.strongjoshua.console.CommandExecutor;
import inf112.ingenting.roborally.cards.ProgrammingCard;

public class MyCommandExecutor extends CommandExecutor {

	public void executeCard(int a, int b){
		System.out.println("Should execute a programming card");
		System.out.println(a);
	}

	public void connect(){
		System.out.println("Connects two players");
	}

	public void displayCards(){
		console.log("Ørjan");
	}

}
