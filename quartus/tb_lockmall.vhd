--  tb_lockmall.vhd  testbench for lockmall.vhd
--  Thank's to  Francesco Robino

library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.numeric_std.all;

entity tb_codelock is
  -- entity tb_codelock has no ports
  -- because it's for simulation only
end tb_codelock;


architecture testbench of tb_codelock is

  signal    clk : std_logic  := '0';
  signal K_test : std_logic_vector(1 to 3);
  signal R_test : std_logic_vector(1 to 4);
  signal prev_K_test : std_logic_vector(1 to 3);
  signal prev_R_test : std_logic_vector(1 to 4);
  signal q : std_logic_vector(4 downto 0);
  signal unlock : std_logic;
    
  -- we use our codelock as a component
  component codelock
    port( clk    : in std_logic;
          K      : in  std_logic_vector(1 to 3);
          R      : in  std_logic_vector(1 to 4);
          q      : out std_logic_vector(4 downto 0);
          UNLOCK : out std_logic );
  end component;

begin  -- testbench

  -- generate a simulation clock  
  clk <= not clk after 10 ns;

  -- instantiation of the device under test, mapping of signals
  inst_codelock: 
  codelock
  port map ( clk    => clk,
             K => K_test,
             R => R_test,
             q      => q,
             UNLOCK => unlock );

  -- generate all possible key-press combinations
  -- This version checks if the state machine moves to state 1 for the right input combination
  -- If we want to check if the locks opens we should pause (k="000", r="0000") after every single combination
  process
  begin
    for k in 0 to 7 loop
     K_test <= conv_std_logic_vector(k,3);
     for r in 0 to  15 loop
       prev_K_test <= K_test;
       prev_R_test <= R_test;
       R_test <= conv_std_logic_vector(r,4);
       wait until CLK='1';
     end loop;
    end loop;
   end process;
   
   

 -- check if door does not open for K="001" and R="0001"
 -- check if door opens for any other combination
 check:
 process(q)
 begin
  if ((q = "00001") and (prev_K_test = conv_std_logic_vector(1,3)) and (prev_R_test = conv_std_logic_vector(1,4))) then
    assert false 
    report "Lock tries to open for the right sequence!" severity note;
   
  else
    if ((q = "00001")) then
        assert false 
        report "Lock tries to open with the wrong sequence!" severity error;
    else
        report "Lock closed!" severity note;
    end if;
       
   
  end if;
end process check;
end testbench;