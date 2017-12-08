-- Copyright (C) 1991-2013 Altera Corporation
-- Your use of Altera Corporation's design tools, logic functions 
-- and other software and tools, and its AMPP partner logic 
-- functions, and any output files from any of the foregoing 
-- (including device programming or simulation files), and any 
-- associated documentation or information are expressly subject 
-- to the terms and conditions of the Altera Program License 
-- Subscription Agreement, Altera MegaCore Function License 
-- Agreement, or other applicable license agreement, including, 
-- without limitation, that your use is for the sole purpose of 
-- programming logic devices manufactured by Altera and sold by 
-- Altera or its authorized distributors.  Please refer to the 
-- applicable agreement for further details.

-- VENDOR "Altera"
-- PROGRAM "Quartus II 64-Bit"
-- VERSION "Version 13.0.0 Build 156 04/24/2013 SJ Web Edition"

-- DATE "12/04/2017 09:26:43"

-- 
-- Device: Altera EPM3032ALC44-10 Package PLCC44
-- 

-- 
-- This VHDL file should be used for ModelSim-Altera (VHDL) only
-- 

LIBRARY IEEE;
LIBRARY MAX;
USE IEEE.STD_LOGIC_1164.ALL;
USE MAX.MAX_COMPONENTS.ALL;

ENTITY 	codelock IS
    PORT (
	clk : IN std_logic;
	K : IN std_logic_vector(1 TO 3);
	R : IN std_logic_vector(1 TO 4);
	q : OUT std_logic_vector(4 DOWNTO 0);
	UNLOCK : OUT std_logic
	);
END codelock;

-- Design Ports Information
-- clk	=>  Location: PIN_43
-- K[3]	=>  Location: PIN_18
-- K[2]	=>  Location: PIN_19
-- K[1]	=>  Location: PIN_20
-- R[4]	=>  Location: PIN_28
-- R[3]	=>  Location: PIN_27
-- R[2]	=>  Location: PIN_26
-- R[1]	=>  Location: PIN_25
-- q[1]	=>  Location: PIN_5
-- q[2]	=>  Location: PIN_6
-- q[3]	=>  Location: PIN_8
-- q[4]	=>  Location: PIN_9
-- UNLOCK	=>  Location: PIN_14
-- q[0]	=>  Location: PIN_4


ARCHITECTURE structure OF codelock IS
SIGNAL gnd : std_logic := '0';
SIGNAL vcc : std_logic := '1';
SIGNAL unknown : std_logic := 'X';
SIGNAL ww_clk : std_logic;
SIGNAL ww_K : std_logic_vector(1 TO 3);
SIGNAL ww_R : std_logic_vector(1 TO 4);
SIGNAL ww_q : std_logic_vector(4 DOWNTO 0);
SIGNAL ww_UNLOCK : std_logic;
SIGNAL \state[1]_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[1]_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[3]_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[4]_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Equal9~6_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[0]_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~13bal_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \state[2]~0_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm0_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm1_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm2_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm3_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm4_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pterm5_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pxor_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pclk_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_pena_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_paclr_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~27_papre_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~11_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~12_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~15_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~16_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~17_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~18_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector2~19_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~13_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~14_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~15_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~16_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~17_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~18_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~12sexp1_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~12sexp2_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~12sexp3_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~12sexp4_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \Selector1~12sexp5_datain_bus\ : std_logic_vector(51 DOWNTO 0);
SIGNAL \clk~dataout\ : std_logic;
SIGNAL \Selector2~27_dataout\ : std_logic;
SIGNAL \Selector1~13_dataout\ : std_logic;
SIGNAL \Selector1~14_dataout\ : std_logic;
SIGNAL \Selector1~15_dataout\ : std_logic;
SIGNAL \Selector1~16_dataout\ : std_logic;
SIGNAL \Selector1~17_dataout\ : std_logic;
SIGNAL \Selector1~18_dataout\ : std_logic;
SIGNAL \Selector1~12sexp1_dataout\ : std_logic;
SIGNAL \Selector1~12sexp2_dataout\ : std_logic;
SIGNAL \Selector1~12sexp3_dataout\ : std_logic;
SIGNAL \Selector1~12sexp4_dataout\ : std_logic;
SIGNAL \Selector1~12sexp5_dataout\ : std_logic;
SIGNAL \state[2]~0_dataout\ : std_logic;
SIGNAL \Selector2~15_dataout\ : std_logic;
SIGNAL \Selector2~16_dataout\ : std_logic;
SIGNAL \Selector2~17_dataout\ : std_logic;
SIGNAL \Selector2~18_dataout\ : std_logic;
SIGNAL \Selector2~19_dataout\ : std_logic;
SIGNAL \Selector2~11_dataout\ : std_logic;
SIGNAL \Selector2~12_dataout\ : std_logic;
SIGNAL \Selector2~13bal_dataout\ : std_logic;
SIGNAL \Equal9~6_dataout\ : std_logic;
SIGNAL state : std_logic_vector(4 DOWNTO 0);
SIGNAL \R~dataout\ : std_logic_vector(1 TO 4);
SIGNAL \K~dataout\ : std_logic_vector(1 TO 3);
SIGNAL \ALT_INV_R~dataout\ : std_logic_vector(4 DOWNTO 1);
SIGNAL \ALT_INV_K~dataout\ : std_logic_vector(3 DOWNTO 1);
SIGNAL ALT_INV_state : std_logic_vector(4 DOWNTO 0);
SIGNAL \ALT_INV_state[2]~0_dataout\ : std_logic;

