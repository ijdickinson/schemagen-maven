/*****************************************************************************
 * File:    SchemagenMojoIntegrationTest.java
 * Project: schemagen
 * Created: 25 May 2010
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
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>TODO class comment</p>
 *
 * @author Ian Dickinson, Epimorphics (mailto:ian@epimorphics.com)
 */
public class SchemagenMojoIntegrationTest
{
    /***********************************/
    /* Constants                       */
    /***********************************/

    /***********************************/
    /* Static variables                */
    /***********************************/

    @SuppressWarnings( value = "unused" )
    private static final Logger log = LoggerFactory.getLogger( SchemagenMojoIntegrationTest.class );

    /***********************************/
    /* Instance variables              */
    /***********************************/

    /***********************************/
    /* Constructors                    */
    /***********************************/

    /***********************************/
    /* External signature methods      */
    /***********************************/

    @Before
    public void setUp() throws Exception {
        //
    }

    @Test
    public void schemagenIntegrationTest0()
        throws Exception
    {
        // Create dummy Maven project in /src/test/resources/...
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/schemagen-integration-0" );

        Verifier verifier = new Verifier( testDir.getAbsolutePath() );

        /*
         * The Command Line Options (CLI) are passed to the
         * verifier as a list.
         */
        List<String> cliOptions = new ArrayList<String>();
        verifier.setCliOptions( cliOptions );

        verifier.executeGoal( "generate-sources" );

        /*
         * This is the simplest way to check a build
         * succeeded. It is also the simplest way to create
         * an IT test: make the build pass when the test
         * should pass, and make the build fail when the
         * test should fail. There are other methods
         * supported by the verifier. They can be seen here:
         * http://maven.apache.org/shared/maven-verifier/apidocs/index.html
         */
        verifier.verifyErrorFreeLog();

        /*
         * Reset the streams before executing the verifier
         * again.
         */
        verifier.resetStreams();

        /*
         * The verifier also supports beanshell scripts for
         * verification of more complex scenarios. There are
         * plenty of examples in the core-it tests here:
         * http://svn.apache.org/repos/asf/maven/core-integration-testing/trunk
         */
    }

    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

