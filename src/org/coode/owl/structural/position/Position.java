package org.coode.owl.structural.position;

import java.util.Collections;
import java.util.List;

import org.semanticweb.owlapi.model.OWLObject;

public class Position {
	public final static List<Integer> EMPTY_POSITION = Collections.singletonList(-1);
	private final static OWLObjectDecomposer DECOMPOSER = new OWLObjectDecomposer();

	public static Object get(OWLObject owlObject, List<Integer> position) {
		if (owlObject == null) {
			throw new NullPointerException("The OWL object cannot be null");
		}
		if (position == null) {
			throw new NullPointerException("The position cannot be null");
		}
		Object toReturn = owlObject;
		if (!position.isEmpty()) {
			Integer index = position.get(0);
			List<Object> parts = owlObject.accept(DECOMPOSER);
			if (index >= 1 && index <= parts.size()) {
				toReturn = parts.get(index - 1);
				if (position.size() > 1) {
					if (toReturn instanceof OWLObject) {
						List<Integer> newPosition = position.subList(1, parts.size());
						toReturn = get((OWLObject) toReturn, newPosition);
					} else {
						toReturn = null;
					}
				}
			} else if (index != 0) {
				toReturn = null;
			}
		}
		return toReturn;
	}
}
