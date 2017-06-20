package play.game.cricket;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public void createTeams() throws IOException
	{
		System.out.println("** Team A **");
		TeamA aTeam = new TeamA();
		aTeam.addPlayers();
		aTeam.showTeam();
		
		System.out.println("\n** Team B **");
		TeamB bTeam = new TeamB();
		bTeam.addPlayers();
		bTeam.showTeam();
	}
	
	public void startOver()
	{
		Scanner sc = new Scanner(System.in);
		int totalOvers = sc.nextInt();
		
		for(int j=0;j<totalOvers;j++)
		{
			System.out.println("\n***Over  "+j+"  ***\n");
			for(int i=0;i<=5;i++)
			{
				//System.out.println("Ball  "+i);
				int run = getRun();
				System.out.println("Run = "+run);
			}
		}
		
	}
	public int getRun()
	{
		//int minRun = 0,maxRun = 6;
		
		final String possibleRuns = "0123456NOW";
		int len = possibleRuns.length();
		int run= 0;
		Random r = new Random();
		//int run = minRun + (int)(Math.random() * ((maxRun - minRun) + 1));
		//int run = r.nextInt((maxRun-minRun)+1)+minRun;

		run = (possibleRuns.charAt(r.nextInt(len)));
		
		return run;
	}
	public static void main(String[] args) throws IOException
	{
		Game startGame = new Game();
		//startGame.createTeams();
		startGame.startOver();
	}
}
