public class Chatbot {

    private FAQData faqData;

    public Chatbot() {
        faqData = new FAQData();
    }

    public String respond(String userInput) {

        // NLP preprocessing
        userInput = userInput.trim().toLowerCase();

        return faqData.getResponse(userInput);
    }
}