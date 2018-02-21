addi $a0, $0, 3  # Initilize n
func:
addi $a1, $0, 1  # Start i at 1 and move up to n
addi $v0, $0, 1  # Initialize multiplicant (and return) to 1

beq $a0, $0, end  # Check for 0!
loop:
beq $a0, $a1, end # Finished when i = n
addi $a1, $a1, 1  # i++
addi $a2, $a1, -1 # Initialize j = i - 1
add $a3, $v0, $0  # Save last loops result to use as multiplicant

multi:  # v0 = v0 * a2
beq $a2, $0, done  # While  j != 0
add $v0, $v0, $a3  # Add a3 to v0
addi $a2, $a2, -1  # j--
beq $0, $0, multi  # Restart multiply loop
done:
beq $0, $0, loop   # Jump to next multiplier loop

end:
beq $0, $0, end    # Infinate loop