BEGIN

ww_clk <= clk;
ww_K <= K;
ww_R <= R;
q <= ww_q;
UNLOCK <= ww_UNLOCK;

\state[1]_pterm0_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & state(1) & state(0) & \Selector2~27_dataout\ & \Selector2~19_dataout\ & \Selector2~18_dataout\ & \Selector2~17_dataout\ & \Selector2~16_dataout\ & \Selector2~15_dataout\);

\state[1]_pterm1_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[1]_pterm2_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & \R~dataout\(4) & NOT state(3) & NOT state(4) & \Selector2~11_dataout\ & \Selector2~19_dataout\ & \Selector2~18_dataout\ & \Selector2~17_dataout\ & \Selector2~16_dataout\ & \Selector2~15_dataout\);

\state[1]_pterm3_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & \R~dataout\(2) & \Selector2~12_dataout\ & NOT state(3) & NOT state(4) & \Selector2~19_dataout\ & \Selector2~18_dataout\ & \Selector2~17_dataout\ & \Selector2~16_dataout\ & \Selector2~15_dataout\);

\state[1]_pterm4_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & \Selector2~13bal_dataout\ & NOT state(3) & NOT state(4) & \Selector2~19_dataout\ & \Selector2~18_dataout\ & \Selector2~17_dataout\ & \Selector2~16_dataout\ & \Selector2~15_dataout\);

\state[1]_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[1]_pxor_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \Selector2~19_dataout\ & \Selector2~18_dataout\ & \Selector2~17_dataout\ & \Selector2~16_dataout\ & \Selector2~15_dataout\);

\state[1]_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[1]_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[1]_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[1]_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & \Selector1~12sexp5_dataout\ & \Selector1~12sexp4_dataout\ & \Selector1~12sexp3_dataout\ & \Selector1~12sexp2_dataout\ & \Selector1~12sexp1_dataout\ & \Selector1~18_dataout\ & \Selector1~17_dataout\ & \Selector1~16_dataout\ & 
\Selector1~15_dataout\ & \Selector1~14_dataout\ & \Selector1~13_dataout\);

\state[2]_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[2]_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \state[2]~0_dataout\ & state(0) & state(1) & state(4));

\state[3]_pterm2_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & NOT \R~dataout\(3) & NOT \K~dataout\(2) & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(4) & \state[2]~0_dataout\ & state(0) & state(1));

\state[3]_pterm3_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & state(3) & \state[2]~0_dataout\ & state(0) & state(1));

\state[3]_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[3]_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[3]_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & state(0) & state(1) & \state[2]~0_dataout\ & state(3));

\state[4]_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[4]_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[4]_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(3) & NOT state(4));

\Equal9~6_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\Equal9~6_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Equal9~6_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[0]_pterm0_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(0) & \Selector2~27_dataout\);

\state[0]_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & \K~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(2) & \R~dataout\(4) & state(1) & NOT \state[2]~0_dataout\ & NOT state(3) & NOT state(4));

\state[0]_pterm2_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & \R~dataout\(3) & \K~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(2) & NOT \R~dataout\(4) & NOT state(1) & NOT \state[2]~0_dataout\ & NOT state(3) & NOT state(4));

