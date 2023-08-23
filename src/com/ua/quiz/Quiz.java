package com.ua.quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz implements ActionListener{

	
	// creating variathions of asks
	String[] questions  = 	{
							"Which company created Java?",
							"Wich year was Java created?",
							"What was Java originaly called?",
							"Who is credited with creating Java?"
							};
	// creating variathions of answers
	String[][] options = {
						{"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"},
						{"1989", "1996", "1972", "1492"},
						{"Apple", "Latte", "Oak", "Koffing"},
						{"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zukerberg"}
						 };
	char [] answers = {
						'A',
						'B',
						'C',
						'C'
					  };
	// create variables
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_quiestions = questions.length;
	int result;
	int second=10;
	
	// create objects of awt/swing
	JFrame frame = new JFrame(); // window 
	JTextField textfield = new JTextField(); //small input in one line 
	JTextArea textarea = new JTextArea(); //input in diferent line
	JButton buttonA = new JButton(); 
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondLeft = new JLabel();
	JTextField numberRigt = new JTextField();
	JTextField percentage = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			second--;
			secondLeft.setText(String.valueOf(second));
			if(second<=0) {
				displayAnswer();
			}
		
		}
	});
	
	// create constructor
	public Quiz() {
		// assigning values to objects
		// frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(58, 50, 50));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		// textfield title1
		textfield.setBounds(0, 0, 650, 50);
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Arial", Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		// textarea title2
		textarea.setBounds(0, 50, 650, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);		
		textarea.setBackground(new Color(25, 25, 25));
		textarea.setForeground(new Color(25, 255, 0));
		textarea.setFont(new Font("Arial", Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		// butonns
		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font("Arial", Font.CENTER_BASELINE, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		
		answerLabelA.setBounds(125, 100, 500, 100);
		answerLabelA.setBackground(new Color(50, 50, 50));
		answerLabelA.setForeground(new Color(25, 255, 0));
		answerLabelA.setFont(new Font("Arial", Font.PLAIN, 35));
		answerLabelA.setText("test");
		answerLabelA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		answerLabelA.setOpaque(true);
		
		
		answerLabelB.setBounds(125, 200, 500, 100);
		answerLabelB.setBackground(new Color(50, 50, 50));
		answerLabelB.setForeground(new Color(25, 255, 0));
		answerLabelB.setFont(new Font("Arial", Font.PLAIN, 35));
		answerLabelB.setText("test");
		answerLabelB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		answerLabelB.setOpaque(true);
		
		answerLabelC.setBounds(125, 300, 500, 100);
		answerLabelC.setBackground(new Color(50, 50, 50));
		answerLabelC.setForeground(new Color(25, 255, 0));
		answerLabelC.setFont(new Font("Arial", Font.PLAIN, 35));
		answerLabelC.setText("test");
		answerLabelC.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		answerLabelC.setOpaque(true);
		
		answerLabelD.setBounds(125, 400, 500, 100);
		answerLabelD.setBackground(new Color(50, 50, 50));
		answerLabelD.setForeground(new Color(25, 255, 0));
		answerLabelD.setFont(new Font("Arial", Font.PLAIN, 35));
		answerLabelD.setText("test");
		answerLabelD.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		answerLabelD.setOpaque(true);
		// Timer
	
		secondLeft.setBounds(535, 510, 100, 100);
		secondLeft.setBackground(new Color(50, 50, 50));
		secondLeft.setForeground(new Color(255, 0, 0));
		secondLeft.setFont(new Font("Arial", Font.PLAIN, 60));
		secondLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondLeft.setOpaque(true);
		secondLeft.setHorizontalAlignment(JTextField.CENTER);
		secondLeft.setText(String.valueOf(second));
		
		timeLabel.setBounds(400, 510, 100, 100);
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		timeLabel.setText("Timer >:D");
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setForeground(new Color(255, 0, 0));
		timeLabel.setBackground(new Color(50, 50, 50));
		
		numberRigt.setBounds(225, 225, 200, 100);
		numberRigt.setBackground(new Color(25, 25, 25));
		numberRigt.setForeground(new Color(25, 255, 0));
		numberRigt.setFont(new Font("Arial", Font.PLAIN, 50));
		numberRigt.setBorder(BorderFactory.createBevelBorder(1));
		numberRigt.setHorizontalAlignment(JTextField.CENTER);
		numberRigt.setEditable(false);
		
		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Arial", Font.PLAIN, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		// building all together
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(answerLabelD);
		frame.add(secondLeft);
		frame.add(timeLabel);
		
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		
		if(index>=total_quiestions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answerLabelA.setText(options[index][0]);
			answerLabelB.setText(options[index][1]);
			answerLabelC.setText(options[index][2]);
			answerLabelD.setText(options[index][3]);
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonB) {
			answer = 'B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonC) {
			answer = 'C';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonD) {
			answer = 'D';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
	}
	
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A') 
			answerLabelA.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'B') 
			answerLabelB.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'C') 
			answerLabelC.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'D') 
			answerLabelD.setForeground(new Color(255, 0, 0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answerLabelA.setForeground(new Color(25, 255, 0));
				answerLabelB.setForeground(new Color(25, 255, 0));
				answerLabelC.setForeground(new Color(25, 255, 0));
				answerLabelD.setForeground(new Color(25, 255, 0));
			
				answer = ' ';
				second = 10;
				secondLeft.setText(String.valueOf(second));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
		
	}
	
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)(correct_guesses/(double)total_quiestions*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answerLabelA.setText("");
		answerLabelB.setText("");
		answerLabelC.setText("");
		answerLabelD.setText("");
		
		numberRigt.setText("("+correct_guesses+"/"+total_quiestions+")");
		percentage.setText(result+"%");
		
		frame.add(numberRigt);
		frame.add(percentage);
		
	}
	
	
	
}
