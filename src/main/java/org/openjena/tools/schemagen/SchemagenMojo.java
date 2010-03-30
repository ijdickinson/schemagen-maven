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

import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.*;
import org.apache.maven.plugin.logging.Log;

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
    private String[] includes;

    /**
     * Array of file patterns to exclude from processing
     * @parameter alias="excludes"
     */
    private String[] excludes;

    /**
     * Options for individual files
     * @parameter alias="props"
     */
    private List<Source> props;

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "includes = " + (includes == null ? null : includes[0]) );

        for (Source p: props) {
            getLog().info( "source: fileName=" + p.getFileName() );
        }
    }


    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

