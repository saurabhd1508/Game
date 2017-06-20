package play.game.cricket;

import java.io.IOException;
import java.util.Scanner;

public class TeamA 
{
	Player[] players = new Player[11];
	
	public Player[] addPlayers() throws IOException 
	{
		
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<1;i++)
		{
			Player p = new Player();

			System.out.println("Enter ID");
			int id = sc.nextInt();
			p.setPlayerId(id);
		
			System.out.println("Enter Name");
			String name = sc.next();
			p.setName(name);
		
			System.out.println("Enter age");
			int age = sc.nextInt();
			p.setAge(age);
		
			System.out.println("Enter Play Type");
			String playType = sc.next();
			p.setPlayType(playType);
			
			players[i] = p;
		}
		return players;
	}
	public void showTeam()
	{
		for(int i=0;i<1;i++)
		{
			System.out.println("ID - "+players[i].getPlayerId()+",  Name - "+players[i].getName()+",  Age - "+players[i].getAge()+",  PlayerType - "+players[i].getPlayType());
		}
	}
}
