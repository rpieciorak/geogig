/* Copyright (c) 2013-2014 Boundless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 * Gabriel Roldan (Boundless) - initial implementation
 */
package org.locationtech.geogig.geotools.cli.spatialite;

import org.geotools.data.DataStore;
import org.locationtech.geogig.cli.CLICommand;
import org.locationtech.geogig.cli.annotation.ReadOnly;
import org.locationtech.geogig.geotools.cli.DataStoreList;
import org.locationtech.geogig.geotools.plumbing.ListOp;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;

/**
 * Lists tables from a SpatiaLite database.
 * 
 * SpatiaLite CLI proxy for {@link ListOp}
 * 
 * @see ListOp
 */
@ReadOnly
@Parameters(commandNames = "list", commandDescription = "List available feature types in a database")
public class SLList extends DataStoreList implements CLICommand {

    /**
     * Common arguments for SpatiaLite commands.
     */
    @ParametersDelegate
    public SLCommonArgs commonArgs = new SLCommonArgs();

    final SpatialiteSupport support = new SpatialiteSupport();

    @Override
    protected DataStore getDataStore() {
        return support.getDataStore(commonArgs);
    }
}