\state[0]_pterm3_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & \K~dataout\(3) & NOT \R~dataout\(2) & \R~dataout\(4) & NOT state(1) & \state[2]~0_dataout\ & NOT state(3) & NOT state(4));

\state[0]_pterm4_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & \K~dataout\(3) & \R~dataout\(2) & NOT \R~dataout\(4) & state(1) & \state[2]~0_dataout\ & NOT state(3) & NOT state(4));

\state[0]_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[0]_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[0]_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[0]_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[0]_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[0]_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3));

\Selector2~13bal_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\Selector2~13bal_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~13bal_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & state(2));

\state[2]~0_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & 
vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\state[2]~0_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\state[2]~0_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & 
gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pterm0_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pterm1_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(3) & NOT state(4));

\Selector2~27_pterm2_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pterm3_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pterm4_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pterm5_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pxor_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pclk_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_pena_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc);

\Selector2~27_paclr_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~27_papre_bus\ <= (gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd
& gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd & gnd);

\Selector2~11_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \K~dataout\(2) & NOT \state[2]~0_dataout\ & state(1));

\Selector2~12_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \K~dataout\(3) & \state[2]~0_dataout\ & state(1));

\Selector2~15_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(2) & \state[2]~0_dataout\ & state(1) & state(0));

\Selector2~16_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(4) & NOT \state[2]~0_dataout\ & state(1) & state(0));

\Selector2~17_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \K~dataout\(2) & NOT \R~dataout\(4) & NOT state(3) & NOT state(4));

\Selector2~18_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & \K~dataout\(3) & NOT \R~dataout\(2) & NOT state(3) & NOT state(4));

\Selector2~19_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(1) & NOT state(0));

\Selector1~13_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(1) & state(4) & \state[2]~0_dataout\);

\Selector1~14_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(1) & state(3) & \state[2]~0_dataout\);

\Selector1~15_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(0) & state(4) & \state[2]~0_dataout\);

\Selector1~16_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & NOT state(0) & state(3) & \state[2]~0_dataout\);

\Selector1~17_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & state(0) & state(1) & state(4) & NOT \state[2]~0_dataout\);

\Selector1~18_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & state(0) & state(1) & state(3) & NOT \state[2]~0_dataout\);

\Selector1~12sexp1_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(2) & NOT \R~dataout\(4) & state(0) & state(1) & NOT \state[2]~0_dataout\);

\Selector1~12sexp2_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(2) & NOT \R~dataout\(4) & NOT state(1) & \state[2]~0_dataout\);

\Selector1~12sexp3_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & \K~dataout\(3) & NOT \R~dataout\(2) & \R~dataout\(4) & NOT state(1) & \state[2]~0_dataout\);

\Selector1~12sexp4_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & NOT \K~dataout\(3) & NOT \R~dataout\(2) & NOT \R~dataout\(4) & NOT state(0) & \state[2]~0_dataout\);

\Selector1~12sexp5_datain_bus\ <= (vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc & vcc
& vcc & vcc & vcc & vcc & NOT \R~dataout\(1) & NOT \K~dataout\(1) & NOT \R~dataout\(3) & NOT \K~dataout\(2) & \K~dataout\(3) & \R~dataout\(2) & NOT \R~dataout\(4) & state(1) & NOT state(3) & NOT state(4) & \state[2]~0_dataout\);
\ALT_INV_R~dataout\(4) <= NOT \R~dataout\(4);
\ALT_INV_K~dataout\(1) <= NOT \K~dataout\(1);
\ALT_INV_K~dataout\(2) <= NOT \K~dataout\(2);
\ALT_INV_K~dataout\(3) <= NOT \K~dataout\(3);
ALT_INV_state(0) <= NOT state(0);
ALT_INV_state(4) <= NOT state(4);
ALT_INV_state(3) <= NOT state(3);
ALT_INV_state(1) <= NOT state(1);
\ALT_INV_R~dataout\(2) <= NOT \R~dataout\(2);
\ALT_INV_R~dataout\(3) <= NOT \R~dataout\(3);
\ALT_INV_state[2]~0_dataout\ <= NOT \state[2]~0_dataout\;
\ALT_INV_R~dataout\(1) <= NOT \R~dataout\(1);

-- Location: PIN_43
\clk~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_clk,
	dataout => \clk~dataout\);

