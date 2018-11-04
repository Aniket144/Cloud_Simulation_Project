package org.cloudbus.cloudsim.examples;
import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.UtilizationModel;

public class cloudlet3 extends Cloudlet {
	
	double[] executioncost=new double[3];
	int[] datasize = new int[2];

	public cloudlet3(int cloudletId, long cloudletLength, int pesNumber, long cloudletFileSize, long cloudletOutputSize,
			UtilizationModel utilizationModelCpu, UtilizationModel utilizationModelRam,
			UtilizationModel utilizationModelBw, double[] executioncost,int[] datasize) {
		super(cloudletId, cloudletLength, pesNumber, cloudletFileSize, cloudletOutputSize, utilizationModelCpu,
				utilizationModelRam, utilizationModelBw);
		
		this.executioncost = executioncost;
		this.datasize=datasize;
		// TODO Auto-generated constructor stub
	}
	

}
