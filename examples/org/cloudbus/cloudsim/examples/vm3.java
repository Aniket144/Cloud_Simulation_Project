package org.cloudbus.cloudsim.examples;

import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.Vm;

public class vm3 extends Vm {
	
	double[] comcost = new double[3];

	public vm3(int id, int userId, double mips, int numberOfPes, int ram, long bw, long size, String vmm,
			CloudletScheduler cloudletScheduler,double[] comcost) {
		
		super(id, userId, mips, numberOfPes, ram, bw, size, vmm, cloudletScheduler);
		this.comcost=comcost;

	}
}
