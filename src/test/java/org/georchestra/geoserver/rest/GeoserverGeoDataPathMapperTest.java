package org.georchestra.geoserver.rest;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class GeoserverGeoDataPathMapperTest {


    @Test
    public void testPathMapper() throws IOException {
        GeoserverGeoDataPathMapper toTest = new GeoserverGeoDataPathMapper(null);
        StringBuilder expectedPath = new StringBuilder();

        toTest.mapStorePath(expectedPath, "cite", "shp", null);

        assertTrue(expectedPath.toString().startsWith("/mnt/geoserver_geodata"));
    }
}
