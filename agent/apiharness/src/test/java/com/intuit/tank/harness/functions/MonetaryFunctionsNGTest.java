package com.intuit.tank.harness.functions;

/*
 * #%L
 * Intuit Tank Agent (apiharness)
 * %%
 * Copyright (C) 2011 - 2015 Intuit Inc.
 * %%
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * #L%
 */

import com.intuit.tank.harness.test.data.Variables;
import com.intuit.tank.test.TestGroups;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonetaryFunctionsNGTest {
    Variables variables = new Variables();

    @Test
    @Tag(TestGroups.FUNCTIONAL)
    public void testIsValid() {
        // Generic Tests
        assertFalse(FunctionHandler.validFunction("#function.monetary"));
        assertFalse(FunctionHandler.validFunction("#function.monetary.bogusFunction"));

        assertTrue(FunctionHandler.validFunction("#function.monetary.randomPositive.5"));

        // Random Negative Whole Number
        assertFalse(FunctionHandler.validFunction("#function.monetary.randomNegative"));
        assertTrue(FunctionHandler.validFunction("#function.monetary.randomNegative.5"));
    }

    @Test
    @Tag(TestGroups.FUNCTIONAL)
    public void testRandomPositiveNumber() {
        String command = "#function.monetary.randomPositive.4";

        String random = FunctionHandler.executeFunction(command, variables);
        assertNotNull(random);
        assertEquals(random.length(), 7);
    }

    @Test
    @Tag(TestGroups.FUNCTIONAL)
    public void testRandomNegativeNumber() {
        String command = "#function.monetary.randomNegative.5";

        String random = FunctionHandler.executeFunction(command, variables);
        assertNotNull(random);
        assertEquals(random.length(), 9);
    }
}
