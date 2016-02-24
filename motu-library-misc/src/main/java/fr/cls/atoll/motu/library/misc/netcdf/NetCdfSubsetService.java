package fr.cls.atoll.motu.library.misc.netcdf;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import fr.cls.atoll.motu.library.misc.data.ExtractCriteriaDatetime;
import fr.cls.atoll.motu.library.misc.data.ExtractCriteriaDepth;
import fr.cls.atoll.motu.library.misc.data.ExtractCriteriaLatLon;

/**
 * Class to handle NCSS requests
 * 
 * <br>
 * <br>
 * Copyright : Copyright (c) 2016 <br>
 * <br>
 * Soci�t� : CLS (Collecte Localisation Satellites)
 * 
 * @author Joan SALA
 * @version $Revision: 1.1 $ - $Date: 2007-05-22 16:56:28 $
 */

public class NetCdfSubsetService {

    /** Name of variables, separated by ',' */
    public final static String NCSS_ATTR_VARIABLES = "var";

    /** Point location. units of degrees_east, degrees_north */
    public final static String NCSS_ATTR_LATITUDE = "latitude";
    public final static String NCSS_ATTR_LONGITUDE = "longitude";

    /** Lat/lon bounding box, units of degrees_east, degrees_north */
    public final static String NCSS_ATTR_NORTH = "north";
    public final static String NCSS_ATTR_EAST = "east";
    public final static String NCSS_ATTR_WEST = "west";
    public final static String NCSS_ATTR_SOUTH = "south";

    /** Projection bounding box, in projection coordinate units */
    public final static String NCSS_ATTR_MINX = "minx";
    public final static String NCSS_ATTR_MINY = "miny";
    public final static String NCSS_ATTR_MAXX = "maxx";
    public final static String NCSS_ATTR_MAXY = "maxy";

    /** Take only every nth point (both x and y) */
    public final static String NCSS_ATTR_HORIZSTRIDE = "horizStride";

    /** if present, make output strictly CF compliant by adding lat/lon coordinates if needed */
    public final static String NCSS_ATTR_ADDLATLON = "addLatLon";

    /** Time as a W3C date or "present". The time slice closest to the requested time is returned */
    public final static String NCSS_ATTR_TIME = "time";

    /** Used to specify a time range. Time as a W3C date or "present". Duration as a W3C time duration */
    public final static String NCSS_ATTR_TIME_START = "time_start";
    public final static String NCSS_ATTR_TIME_END = "time_end";
    public final static String NCSS_ATTR_TIME_DURATION = "time_duration";

    /** Must be equal to "all" to have effect */
    public final static String NCSS_ATTR_TEMPORAL = "temporal";

    /** Take only every nth time in the available series */
    public final static String NCSS_ATTR_TIMESTRIDE = "timeStride";

    /** Bounding box requests on grid datasets must have the same vertical levels */
    public final static String NCSS_ATTR_VERTCOORD = "vertCoord";

    /** Used to specify the returned format. */
    public final static String NCSS_ATTR_ACCEPT = "accept";

    /** Used to specify the type on a station feature. subset=stns means we will provide a station list */
    public final static String NCSS_ATTR_SUBSET = "subset";

    /** Used when subset=stns to specify the list of stations in the subset */
    public final static String NCSS_ATTR_STNS = "stns";

    /** Accepted output formats */
    public final static String NCSS_ATTR_FORMAT_NC3 = "netCDF";
    public final static String NCSS_ATTR_FORMAT_NC4 = "netCDF4";
    public final static String NCSS_ATTR_FORMAT_NC4EXT = "netCDF4ext";

    /** Attributes of the subset */
    protected ExtractCriteriaDatetime timeSubset;
    protected ExtractCriteriaLatLon geoSubset;
    protected ExtractCriteriaDepth depthSubset;
    protected Set<String> varSubset;
    protected String outputDir;
    protected String outputFile;
    protected String ncssURL;

    /**
     * Setter of the time subset setup .
     * 
     * @return
     */
    public void setTimeSubset(ExtractCriteriaDatetime in) {
        timeSubset = in;
    }

    /**
     * Setter of the geographical subset setup .
     * 
     * @return
     */
    public void setGeoSubset(ExtractCriteriaLatLon in) {
        geoSubset = in;
    }

