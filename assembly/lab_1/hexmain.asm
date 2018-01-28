  # hexmain.asm
  # Written 2015-09-04 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

	.text
main:
	li	$a0,0		# change this to test different values

	jal	hexasc		# call hexasc
	nop			# delay slot filler (just in case)	

	move	$a0,$v0		# copy return value to argument register

	li	$v0,11		# syscall with v0 = 11 will print out
	syscall			# one byte from a0 to the Run I/O window
	
stop:	j	stop		# stop after one run
	nop			# delay slot filler (just in case)

  # You can write your own code for hexasc here
  #

hexasc:
	andi $t0, $a0, 0xf	# Mask a0 so that only the 4 lsb are left
	slti $t1, $t0, 10
	beq $t1, $0, letter	# If a0 >= 10 handle like letter
	nop			# Else handle like number
	addi $t2, $t0, 0x30	# Add 0x30 to a0 to convert it to the ascii code for a0
	j end			# Skip letter handling
	nop			# Safety
	letter:
	addi $t0, $t0, -10	# Reduce t0 to account for the offset of 10 in the number for letter conversion
	addi $t2, $t0, 0x41	# Add 0x41 to a0 to convert it to the ascii code for the letter a0 represents

	end:
	add $v0, $t2, $0	# Set v0 to the new converted number
	jr $ra			# Return to function call
	nop			# Safety
