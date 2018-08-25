package de.jfpgmc.ui.context;

import java.io.Serializable;
import java.util.Observable;

import de.jfpgmc.dto.User;

/**
 * The context to store user specific data.
 * 
 * @author Martin Cremer
 */
public class UserContext extends Observable implements Serializable {
	private static final long serialVersionUID = -5186831807349398570L;
	private User user;

	/**
	 * Initialize the context for a specific user.
	 * 
	 */
	public void initUser(User user) {
		if ((this.user == null && user != null)
				|| (this.user != null && user == null)
				|| (this.user != null && !this.user.equals(user))) {
			this.user = user;
			setChanged();
		}
	}
	
	/**
	 * Dispose the current context and reset it to default for reuse.
	 */
	public void disposeUser() {
		user = null;
		setChanged();
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
}
