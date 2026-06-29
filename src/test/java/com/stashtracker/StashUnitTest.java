package com.stashtracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class StashUnitTest
{
	@Test
	public void everyUnitHasTierNameAndLocation()
	{
		for (StashUnit unit : StashUnit.values())
		{
			assertNotNull(unit.name(), unit.getTier());
			assertTrue(unit.name(), unit.getDisplayName() != null && !unit.getDisplayName().isEmpty());
			assertTrue(unit.name(), unit.getWorldPoints().length >= 1);
		}
	}

	@Test
	public void objectIdsAreUnique()
	{
		final Set<Integer> ids = new HashSet<>();
		for (StashUnit unit : StashUnit.values())
		{
			assertTrue("duplicate object id for " + unit.name(), ids.add(unit.getObjectId()));
			assertEquals(unit, StashUnit.forObjectId(unit.getObjectId()));
		}
	}

	@Test
	public void lookupByUnknownObjectIdIsNull()
	{
		assertEquals(null, StashUnit.forObjectId(-12345));
	}
}