-- Location: PIN_28
\R[4]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_R(4),
	dataout => \R~dataout\(4));

-- Location: PIN_26
\R[2]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_R(2),
	dataout => \R~dataout\(2));

-- Location: PIN_18
\K[3]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_K(3),
	dataout => \K~dataout\(3));

-- Location: PIN_19
\K[2]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_K(2),
	dataout => \K~dataout\(2));

-- Location: PIN_27
\R[3]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_R(3),
	dataout => \R~dataout\(3));

-- Location: PIN_20
\K[1]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_K(1),
	dataout => \K~dataout\(1));

-- Location: PIN_25
\R[1]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "input",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	oe => GND,
	padio => ww_R(1),
	dataout => \R~dataout\(1));

-- Location: LC31
\Selector2~27\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "invert",
	output_mode => "comb",
	pexp_mode => "off")
-- pragma translate_on
PORT MAP (
	pterm0 => \Selector2~27_pterm0_bus\,
	pterm1 => \Selector2~27_pterm1_bus\,
	pterm2 => \Selector2~27_pterm2_bus\,
	pterm3 => \Selector2~27_pterm3_bus\,
	pterm4 => \Selector2~27_pterm4_bus\,
	pterm5 => \Selector2~27_pterm5_bus\,
	pxor => \Selector2~27_pxor_bus\,
	pclk => \Selector2~27_pclk_bus\,
	papre => \Selector2~27_papre_bus\,
	paclr => \Selector2~27_paclr_bus\,
	pena => \Selector2~27_pena_bus\,
	dataout => \Selector2~27_dataout\);

-- Location: LC1
\state[0]\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "normal",
	output_mode => "reg",
	pexp_mode => "off",
	power_up => "low",
	register_mode => "dff")
-- pragma translate_on
PORT MAP (
	clk => \clk~dataout\,
	pterm0 => \state[0]_pterm0_bus\,
	pterm1 => \state[0]_pterm1_bus\,
	pterm2 => \state[0]_pterm2_bus\,
	pterm3 => \state[0]_pterm3_bus\,
	pterm4 => \state[0]_pterm4_bus\,
	pterm5 => \state[0]_pterm5_bus\,
	pxor => \state[0]_pxor_bus\,
	pclk => \state[0]_pclk_bus\,
	papre => \state[0]_papre_bus\,
	paclr => \state[0]_paclr_bus\,
	pena => \state[0]_pena_bus\,
	dataout => state(0));

-- Location: LC5
\state[3]\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "normal",
	output_mode => "reg",
	pexp_mode => "off",
	power_up => "low",
	register_mode => "tff")
-- pragma translate_on
PORT MAP (
	clk => \clk~dataout\,
	pterm0 => \state[3]_pterm0_bus\,
	pterm1 => \state[3]_pterm1_bus\,
	pterm2 => \state[3]_pterm2_bus\,
	pterm3 => \state[3]_pterm3_bus\,
	pterm4 => \state[3]_pterm4_bus\,
	pterm5 => \state[3]_pterm5_bus\,
	pxor => \state[3]_pxor_bus\,
	pclk => \state[3]_pclk_bus\,
	papre => \state[3]_papre_bus\,
	paclr => \state[3]_paclr_bus\,
	pena => \state[3]_pena_bus\,
	dataout => state(3));

-- Location: LC6
\state[4]\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "normal",
	output_mode => "reg",
	pexp_mode => "off",
	power_up => "low",
	register_mode => "tff")
-- pragma translate_on
PORT MAP (
	clk => \clk~dataout\,
	pterm0 => \state[4]_pterm0_bus\,
	pterm1 => \state[4]_pterm1_bus\,
	pterm2 => \state[4]_pterm2_bus\,
	pterm3 => \state[4]_pterm3_bus\,
	pterm4 => \state[4]_pterm4_bus\,
	pterm5 => \state[4]_pterm5_bus\,
	pxor => \state[4]_pxor_bus\,
	pclk => \state[4]_pclk_bus\,
	papre => \state[4]_papre_bus\,
	paclr => \state[4]_paclr_bus\,
	pena => \state[4]_pena_bus\,
	dataout => state(4));

-- Location: SEXP23
\Selector1~13\ : max_sexp
PORT MAP (
	datain => \Selector1~13_datain_bus\,
	dataout => \Selector1~13_dataout\);

