package replicatorg.drivers;

/// A fake, but agreeable driver.

import java.awt.Color;
import java.util.EnumSet;

import javax.vecmath.Point3d;

import org.w3c.dom.Node;

import replicatorg.app.Base;
import replicatorg.app.exceptions.BuildFailureException;
import replicatorg.machine.model.AxisId;
import replicatorg.machine.model.MachineModel;
import replicatorg.util.Point5d;

public class VirtualPrinter implements Driver, DriverQueryInterface {

	final String firmwareInfo = "No Firmware";
	final Version version = new Version(0,0);
	final Version minimumVersion = new Version(0,0);
	final Version preferredVersion = new Version(0,0);
	final boolean hasSoftStop = true;	
	final boolean hasEStop = true;
	
	double toolTemperature = 0;
	double toolTemperatureSetting = 0;
	double platformTemperature = 0;
	double platformTemperatureSetting = 0;
	boolean isInitialized = false;
	MachineModel machineModel = new MachineModel();
	Point5d currentPosition = new Point5d();
	Point5d maximumFeedrates = new Point5d(1,1,1,1,1);
	Point3d[] currentOffset = new Point3d[]{
			new Point3d(),
			new Point3d(),
			new Point3d(),
			new Point3d(),
			new Point3d()};
	
	@Override
	public void loadXML(Node xml) {
		// this space intentionally left blank
		machineModel.loadXML(xml);
	}

	@Override
	public boolean isPassthroughDriver() {
		// this space intentionally left blank
		return false;
	}

	@Override
	public void executeGCodeLine(String code) {
		// this space intentionally left blank

	}

	@Override
	public boolean isFinished() {
		// this space intentionally left blank
		return true;
	}

	@Override
	public boolean isBufferEmpty() {
		// this space intentionally left blank
		return true;
	}

	@Override
	public void assessState() {
		// this space intentionally left blank

	}

	@Override
	public boolean hasError() {
		// this space intentionally left blank
		return false;
	}

	@Override
	public DriverError getError() {
		// this space intentionally left blank
		return null;
	}

	@Override
	public void checkErrors() throws BuildFailureException {
		// this space intentionally left blank

	}

	@Override
	public void initialize() throws VersionException {
		isInitialized = true;
	}

	@Override
	public void uninitialize() {
		isInitialized = false;
	}

	@Override
	public boolean isInitialized() {
		// this space intentionally left blank
		return isInitialized;
	}

	@Override
	public void dispose() {
		// this space intentionally left blank

	}

	@Override
	public MachineModel getMachine() {
		return machineModel;
	}

	@Override
	public void setMachine(MachineModel m) {
		machineModel = m;
	}

	@Override
	public String getDriverName() {
		// this space intentionally left blank
		return "VirtualPrinter";
	}

