package replicatorg.drivers.commands;

import replicatorg.drivers.Driver;
import replicatorg.drivers.RetryException;

public class SetMotorRPM implements DriverCommand {

	double rpm;
	int toolhead = -1; /// by default, get current tool at dispatch time
	
	public SetMotorRPM(double rpm) {
		this.rpm = rpm;
	}

	public SetMotorRPM(double rpm, int toolhead) {
		this.rpm = rpm;
		this.toolhead = toolhead;
	}

	@Override
	public void run(Driver driver) throws RetryException {
		driver.setMotorRPM(rpm,toolhead);
	}
}