package fr.cls.atoll.motu.processor.wps;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.log4j.Logger;

import org.deegree.commons.xml.XMLAdapter;
import org.deegree.services.wps.Processlet;
import org.deegree.services.wps.ProcessletException;
import org.deegree.services.wps.ProcessletExecutionInfo;
import org.deegree.services.wps.ProcessletInputs;
import org.deegree.services.wps.ProcessletOutputs;
import org.deegree.services.wps.input.ComplexInput;
import org.deegree.services.wps.input.LiteralInput;
import org.deegree.services.wps.output.ComplexOutput;
import org.deegree.services.wps.output.LiteralOutput;
import org.deegree.services.wps.output.ProcessletOutput;

/**
 * <br>
 * <br>
 * Copyright : Copyright (c) 2009. <br>
 * <br>
 * Soci�t� : CLS (Collecte Localisation Satellites)
 * 
 * @author $Author: dearith $
 * @version $Revision: 1.3 $ - $Date: 2009-04-15 14:30:30 $
 */
public class TestAdd implements Processlet {
    /**
     * Logger for this class
     */
    private static final Logger LOG = Logger.getLogger(TestAdd.class);

    /**
     * Constructeur.
     */
    public TestAdd() {
    }

    /** {@inheritDoc} */
    @Override
    public void destroy() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("destroy() - entering");
        }
        // TODO Auto-generated method stub

        if (LOG.isDebugEnabled()) {
            LOG.debug("destroy() - exiting");
        }
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    /** {@inheritDoc} */
    @Override
    public void process(ProcessletInputs in, ProcessletOutputs out, ProcessletExecutionInfo info) throws ProcessletException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("process(ProcessletInputs in=" + in + ", ProcessletOutputs out=" + out + ", ProcessletExecutionInfo info=" + info
                    + ") - entering");
        }
        //        
        // LiteralInput a = (LiteralInput) in.getParameter("A");
        // LiteralInput b = (LiteralInput) in.getParameter("B");
        //
        // int value = Integer.parseInt(a.getValue()) + Integer.parseInt(b.getValue());

        ComplexInput a = (ComplexInput) in.getParameter("A");
        ComplexInput b = (ComplexInput) in.getParameter("B");
        String aa = null;
        String bb = null;
        try {
            aa = a.getValueAsElement().getText();
            bb = b.getValueAsElement().getText();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        int value = Integer.parseInt(aa) + Integer.parseInt(bb);
        // TODO Auto-generated method stub
        // LiteralOutput c = (LiteralOutput)out.getParameter("C");
        // c.setValue(Integer.toString(value));
        ComplexOutput c = (ComplexOutput) out.getParameter("C");
        try {

            XMLStreamWriter writer = c.getXMLStreamWriter();
            XMLAdapter.writeElement(writer, c.getIdentifier().getCode(), Integer.toString(value));
        } catch (XMLStreamException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // try {
        //
        // c.getBinaryOutputStream().write(Integer.toString(value).getBytes());
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        //
        // }
        // ComplexOutput c = (ComplexOutput) out.getParameter("C");
        // try {
        // c.getXMLStreamWriter().writeEmptyElement("C");
        // c.getXMLStreamWriter().writeCData(Integer.toString(value));
        // } catch (XMLStreamException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        if (LOG.isDebugEnabled()) {
            LOG.debug("process(ProcessletInputs, ProcessletOutputs, ProcessletExecutionInfo) - exiting");
        }
    }

    /**
     * .
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
