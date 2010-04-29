/*****************************************************************************
 * File:    SchemagenMojo.java
 * Project: schemagen
 * Created: 22 Mar 2010
 * By:      ian
 *
 * Copyright (c) 2010 Epimorphics Ltd. All rights reserved.
 *****************************************************************************/

// Package
///////////////

package org.openjena.tools.schemagen;


// Imports
///////////////

import java.io.File;
import java.util.*;

import jena.schemagen;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.util.DirectoryScanner;


/**
 * <p>Maven plugin to execute Jena schemagen as part of a Jena-based
 * project build cycle
 * </p>
 *
 * @author Ian Dickinson, Epimorphics (mailto:ian@epimorphics.com)
 *
 * Maven Mojo options
 * @goal translate
 * @phase generate-sources
*/
public class SchemagenMojo
    extends AbstractMojo
{
    /***********************************/
    /* Constants                       */
    /***********************************/

    /** Default pattern for includes */

    /** Name of default options element */
    public static final String DEFAULT_OPTIONS_ELEM = "default";

    /***********************************/
    /* Static variables                */
    /***********************************/

    /***********************************/
    /* Instance variables              */
    /***********************************/

    /**
     * Array of file patterns to include in processing
     * @parameter alias="includes"
     */
    private String[] includes = new String[0];

    /**
     * Array of file patterns to exclude from processing
     * @parameter alias="excludes"
     */
    private String[] excludes = new String[0];

    /**
     * Options for individual files
     * @parameter alias="fileOptions"
     */
    private List<Source> fileOptions;

    /**
     * The current base directory of the project
     * @parameter default-value="${basedir}"
     */
    private File baseDir;

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "includes = " + (includes == null ? null : includes[0]) );

        for (Source p: fileOptions) {
            getLog().info( "source: fileName=" + p.getFileName() );

            if (isDefaultOptions( p )) {
                handleDefaultOptions( p );
            }
            else {
                handleFile( p );
            }
        }
    }

    /**
     * Return a list of the file names to be processed by schemagen. These are
     * determined by processing the Ant style paths given in the <code>includes</code>
     * and <code>excludes</code> parameters.
     *
     * @return Non-null but possibly empty list of files to process, sorted into lexical order
     */
    protected List<String> matchFileNames() {
        DirectoryScanner ds = new DirectoryScanner();
        ds.setExcludes( excludes );
        ds.setIncludes( includes );
        ds.setBasedir( getBaseDir() );
        ds.scan();

        String[] files = ds.getIncludedFiles();
        Arrays.sort( files );
        return Arrays.asList( files );
    }


    protected SchemagenOptions getDefaultOptions() {
        return null;
    }

    protected boolean isDefaultOptions( Source s ) {
        return false;
    }

    protected void handleDefaultOptions( Source defOptions ) {

    }

    protected void handleFile( Source file ) {

    }


    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    public void setExcludes( String[] excludes ) {
        this.excludes = excludes;
    }

    public void setIncludes( String[] includes ) {
        this.includes = includes;
    }

    /**
     * Append the given string to the array of included file patterns
     * @param incl File pattern string to append to <code>this.includes</code>
     */
    public void addIncludes( String incl ) {
        String[] incls = new String[this.includes.length + 1];
        int i = 0;
        for (String s: this.includes) {
            incls[i++] = s;
        }
        incls[i] = incl;

        this.includes = incls;
    }

    /**
     * Append the given string to the array of excluded file patterns
     * @param excl File pattern string to append to <code>this.excludes</code>
     */
    public void addExcludes( String excl ) {
        String[] excls = new String[this.excludes.length + 1];
        int i = 0;
        for (String s: this.excludes) {
            excls[i++] = s;
        }
        excls[i] = excl;
        this.excludes = excls;
    }

    /**
     * Return the base directory for the plugin, which should be supplied
     * by plexus, but if not we default to the current working directory.
     *
     * @return The base directory as a file
     */
    protected File getBaseDir() {
        return (baseDir == null) ? new File(".").getAbsoluteFile() : baseDir;
    }
}

