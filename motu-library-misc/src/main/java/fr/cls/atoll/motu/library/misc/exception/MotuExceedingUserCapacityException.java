/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cls.atoll.motu.library.misc.exception;

import org.apache.log4j.Logger;

/**
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class MotuExceedingUserCapacityException extends MotuExceptionBase {

    /** Logger for this class. */
    private static final Logger LOG = Logger.getLogger(MotuExceedingUserCapacityException.class);

    /** . */
    private static final long serialVersionUID = 1L;

    /**
     * The Constructor.
     * 
     * @param max the max
     * @param userId the user id
     * @param isAnonymous the is anonymous
     */
    public MotuExceedingUserCapacityException(String userId, boolean isAnonymous, int max) {
        super("Exceeding user capacity.");
        this.userId = userId;
        this.isAnmonymous = isAnonymous;
        this.max = max;
        notifyLogException();
    }

    /** The user id. */
    final private String userId;

    /** The is anmonymous. */
    final private boolean isAnmonymous;

    /** The max. */
    final private int max;

    /**
     * Checks if is anmonymous.
     * 
     * @return true, if is anmonymous
     */
    public boolean isAnmonymous() {
        return isAnmonymous;
    }

    /**
     * Gets the user id.
     * 
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the max.
     * 
     * @return the max
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Gets the max as string.
     * 
     * @return the max as string
     */
    public String getMaxAsString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Integer.toString(max));
        stringBuffer.append(" request(s).");
        return stringBuffer.toString();
    }

    /**
     * Gets the user category.
     * 
     * @return the user category
     */
    public String getUserCategory() {
        if (isAnmonymous) {
            return "anonymous";
        } else {
            return "authenticate";

        }
    }

    /**
     * writes exception information into the log.
     */
    @Override
    public void notifyLogException() {

        super.notifyLogException();
        LOG.warn(notifyException());
    }

    /**
     * Notify exception.
     * 
     * @return exception information.
     */
    @Override
    public String notifyException() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.notifyException());

        stringBuffer.append("The maximum number of requests is reached for the user '");
        stringBuffer.append(userId);
        stringBuffer.append("' (");
        stringBuffer.append(getUserCategory());
        stringBuffer.append(").\n");
        stringBuffer.append("Please, submit the request later.");
        stringBuffer.append("(Maximum is ");
        stringBuffer.append(getMaxAsString());
        stringBuffer.append(", a negative value means 'unlimited').");
        return stringBuffer.toString();
    }

}