	@Override
	public String getFirmwareInfo() {
		// this space intentionally left blank
		return firmwareInfo;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public void updateManualControl() {
		// this space intentionally left blank

	}

	@Override
	public Version getMinimumVersion() {
		// this space intentionally left blank
		return minimumVersion;
	}

	@Override
	public Version getPreferredVersion() {
		// this space intentionally left blank
		return preferredVersion;
	}

	@Override
	public void setCurrentPosition(Point5d p) throws RetryException {
		currentPosition = p;
	}

	@Override
	public void storeHomePositions(EnumSet<AxisId> axes) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void recallHomePositions(EnumSet<AxisId> axes) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public boolean positionLost() {
		// this space intentionally left blank
		return false;
	}

	@Override
	public Point5d getCurrentPosition(boolean update) {
		// Note that we don't have a 
		if (currentPosition == null) {
			currentPosition = new Point5d();
		}
		return currentPosition;
	}

	@Override
	public void invalidatePosition() {
		currentPosition = null;
	}

	@Override
	public void queuePoint(Point5d p) throws RetryException {
		currentPosition = p;
	}

	@Override
	public Point3d getOffset(int i) {
		return currentOffset[i];
	}

	@Override
	public void setOffsetX(int i, double j) {
		currentOffset[i].x = j;

	}

	@Override
	public void setOffsetY(int i, double j) {
		currentOffset[i].y = j;

	}

	@Override
	public void setOffsetZ(int i, double j) {
		currentOffset[i].z = j;

	}

	@Override
	public Point5d getPosition() {
		// this space intentionally left blank
		return currentPosition;
	}

	@Override
	public void requestToolChange(int toolIndex, int timeout)
			throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void selectTool(int toolIndex) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void setFeedrate(double feed) {
		// this space intentionally left blank

	}

	@Override
	public double getCurrentFeedrate() {
		// this space intentionally left blank
		return 0;
	}

	@Override
	public void homeAxes(EnumSet<AxisId> axes, boolean positive, double feedrate)
			throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void delay(long millis) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void openClamp(int clampIndex) {
		// this space intentionally left blank

	}

	@Override
	public void closeClamp(int clampIndex) {
		// this space intentionally left blank

	}

	@Override
	public void enableDrives() throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void disableDrives() throws RetryException {
		// this space intentionally left blank

	}


	public void enableAxes(EnumSet<AxisId> axes) throws RetryException {
		// Not all drivers support this method.
	}
	
	public void disableAxes(EnumSet<AxisId> axes) throws RetryException {
		// Not all drivers support this method.
	}

	@Override
	public void changeGearRatio(int ratioIndex) {
		// this space intentionally left blank

	}

	@Override
	public void readToolStatus() {
		// this space intentionally left blank

	}

	@Override
	public int getToolStatus() {
		// this space intentionally left blank
		return 0;
	}

	@Override
	public void setMotorDirection(int dir) {
		// this space intentionally left blank

	}

	@Override
	public void setMotorRPM(double rpm, int toolhead) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void setMotorPWM(int pwm) throws RetryException {
		// this space intentionally left blank
	}

	@Override
	public double getMotorRPM() {
		return 0;
	}

	@Override
	public int getMotorPWM() {
		return 0;
	}

	@Override
	public void enableMotor() throws RetryException {
	}

	@Override
	public void enableMotor(long millis) throws RetryException {
	}

	@Override
	public void disableMotor() throws RetryException {
	}

	@Override
	public void setSpindleRPM(double rpm) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void setSpindleSpeedPWM(int pwm) throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void setSpindleDirection(int dir) {
		// this space intentionally left blank

	}

	@Override
	public double getSpindleRPM() {
		// this space intentionally left blank
		return 0;
	}

	@Override
	public int getSpindleSpeedPWM() {
		// this space intentionally left blank
		return 0;
	}

	@Override
	public void enableSpindle() throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void disableSpindle() throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void setTemperature(double temperature) throws RetryException {
		toolTemperature = temperature;
		toolTemperatureSetting = temperature;
	}

	@Override
	public void setTemperature(double temperature, int toolhead) throws RetryException {
		toolTemperature = temperature;
		toolTemperatureSetting = temperature;
	}

	@Override
	public void readTemperature() {
	}

	@Override
	@Deprecated
	public double getTemperature() {
		return toolTemperature;
	}

	@Override
	public double getTemperature(int toolheadIndex) {
		return toolTemperature;
	}

	@Override
	public double getTemperatureSetting() {
		return toolTemperatureSetting;
	}

	@Override
	public void setPlatformTemperature(double temperature)
			throws RetryException {
		platformTemperature = temperature;
		platformTemperatureSetting = temperature;
	}

	@Override
	public void setPlatformTemperature(double temperature, int toolhead) throws RetryException {
		platformTemperature = temperature;
		platformTemperatureSetting = temperature;
	}

	
	@Override
	public void readPlatformTemperature() {
	}

	@Override
	public double getPlatformTemperature() {
		return platformTemperature;
	}

	/** relies on timing to have the 'right selected toolhead', deprecated */
	@Override
	@Deprecated
	public double getPlatformTemperature(int toolheadIndex) {
		return platformTemperature;
	}

	@Override
	public double getPlatformTemperatureSetting() {
		return platformTemperatureSetting;
	}

	@Override
	public void setChamberTemperature(double temperature) {
		// this space intentionally left blank

	}

	@Override
	public void readChamberTemperature() {
		// this space intentionally left blank

	}

	@Override
	public double getChamberTemperature() {
		// this space intentionally left blank
		return 0;
	}

	@Override
	public void enableFloodCoolant() {
		// this space intentionally left blank

	}

	@Override
	public void disableFloodCoolant() {
		// this space intentionally left blank

	}

	@Override
	public void enableMistCoolant() {
		// this space intentionally left blank

	}

	@Override
	public void disableMistCoolant() {
		// this space intentionally left blank

	}

	@Override
	public void enableFan() throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void disableFan() throws RetryException {
		// this space intentionally left blank

	}
	
	@Override 
	public void setAutomatedBuildPlatformRunning(boolean state) throws RetryException {
		// this space intentionally left blank
	}
	
	@Override
	public void openValve() throws RetryException {
		// this space intentionally left blank

	}

	@Override
	public void closeValve() throws RetryException {
		// this space intentionally left blank

	}

	public void setStepperVoltage(int stepperId, int referenceValue)
	{
		Base.logger.finer("VirtualPrinter::setStepperVoltage");
		//generated method stub
	}

	public int getStepperVoltage(int stepperId)
	{
		Base.logger.finer("VirtualPrinter::setStepperVoltage");
		return 0;
		//generated method stub
	}
	

	public void storeStepperVoltage(int stepperId, int referenceValue)
	{
		Base.logger.finer("VirtualPrinter::storeStepperVoltage");
		//generated method stub
	}

	
	public void setLedStrip(Color color, int effectId)
	{
		Base.logger.finer("VirtualPrinter::setLedStrip");
		//generated method stub
	}
	
	
	public void sendBeep(int frequencyHz, int durationMs,int effect) throws RetryException
	{
		Base.logger.finer("VirtualPrinter::sendBeep");
		//generated method stub
	}

	
	@Override
	public void openCollet() {
		// this space intentionally left blank

	}

	@Override
	public void closeCollet() {
		// this space intentionally left blank

	}

	@Override
	public void pause() {
		// this space intentionally left blank

	}

	@Override
	public void unpause() {
		// this space intentionally left blank

	}

	@Override
	public void stop(boolean abort) {
		// this space intentionally left blank

	}

	@Override
	public boolean hasSoftStop() {
		// this space intentionally left blank
		return hasSoftStop;
	}

	@Override
	public boolean hasEmergencyStop() {
		// this space intentionally left blank
		return hasEStop;
	}

	@Override
	public void reset() {
		// this space intentionally left blank

	}

	@Override
	public boolean heartbeat() {
		// this space intentionally left blank
		return false;
	}

	@Override
	public Point5d getMaximumFeedrates() {
		// this space intentionally left blank
		return maximumFeedrates;
	}

	@Override
	public boolean hasAutomatedBuildPlatform() {
		// this space intentionally left blank
		return true;
	}

	@Override
	public void readAllTemperatures() {
		// this space intentionally left blank
		
	}

	@Override
	public void readAllPlatformTemperatures() {
		// this space intentionally left blank
		
	}

	
	@Override
	public void setMotorDirection(int dir, int toolhead) {
		// this space intentionally left blank
		
	}

	@Override
	public void setMotorPWM(int pwm, int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void enableMotor(int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void enableMotor(long millis, int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void disableMotor(int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void enableFan(int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void disableFan(int toolhead) throws RetryException {
		// this space intentionally left blank
		
	}

	@Override
	public void setAutomatedBuildPlatformRunning(boolean state, int toolhead)
			throws RetryException {
		// this space intentionally left blank
		
	}

}
