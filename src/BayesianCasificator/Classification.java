package BayesianCasificator;

import java.util.*;

public class Classification {
	
	private double avgGrade;
	private int typeOfSchool;
	private double avgGradFax;
	private double numberOfNotPassedSubjectFromFirstYear;
	
	private TestKnowledge on_time; 	
	private TestKnowledge withDelay;
	private TestKnowledge notGraduate;
	
	public Classification(double avgGrade, int typeOfSchool, double avgGradFax,
			double numberOfNotPassedSubjectFromFirstYear) { 
		this.avgGrade = avgGrade;
		this.typeOfSchool = typeOfSchool;
		this.avgGradFax = avgGradFax;
		this.numberOfNotPassedSubjectFromFirstYear = numberOfNotPassedSubjectFromFirstYear;
		on_time = new TestKnowledge(4.696, 0.157664, 0.8, 0.2, 8.938, 0.53482, 0.375, 0.54, 0.042, 0.042);
		withDelay = new TestKnowledge(4.332, 0.514456, 0.6, 0.4, 8.752, 0.49989, 0.042, 0.208, 0.54, 0.208);
		notGraduate = new TestKnowledge(3.048, 0.43726, 0.2, 0.8, 6.540, 1.1024, 0.042, 0.042, 0.375, 0.54);
	}

	public String findTypeOfStudent(){
		double onTimeProbabilite = calculate(on_time); 
		double delayProbability = calculate(withDelay); 
		double notGraduateProbability = calculate(notGraduate); 
		
		double evidance = onTimeProbabilite + delayProbability + notGraduateProbability; 
		
		onTimeProbabilite /= evidance; 
		delayProbability /= evidance;
		notGraduateProbability /= evidance;
		
		if(onTimeProbabilite > delayProbability && onTimeProbabilite > notGraduateProbability)
			return "On time";
		else if(delayProbability > onTimeProbabilite && delayProbability > notGraduateProbability)
			return "Delay";
		else 
			return "Not graduate";
	}
	
	public double calculate(TestKnowledge object){
		double result = 0.3; 
		result *= NormalDistribution(avgGrade, object.mean_avgGrade_midSchool, object.var_avgGrade_midSchool); 
		if(typeOfSchool == 0)
			result *= object.midSchool_gim;
		else
			result *= object.midSchool_struc;
		result *= NormalDistribution(avgGradFax, object.mean_avgGrade_firstYear, object.var_avgGrade_firstYear); 
		if(numberOfNotPassedSubjectFromFirstYear == 0) 
			result *= object.subjectsNotPassed0;
		else if(numberOfNotPassedSubjectFromFirstYear >= 1 && numberOfNotPassedSubjectFromFirstYear <= 2)
			result *= object.subjectsNotPassed1to2;
		else if(numberOfNotPassedSubjectFromFirstYear >= 3 && numberOfNotPassedSubjectFromFirstYear <= 5)
			result *= object.subjectsNotPassed3to5;
		else
			result *= object.subjectsNotPassedAbouve5;
		return result;
	}
	
	private double NormalDistribution(double X, double mean, double variance){
		double result = 0.0;
		double x = Math.sqrt(2 * Math.PI * variance);
		double y = Math.pow(((X-mean)/(2*variance)),2);
		double calculate = Math.pow(Math.E, (y * (-1)));
		result = calculate / x;
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter avg grade from mid: ");
		double avgGrade = sc.nextDouble();
		System.out.print("\nTip na sredno skolo (Za gimnazija se vnesuva 0, za strucno skolo se vnesuva 1): ");
		int typeOfSchool = sc.nextInt();
		System.out.print("\nProsek od prva godina na fakultet: ");
		double avgGradeFax = sc.nextDouble();
		System.out.print("\nBroj na ne polozeni predmeti od prva godina (0 ne polozeni predmeti - 0 ; 1/2 za 1 ili 2 ne polozeni predmeti ;\n 3/4/5 za ne polozeni predmeti od 3 do 5 ; i se nad 5 se odnesuva za povekje od 5 ne polozeni predmeti): ");
		double numberOfNotPassedSubjectFromFirstYear = sc.nextInt();
		
		Classification classification = new Classification(avgGrade,typeOfSchool,
				avgGradeFax,numberOfNotPassedSubjectFromFirstYear);
		
		System.out.println(classification.findTypeOfStudent());
		sc.close();
	}
	
}
