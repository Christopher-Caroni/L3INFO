package fil.coo.quiz;

import fil.coo.answers.AnswerFactory;

import java.io.*;

public class QuizFactory {

    /**
     * Creates a {@link Question} from raw string inputs
     *
     * @param rawQuestion the input text for the question
     * @param rawAnswer   the input text for the answer
     * @param rawNbPoints the input text for the number of points of this question
     * @return a Question created from the 3 parameters
     * @throws IOException if inputPointText is not a number
     */
    public Question createQuestion(String rawQuestion, String rawAnswer, String rawNbPoints)
            throws IOException {
        try {
            int nbPoints = Integer.parseInt(rawNbPoints);
            return new Question(rawQuestion, AnswerFactory.FACTORYANSWER.buildAnswer(rawAnswer), nbPoints);
        } catch (NumberFormatException e) {
            throw new IOException("rawNbPoints is not a number");
        }
    }

    /**
     * Creates a {@link Quiz} from a text file.
     *
     * @param filePath the path to the quiz in text form.
     * @return a {@link Quiz} with all the questions and answers read from the text file.
     * @throws IOException if the file cannot be found or an answer/number of points cannot be found for one question
     */
    public Quiz createQuizFromTextFile(String filePath) throws IOException {
        Quiz questionnaire = new Quiz();
        File source = new File(filePath);

        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String rawQuestionText;

            // read block of 3 lines : text, answer and number of points
            while ((rawQuestionText = in.readLine()) != null) {
                String rawAnswerText = in.readLine();
                String rawNbPointsText = in.readLine();
                if (rawAnswerText == null || rawNbPointsText == null) {
                    throw new IOException("Cannot find text for this question's answer or number of points");
                }
                questionnaire.addQuestion(this.createQuestion(rawQuestionText, rawAnswerText, rawNbPointsText));
            }

        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }

        return questionnaire;
    }
}