    /**
     * Setter of the depth subset setup .
     * 
     * @return
     */
    public void setDepthSubset(ExtractCriteriaDepth in) {
        depthSubset = in;
    }

    /**
     * Setter of the variables subset setup .
     * 
     * @return
     */
    public void setVariablesSubset(Set<String> in) {
        varSubset = in;
    }

    /**
     * Setter of the extraction directory path .
     * 
     * @return
     */
    public void setOutputDir(String in) {
        outputDir = in;
    }

    /**
     * Setter of the unique name of the file to be created .
     * 
     * @return
     */
    public void setOutputFile(String in) {
        outputFile = in;
    }

    /**
     * Setter of the url to access NCSS REST service
     * 
     * @return
     */
    public void setncssURL(String in) {
        ncssURL = in;
    }

    /**
     * Returns the time subset setup .
     * 
     * @return
     */
    public ExtractCriteriaDatetime getTimeSubset() {
        return timeSubset;
    }

    /**
     * Returns the geographical subset setup .
     * 
     * @return
     */
    public ExtractCriteriaLatLon getGeoSubset() {
        return geoSubset;
    }

    /**
     * Returns the depth subset setup .
     * 
     * @return
     */
    public ExtractCriteriaDepth getDepthSubset() {
        return depthSubset;
    }

    /**
     * Returns the variables subset setup .
     * 
     * @return
     */
    public Set<String> getVariablesSubset() {
        return varSubset;
    }

    /**
     * Returns the extraction directory path .
     * 
     * @return
     */
    public String getOutputDir() {
        return outputDir;
    }

    /**
     * Returns the unique name of the file to be created .
     * 
     * @return
     */
    public String getOutputFile() {
        return outputFile;
    }

    /**
     * Returns the url of the NCSS subset service for 1 dataset
     * 
     * @return
     */
    public String getncssURL() {
        return ncssURL;
    }

    /**
     * REST request to NCSS subset service and redirect output to file .
     */
    public void RequestNCSS() {

        // Geographical subset
        String north = String.valueOf(geoSubset.getUpperLeftLat());
        String west = String.valueOf(geoSubset.getUpperLeftLon());
        String east = String.valueOf(geoSubset.getUpperRightLon());
        String south = String.valueOf(geoSubset.getLowerLeftLat());

        // Temporal subset (W3C format supported by TDS)
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String time_start = df.format(timeSubset.getFrom());
        String time_end = df.format(timeSubset.getTo());

        // TODO: Depth subset

        // TODO: netcdf4 output select
        String accept = "netcdf";

        try {
            // Setup query parameters
            MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

            // Variables subset
            for (String var : varSubset) {
                queryParams.add(NCSS_ATTR_VARIABLES, var);
            }

            // Geographical subset
            queryParams.add(NCSS_ATTR_NORTH, north);
            queryParams.add(NCSS_ATTR_WEST, west);
            queryParams.add(NCSS_ATTR_EAST, east);
            queryParams.add(NCSS_ATTR_SOUTH, south);

            // Temporal subset
            queryParams.add(NCSS_ATTR_TIME_START, time_start);
            queryParams.add(NCSS_ATTR_TIME_END, time_end);

            // Vertical subset
            // queryParams.add(NCSS_ATTR_VERTCOORD, vertCoord);

            // Output format
            queryParams.add(NCSS_ATTR_ACCEPT, accept);

            // Prepare client
            Client client = Client.create();
            WebResource webResource = client.resource(ncssURL).queryParams(queryParams);

            // Read buffer response and detect response type
            ClientResponse response = webResource.get(ClientResponse.class);

            if (response.getType().toString().equals("application/x-netcdf")) {
                InputStream is = response.getEntity(InputStream.class);
                byte[] bytes = IOUtils.toByteArray(is);

                // Write buffered response to file
                FileOutputStream fos = new FileOutputStream(outputDir + "/" + outputFile);
                fos.write(bytes);
                fos.flush();
                fos.close();
                is.close();
            } else if (response.getType().toString().equals("text/plain")) {
                // TDS error message handle (plain/text)
                String msg = response.getEntity(String.class);
                System.out.println("ERR -> " + msg);
            } else {
                // Other error handling
                System.out.println("Unkown response type -> " + response.getType().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
