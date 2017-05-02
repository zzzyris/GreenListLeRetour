package org.greenlist.business.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.greenlist.business.api.IBusinessTrancheAge;
import org.greenlist.data.api.IDaoTrancheAge;
import org.greenlist.entity.TrancheAge;

@Remote(IBusinessTrancheAge.class)
@Stateless
public class BusinessTrancheAge implements IBusinessTrancheAge {

	@EJB
	private IDaoTrancheAge proxyTrancheAge;

	@Override
	public List<TrancheAge> getTranchesAges() {
		List<TrancheAge> ta = null;
		try {
			ta = proxyTrancheAge.getTranchesAges();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}

}