-- Location: SEXP22
\Selector1~14\ : max_sexp
PORT MAP (
	datain => \Selector1~14_datain_bus\,
	dataout => \Selector1~14_dataout\);

-- Location: SEXP21
\Selector1~15\ : max_sexp
PORT MAP (
	datain => \Selector1~15_datain_bus\,
	dataout => \Selector1~15_dataout\);

-- Location: SEXP20
\Selector1~16\ : max_sexp
PORT MAP (
	datain => \Selector1~16_datain_bus\,
	dataout => \Selector1~16_dataout\);

-- Location: SEXP19
\Selector1~17\ : max_sexp
PORT MAP (
	datain => \Selector1~17_datain_bus\,
	dataout => \Selector1~17_dataout\);

-- Location: SEXP18
\Selector1~18\ : max_sexp
PORT MAP (
	datain => \Selector1~18_datain_bus\,
	dataout => \Selector1~18_dataout\);

-- Location: SEXP17
\Selector1~12sexp1\ : max_sexp
PORT MAP (
	datain => \Selector1~12sexp1_datain_bus\,
	dataout => \Selector1~12sexp1_dataout\);

-- Location: SEXP30
\Selector1~12sexp2\ : max_sexp
PORT MAP (
	datain => \Selector1~12sexp2_datain_bus\,
	dataout => \Selector1~12sexp2_dataout\);

-- Location: SEXP25
\Selector1~12sexp3\ : max_sexp
PORT MAP (
	datain => \Selector1~12sexp3_datain_bus\,
	dataout => \Selector1~12sexp3_dataout\);

-- Location: SEXP31
\Selector1~12sexp4\ : max_sexp
PORT MAP (
	datain => \Selector1~12sexp4_datain_bus\,
	dataout => \Selector1~12sexp4_dataout\);

-- Location: SEXP24
\Selector1~12sexp5\ : max_sexp
PORT MAP (
	datain => \Selector1~12sexp5_datain_bus\,
	dataout => \Selector1~12sexp5_dataout\);

-- Location: LC25
\state[2]\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "invert",
	output_mode => "reg",
	pexp_mode => "off",
	power_up => "low",
	register_mode => "dff")
-- pragma translate_on
PORT MAP (
	clk => \clk~dataout\,
	pterm0 => \state[2]_pterm0_bus\,
	pterm1 => \state[2]_pterm1_bus\,
	pterm2 => \state[2]_pterm2_bus\,
	pterm3 => \state[2]_pterm3_bus\,
	pterm4 => \state[2]_pterm4_bus\,
	pterm5 => \state[2]_pterm5_bus\,
	pxor => \state[2]_pxor_bus\,
	pclk => \state[2]_pclk_bus\,
	papre => \state[2]_papre_bus\,
	paclr => \state[2]_paclr_bus\,
	pena => \state[2]_pena_bus\,
	dataout => state(2));

-- Location: LC3
\state[2]~0\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "normal",
	output_mode => "comb",
	pexp_mode => "off")
-- pragma translate_on
PORT MAP (
	pterm0 => \state[2]~0_pterm0_bus\,
	pterm1 => \state[2]~0_pterm1_bus\,
	pterm2 => \state[2]~0_pterm2_bus\,
	pterm3 => \state[2]~0_pterm3_bus\,
	pterm4 => \state[2]~0_pterm4_bus\,
	pterm5 => \state[2]~0_pterm5_bus\,
	pxor => \state[2]~0_pxor_bus\,
	pclk => \state[2]~0_pclk_bus\,
	papre => \state[2]~0_papre_bus\,
	paclr => \state[2]~0_paclr_bus\,
	pena => \state[2]~0_pena_bus\,
	dataout => \state[2]~0_dataout\);

-- Location: SEXP7
\Selector2~15\ : max_sexp
PORT MAP (
	datain => \Selector2~15_datain_bus\,
	dataout => \Selector2~15_dataout\);

-- Location: SEXP10
\Selector2~16\ : max_sexp
PORT MAP (
	datain => \Selector2~16_datain_bus\,
	dataout => \Selector2~16_dataout\);

-- Location: SEXP6
\Selector2~17\ : max_sexp
PORT MAP (
	datain => \Selector2~17_datain_bus\,
	dataout => \Selector2~17_dataout\);

-- Location: SEXP4
\Selector2~18\ : max_sexp
PORT MAP (
	datain => \Selector2~18_datain_bus\,
	dataout => \Selector2~18_dataout\);

