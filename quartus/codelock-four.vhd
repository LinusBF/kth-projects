library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.std_logic_arith.all;

entity codelock is
   port( clk:      in  std_logic;
           K:      in  std_logic_vector(1 to 3);
           R:      in  std_logic_vector(1 to 4);
           q:      out std_logic_vector(4 downto 0);
           UNLOCK: out std_logic );
end codelock;

architecture behavior of codelock is
subtype state_type is integer range 0 to 31;
signal state, nextstate: state_type;
  
begin
nextstate_decoder: -- next state decoding part
process(state, K, R)
 begin
   case state is
		-- First number
      when 0 => if (K = "010" and R ="0010")     then nextstate <= 1; -- Check for first unlock number (5)
                else nextstate <= 0;
                end if;
      when 1 => if (K = "010" and R ="0010")     then nextstate <= 1;
                elsif (K = "000" and R = "0000") then nextstate <= 2;
                else nextstate <= 0;
                end if;
		-- Second number
		when 2 => if (K = "000" and R ="0000")     then nextstate <= 2; -- Wait for second number
					 elsif (K = "010" and R ="0001")     then nextstate <= 3; -- Check for second unlock number (2)
					 else nextstate <= 0;
					 end if;
      when 3 => if (K = "010" and R ="0001")     then nextstate <= 3;
                elsif (K = "000" and R = "0000") then nextstate <= 4;
                else nextstate <= 0;
                end if;
		-- Third number
		when 4 => if (K = "000" and R ="0000")     then nextstate <= 4; -- Wait for third number
					 elsif (K = "001" and R ="0001")     then nextstate <= 5; -- Check for thrid unlock number (1)
                else nextstate <= 0;
                end if;
      when 5 => if (K = "001" and R ="0001")     then nextstate <= 5;
                elsif (K = "000" and R = "0000") then nextstate <= 6;
                else nextstate <= 0;
                end if;
		-- Forth number
		when 6 => if (K = "000" and R ="0000")     then nextstate <= 6; -- Wait for forth number
					 elsif (K = "001" and R ="0100")     then nextstate <= 7; -- Check for forth unlock number (7)
                else nextstate <= 0;
                end if;
      when 7 => if (K = "001" and R ="0100")     then nextstate <= 7;
                elsif (K = "000" and R = "0000") then nextstate <= 8;
                else nextstate <= 0;
                end if;
      when 8 to 30 => nextstate <= state + 1; -- Unlock until 31 clock pulses has passed
      when 31      => nextstate <= 0;
    end case;
end process;

debug_output:  -- display the state
q <= conv_std_logic_vector(state,5); 
	
output_decoder: -- output decoder part
process(state)
begin
  case state is
     when 0 to 7  => UNLOCK <= '0';
     when 8 to 31 => UNLOCK <= '1';
  end case;	
end process;

state_register: -- the state register part (the flipflops)
process(clk)
begin
  if rising_edge(clk) then
     state <= nextstate;
  end if;
end process;
end behavior;