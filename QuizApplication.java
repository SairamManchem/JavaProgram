package objectOriented;

import java.util.Scanner;

public class QuizApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		quiz.begin();
	}

}


class Quiz{
	void begin(){
		Question q1 = new Question("Capital Of ANDHRA","Hyderabad","Chennai","Amaravathi","Mumbai",new Answer("Amaravathi"));
		Question q2 = new Question("Capital Of Tamil","Hyderabad","Chennai","Amaravathi","Mumbai", new Answer("Chennai"));
		Question q3 = new Question("Capital Of Telangana","Hyderabad","Chennai","Amaravathi","Mumbai",new Answer("Hyderabad"));
		Question q4 = new Question("Capital Of Maharastra","Hyderabad","Chennai","Amaravathi","Mumbai",new Answer("Mumbai"));
		Question questionArray[] = {q1,q2,q3,q4};
		int countCorrect = 0;
		int countWrong = 0;
		int countTotal = 0;
		for(Question q:questionArray) {
			System.out.println(q.getQuestion());
			System.out.println("A. "+q.getOption1());
			System.out.println("B. "+q.getOption2());
			System.out.println("C. "+q.getOption3());
			System.out.println("D. "+q.getOption4());

			System.out.println("/n Enter an Option");
			Scanner scanner = new Scanner(System.in);
			char option = scanner.next().charAt(0);
			String answer ="";
			switch(option)
			{
			case 'A':
				answer = q.getOption1();
				break;
			case 'B':
				answer = q.getOption2();
				break;
			case 'C' :
				answer = q.getOption3();
				break;
			case 'D':
				answer = q.getOption4();
				break;
			default:break;
			}

			if(answer.equals(q.answer.getAnswer())) {
				System.out.println("-------------------");
				System.out.println("Correct Answer");
				System.out.println("---------------------");
				countCorrect++;
			}else {
				System.out.println("-------------------");
				System.out.println("Wrong Answer");
				System.out.println("---------------------");
				countWrong++;
			}
			System.out.println("\n=======================\n");
			countTotal++;
		}
		ResultOne result = new ResultOne(countTotal, countCorrect, countWrong);
		result.showResult();
	}
}
class Question{
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	Answer answer;
	public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public String getOption2() {
		return option2;
	}
	public String getOption3() {
		return option3;
	}
	public String getOption4() {
		return option4;
	}
	public Answer getAnswer() {
		return answer;
	}


}
class Answer{
	String answer;

	public Answer(String answer) {
		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}


}

interface IResult{
	void showResult();
	double showPercentage(int correctAnswers,int totalQuestions);
	String showPerformance(double percentage);
}

class ResultOne implements IResult{

	int totalQuestions;
	int correctAnswers;
	int wrongAnswers;

	public ResultOne(int totalQuestions,int  correctAnswers,int wrongAnswers) {
		this.totalQuestions=totalQuestions;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
	}

	public void showResult() {
		System.out.println("Your Result: ");
		System.out.println("Total Questions: "+totalQuestions);
		System.out.println("Correct Answers: "+correctAnswers);
		System.out.println("Wrong Answers: "+wrongAnswers);
		System.out.println("Percentage :" +showPercentage(correctAnswers, totalQuestions));
		System.out.println("Performance:"+showPerformance(showPercentage(correctAnswers, totalQuestions)));


	}

	public double showPercentage(int correctAnswers, int totalQuestions) {
		return ((double)correctAnswers/totalQuestions)*100;
	}

	public String showPerformance(double percentage) {
		String performance="";
		if(percentage>60) {
			performance="Good";
		}else if(percentage>40) {
			performance="poor";
		}
		return performance;
	}

}