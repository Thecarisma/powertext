/*
 * security-test - PluginPolicy.java - Copyright © 2007 David Roden
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package power.text.plugin;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;

/**
 * Custom policy for the security-test.
 * 
 * @author David Roden &lt;droden@gmail.com&gt;
 * @version $Id$
 */
public class PluginPolicy extends Policy {

	/**
	 * Returns {@link AllPermission} for any code sources that do not end in
	 * “/rogue.jar” and an empty set of permissions for code sources that do end
	 * in “/rogue.jar”, denying access to all local resources to the rogue
	 * plugin.
	 * 
	 * @param codeSource
	 *            The code source to get the permissiosn for
	 * @return The permissions for the given code source
	 */
	public PermissionCollection getPermissions(CodeSource codeSource) {
		Permissions p = new Permissions();
		if (!codeSource.getLocation().toString().endsWith("/rogue.jar")) {
			p.add(new AllPermission());
		}
		return p;
	}

	/**
	 * Does nothing.
	 */
	public void refresh() {
	}

}
