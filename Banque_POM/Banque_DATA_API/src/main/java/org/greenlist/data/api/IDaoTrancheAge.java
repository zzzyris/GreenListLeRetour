package org.greenlist.data.api;

import java.util.List;

import org.greenlist.entity.TrancheAge;

public interface IDaoTrancheAge {

	/**
	 * permet de recuperer la totalité des tranches d'ages présentes dans le SI
	 * @return la liste des tranches d'ages
	 */
	List<TrancheAge> getTranchesAges()throws Exception;
	
}
