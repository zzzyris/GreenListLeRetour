package org.greenlist.utilitaire;

import java.util.Comparator;

import org.greenlist.entity.Objet;

public class ObjetComparator implements Comparator<Objet> {

	@Override
	public int compare(Objet o1, Objet o2) {
		if (o1.getPertinence() > o2.getPertinence()) {
			return -1;
		} else if (o1.getPertinence() < o2.getPertinence()) {
			return 1;
		} else {
			if (o1.getDistance() < o2.getDistance()) {
				return -1;
			} else if (o1.getDistance() > o2.getDistance()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
