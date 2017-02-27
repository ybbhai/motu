package fr.cls.atoll.motu.web.usl.wcs.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cls.atoll.motu.web.usl.wcs.exceptions.ActionException;

public abstract class Action {

    public abstract void process(HttpServletRequest request, HttpServletResponse response) throws ActionException;

}
