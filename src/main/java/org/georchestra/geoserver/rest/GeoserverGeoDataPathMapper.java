package org.georchestra.geoserver.rest;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.geoserver.catalog.Catalog;
import org.geoserver.platform.ExtensionPriority;
import org.geoserver.rest.util.RESTUploadPathMapperImpl;

public class GeoserverGeoDataPathMapper extends RESTUploadPathMapperImpl
        implements ExtensionPriority {

    public GeoserverGeoDataPathMapper(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void mapStorePath(
            StringBuilder rootDir, String workspace, String store, Map<String, String> storeParams)
            throws IOException {

        // TODO do we need something more configureable than that ?
        rootDir.setLength(0);
        rootDir.append(File.separator);
        rootDir.append("mnt");
        rootDir.append(File.separator);
        rootDir.append("geoserver_geodata");

        if (workspace != null && !workspace.isEmpty()) {
            rootDir.append(File.separator);
            rootDir.append(workspace);
        }

        if (store != null && !store.isEmpty()) {
            rootDir.append(File.separator);
            rootDir.append(store);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
