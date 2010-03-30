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

    /** @parameter expr="fileName" */
    private String fileName;

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    public String getFileName() {
        return fileName;
    }

    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

