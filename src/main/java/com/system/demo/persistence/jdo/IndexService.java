package com.system.demo.persistence.jdo;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.system.demo.configuration.PMF;

public class IndexService {
	
	public static int getPedagogicalPeriodIndex() {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Index.class);
		try {
			
		} catch(Exception e) {
			
		} finally {
			q.closeAll();
			pm.close();
		}
		return 1;
	}

}
