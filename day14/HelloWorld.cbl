* cerner_2tothe5th_2022
* cerner_2^5th_2022
*
* Day 14: Basic COBOL code with some output. Can be ran here: https://ideone.com/KR8qSu
*              To run the program on the online compiler, make sure everything is tabbed right once.

	IDENTIFICATION DIVISION.
	PROGRAM-ID. IDEONE.
	DATA DIVISION.
	    WORKING-STORAGE SECTION.
	        77 BASE PIC 99.
	        77 EXP PIC 99.
	        77 DAYS PIC 99.
	PROCEDURE DIVISION.
	    SET BASE TO 2.
	    SET EXP TO 5.
	    COMPUTE DAYS =  BASE**EXP.
	    DISPLAY "Day 14 of "DAYS" in the 2^5 Competition.".
	STOP RUN.
