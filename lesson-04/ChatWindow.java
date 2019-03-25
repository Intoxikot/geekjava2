
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import javax.swing.*;

public class ChatWindow extends JFrame {
	JTextArea jTextArea;
	JTextField textField;
	JPanel panel;

	public ChatWindow() throws HeadlessException {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("ICQ is back");
		setSize(400, 400);
		createContent();
		setPositions();
		setVisible(true);
	}

	private void setPositions()	{
		this.getContentPane().add(BorderLayout.CENTER, jTextArea);
		this.getContentPane().add(BorderLayout.SOUTH, panel);
	}

	private void createContent()	{
		panel = new JPanel();
		JLabel label = new JLabel("Enter text");
		textField = new JTextField(10);
		JButton sendButton = new JButton("Send");

		jTextArea = new JTextArea();
		jTextArea.setEditable(false);

		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                sendMessage();
			}}
		);
		//sendButton.addActionListener(ActionEvent -> sendMessage());

		textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyText(e.getKeyCode()).equals("Enter")) {
                    sendMessage();
                }
            }
        });

		panel.add(label);
		panel.add(textField);
		panel.add(sendButton);
	}

	public void sendMessage() {
        String text = jTextArea.getText().concat("\n");
        text = text.concat(textField.getText());
        jTextArea.setText(text);
        textField.setText("");
    }
}