package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Driving Test")
public class DrivingOPTest extends LinearOpMode{

private DcMotor motorWheelFL;
private DcMotor motorWheelFR;
private DcMotor motorWheelBL;
private DcMotor motorWheelBR;

@Override
public void runOpMode() {
	motorWheelFL = hardwareMap.get(DcMotor.class, "motorWheelFL");
	motorWheelFR = hardwareMap.get(DcMotor.class, "motorWheelFR");
	motorWheelBL = hardwareMap.get(DcMotor.class, "motorWheelBL");
	motorWheelBR = hardwareMap.get(DcMotor.class, "motorWheelBR");
	
	telemetry.addData("Status", "Initialized");
	telemetry.update();
	
	// Wait for the game to start (driver presses PLAY)
	waitForStart();
	
	double powerFL;
	double powerFR;
	double powerBL;
	double powerBR;
	// run until the end of the match (driver presses STOP)
		while (opModeIsActive()) {
		
		//Left Joystick for front/back and left/right
		//Right Joystick for turning left/right without moving forward
		
		
		powerFL = Range.clip(this.gamepad1.left_stick_y + this.gamepad1.left_stick_x + this.gamepad1.right_stick_x, -1, 1);
		powerFR = Range.clip((this.gamepad1.left_stick_y - this.gamepad1.left_stick_x - this.gamepad1.right_stick_x) * -1, -1, 1);
		powerBL = Range.clip((this.gamepad1.left_stick_y + this.gamepad1.left_stick_x - this.gamepad1.right_stick_x), -1, 1);
		powerBR = Range.clip((this.gamepad1.left_stick_y - this.gamepad1.left_stick_x + this.gamepad1.right_stick_x) * -1, -1, 1);
		

		//Sets calculated power for each motor
		motorWheelFL.setPower(powerFL);
		motorWheelFR.setPower(powerFR);
		motorWheelBL.setPower(powerBL);
		motorWheelBR.setPower(powerBR);
		
		//Send running length and each wheel's power
		telemetry.addData("Status", "Running for " + getRuntime());
		telemetry.addData("Front left power", powerFL);
		telemetry.addData("Front right power", powerFR);
		telemetry.addData("Back left power", powerBL);
		telemetry.addData("Back right power", powerBR);
		telemetry.update();
		}
	}
}
