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
		int currentBall=1,totalBallsInOver=0,currentOver=0, runsInOver=0, runCharToNum=0, extrasInOver=0, totalExtras=0, legByes=0, byes=0, noBallRuns=0, wideRuns=0, wickets=0;
		int bRun= 0;
		for(int j=1;j<=totalOvers;j++)
		{
			currentBall=1;
			System.out.println("\n***  Over  "+j+"  ***\n");
			for(int i=1;i<=6;i++)
			{
				char run = getRun();
				
				if(run=='N')
				{
					System.out.println(currentOver+"."+(currentBall)+" - "+run+" - NO ball...");
					//System.out.println("NO ball...");
					//i=i-1;
					//ballsInOver--;
					noBallRuns++;
					//extrasInOver = extrasInOver+1;;
					//run=getRun();
					totalBallsInOver=currentBall;
					currentBall++;
					i--;
				}else if(run=='W')
				{
					System.out.println(currentOver+"."+(currentBall)+" - "+run+" - WIDE ball...");
					//System.out.println("WIDE ball...");
					//i=i-1;
					//ballsInOver--;
					wideRuns++;
					//extrasInOver = extrasInOver+1;
					//run=getRun();
					totalBallsInOver=currentBall;
					currentBall++;
					i--;
				}else if(run=='B')
				{
					bRun=  calculateByesRuns();
					System.out.println(currentOver+"."+currentBall+" - "+bRun+" - Byes...");
					byes = byes+bRun;
					//extrasInOver = extrasInOver+byes;
					totalBallsInOver=currentBall;
					currentBall++;
				}else if(run=='L')
				{
					//int bRun= 0;
					bRun=  calculateByesRuns();
					System.out.println(currentOver+"."+currentBall+" - "+bRun+" - Leg Byes...");
					totalBallsInOver=currentBall;
					currentBall++;
					legByes = legByes + bRun;
					//extrasInOver = extrasInOver + legByes;
				}
				else if(run=='O')
				{
					System.out.println(currentOver+"."+currentBall+" - OUT...!!!");
					totalBallsInOver=currentBall;
					currentBall++;
					wickets++;
					//System.out.println("OUT");
				}
				else
				{
					runCharToNum = Character.getNumericValue(run);
					//System.out.println("Run in num = "+runInNum);
					
					System.out.println(currentOver+"."+currentBall+" - "+runCharToNum+" Runs");
					totalBallsInOver=currentBall;
					currentBall++;
					runsInOver = runsInOver + runCharToNum;
				}
			}
			extrasInOver = byes+legByes+wideRuns+noBallRuns;
			System.out.println("\nTotal Balls played in a over "+totalBallsInOver);
			System.out.println("\nTotal Extras - "+extrasInOver +" (Byes - "+byes+", LegByes - "+legByes+", Wide - "+wideRuns+", No - "+noBallRuns+")");
			System.out.println("\nAfter "+(currentOver+1)+" over total runs - "+runsInOver);
			runsInOver = runsInOver+extrasInOver;
			System.out.println("\nAfter "+j+" over total runs with extras - "+runsInOver);
			currentOver = currentOver+1;
		}
		System.out.println("Total Wickets "+wickets);
	}
	
	public int calculateByesRuns()
	{
		Random r = new Random();
		
		int byesRun = r.nextInt((6-1)+1)+1;
		//System.out.println("Byes Runs are - "+byesRun);
		return byesRun;
	}
	public char getRun()
	{
		String possibleRuns = "0123456NOWBL";
		int min = 0,max = 11;
		
		char[] pr = possibleRuns.toCharArray(); 
		
		char run;
		Random r = new Random();
		//int run = minRun + (int)(Math.random() * ((maxRun - minRun) + 1));
		
		int pos = r.nextInt((max-min)+1)+min;
		
		//System.out.println("Position is "+pos);
		//run = (possibleRuns.charAt(r.nextInt(len)));
		
		run = pr[pos];
		return run;
	}
	public static void main(String[] args) throws IOException
	{
		Game startGame = new Game();
		//startGame.createTeams();
		startGame.startOver();
	}
}
