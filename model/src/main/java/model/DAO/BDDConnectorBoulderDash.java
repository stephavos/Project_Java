package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// TODO: Auto-generated Javadoc
/**
 * The Class BDDConnectorBoulderDash.
 */
public final class BDDConnectorBoulderDash {
	
	/** The instance. */
	private static BDDConnectorBoulderDash instance;
	
	/** The user. */
	private static String USER = "root";
	
	/** The password. */
	private static String PASSWORD = "";
	
	/** The url. */
	private static String URL = "jdbc:mysl://localhost:3306/boulder_dash?useSSL=false&serverTimezone=UTC";
	
	/** The connection. */
	private Connection connection;
	
	/** The statement. */
	private Statement statement; 
	
	/**
	 * Instantiates a new BDD connector boulder dash.
	 */
	private BDDConnectorBoulderDash() {
		this.open();
	}
	
	/**
	 * Gets the single instance of BDDConnectorBoulderDash.
	 *
	 * @return single instance of BDDConnectorBoulderDash
	 */
	public static BDDConnectorBoulderDash getInstance(){
		if (instance == null){
			setInstance(new BDDConnectorBoulderDash());
		}
		return instance;
	}
	
	/**
	 * Sets the instance.
	 *
	 * @param instance the new instance
	 */
	private static void setInstance(final BDDConnectorBoulderDash instance) {
		BDDConnectorBoulderDash.instance = instance;
	}
	
	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(BDDConnectorBoulderDash.URL, BDDConnectorBoulderDash.USER, BDDConnectorBoulderDash.PASSWORD);
			this.statement = this.connection.createStatement();
			return true;
		}
		
		catch (final SQLException exception) {
			exception.printStackTrace();
		}
		
		return false;
	}
	
	
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 * @return the result set
	 */
	public ResultSet executeQuery(final String query) {
		try {
			return this.getstatement().executeQuery(query);
		}
		catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	private Statement getstatement() {
		// TODO Auto-generated method stub
		return this.statement;
	}

	/**
	 * Sets the sstatement.
	 *
	 * @param statement the new sstatement
	 */
	public void setSstatement(final Statement statement){
		this.statement = statement;
	}
	
	
	
	/**
	 * Prepare call.
	 *
	 * @param query the query
	 * @return the java.sql. callable statement
	 */
	public java.sql.CallableStatement prepareCall(final String query) {
		try {
			return this.getconnection().prepareCall(query);
		}
		catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	private Connection getconnection() {
		// TODO Auto-generated method stub
		return this.connection;
	}
	
	/**
	 * Sets the connection.
	 *
	 * @param connection the new connection
	 */
	public void setconnection(final Connection connection){
		this.connection = connection;
	}

	/**
	 * Execute update.
	 *
	 * @param query the query
	 * @return the int
	 */
	public int executeUpdate(final String query) {
		try {
			return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		}
		catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
