/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, version 2.1, dated February 1999.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the latest version of the GNU Lesser General
 * Public License as published by the Free Software Foundation;
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program (LICENSE.txt); if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Based on code generated by Agitar build: Agitator Version 1.0.2.000071 (Build date: Jan 12, 2007) [1.0.2.000071]
 */
package org.jamwiki.utils;

import java.io.FileNotFoundException;

import org.jamwiki.JAMWikiUnitTest;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResourceUtilTest extends JAMWikiUnitTest {

    /**
     *
     */
    @Test(expected=Exception.class)
    public void testGetClassLoaderFileThrowsException() throws Throwable {
        ResourceUtil.getClassLoaderFile("testUtilitiesFilename");
    }

    /**
     *
     */
    @Test(expected=FileNotFoundException.class)
    public void testReadFileThrowsFileNotFoundException() throws Throwable {
        ResourceUtil.readFile("fakeFileName");
    }

    /**
     *
     */
    @Test(expected=FileNotFoundException.class)
    public void testReadFileThrowsFileNotFoundException1() throws Throwable {
        ResourceUtil.readFile("testUtilitiesFilename");
    }

    /**
     *
     */
    @Test(expected=NullPointerException.class)
    public void testReadFileThrowsNullPointerException() throws Throwable {
        ResourceUtil.readFile(null);
    }

    /*
     *
     */
    @Test
    public void testReadFileClassPath() throws Throwable {
        final String contents = ResourceUtil.readFile("StartingPoints.us-ascii.txt").trim();
        assertNotNull("Classpath reading file returned 'null'", contents);
        assertTrue("Read contents too short: " + contents.length(), 13 == contents.length());
    }

    /*
     *
     */
    @Test
    public void testReadFileFromPath() throws Throwable {
        final String contents = ResourceUtil.readFile("src/test/resources/StartingPoints.us-ascii.txt").trim();
        assertNotNull("File path reading file returned 'null'", contents);
        assertTrue("Read contents too short: " + contents.length(), 13 == contents.length());
    }

    /*
     *
     */
    @Test
    public void testReadFileUSAscii() throws Throwable {
        final String contents = ResourceUtil.readFile("StartingPoints.us-ascii.txt").trim();
        assertNotNull("Classpath reading US-ASCII returned 'null'", contents);
        assertTrue("Reading US-ASCII failed: " + contents, contents.equals("1234567890aou"));
    }

    /*
     *
     */
    @Test
    public void testReadFileUTF8() throws Throwable {
        final String contents = ResourceUtil.readFile("StartingPoints.utf8.txt").trim();
        assertNotNull("Classpath reading UTF-8 returned 'null'", contents);
        assertTrue("Reading UTF-8 failed: " + contents, contents.equals("1234567890äöü"));

    }

    /*
     *
     */
    @Test
    public void testReadFileUTF8BOM() throws Throwable {
        final String contents = ResourceUtil.readFile("StartingPoints.utf8-bom.txt").trim();
        assertNotNull("Classpath reading UTF-8 returned 'null'", contents);
        assertTrue("Reading UTF-8 failed: " + contents, contents.startsWith("1234567890äöü"));

    }
}
