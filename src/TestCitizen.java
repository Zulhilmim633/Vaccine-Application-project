import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.StringTokenizer;

public class TestCitizen extends JFrame implements ActionListener{

	private Container cont;
	private JButton btnAdd, btnRemove, btnUpdate, btnContinue;
	private JLabel lblLoader;
	private LinkedList<Citizen> CitizenList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		LinkedList<Citizen> citizenlist = new LinkedList<>();
		try {
			//Read file
            BufferedReader br = new BufferedReader(new FileReader("Citizen.txt"));
            Citizen citizen;

            String line = br.readLine();
			//Loop until line == null
            while (line != null) {
				//Using StringTokenizer with ";" delimeter
                StringTokenizer st = new StringTokenizer(line, ";");
                String name = st.hasMoreTokens() ? st.nextToken() : null;
                String ic = st.hasMoreTokens() ? st.nextToken() : null;
                String state = st.hasMoreTokens() ? st.nextToken() : null;
                int age = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
                String category = st.hasMoreTokens() ? st.nextToken() : null;
                String stat1stDose = st.hasMoreTokens() ? st.nextToken() : null;
                String stat2ndDose = st.hasMoreTokens() ? st.nextToken() : null;
                String certificate = st.hasMoreTokens() ? st.nextToken() : null;
				
                citizen = new Citizen(name, ic, state, age, category, stat1stDose, stat2ndDose, certificate);
                citizenlist.add(citizen);

                line = br.readLine();
            }

			//Close file
            br.close();

		//Catch some erorr and print to user
        } catch (EOFException ex) {
			System.out.println("End of file error");
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("Wrong input!!!");
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		//Create new TestCitizen object
		TestCitizen frame = new TestCitizen(citizenlist);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public TestCitizen(LinkedList<Citizen> CitizenList) {
		super("Citizen");

		this.CitizenList = CitizenList;

		cont = getContentPane();
        cont.setLayout(null);
        
        lblLoader = new JLabel(CitizenList.size()+" Citizen have loaded");
        lblLoader.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoader.setBounds(10, 23, 295, 13);
        cont.add(lblLoader);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(10, 55, 88, 21);
		btnAdd.addActionListener(this);
        cont.add(btnAdd);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBounds(115, 55, 88, 21);
		btnRemove.addActionListener(this);
        cont.add(btnRemove);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(217, 55, 88, 21);
		btnUpdate.addActionListener(this);
        cont.add(btnUpdate);
        
        btnContinue = new JButton("Continue");
        btnContinue.setBounds(217, 96, 88, 21);
		btnContinue.addActionListener(this);
        cont.add(btnContinue);

		setBounds(200, 200, 450, 300);
        setSize(329,178);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		//Button add function
		if(e.getSource() == btnAdd){
			Form frame = new Form("ADD", CitizenList, new Citizen());
			frame.setVisible(true);
			dispose();
			return;
		}
		//Button Continue function
		else if(e.getSource() == btnContinue){
			Stack<Citizen> stCenter1, stCenter2, stCenter3;
			Queue<Citizen> qCenter1, qCenter2, qCenter3;
			
			stCenter1 = new Stack<>();
			stCenter2 = new Stack<>();
			stCenter3 = new Stack<>();
			
			qCenter1 = new LinkedList<>();
			qCenter2 = new LinkedList<>();
			qCenter3 = new LinkedList<>();

			LinkedList<Citizen> completedList =  new LinkedList<>();
			
			int size = CitizenList.size();
			for (int i = 0; i < size; i++) {
				Citizen person = CitizenList.removeLast();
				//If person age is greater or equal 18 and below or equal 30 
				if(person.getAge() >= 18 & person.getAge() <= 30){

					//If person 2nd dose is complete
					if(person.getStat2ndDose() != null){

						//Add to complete list
						completedList.add(person);

						//Continue with next person
						continue;
					}
					//If person 1st dose is complete
					else if(person.getStat1stDose() != null){

						//Add to desire queue center
						qCenter1.add(person);

						//Continue with next person
						continue;
					}
					//If person does not inject yet
					else{

						//Add to desire Stack center
						stCenter1.add(person);

						//Continue with next person
						continue;
					}
				}
				//If person age is greater or equal 31 and below or equal 49
				else if(person.getAge() >= 31 & person.getAge() <=49){

					//If person 2nd dose is complete
					if(person.getStat2ndDose() != null){

						//Add to complete list
						completedList.add(person);

						//Continue with next person
						continue;
					}
					//If person 1st dose is complete
					else if(person.getStat1stDose() != null){

						//Add to desire queue center
						qCenter2.add(person);

						//Continue with next person
						continue;
					}
					//If person does not inject yet
					else{

						//Add to desire Stack center
						stCenter2.add(person);

						//Continue with next person
						continue;
					}
				}
				//If person age is more or equal 50
				else if(person.getAge() >= 50){

					//If person 2nd dose is complete
					if(person.getStat2ndDose() != null){

						//Add to complete list
						completedList.add(person);

						//Continue with next person
						continue;
					}
					//If person 1st dose is complete
					else if(person.getStat1stDose() != null){

						//Add to desire queue center
						qCenter3.add(person);

						//Continue with next person
						continue;
					}
					//If person does not inject yet
					else{

						//Add to desire Stack center
						stCenter3.add(person);

						//Continue with next person
						continue;
					}
				}
			}

			//Continue with next frame
			Vaccination frame = new Vaccination(stCenter1, stCenter2, stCenter3,qCenter1, qCenter2, qCenter3,completedList);
			frame.setVisible(true);
			dispose();
			return;
		}

		//Ask user to input the IC 
		String ic = JOptionPane.showInputDialog(null, "Insert IC", "IC", JOptionPane.QUESTION_MESSAGE);
		int Person_num = -1;
		for (int i = 0; i < CitizenList.size(); i++) {
			//Find citizen based on IC that user input
			if(CitizenList.get(i).getIc().equalsIgnoreCase(ic)) {
				Person_num = i;
				break;
			}
		}
		//Exit if user doesn't put IC
		if(ic == null)
			return;

		//Exit if system can't find IC
		if(Person_num == -1){
			JOptionPane.showMessageDialog(null, "Citizen with " + ic + " not existed","Not Found", JOptionPane.WARNING_MESSAGE);
			return;
		}

		//Button remove function
		if(e.getSource() == btnRemove){

			//Show confirmation box
			int reply = JOptionPane.showConfirmDialog(null, CitizenList.get(Person_num), "Are you sure to delete this citizen", JOptionPane.YES_NO_OPTION);

			//If user press yes to delete
			if (reply == JOptionPane.YES_OPTION) {
				CitizenList.remove(Person_num);
			}
		}

		//Button update function
		else if (e.getSource() == btnUpdate) {
			Form frame = new Form("UPDATE", CitizenList, CitizenList.get(Person_num));
			frame.setVisible(true);
			dispose();
		}
	}
}
