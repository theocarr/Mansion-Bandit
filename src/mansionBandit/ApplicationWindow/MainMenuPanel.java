package mansionBandit.ApplicationWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenuPanel extends JPanel implements ActionListener{


	GridLayout gridLayout = new GridLayout(0,1,10,10);
	//initialize panels for the menus
	JPanel startMenuPanel = new JPanel(gridLayout);
	JPanel hostLobbyMenuPanel = new JPanel(gridLayout);
	JPanel slaveLobbyMenuPanel = new JPanel(gridLayout);
	JPanel multiplayerMenuPanel = new JPanel(gridLayout);
	JPanel hostGamePanel = new JPanel(gridLayout);
	JPanel connectToGamePanel = new JPanel(gridLayout);

	//the current panel displayed
	JPanel currentPanel;

	//The frame that this menu is added to
	GameFrame gameFrame;

	//player name fields for the lobby
	JLabel player1NameLabel = new JLabel("Empty slot");
	JLabel player2NameLabel =new JLabel("Empty slot");
	JLabel player3NameLabel=new JLabel("Empty slot");
	JLabel player4NameLabel=new JLabel("Empty slot");

	//player name fields for the lobby
	JLabel clientPlayer1NameLabel = new JLabel("Empty slot");
	JLabel clientPlayer2NameLabel =new JLabel("Empty slot");
	JLabel clientPlayer3NameLabel=new JLabel("Empty slot");
	JLabel clientPlayer4NameLabel=new JLabel("Empty slot");

	//the textbox that multiplayer users into their name into
	private JTextField usernameTextField;

	private JTextField hostNameTextField;

	//the textfield clients enter the address of a host into
	private JTextField addressTextField;


	//the dimension/width and height of the textboxes in the menu
	private final Dimension textBoxDimension = new Dimension(150,25);

	//the set location and dimensions of the menu
	private final int menuX = 350;
	private final int menuY = 250;
	private final int menuH = 300;
	private final int menuW = 300;

	public MainMenuPanel(GameFrame frame){
		this.setLayout(null);
		//sets the location and dimensions of the menu
		this.setBounds(menuX, menuY, menuW, menuH);
		this.setBackground(Color.black);


		//sets the frame that this menu will be placed in
		gameFrame = frame;

		//Sets up all of buttons in the separate JPanels/Sub menus
		//this just creates them so they
		setupStartMenu();
		setupSlaveLobbyMenu();
		setupHostLobbyMenu();
		setupMultiplayerMenu();
		setupHostGameMenu();
		setupConnectToGameMenu();



		//Sets the menu to the main menu initially
		setMenu(startMenuPanel);


		this.setSize(1024,768);
		this.setLocation(0, 0);
		JLabel titleLabel = new JLabel();
		try {
			titleLabel.setIcon(new ImageIcon(ImageIO.read( this.getClass().getResource("/GUIgraphics/titlescaled.png"))));

		} catch (IOException e) {

			e.printStackTrace();
		}

		titleLabel.setBounds(150, -675, 2000, 1500);
		titleLabel.setVisible(true);
		titleLabel.repaint();

		this.add(titleLabel);
		this.repaint();

		gameFrame.pack();
		gameFrame.repaint();

	 }



	/**
	 * sets up the buttons for the first screen of the main menu
	 */
	private void setupStartMenu(){
		//set up buttons

		// creates the exit button
		JButton playButton = new JButton("Play");
		playButton.addActionListener(this);
		playButton.setActionCommand("startGame");
		//makes sure that focus is kept on the main window
		playButton.setFocusable(false);
		//adds the button to the menu
		startMenuPanel.add(playButton);


		// creates the multiplayer button
		JButton multiplayerButton = new JButton("Multiplayer");
		multiplayerButton.addActionListener(this);
		multiplayerButton.setActionCommand("setMenuMultiplayer");
		//makes sure that focus is kept on the main window
		multiplayerButton.setFocusable(false);
		startMenuPanel.add(multiplayerButton);


		// creates the tutorial button in the menu
		JButton helpButton = new JButton("Tutorial");
		helpButton.addActionListener(this);
		helpButton.setActionCommand("startTutorial");
		//makes sure that focus is kept on the main window
		helpButton.setFocusable(false);
		startMenuPanel.add(helpButton);

		// creates the exit button
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setActionCommand("exitButton");
		//makes sure that focus is kept on the main window
		exitButton.setFocusable(false);
		//adds the button to the menu panel
		startMenuPanel.add(exitButton);

		//set the position of the menu
		startMenuPanel.setBounds(menuX,menuY,menuH,menuW);
		startMenuPanel.setBackground(Color.black);
	}

	/**
	 * sets up the buttons for the first screen of the main menu
	 */
	private void setupMultiplayerMenu(){

		// creates the back button which will take the player back to the start of the main menu
		JButton connectButton = new JButton("Connect to game");
		connectButton.addActionListener(this);
		connectButton.setActionCommand("setMenuConnectToGame");

		//makes sure that focus is kept on the main window
		connectButton.setFocusable(false);

		multiplayerMenuPanel.add(connectButton);

		// creates the back button which will take the player back to the start of the main menu
		JButton hostGameButton = new JButton("Host Game");
		hostGameButton.addActionListener(this);
		hostGameButton.setActionCommand("setMenuHostGame");

		//makes sure that focus is kept on the main window
		hostGameButton.setFocusable(false);

		multiplayerMenuPanel.add(hostGameButton);

		// creates the disconnect button which will take the player back to the start of the main menu
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setActionCommand("backButton");

		//makes sure that focus is kept on the main window
		backButton.setFocusable(false);

		multiplayerMenuPanel.add(backButton);

		//set the position of the menu
		multiplayerMenuPanel.setBounds(menuX,menuY,menuH,menuW);

		multiplayerMenuPanel.setBackground(Color.black);
	}

	/**
	 * sets up the buttons for the first screen of the main menu
	 */
	private void setupConnectToGameMenu(){


		// creates the back button which will take the player back to the start of the main menu
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setActionCommand("backButton");

		//makes sure that focus is kept on the main window
		backButton.setFocusable(false);

		connectToGamePanel.add(backButton);


		// creates the back button which will take the player back to the start of the main menu
		JButton connectButton = new JButton("Connect");
		connectButton.addActionListener(this);
		connectButton.setActionCommand("setMenuSlaveLobby");

		//makes sure that focus is kept on the main window
		connectButton.setFocusable(false);

		connectToGamePanel.add(connectButton);

		JLabel addressLabel = new JLabel("Address");

		connectToGamePanel.add(addressLabel);

		//sets up text box for user to input host address
		addressTextField = new JTextField();
		//add the name textbox to the panel
		connectToGamePanel.add(addressTextField);

		//set the size of the textbox
		addressTextField.setPreferredSize(textBoxDimension);

		JLabel userNameLabel = new JLabel("Name");

		connectToGamePanel.add(userNameLabel);

		//sets up a textbox for the player to input their name
		usernameTextField = new JTextField();

		//set the size of the textbox
		usernameTextField.setPreferredSize(textBoxDimension);

		//add the name textbox to the panel
		connectToGamePanel.add(usernameTextField);

		//set the position of the menu
		connectToGamePanel.setBounds(menuX,menuY,menuH,menuW);

		connectToGamePanel.setBackground(Color.black);
	}

	/**
	 * sets up the buttons for the first screen of the main menu
	 */
	private void setupHostGameMenu(){


		// creates the back button which will take the player back to the start of the main menu
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setActionCommand("backButton");

		//makes sure that focus is kept on the main window
		backButton.setFocusable(false);

		hostGamePanel.add(backButton);


		// creates the back button which will take the player back to the start of the main menu
		JButton startHostingButton = new JButton("Start hosting");
		startHostingButton.addActionListener(this);
		startHostingButton.setActionCommand("setMenuHostLobby");

		//makes sure that focus is kept on the main window
		startHostingButton.setFocusable(false);

		hostGamePanel.add(startHostingButton);

		//sets up addressLabel
		JLabel addressLabel = new JLabel("Address");

		hostGamePanel.add(addressLabel);

		//sets up text box for user to input host address
		addressTextField = new JTextField();
		//add the name textbox to the panel
		hostGamePanel.add(addressTextField);

		//set the size of the textbox
		addressTextField.setPreferredSize(textBoxDimension);


		//sets up addressLabel
		JLabel nameLabel = new JLabel("Name");

		hostGamePanel.add(nameLabel);

		//sets up a textbox for the player to input their name
		hostNameTextField = new JTextField();

		//set the size of the textbox
		hostNameTextField.setPreferredSize(textBoxDimension);

		//add the textbox
		hostGamePanel.add(hostNameTextField);

		//set the position of the menu
		hostGamePanel.setBounds(menuX,menuY,menuH,menuW);

		hostGamePanel.setBackground(Color.black);
	}

	/**
	 * sets up the interface for lobby menu for a slave (non-host) player
	 * this screen displays the users currently connected to the host
	 */
	private void setupSlaveLobbyMenu(){

		slaveLobbyMenuPanel.removeAll();
		// creates the back button which will take the player back to the start of the main menu
		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(this);
		disconnectButton.setActionCommand("disconnectButton");

		//makes sure that focus is kept on the main window
		disconnectButton.setFocusable(false);

		slaveLobbyMenuPanel.add(disconnectButton);


		//Sets up the labels that will display the names of the players
		//JLabel player1NameLabel = new JLabel();
		slaveLobbyMenuPanel.add(clientPlayer1NameLabel);
		//JLabel player2NameLabel = new JLabel();
		slaveLobbyMenuPanel.add(clientPlayer2NameLabel);
		//JLabel player3NameLabel = new JLabel();
		slaveLobbyMenuPanel.add(clientPlayer3NameLabel);
		//JLabel player4NameLabel = new JLabel();
		slaveLobbyMenuPanel.add(clientPlayer4NameLabel);

		//set the position of the menu
		slaveLobbyMenuPanel.setBounds(menuX,menuY,menuH,menuW);

		slaveLobbyMenuPanel.setBackground(Color.black);
	}

	/**
	 * sets up the interface for lobby menu for a host player, allowing them to start the game
	 * this screen displays the users currently connected to the host
	 */
	private void setupHostLobbyMenu(){


		// creates the disconnect button which will exit from the session and bring them back to the start menu
		JButton disconnectButton = new JButton("Disconnect");
		disconnectButton.addActionListener(this);
		disconnectButton.setActionCommand("disconnectButton");

		//makes sure that focus is kept on the main window
		disconnectButton.setFocusable(false);

		hostLobbyMenuPanel.add(disconnectButton);


		//Starts the multiplayer game
		JButton startGameButton = new JButton("Start game");
		startGameButton.addActionListener(this);
		startGameButton.setActionCommand("startMultiplayerGame");

		//makes sure that focus is kept on the main window
		startGameButton.setFocusable(false);

		hostLobbyMenuPanel.add(startGameButton);



		//Sets up the labels that will display the names of the players
		//JLabel player1NameLabel = new JLabel();
		hostLobbyMenuPanel.add(player1NameLabel);
		//JLabel player2NameLabel = new JLabel();
		hostLobbyMenuPanel.add(player2NameLabel);
		//JLabel player3NameLabel = new JLabel();
		hostLobbyMenuPanel.add(player3NameLabel);
		//JLabel player4NameLabel = new JLabel();
		hostLobbyMenuPanel.add(player4NameLabel);


		//player1NameLabel.setText(gameFrame.getServer().getClient(0).getUserName());

		//set the position of the menu
		hostLobbyMenuPanel.setBounds(menuX,menuY,menuH,menuW);

		hostLobbyMenuPanel.setBackground(Color.black);
	}





	/**
	 * Changes/sets the menu. Only one sub-menu will be displayed at a time.
	 * @param the menu that is to be displayed to the user
	 */
	private void setMenu(JPanel submenu){

		//removes all current menus/panels that are displayed
		//this.removeAll();
		if(currentPanel!=null){
			this.remove(currentPanel);
		}
		//sets the current menu to submenu
		this.add(submenu);
		//set the current panel to the just added panel
		this.currentPanel = submenu;
		//ensures the newly added menu is presented to the user
		submenu.validate();
		submenu.setVisible(true);
		gameFrame.revalidate();
		gameFrame.repaint();
	}


	/**
	 * quits out of the main menu and starts the game
	 */
	private void startGame(){

		this.setVisible(false);

		gameFrame.startGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("startGame")){
			startGame();
		}
		else if(e.getActionCommand().equals("setMenuMultiplayer")){
			//set the menu to the multiplayer menu
			setMenu(multiplayerMenuPanel);
		}
		else if(e.getActionCommand().equals("setMenuHostLobby")){
			//begin hosting the game
			beginHostingGame();
			//set the menu to the multiplayer lobby menu as the host
			setMenu(hostLobbyMenuPanel);
		}
		else if(e.getActionCommand().equals("setMenuSlaveLobby")){
			//begin connecting to the game
			connectToGame();
			//set the menu to the multiplayer lobby menu as a slave
			setMenu(slaveLobbyMenuPanel);
		}
		else if(e.getActionCommand().equals("setMenuHostGame")){
			//set the menu to the multiplayer host a game menu
			setMenu(hostGamePanel);
		}
		else if(e.getActionCommand().equals("setMenuConnectToGame")){
			//set the menu to the multiplayer connect to game menu
			setMenu(connectToGamePanel);
		}
		else if(e.getActionCommand().equals("exitButton")){
			//exit the game and asks for confirmation, uses the frames exit game method
			gameFrame.exitGame();
		}
		else if(e.getActionCommand().equals("startMultiplayerGame")){
			//starts the multiplayer game. Used only be host.

		}
		else if(e.getActionCommand().equals("backButton")){
			//go back to the main menu
			setMenu(startMenuPanel);
		}
		else if(e.getActionCommand().equals("disconnectButton")){
			//TODO gameFrame.getClient.disconnect()
			//go back to the main menu
			setMenu(multiplayerMenuPanel);
		}



	}


	/**
	 * gives list of connected players
	 * @param usernameList
	 */
	public void playerHasConnected(ArrayList<String> usernameList){

		if(player2NameLabel.getText().equals("Empty slot"))
		{
			player2NameLabel.setText(usernameList.get(1));
		}
		else if(player3NameLabel.getText().equals("Empty slot"))
		{
			player3NameLabel.setText(usernameList.get(2));
		}
		else if(player3NameLabel.getText().equals("Empty slot"))
		{
			player4NameLabel.setText(usernameList.get(3));
		}
		this.repaint();
	}

	/**
	 * @param list of user names
	 */
	public void clientPlayerHasConnected(ArrayList<String> usernameList){

		if(clientPlayer1NameLabel.getText().equals("Empty slot"))
		{

			clientPlayer1NameLabel.setText(usernameList.get(0));

		}
		if(clientPlayer2NameLabel.getText().equals("Empty slot"))
		{

			clientPlayer2NameLabel.setText(usernameList.get(1));
		}
		if(clientPlayer3NameLabel.getText().equals("Empty slot"))
		{
			clientPlayer3NameLabel.setText(usernameList.get(2));
		}
		if(clientPlayer3NameLabel.getText().equals("Empty slot"))
		{
			clientPlayer4NameLabel.setText(usernameList.get(3));
		}

		this.repaint();
	}

	/**
	 * starts process to begin hosting a game. Uses textfields for any required information.
	 */
	private void beginHostingGame(){
		//calls to methods that create the host object, give it a game object and a player as well as give the gameFrame a game object and player
		String userName = hostNameTextField.getText();
		player1NameLabel.setText(userName);
		this.repaint();
		gameFrame.runServer(32768,4,userName);


	}

	/**
	 * starts process to connect to a game. Uses textfields for required information such as the address of the host.
	 */
	private void connectToGame(){
		String userName = usernameTextField.getText();
		String address = addressTextField.getText();

		System.out.println("user " + userName +  " attempting to connect to game "+ address);

		try {
			gameFrame.runClient(address,32768, userName);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public int getMenuWidth(){
		return menuW;
	}
	public int getMenuHeight(){
		return menuH;
	}
	public int getMenuX(){
		return menuX;
	}
	public int getMenuY(){
		return menuY;
	}

}
