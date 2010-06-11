/*****************************************************************************
 * File:    SchemagenMojoIntegrationTestBase.java
 * Project: schemagen
 * Created: 10 June 2010
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

import org.apache.maven.it.Verifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Base class for integration tests</p>
 *
 * @author Ian Dickinson, Epimorphics (mailto:ian@epimorphics.com)
 */
public class SchemagenMojoIntegrationTestBase
{
    /***********************************/
    /* Constants                       */
    /***********************************/

    /***********************************/
    /* Static variables                */
    /***********************************/

    @SuppressWarnings( value = "unused" )
    private static final Logger log = LoggerFactory.getLogger( SchemagenMojoIntegrationTestBase.class );

    /***********************************/
    /* Instance variables              */
    /***********************************/

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    /**
     * Convert a relative path name to an absolute path by including the base name from
     * the verifier unless the file name already starts with the <code>File.separator</code>
     * character.
     *
     * @param verifier
     * @param name Relative or absolute file name
     * @return Absolute file name
     */
    protected String asAbsoluteFileName( Verifier verifier, String name ) {
        return (name.startsWith( File.separator )) ? name : verifier.getBasedir() + File.separator + name;
    }


    /***********************************/
    /* Internal implementation methods */
    /***********************************/


    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

