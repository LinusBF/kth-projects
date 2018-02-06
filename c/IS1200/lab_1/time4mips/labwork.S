  # labwork.S
  # Written 2015-2017 by F Lundevall
  # Skeleton file for IS1200/IS1500 lab 1.
  # The macros PUSH and POP are in the public domain.
  # Please add your own code at the end of the file.

.macro	PUSH reg
	addi	$sp,$sp,-4
	sw	\reg,0($sp)
.endm

.macro	POP reg
	lw	\reg,0($sp)
	addi	$sp,$sp,4
.endm


.global delay
.global time2string

.data
.align 2

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

delay:
	addi $t0, $0, 1	# Initialize constant
	add $t1, $0, $0		# Initialize i
	while:
		add $t1, $0, $0		# Reset i
		for:
			addi $t1, $t1, 1	# i + 1
			bne $t1, $t0, for	# i < const
			nop

		li $t2, 1
		sub $a0, $a0, $t2	# ms - 1
		slti $t3, $a0, 1	# if(ms > 0)
		bne $t3, 1, while	#   continue while
		nop

	jr $ra
	nop

time2string:
	PUSH $s0
	PUSH $s1
	PUSH $s2
	andi $s0, $a1, 0xffff	# Mask a1 so that only the 4 LSB are left
	li $s1, 0		# Init value to store clock in ascii
	li $s2, 0		# Init i for loop
	PUSH $ra
	loop:
		slti $t3, $s2, 4	# Check i >= 4
		beq $t3, $0, done
		nop
 		add $t4, $0, $s2	# Set t4 to i
 		sll $t4, $t4, 2		# Multiply i by 4 for byte index
 		srlv $t5, $s0, $t4	# Shift a1 so that the the byte at i is visible

 		PUSH $a0		# Put given a0 and a1 on the stack
 		PUSH $a1
 		add $a0, $t5, $0	# Set argument for hexasc function
 		jal hexasc		# Call hexasc
 		nop

 		POP $a1
 		POP $a0
 		sll $s1, $s1, 8		# Shift ascii clock value 8 bits to the left to make room for return value from hexasc
 		or $s1, $s1, $v0	# Or answer from hexasc into ascii clock value variable
 		addi $s2, $s2, 1	# Increment i

		j loop
		nop
 	done:
 		POP $ra

 		andi $t3, $s1, 0xffff		# Mask ascii clock value with FFFF to store minutes in the LSB
 		la $t6, 0x3A0000
 		or $t3, $t3, $t6		# Or in the ascii value for comma
 		la $t6, 0xff0000
 		and $t4, $s1, $t6		# Mask ascii clock value with FF00 to get most significant seconds number
 		sll $t4, $t4, 8			# Shift the value to the left to fit in $t3
 		or $t3, $t3, $t4		# Or in the most significant seconds number in the LSB of t3

 		la $t6, 0xff000000
 		and $t5, $s1, $t6	# Mask scii clock value with FF000000 to store least significant seconds number
 		srl $t5, $t5, 24		# Shift to LSB

 		andi $t6, $s0, 0x1		# Extract the lsb of the LSB in a1
 		addi $t7, $0, 0x44		# Initialize variable for storing the letter D or E
 		bne $t6, $0, odd		# Check if least sig. second
 		nop
 		addi $t7, $t7, 1		# Add one to the ASCII code if the number is even

 		odd:
 		sll $t7, $t7, 8			# Shift bits to fit in with t5
 		or $t5, $t5, $t7		# Or the ascii code into t5

 		sw $t3, 0($a0)			# Store t3 (first 4 ascii characters) at the address in a0
 		sw $t5, 4($a0)			# Store t5 (last ascii character) at the word after a0 (a0 + 4)

 		POP $s2
 		POP $s1
 		POP $s0

 		jr $ra
 		nop

