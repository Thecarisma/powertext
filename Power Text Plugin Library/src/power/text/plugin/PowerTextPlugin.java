/*
 * security-test - PowerTextPlugin.java - Copyright © 2007 David Roden
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

/**
 * Interface for the plugin classes.
 * 
 * @author David Roden &lt;droden@gmail.com&gt;
 * @version $Id$
 */
public interface PowerTextPlugin {

	/**
	 * Performs the plugin action.
	 */
	public void run();
        
        /**
         * Shows the name of the plugin.
         * @return 
         */
        public String getName();
        
        /**
         * Shows the name of the plugin creator/writer.
         * @return 
         */
        public String author();
        
        /**
         * Shows the source of the plugin 
         * @return 
         */
        public String source();
        
        /**
         * Shows the category of the plugin 
         * @return 
         */
        public String category();
        
        /**
         * Shows the category of the plugin 
         * @return 
         */
        public String version();
        
        /**
         * returns the description of the plugin.
         * @return 
         */
        public String description();

}
