import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Chatbot chatbot;

    public ChatbotGUI() {

        chatbot = new Chatbot();

        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    private void sendMessage() {

        String userText = inputField.getText();

        if (!userText.isEmpty()) {

            chatArea.append("You: " + userText + "\n");

            String response = chatbot.respond(userText);

            chatArea.append("Bot: " + response + "\n\n");

            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}