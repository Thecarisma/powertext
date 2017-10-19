/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.text.Interface;

import static com.power.text.Main.*;

/**
 *
 * @author Thecarisma
 */
public interface PowerTextProperties {
    
    /**
     * 
     * @return the version of the latest Power Text Editor
     */
    public static String getVersion() {
        return version ;
    }
    
    /**
     * 
     * @return the full version of the latest Power Text Editor
     */
    public static String getFullVersion() {
        return fullVersion ;
    }
    
    /**
     * 
     * @return the version number of the latest Power Text Editor
     */
    public static String getVersionNumber() {
        return versionNumber ;
    }
    
    /**
     * 
     * @return the build of the latest Power Text Editor
     */
    public static String getBuild() {
        return build ;
    }
    
    /**
     * 
     * @return the build number of the latest Power Text Editor
     */
    public static String getBuildNumber() {
        return buildNumber ;
    }
    
    /**
     * 
     * @return the release date of the latest Power Text Editor
     */
    public static String getRealeaseDate() {
        return releaseDate ;
    }
    
    /**
     * 
     * @return the date of the latest Power Text Editor
     */
    public static String getDate() {
        return date ;
    }
    
    /**
     * 
     * @return the author of Power Text Editor
     */
    public static String getAuthor() {
        return author ;
    }
    
    /**
     * 
     * @return the location of last release of Power Text Editor
     */
    public static String getLocation() {
        return location ;
    }
    
    /**
     * 
     * @return the programming language of Power Text Editor
     */
    public static String getProgrammingLanguage() {
        return language ;
    }
    
    /**
     * 
     * @return the system used to release the latest Power Text Editor
     */
    public static String getSystem() {
        return system ;
    }
    /**
     * 
     * @return the Operating System used for latest Power Text Editor Build
     */
    public static String getOS() {
        return os ;
    }
    
}
