/*****************************************************************************
 * File:    SourceTest.java
 * Project: schemagen
 * Created: 10 May 2010
 * By:      ian
 *
 * Copyright (c) 2010 Epimorphics Ltd. All rights reserved.
 *****************************************************************************/

// Package
///////////////

package org.openjena.tools.schemagen;


// Imports
///////////////

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import jena.schemagen.SchemagenOptions.OPT;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>TODO class comment</p>
 *
 * @author Ian Dickinson, Epimorphics (mailto:ian@epimorphics.com)
 */
@RunWith( Parameterized.class )
public class SourceTest
{
    /***********************************/
    /* Constants                       */
    /***********************************/

    /** Test parameters are formed from the schemagen options
     **/
    @Parameters
    public static Collection<Object[]> testParameters() {
        Collection<Object[]> params = new ArrayList<Object[]>();

        for (OPT opt: OPT.values()) {
            Object[] par = new Object[2];
            par[0] = opt;
            par[1] = opt.name();

            params.add( par );
        }

        return params;
    }


    /***********************************/
    /* Static variables                */
    /***********************************/

    @SuppressWarnings( value = "unused" )
    private static final Logger log = LoggerFactory.getLogger( SourceTest.class );

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        //
    }

    /***********************************/
    /* Instance variables              */
    /***********************************/

    private OPT option;
    private String optionName;
    private Object expected;

    /***********************************/
    /* Constructors                    */
    /***********************************/

    public SourceTest( OPT paramVal, String paramName ) {
        option = paramVal;
        optionName = paramName;
    }

    /***********************************/
    /* External signature methods      */
    /***********************************/

    /**
     * Test method for {@link org.openjena.tools.schemagen.Source#getFileName()}.
     */
    @Test
    public void testGetOption() {
        Source s = new Source();
        setParamValue( s );
        assertEquals( expected, s.getOption( option ) );
    }


    /***********************************/
    /* Internal implementation methods */
    /***********************************/

    protected void setParamValue( Source s ) {
        switch (option) {
            case INPUT:
                s.setInput( optionName );

                expected = optionName;
                break;

            case CLASS_SECTION:
            case CLASSDEC:
            case CLASSNAME:
            case CLASSNAME_SUFFIX:
            case CLASS_TEMPLATE:
            case CONFIG_FILE:
            case DECLARATIONS:
            case ENCODING:
            case FOOTER:
            case HEADER:
            case INCLUDE:
            case INDIVIDUALS_SECTION:
            case INDIVIDUAL_TEMPLATE:
            case MARKER:
            case NAMESPACE:
            case OUTPUT:
            case PACKAGENAME:
            case PROPERTY_SECTION:
            case PROP_TEMPLATE:
            case ROOT:

                s.setOption( option, "fail" );
                expected = optionName;
                break;

            // Boolean options
            case DOS:
            case HELP:
            case INCLUDE_SOURCE:
            case LANG_DAML:
            case LANG_OWL:
            case LANG_RDFS:
            case NOCLASSES:
            case NOHEADER:
            case NOINDIVIDUALS:
            case NOPROPERTIES:
            case NO_COMMENTS:
            case NO_STRICT:
            case ONTOLOGY:
            case STRICT_INDIVIDUALS:
            case UC_NAMES:
            case USE_INF:

                s.setOption( option, false );
                expected = true;
                break;

        }
    }

    /***********************************/
    /* Inner class definitions         */
    /***********************************/

}

