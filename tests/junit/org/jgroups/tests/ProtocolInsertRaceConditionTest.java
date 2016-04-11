package org.jgroups.tests;


import org.jgroups.*;
import org.jgroups.protocols.*;
import org.jgroups.protocols.pbcast.GMS;
import org.jgroups.protocols.pbcast.NAKACK2;
import org.jgroups.protocols.pbcast.STABLE;
import org.jgroups.stack.Protocol;
import org.jgroups.stack.ProtocolStack;
import org.jgroups.util.Digest;
import org.jgroups.util.MutableDigest;
import org.jgroups.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;


/**
 * Tests merging with SEQUENCER
 * @author Bela Ban
 * @since 3.1
 */
@Test(groups="ralf",singleThreaded=true)
public class ProtocolInsertRaceConditionTest {

	public void testMergeAndSendOrdering() throws Exception {
    	System.out.println("ZoCK");
    	
    	ProtocolStack s = new ProtocolStack();
    	
    	Protocol top = new DISCARD();
    	Protocol bottom = new DELAY();
       	s.addProtocol(top);
       	s.addProtocol(bottom);
       	
       	s.insertProtocol(new PING(), ProtocolStack.ABOVE, DISCARD.class);
       	
       	top.down(new Event(Event.USER_DEFINED, null));
       	
    	System.out.println("ZlCK " + s.getProtocols());
           	
    }
}
