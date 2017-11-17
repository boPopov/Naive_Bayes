package BayesianCasificator;

public class TestKnowledge {
	
	double mean_avgGrade_midSchool;
	double var_avgGrade_midSchool;
	double midSchool_gim;
	double midSchool_struc;
	double mean_avgGrade_firstYear;
	double var_avgGrade_firstYear;
	double subjectsNotPassed0;
	double subjectsNotPassed1to2;
	double subjectsNotPassed3to5;
	double subjectsNotPassedAbouve5;
	
	public TestKnowledge(double mean_avgGrade_midSchool, double var_avgGrade_midSchool, double midSchool_gim,
			double midSchool_struc, double mean_avgGrade_firstYear, double var_avgGrade_firstYear,
			double subjectsNotPassed0, double subjectsNotPassed1to2, double subjectsNotPassed3to5,
			double subjectsNotPassedAbouve5) {
		this.mean_avgGrade_midSchool = mean_avgGrade_midSchool;
		this.var_avgGrade_midSchool = var_avgGrade_midSchool;
		this.midSchool_gim = midSchool_gim;
		this.midSchool_struc = midSchool_struc;
		this.mean_avgGrade_firstYear = mean_avgGrade_firstYear;
		this.var_avgGrade_firstYear = var_avgGrade_firstYear;
		this.subjectsNotPassed0 = subjectsNotPassed0;
		this.subjectsNotPassed1to2 = subjectsNotPassed1to2;
		this.subjectsNotPassed3to5 = subjectsNotPassed3to5;
		this.subjectsNotPassedAbouve5 = subjectsNotPassedAbouve5;
	}
	
}
