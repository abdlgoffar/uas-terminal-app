package uas.terminal.app.helpers;

public class Count {
    public static Integer valueCalculation(Integer numberOfQuestion, Integer questionsAnsweredCorrectly) {
        Integer maxValue = 100;
        Integer maxValueDividedNumberOfQuestion = maxValue / numberOfQuestion;
        Integer calculationValueAssessment = maxValueDividedNumberOfQuestion;

        Integer value = questionsAnsweredCorrectly * calculationValueAssessment;
        return value;
    }
}
