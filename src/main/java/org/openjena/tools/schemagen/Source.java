/*****************************************************************************
 * File:    Source.java
 * Project: schemagen
 * Created: 24 Mar 2010
 * By:      ian
 *
 * Copyright (c) 2010 Epimorphics Ltd. All rights reserved.
 *****************************************************************************/

// Package
///////////////

package org.openjena.tools.schemagen;


// Imports
///////////////


/**
 * <p>Simple container object to hold the per-source configuration
 * values from the <code>pom.xml</code>.</p>
 *
 * @author Ian Dickinson, Epimorphics (mailto:ian@epimorphics.com)
 */
public class Source
    extends SchemagenOptions
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

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    public String getFileName() {
        return getOption( OPT.INPUT );
    }

    /** @parameter expr="fileName" */
    public void setFileName( String fileName ) {
        setOption( OPT.INPUT, fileName );
    }

    /**
     * Return true if this source actually represents the default options
     * element
     *
     * @return True for the default options
     */
    public boolean isDefaultOptions() {
        return getFileName().equals( SchemagenMojo.DEFAULT_OPTIONS_ELEM );
    }


    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

