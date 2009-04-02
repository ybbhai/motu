package fr.cls.atoll.motu.processor.wps;


import java.util.Map;

import org.apache.log4j.Logger;
import org.deegree.ogcwebservices.OGCWebServiceException;
import org.deegree.ogcwebservices.wps.describeprocess.ProcessDescription;
import org.deegree.ogcwebservices.wps.execute.IOValue;
import org.deegree.ogcwebservices.wps.execute.OutputDefinitions;
import org.deegree.ogcwebservices.wps.execute.ExecuteResponse.ProcessOutputs;

/**
 * This class describes an exemplary Process Implementation.
 * 
 * @author ccamel
 * @version $Revision: 1.2 $ - $Date: 2009-04-02 15:03:44 $ - $Author: dearith $
 */
public class TestProcess extends TransformProcessAbstract {
    /**
     * Private logger for this instance.
     */
    private static final Logger LOG = Logger.getLogger(TestProcess.class);

    @InputAnnotation("paramA")
    private int paramA;

    /**
     * @param processDescription Description of this service.
     */
    public TestProcess(ProcessDescription processDescription) {
        super(processDescription);
    }

    /**
     * Process method. A <code>Map<String,IOValue></code> serves as an input object.
     * 
     * The method returns a <code>ProcessOutputs</code> object, which encapsulates the result of the process's
     * operation.
     * 
     * @param inputs serves as an input object. Each String represents the key which holds an IOValue as value
     *            (e.g. an object representing a complete <wps:Input> element with all corresponding
     *            sub-elements). The process implementation is responsible for retrieving all specified values
     *            according to the process configuration document.
     * @return a parameter which encapsulates the result of the process's operation.
     */
    @Override
    public ProcessOutputs execute(Map<String, IOValue> inputs, OutputDefinitions outputDefinitions) throws OGCWebServiceException {
        return null;
    }

    /**
     * @return the paramA
     */
    public int getParamA() {
        return paramA;
    }

    /**
     * @param paramA the paramA to set
     */
    public void setParamA(int paramA) {
        this.paramA = paramA;
    }

    @Override
    protected Object execute() {
        System.out.println(paramA);
        return null;
    }

}
