/*
 * This file is part of RskJ
 * Copyright (C) 2017 RSK Labs Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package co.rsk.vm;

import co.rsk.config.RskSystemProperties;
import co.rsk.peg.Bridge;
import org.ethereum.vm.DataWord;
import org.ethereum.vm.PrecompiledContracts;
import org.ethereum.vm.PrecompiledContracts.PrecompiledContract;
import org.junit.Assert;
import org.junit.Test;

public class PrecompiledContractTest {

    private final RskSystemProperties config = new RskSystemProperties();

    @Test
    public void getBridgeContract() {
        DataWord bridgeAddress = new DataWord(PrecompiledContracts.BRIDGE_ADDR.getBytes());
        PrecompiledContract bridge = PrecompiledContracts.getContractForAddress(config, bridgeAddress);

        Assert.assertNotNull(bridge);
        Assert.assertEquals(Bridge.class, bridge.getClass());
    }

    @Test
    public void getBridgeContractTwice() {
        DataWord bridgeAddress = new DataWord(PrecompiledContracts.BRIDGE_ADDR.getBytes());
        PrecompiledContract bridge1 = PrecompiledContracts.getContractForAddress(config, bridgeAddress);
        PrecompiledContract bridge2 = PrecompiledContracts.getContractForAddress(config, bridgeAddress);

        Assert.assertNotNull(bridge1);
        Assert.assertNotNull(bridge2);
        Assert.assertNotSame(bridge1, bridge2);
    }
}
