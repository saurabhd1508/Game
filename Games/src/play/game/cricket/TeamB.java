package play.game.cricket;

import java.util.Scanner;

public class TeamB 
{
	Player[] players = new Player[11]; 
	
	public Player[] addPlayers()
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<1;i++)
		{
			Player p = new Player();
			
			System.out.println("Enter ID");
			int id = sc.nextInt(); 
			p.setPlayerId(id);
			
			System.out.println("Enter name");
			String name = sc.next();
			p.setName(name);
			
			System.out.println("Enter Age");
			int age = sc.nextInt();
			p.setAge(age);
			
			System.out.println("Enter player type");
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
