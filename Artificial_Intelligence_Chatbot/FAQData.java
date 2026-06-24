import java.util.HashMap;
import java.util.Map;

public class FAQData {

    private Map<String, String> responses;

    public FAQData() {
        responses = new HashMap<>();

        responses.put("hello", "Hello! How can I help you?");
        responses.put("hi", "Hi! Nice to meet you.");
        responses.put("how are you", "I am doing great!");
        responses.put("your name", "I am an AI Chatbot developed in Java.");
        responses.put("java", "Java is a popular object-oriented programming language.");
        responses.put("bye", "Goodbye! Have a nice day.");
    }

    public String getResponse(String input) {

        input = input.toLowerCase();

        for (String key : responses.keySet()) {
            if (input.contains(key)) {
                return responses.get(key);
            }
        }

        return "Sorry, I don't understand that question.";
    }
}