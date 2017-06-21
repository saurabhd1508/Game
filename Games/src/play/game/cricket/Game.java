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
		sc.close();
		int ballsInOver=0,runsInOver=0, runInNum=0, extrasInOver=0, totalExtras=0, legByes=0, byes=0, noBallRuns=0, wideRuns=0, wickets=0;
		
		for(int j=1;j<=totalOvers;j++)
		{
			System.out.println("\n***  Over  "+j+"  ***\n");
			for(int i=1;i<=6;i++)
			{
				ballsInOver++;
				char run = getRun();
				
				if(run=='N')
				{
					System.out.println("Ohh...!!! Its a NO ball, you need to ball again...");
					//i=i-1;
					//ballsInOver--;
					noBallRuns++;
					extrasInOver++;
					run=getRun();
				}else if(run=='W')
				{
					System.out.println("Ohh...!!! Its a WIDE ball, you need to ball again...");
					//i=i-1;
					//ballsInOver--;
					wideRuns++;
					extrasInOver++;
					run=getRun();
				}else if(run=='B')
				{
					byes++;
					extrasInOver++;
				}else if(run=='L')
				{
					legByes++;
					extrasInOver++;
				}
				else if(run=='O')
				{
					wickets++;
					System.out.println("Ohh...!!! Its OUT");
				}
				else
				{
					runInNum = Character.getNumericValue(run);
					//System.out.println("Run in num = "+runInNum);
					runsInOver = runsInOver + runInNum;
				}
			}
			System.out.println("Total Balls played in a over "+ballsInOver);
			System.out.println("\nTotal Extras - "+extrasInOver +" (Byes - "+byes+", LegByes - "+legByes+", Wide - "+wideRuns+", No - "+noBallRuns+")");
			System.out.println("\nTotal Runs "+runsInOver);
			runsInOver = runsInOver+extrasInOver;
			System.out.println("\nTotal Runs with extras in "+j+" over "+runsInOver);
			System.out.println("Total Wickets in a over "+wickets);
			
		}
	}
	public char getRun()
	{
		String possibleRuns = "0123456NOWBL";
		int min = 0,max = 11;
		
		//max = possibleRuns.length()-1;
		//System.out.println("min "+min+" max "+max);
		
		char[] pr = possibleRuns.toCharArray(); 
		//int len = possibleRuns.length();
		char run;
		Random r = new Random();
		//int run = minRun + (int)(Math.random() * ((maxRun - minRun) + 1));
		
		int pos = r.nextInt((max-min)+1)+min;
		
		//System.out.println("Position is "+pos);
		//run = (possibleRuns.charAt(r.nextInt(len)));
		
		run = pr[pos];
		System.out.println("Run - "+run);
		return run;
	}
	public static void main(String[] args) throws IOException
	{
		Game startGame = new Game();
		//startGame.createTeams();
		startGame.startOver();
	}
}