-- Location: SEXP5
\Selector2~19\ : max_sexp
PORT MAP (
	datain => \Selector2~19_datain_bus\,
	dataout => \Selector2~19_dataout\);

-- Location: SEXP3
\Selector2~11\ : max_sexp
PORT MAP (
	datain => \Selector2~11_datain_bus\,
	dataout => \Selector2~11_dataout\);

-- Location: SEXP8
\Selector2~12\ : max_sexp
PORT MAP (
	datain => \Selector2~12_datain_bus\,
	dataout => \Selector2~12_dataout\);

-- Location: LC30
\Selector2~13bal\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "invert",
	output_mode => "comb",
	pexp_mode => "off")
-- pragma translate_on
PORT MAP (
	pterm0 => \Selector2~13bal_pterm0_bus\,
	pterm1 => \Selector2~13bal_pterm1_bus\,
	pterm2 => \Selector2~13bal_pterm2_bus\,
	pterm3 => \Selector2~13bal_pterm3_bus\,
	pterm4 => \Selector2~13bal_pterm4_bus\,
	pterm5 => \Selector2~13bal_pterm5_bus\,
	pxor => \Selector2~13bal_pxor_bus\,
	pclk => \Selector2~13bal_pclk_bus\,
	papre => \Selector2~13bal_papre_bus\,
	paclr => \Selector2~13bal_paclr_bus\,
	pena => \Selector2~13bal_pena_bus\,
	dataout => \Selector2~13bal_dataout\);

-- Location: LC2
\state[1]\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "xor",
	output_mode => "reg",
	pexp_mode => "off",
	power_up => "low",
	register_mode => "dff")
-- pragma translate_on
PORT MAP (
	clk => \clk~dataout\,
	pterm0 => \state[1]_pterm0_bus\,
	pterm1 => \state[1]_pterm1_bus\,
	pterm2 => \state[1]_pterm2_bus\,
	pterm3 => \state[1]_pterm3_bus\,
	pterm4 => \state[1]_pterm4_bus\,
	pterm5 => \state[1]_pterm5_bus\,
	pxor => \state[1]_pxor_bus\,
	pclk => \state[1]_pclk_bus\,
	papre => \state[1]_papre_bus\,
	paclr => \state[1]_paclr_bus\,
	pena => \state[1]_pena_bus\,
	dataout => state(1));

-- Location: LC10
\Equal9~6\ : max_mcell
-- pragma translate_off
GENERIC MAP (
	operation_mode => "invert",
	output_mode => "comb",
	pexp_mode => "off")
-- pragma translate_on
PORT MAP (
	pterm0 => \Equal9~6_pterm0_bus\,
	pterm1 => \Equal9~6_pterm1_bus\,
	pterm2 => \Equal9~6_pterm2_bus\,
	pterm3 => \Equal9~6_pterm3_bus\,
	pterm4 => \Equal9~6_pterm4_bus\,
	pterm5 => \Equal9~6_pterm5_bus\,
	pxor => \Equal9~6_pxor_bus\,
	pclk => \Equal9~6_pclk_bus\,
	papre => \Equal9~6_papre_bus\,
	paclr => \Equal9~6_paclr_bus\,
	pena => \Equal9~6_pena_bus\,
	dataout => \Equal9~6_dataout\);

-- Location: PIN_5
\q[1]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => state(1),
	oe => VCC,
	padio => ww_q(1));

-- Location: PIN_6
\q[2]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => \state[2]~0_dataout\,
	oe => VCC,
	padio => ww_q(2));

-- Location: PIN_8
\q[3]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => state(3),
	oe => VCC,
	padio => ww_q(3));

-- Location: PIN_9
\q[4]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => state(4),
	oe => VCC,
	padio => ww_q(4));

-- Location: PIN_14
\UNLOCK~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => \Equal9~6_dataout\,
	oe => VCC,
	padio => ww_UNLOCK);

-- Location: PIN_4
\q[0]~I\ : max_io
-- pragma translate_off
GENERIC MAP (
	bus_hold => "false",
	open_drain_output => "false",
	operation_mode => "output",
	weak_pull_up => "false")
-- pragma translate_on
PORT MAP (
	datain => state(0),
	oe => VCC,
	padio => ww_q(0));
END structure;


