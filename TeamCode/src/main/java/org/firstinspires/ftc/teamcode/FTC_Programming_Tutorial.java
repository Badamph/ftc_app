package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by FIXIT on 16-10-22.
 */
@Autonomous
public class FTC_Programming_Tutorial extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor left = hardwareMap.dcMotor.get("driveL");
        DcMotor right = hardwareMap.dcMotor.get("driveR");

        Servo flag = hardwareMap.servo.get("flag");

        CRServo spinner = hardwareMap.crservo.get("spinner");

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setTargetPosition(2240);

        left.setPower(1);
        right.setPower(1);

        while(left.isBusy())
        {
            idle();
        }

        flag.setPosition(0.5);

        spinner.setPower(-1);

        telemetry.addData("Motor Power", right.getPower());

        telemetry.update();
    }
}
