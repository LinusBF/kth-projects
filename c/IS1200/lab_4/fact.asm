addi $a0, $0, 8  # Initilize n
func:
addi $a1, $0, 1  # Start i at 1 and move up to n
addi $v0, $0, 1  # Initialize multiplicant (and return) to 1

beq $a0, $0, end  # Check for 0!
loop:
beq $a0, $a1, end # Finished when i = n
addi $a1, $a1, 1  # i++
mul $v0, $v0, $a1
beq $0, $0, loop   # Jump to next multiplier loop

end:
beq $0, $0, end    # Infinate loop
