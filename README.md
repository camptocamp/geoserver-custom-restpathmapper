# About

This repository contains the code to implement a [Rest PAthMapper](https://docs.geoserver.org/main/en/developer/programming-guide/rest-services/implementing-mapper.html)
which saves uploaded resources under `/mnt/geoserver_geodata` instead of `<geoserver datadir>/data`.

As we consider the geoserver datadir as a configuration directory, storing raw (binary) data is not
relevant and we want to use a dedicated directory for this purpose instead.

# Usage

Just compile the module using:

```
$ mvn clean package
```

then copy the JAR file generated under `target/` directly into your GeoServer classpath (e.g. `WEB-INF/lib`).

# Test

You can runtime test using the docker composition provided under `src/docker`:

With a zipped shapefile:

```
$ cd src/docker
$ docker compose up -d
[...]
$ curl -u admin:geoserver --data-binary @armoires.zip -X PUT \
    'http://localhost:8080/geoserver/rest/workspaces/cite/datastores/armoires/file.shp?update=overwrite' \
    -H 'Content-Type: application/zip'
```

With a geotiff:

```
% curl -u admin:geoserver --data-binary @sample.tif -X PUT \
    'http://localhost:8080/geoserver/rest/workspaces/cite/coveragestores/tiff/file.geotiff?update=overwrite' \
    -H 'Content-Type: image/geotiff

```
