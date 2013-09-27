package com.bharatonjava.school.web.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionPhaseListener implements PhaseListener{

	private static final long serialVersionUID = 123412341L;

	private Logger log = LoggerFactory.getLogger(SessionPhaseListener.class);
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		
		log.info("AFTER PHASE");
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		log.info("BEFORE PHASE");
		
	}

	@Override
	public PhaseId getPhaseId() {
		log.info("GET PHASE ID");
		return null;
	}

}
